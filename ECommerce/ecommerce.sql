drop TABLE Product;
drop TABLE Address;
drop TABLE Customer;



CREATE TABLE Customer(Cust_ID int PRIMARY KEY, LastName varchar(20), FirstName varchar(20), Gender varchar(1), EmailID varchar(20), Password varchar(10), Phone_No VARCHAR(12));
  

CREATE TABLE Address(Addr_Id int PRIMARY KEY, City varchar(15), State varchar(20), Country varchar(20), Zip_code int , Cust_ID int, FOREIGN KEY(Cust_ID) REFERENCES Customer(Cust_ID));

CREATE TABLE Product(Prod_ID int PRIMARY KEY, Prod_Name varchar(20),  Prod_Stock int, Prod_Price float, Prod_Description varchar(30), Prod_Type varchar(10));
 CREATE TABLE cart(cart_Id int PRIMARY KEY, Prod_ID int, FOREIGN KEY(Prod_ID) REFERENCES Product(Prod_ID),quantity int,status varchar(1),order_Id int,FOREIGN KEY(order_Id) REFERENCES Shoppingorder(order_Id),Cust_ID int, FOREIGN KEY(Cust_ID) REFERENCES Customer(Cust_ID));
 CREATE TABLE Shoppingorder(order_Id int,order_date Date);