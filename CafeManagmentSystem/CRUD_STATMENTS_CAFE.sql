


--INSERTING ROLE TYPES

INSERT INTO ROLE(POSITION,SALARY) VALUES('Waiter',3000)
INSERT INTO ROLE(POSITION,SALARY) VALUES('Manager',5000)
INSERT INTO ROLE(POSITION,SALARY) VALUES('Barista',3000)
INSERT INTO ROLE(POSITION,SALARY) VALUES('Cook',4000)
INSERT INTO ROLE(POSITION,SALARY) VALUES('Cashier',3500)

SELECT * FROM role
--///////////////////////////////////////////////


--inserting service types
		--coffee
			INSERT INTO SERVICE(name,catagory,singlePrice,description) VALUES('Macchiato','Coffee',35,'Macchiato is an espresso coffee drink, topped with a small amount of foamed or steamed milk.')
			INSERT INTO SERVICE(name,catagory,singlePrice,description) VALUES('Espressoo','Coffee',30,'Espresso coffee drink is a concentrated form of coffee served in small, strong shots.')
		--drinks
			INSERT INTO SERVICE(name,catagory,singlePrice,description) VALUES('Softdrink','bottleddrinks',25,'non alcholic bevereges')
		--Food
			INSERT INTO SERVICE(name,catagory,singlePrice,description) VALUES('NormalBurger','Food',120,'normal burger.')
			INSERT INTO SERVICE(name,catagory,singlePrice,description) VALUES('CheeseBurger','Food',150,'A hamburger topped with a slice of cheese.')
			INSERT INTO SERVICE(name,catagory,singlePrice,description) VALUES('cafeSpecial','Food',250,'ingredients are family secret.')
			INSERT INTO SERVICE(name,catagory,singlePrice,description) VALUES('Chips','Food',60,'Potato fries.')
			INSERT INTO SERVICE(name,catagory,singlePrice,description) VALUES('cafe special Pizza','Food',200,'cafe spetial ppizaa ingredients are secret.')
		--desert
			INSERT INTO SERVICE(name,catagory,singlePrice,description) VALUES('Blackforest','Desert',110,'soft cake with choclate topping.')
			INSERT INTO SERVICE(name,catagory,singlePrice,description) VALUES('Boksegna','Desert',70,'outside bread inside cream.')
			INSERT INTO SERVICE(name,catagory,singlePrice,description) VALUES('Donut','Desert',50,'Torus shaped bread with chocklate topping')

		select * from SERVICE
--////////////////////////////////////////////////


--inserting Employees




INSERT INTO EMPLOYEE(FIRSTNAME,LASTNAME,GENDER,AGE,DATE_OF_EMPLOYMENT,ROLE_ID,PASSWORD,CONTRAT_TYPE)VALUES('ASER','GEZU','MALE',20,'20120618 10:00:00 AM',5,'aser','FULL TIME')
INSERT INTO EMPLOYEE(FIRSTNAME,LASTNAME,GENDER,AGE,DATE_OF_EMPLOYMENT,ROLE_ID,PASSWORD,CONTRAT_TYPE)VALUES('ABUMA','HINSENE','MALE',20,'20120618 10:00:00 AM',2,'ABUMA','FULL TIME')
INSERT INTO EMPLOYEE(FIRSTNAME,LASTNAME,GENDER,AGE,ROLE_ID,CONTRAT_TYPE)VALUES('ELIAS','MELESE','MALE',20,1,'FULL TIME')
INSERT INTO EMPLOYEE(FIRSTNAME,LASTNAME,GENDER,AGE,ROLE_ID,CONTRAT_TYPE)VALUES('AMANUEL','KASSAHUN','MALE',20,3,'FULL TIME')
INSERT INTO EMPLOYEE(FIRSTNAME,LASTNAME,GENDER,AGE,ROLE_ID,CONTRAT_TYPE)VALUES('ABEL','ABRAHA','MALE',20,4,'FULL TIME')



SELECT * FROM EMPLOYEE