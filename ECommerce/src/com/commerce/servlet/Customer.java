package com.commerce.servlet;

public class Customer {
	int custId;
	String lastName;
	String firstName;
    String gender;
    String emailID;
    String password;
    String phoneNo;
    
    public Customer(int custId, String LastName,String FirstName, String Gender, String EmailID , String Password, String PhoneNo){
    	super();
    	this.custId= custId;
    	this.lastName= LastName;
    	this.firstName= FirstName;
    	this.gender= Gender;
    	this.emailID= EmailID;
    	this.password= Password;
    	this.phoneNo= PhoneNo;
    	
    }
   
   public Customer(int custId,String LastName,String FirstName,String Gender,String EmailID,String PhoneNo){
	  
		this.custId= custId;
	   	this.lastName= LastName;
	   	this.firstName= FirstName;
	   	this.gender= Gender;
	   	this.emailID= EmailID;
	   	this.phoneNo= PhoneNo;
	}	


public int getCust_ID() {
	return custId;
}


public void setCustId(int custId) {
	this.custId = custId;
}
public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getFirstName() {
	return firstName;
}


public void setFirsttName(String firstName) {
	this.firstName =firstName;
}
public String getGender() {
	return gender;
}


public void setGender(String gender) {
	this.gender = gender;
}
public String getEmailID() {
	return emailID;
}


public void setEmailID(String EmailID) {
	this.emailID = EmailID;
}
public String getPassword() {
	return password;
}



public void setPassword(String Password) {
	this.password = Password;
}
public String getPhoneNo() {
	return phoneNo;
}


public void setPhoneNo(String PhoneNo) {
	this.phoneNo = PhoneNo;
}
public String toString() {
	return "Customer [Cust_ID=" + custId + ", LastName=" +lastName + ", FirstName=" + firstName + ", Gender=" + gender
			+ "EmailID, =" + emailID + ",Password =" + password + ", PhoneNo=" + phoneNo + " ]";
}

}

