package Customers;

import gasSupplier.gasAgency;

public class Customer implements gasAgency{
    public String name;
    public String street;
    public String area;
    public String pincode;
    public String mobile;

    // We create a constructor
    // What is a constructor : Whenever we want to assign variable or run any block of code at the time of object creation we use the concept of constructor
    // It has the same name as the class name;

    // For generating constructors automatically go source action and select genarate constructors.

    public Customer(String name, String street, String pincode, String mobile) {
        this.name = name;
        this.street = street;
        this.pincode = pincode;
        this.mobile = mobile;
    }
}
