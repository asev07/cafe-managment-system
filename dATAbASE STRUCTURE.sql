CREATE DATABASE CAFE


CREATE TABLE EMPLOYEE_STATUS
(
ID INT NOT NULL IDENTITY,
E_STATUS VARCHAR(40),
CONTRAT_TYPE VARCHAR(60),
PRIMARY KEY(ID)
)


CREATE TABLE EMPLOYEE_ROLE
(
ID INT NOT NULL IDENTITY,
POSITION VARCHAR(60),
PRIMARY KEY(ID)
)

CREATE TABLE EMPLOYEE
(
ID INT NOT NULL identity,
FIRSTNAME VARCHAR(30),
LASTNAME VARCHAR(30),
AGE TINYINT,
DATE_OF_EMPLOYMENT DATE,
STATUS_ID INT,
ROLE_ID INT,
PRIMARY KEY(ID),
CONSTRAINT FK_EMPLOYEE_STATUS FOREIGN KEY (STATUS_ID) REFERENCES EMPLOYEE_STATUS(ID),
CONSTRAINT FK_EMPLOYEE_ROLE FOREIGN KEY (ROLE_ID) REFERENCES EMPLOYEE_ROLE(ID)

)



CREATE TABLE SERVICE
(
ID INT NOT NULL IDENTITY,
S_CATAGORY VARCHAR(255),
S_PRICEFORONE FLOAT,
S_TYPE VARCHAR(55),
S_DESCRIPTION VARCHAR(255),
PRIMARY KEY(ID)

)

CREATE TABLE CUSTOMER_ORDER
(
ID INT NOT NULL IDENTITY,
QUANTITY INT,
SERVICEID INT,
PRIMARY KEY(ID),
CONSTRAINT FK_SERVICE_ID FOREIGN KEY (SERVICEID) REFERENCES SERVICE(ID)
)




CREATE TABLE STOCKTYPE
(

ID INT NOT NULL IDENTITY,
STOCKNAME VARCHAR(30),
SINGLEPRICE FLOAT,
QUANTITY INT,
CATAGORY VARCHAR(60),
PRIMARY KEY(ID)
)


CREATE TABLE STOCK
(
ID INT NOT NULL IDENTITY,
DATEOFSTOCK DATE,
EMPLOYEEID INT,
STOCKTYPEID INT,
PRIMARY KEY(ID),
CONSTRAINT FK_STOCKID_STOCK FOREIGN KEY (STOCKTYPEID) REFERENCES STOCKTYPE(ID),
CONSTRAINT FK_EMPLOYEE FOREIGN KEY (EMPLOYEEID) REFERENCES EMPLOYEE(ID)
)