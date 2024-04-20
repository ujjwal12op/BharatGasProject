package Customers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class gasConnection extends Customer{
    public int numberOfCylinders;
    String date;

    // Why are we making static : Because I dont want to access this variable without creating object .
    static int ConnectionNumber =100;
    {
        ConnectionNumber+=1;
    }

    // Now we are finding the date.
    protected Date lastDate = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public gasConnection(String name, String street, String pincode, String mobile, int numberOfCylinders) {
        super(name, street, pincode, mobile); // use to call the constructor of the parent class.
        this.numberOfCylinders = numberOfCylinders;
    }

    @SuppressWarnings("resource")
    public void getLastDate(){
        System.out.println("Please enter the last date: ");
        date = new Scanner(System.in).nextLine();

        try {
            lastDate = dateFormat.parse(date);
        } catch (Exception e) {
            System.out.println("Error in the last date "+e);
        }
    }

    
}
