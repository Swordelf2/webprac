-- DBMS: PostgreSQL


alter database comoperator
    set datestyle to ISO, DMY;

set datestyle to ISO, DMY;

--
-- Create Statements
--

CREATE TABLE Client (
	ClientID serial NOT NULL,
	Type varchar(12) NOT NULL,
	Name varchar(60) NOT NULL,
	Balance numeric(8,2) NOT NULL,
    CreditLimit numeric(8,2) default 100 NOT NULL,
    CreditTime integer default 5,
	CONSTRAINT Client_pk PRIMARY KEY (ClientID)
);


CREATE TABLE Individual (
	ClientID integer NOT NULL,
	BirthDate DATE NOT NULL,
	Gender char(1) NOT NULL,
	CONSTRAINT Individual_pk PRIMARY KEY (ClientID)
);


CREATE TABLE LegalEntity (
	ClientID integer NOT NULL,
	INN varchar(12) NOT NULL,
	CONSTRAINT LegalEntity_pk PRIMARY KEY (ClientID)
);


CREATE TABLE Credit (
	CreditID serial NOT NULL,
	ClientID integer NOT NULL,
	Sum numeric(8,2) NOT NULL,
	StartDate DATE NOT NULL,
	EndDate DATE,
	CONSTRAINT Credit_pk PRIMARY KEY (CreditID)
);


CREATE TABLE Deposit (
	DepositID serial NOT NULL,
	ClientID integer NOT NULL,
	Sum numeric(8,2) NOT NULL,
	Time TIMESTAMP NOT NULL,
	CONSTRAINT Deposit_pk PRIMARY KEY (DepositID)
);


CREATE TABLE Service (
	ServiceID serial NOT NULL,
    Name varchar(30) NOT NULL,
	Description varchar(200) NOT NULL,
    TariffDescription varchar(300) NOT NULL,
	CONSTRAINT Service_pk PRIMARY KEY (ServiceID)
);


CREATE TABLE ActivatedService (
    ClientID integer NOT NULL,
	Number char(10) NOT NULL,
	ServiceID integer NOT NULL,
	StartTime timestamp NOT NULL,
    EndTime timestamp,
    CONSTRAINT ActivatedService_pk PRIMARY KEY (ClientID, Number,
        ServiceID)
);


CREATE TABLE Charge (
	ChargeID serial NOT NULL,
	ClientID integer NOT NULL,
	Sum numeric(8,2) NOT NULL,
	Time TIMESTAMP NOT NULL,
	ServiceID integer,
	CONSTRAINT Charges_pk PRIMARY KEY (ChargeID)
);


CREATE TABLE Contact (
	ContactID serial NOT NULL,
	ClientID integer NOT NULL,
	Type varchar(12) NOT NULL,
	Description varchar(30) NOT NULL,
	CONSTRAINT Contact_pk PRIMARY KEY (ContactID)
);


--
-- Insert statements
--
\i db_insert.sql


--
-- Foreign Key Constraints Statements
--

ALTER TABLE Individual ADD CONSTRAINT Individual_fk0 FOREIGN KEY (ClientID) REFERENCES Client(ClientID);

ALTER TABLE LegalEntity ADD CONSTRAINT LegalEntity_fk0 FOREIGN KEY (ClientID) REFERENCES Client(ClientID);


ALTER TABLE Credit ADD CONSTRAINT Credit_fk0 FOREIGN KEY (ClientID) REFERENCES Client(ClientID);

ALTER TABLE Deposit ADD CONSTRAINT Deposit_fk0 FOREIGN KEY (ClientID) REFERENCES Client(ClientID);

ALTER TABLE ActivatedService ADD CONSTRAINT ActivatedService_fk0 FOREIGN KEY (ClientID) REFERENCES Client(ClientID);
ALTER TABLE ActivatedService ADD CONSTRAINT ActivatedService_fk1 FOREIGN KEY (ServiceID) REFERENCES Service(ServiceID);


ALTER TABLE Charge ADD CONSTRAINT Charge_fk0 FOREIGN KEY (ClientID) REFERENCES Client(ClientID);
ALTER TABLE Charge ADD CONSTRAINT Charge_fk1 FOREIGN KEY (ServiceID) REFERENCES Service(ServiceID);

ALTER TABLE Contact ADD CONSTRAINT Contact_fk0 FOREIGN KEY (ClientID) REFERENCES Client(ClientID);

