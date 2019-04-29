-- DBMS: PostgreSQL


alter database comoperator
    set datestyle to ISO, DMY;

set datestyle to ISO, DMY;

--
-- Create Statements
--

CREATE TABLE Client (
	Id serial NOT NULL,
	Type char(1) NOT NULL,
	Name varchar(60) NOT NULL,
	Balance numeric(8,2) NOT NULL,
    CreditLimit numeric(8,2) default 100 NOT NULL,
    CreditTime integer default 5,
	CONSTRAINT Client_pk PRIMARY KEY (Id)
);


CREATE TABLE Credit (
	Id serial NOT NULL,
	Client_id integer NOT NULL,
	Sum numeric(8,2) NOT NULL,
	StartDate DATE NOT NULL,
	EndDate DATE,
	CONSTRAINT Credit_pk PRIMARY KEY (Id)
);


CREATE TABLE Deposit (
	Id serial NOT NULL,
	Client_id integer NOT NULL,
	Sum numeric(8,2) NOT NULL,
	Time TIMESTAMP NOT NULL,
	CONSTRAINT Deposit_pk PRIMARY KEY (Id)
);


CREATE TABLE Service (
	Id serial NOT NULL,
    Name varchar(30) NOT NULL,
	Description varchar(200) NOT NULL,
    TariffDescription varchar(300) NOT NULL,
	CONSTRAINT Service_pk PRIMARY KEY (Id)
);


CREATE TABLE ActivatedService (
    Client_id integer NOT NULL,
	Number char(10) NOT NULL,
	Service_id integer NOT NULL,
	StartTime timestamp NOT NULL,
    EndTime timestamp,
    CONSTRAINT ActivatedService_pk PRIMARY KEY (Client_id, Number,
        Service_id)
);


CREATE TABLE Charge (
	Id serial NOT NULL,
	Client_id integer NOT NULL,
	Sum numeric(8,2) NOT NULL,
	Time TIMESTAMP NOT NULL,
	Service_id integer,
	CONSTRAINT Charges_pk PRIMARY KEY (Id)
);


CREATE TABLE Contact (
	Id serial NOT NULL,
	Client_id integer NOT NULL,
	Type char(1) NOT NULL,
	Description varchar(30) NOT NULL,
	CONSTRAINT Contact_pk PRIMARY KEY (Id)
);


--
-- Insert statements
--
\i db_insert.sql


--
-- Foreign Key Constraints Statements
--

ALTER TABLE Credit ADD CONSTRAINT Credit_fk0 FOREIGN KEY (Client_id) REFERENCES Client(Id);

ALTER TABLE Deposit ADD CONSTRAINT Deposit_fk0 FOREIGN KEY (Client_id) REFERENCES Client(Id);

ALTER TABLE ActivatedService ADD CONSTRAINT ActivatedService_fk0 FOREIGN KEY (Client_id) REFERENCES Client(Id);
ALTER TABLE ActivatedService ADD CONSTRAINT ActivatedService_fk1 FOREIGN KEY (Service_id) REFERENCES Service(Id);


ALTER TABLE Charge ADD CONSTRAINT Charge_fk0 FOREIGN KEY (Client_id) REFERENCES Client(Id);
ALTER TABLE Charge ADD CONSTRAINT Charge_fk1 FOREIGN KEY (Service_id) REFERENCES Service(Id);

ALTER TABLE Contact ADD CONSTRAINT Contact_fk0 FOREIGN KEY (Client_id) REFERENCES Client(Id);

