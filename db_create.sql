-- DBMS: PostgreSQL


alter database comoperator
    set datestyle to "ISO, DMY";

set datestyle to "ISO, DMY";

--
-- Create Statements
--

CREATE TYPE ClientType as ENUM ('Individual', 'LegalEntity');

CREATE TABLE "Clients" (
	"ClientID" serial NOT NULL,
	"Type" ClientType NOT NULL,
	"Name" varchar(60) NOT NULL,
	"AccountID" integer NOT NULL,
	CONSTRAINT Clients_pk PRIMARY KEY ("ClientID")
);


CREATE TABLE "Individuals" (
	"ClientID" integer NOT NULL,
	"BirthDate" DATE NOT NULL,
	"Gender" char(1) NOT NULL,
	CONSTRAINT Individuals_pk PRIMARY KEY ("ClientID")
);


CREATE TABLE "LegalEntities" (
	"ClientID" integer NOT NULL,
	"INN" varchar(12) NOT NULL,
	CONSTRAINT LegalEntities_pk PRIMARY KEY ("ClientID")
);


CREATE TABLE "Accounts" (
	"AccountID" serial NOT NULL,
	"Balance" money NOT NULL,
	"CreditLimit" money default 100 NOT NULL,
	"CreditTime" integer default 5,
	CONSTRAINT Accounts_pk PRIMARY KEY ("AccountID")
);


CREATE TABLE "Credits" (
	"CreditID" serial NOT NULL,
	"AccountID" integer NOT NULL,
	"Sum" money NOT NULL,
	"StartDate" DATE NOT NULL,
	"EndDate" DATE,
	CONSTRAINT Credits_pk PRIMARY KEY ("CreditID")
);


CREATE TABLE "Deposits" (
	"DepositID" serial NOT NULL,
	"AccountID" integer NOT NULL,
	"Sum" money NOT NULL,
	"Time" TIMESTAMP NOT NULL,
	CONSTRAINT Deposits_pk PRIMARY KEY ("DepositID")
);


CREATE TABLE "Tariffs" (
	"TariffID" serial NOT NULL,
	"MonthlyCharge" money NOT NULL,
	"Description" varchar(200),
	CONSTRAINT Tariffs_pk PRIMARY KEY ("TariffID")
);


CREATE TABLE "Numbers" (
	"Number" char(10) NOT NULL,
	"ClientID" integer NOT NULL,
	"TariffID" integer NOT NULL,
	CONSTRAINT Numbers_pk PRIMARY KEY ("Number")
);


CREATE TABLE "Services" (
	"ServiceID" serial NOT NULL,
    "Name" varchar(30) NOT NULL,
	"Description" varchar(200) NOT NULL,
	CONSTRAINT Services_pk PRIMARY KEY ("ServiceID")
);


CREATE TABLE "ActivatedServices" (
	"Number" char(10) NOT NULL,
	"ServiceID" integer NOT NULL,
	"ActivationTime" TIMESTAMP NOT NULL
    CONSTRAINT ActivatedServices_pk PRIMARY KEY ("Number", "ServiceID")
);


CREATE TYPE ChargeType AS ENUM ('Tariff', 'Service');

CREATE TABLE "Charges" (
	"ChargeID" serial NOT NULL,
	"AccountID" bigint NOT NULL,
	"Type" ChargeType NOT NULL,
	"Sum" money NOT NULL,
	"Time" TIMESTAMP NOT NULL,
	"TariffID" integer,
	"ServiceID" integer,
	CONSTRAINT Charges_pk PRIMARY KEY ("ChargeID")
);


CREATE TYPE ContactType AS ENUM ('PhoneNumber', 'E-mail', 'Person');

CREATE TABLE "Contacts" (
	"ContactID" serial NOT NULL,
	"ClientID" integer NOT NULL,
	"Type" ContactType NOT NULL,
	"Description" varchar(30) NOT NULL,
	CONSTRAINT Contacts_pk PRIMARY KEY ("ContactID")
);


--
-- Insert statements
--
\i db_insert.sql


--
-- Foreign Key Constraints Statements
--

ALTER TABLE "Clients" ADD CONSTRAINT "Clients_fk0" FOREIGN KEY ("AccountID") REFERENCES "Accounts"("AccountID");

ALTER TABLE "Individuals" ADD CONSTRAINT "Individuals_fk0" FOREIGN KEY ("ClientID") REFERENCES "Clients"("ClientID");

ALTER TABLE "LegalEntities" ADD CONSTRAINT "LegalEntities_fk0" FOREIGN KEY ("ClientID") REFERENCES "Clients"("ClientID");


ALTER TABLE "Credits" ADD CONSTRAINT "Credits_fk0" FOREIGN KEY ("AccountID") REFERENCES "Accounts"("AccountID");

ALTER TABLE "Deposits" ADD CONSTRAINT "Deposits_fk0" FOREIGN KEY ("AccountID") REFERENCES "Accounts"("AccountID");


ALTER TABLE "Numbers" ADD CONSTRAINT "Numbers_fk0" FOREIGN KEY ("ClientID") REFERENCES "Clients"("ClientID");
ALTER TABLE "Numbers" ADD CONSTRAINT "Numbers_fk1" FOREIGN KEY ("TariffID") REFERENCES "Tariffs"("TariffID");


ALTER TABLE "ActivatedServices" ADD CONSTRAINT "ActivatedServices_fk0" FOREIGN KEY ("Number") REFERENCES "Numbers"("Number");
ALTER TABLE "ActivatedServices" ADD CONSTRAINT "ActivatedServices_fk1" FOREIGN KEY ("ServiceID") REFERENCES "Services"("ServiceID");

ALTER TABLE "Charges" ADD CONSTRAINT "Charges_fk0" FOREIGN KEY ("TariffID") REFERENCES "Accounts"("AccountID");
ALTER TABLE "Charges" ADD CONSTRAINT "Charges_fk1" FOREIGN KEY ("ServiceID") REFERENCES "Services"("ServiceID");

ALTER TABLE "Contacts" ADD CONSTRAINT "Contacts_fk0" FOREIGN KEY ("ClientID") REFERENCES "Clients"("ClientID");
