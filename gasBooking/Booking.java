package gasBooking;
import Customers.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Booking extends gasConnection {

    public double otp = 5678,amount =825.0,refund = 0;
    public String dt,delDate , Status ,  DelMobileNumber = "721231312"; 
    public Date  dt_1;
    public Date  dt_2;

    public Booking(String name, String street,String area, String pincode, String mobile, int numberOfCylinders) {
        super(name, street,pincode,area,numberOfCylinders);
        
    }

    @SuppressWarnings("resource")
    public void getDates(){
        System.out.println("enter booking date: ");
        dt = new Scanner(System.in).nextLine();
        dt_1 = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dt_1 = dateFormat.parse(dt);
        } catch (Exception e) {
            System.out.println("The error in get dates is"+e);
        }
        // Delivery details
        System.out.println("Enter delivery date : ");
        delDate = new Scanner(System.in).nextLine();
        try{
         dt_2 = dateFormat.parse(delDate);
        }catch(Exception e)
        {
            System.out.println("Error in parsing second date "+e);
         }
         // Find the difference between two dates

         try{
            long difference = dt_2.getTime() - dt_1.getTime();

            // difference in days 
            // here the time is getting converted to days
            long newDifference = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
            if(newDifference>7)
            {
                Status = "P";
            }
         }catch(Exception e){
            System.out.println("Error while finding differnce "+e);
         }

        }

        public void validate(){
            // get the difference between two dates
            long elapstime = dt_1.getTime() - lastDate.getTime();
            // getting the time in days
            long diff = TimeUnit.DAYS.convert(elapstime, TimeUnit.MILLISECONDS);

            System.out.println("The difference between two dates is "+diff);


            // If the number of cylinders is 1 duration should be more than 30
            if(numberOfCylinders==1) // Check for single cylinder   
            {
                if(diff<30)
                {
                    System.out.println("Booking cannot be done");
                    Status = "C"; // Cancelled
                }else{  //when diff > 30
                    Status = "B" ; // Booked
                    lastDate = dt_1; // Current booking date will become last booking date
                }
                // If today i am booking the cylinder and last date was 30 days back the prev month , then current date will be the last date.
            }else if(numberOfCylinders==2){
                if(diff<50)
                {
                    System.out.println("Booking cannot be done");
                    Status= "C"; // cancelled
                }else{
                    Status = "B";
                    lastDate=dt_1;
                }
            }
        }


    }
