# Database Challenge
This project is a demo of how to implement JPA using Hibernate in InteliJ IDEA with MySQL.

## Technologies
- InteliJ IDEA 2022.2
- MySQL Workbench 8.0 CE
- TestNG

## Challenge

1. Create the table institution that will have a relationship with the table employee
   (use foreign key), to show the studies from an employee. Take a screenshot from the
   new Entity-Relationship Diagram.
- At run the next file on MySQL, it will be created the database on MySQL: [Diagram entity-relationship](https://github.com/Nessa2513/DBChallenge/blob/master/External%20files%20DBC/createForChallenge.sql)

###### Diagram entity-relationship
![Diagram entity-relation ship](https://github.com/Nessa2513/DBChallenge/blob/master/External%20files%20DBC/Diagrama%20Entidad-Relacion.png)

##### Diagram entity-relationship connect to columns
![Diagram entity-relationship connect to columns](https://github.com/Nessa2513/DBChallenge/blob/master/External%20files%20DBC/Diagrama%20Entidad-Relacion%20connectToColumns.png)

####
2. Use the Join Clause to get the data from the tables institution and employee
- [Code for this point on clicking here](https://github.com/Nessa2513/DBChallenge/blob/master/External%20files%20DBC/Challenge.sql)
  
![Result](https://github.com/Nessa2513/DBChallenge/blob/master/External%20files%20DBC/2.png)
####
3. Use Sub-Queries to get the data from the children whose parents work in PriceSmart
   (idCompany = 5). Note: Get the data only from the table children.
- [Code for this point on clicking here](https://github.com/Nessa2513/DBChallenge/blob/master/External%20files%20DBC/Challenge.sql)

![Result](https://github.com/Nessa2513/DBChallenge/blob/master/External%20files%20DBC/3.png)
####
4. Create a Java program using JPA+Hibernate to create a database connection, where
   the user should be able to perform the following actions:
   - Get all records from the table employee
   - Get employees by last name from the table employee
   - Insert a new record in the table employee
   - Update a record in the table employee
   - Delete a record in the table employee

    

