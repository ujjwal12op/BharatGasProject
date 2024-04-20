package gasBooking;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Delivery extends Booking{

    public String delPersonName;
    int customerOTP;

    public Delivery(String name, String street,String area, String pincode, String mobile, int numberOfCylinders) {
        super(name, street,area, pincode, mobile, numberOfCylinders);
        //TODO Auto-generated constructor stub
    }



    public void amountCalc(){
        long dayDiff = dt_2.getTime() - dt_1.getTime(); // dt_2 is the delivery date and dt 1 is booking date
        // Converting time to days
        long newDiff = TimeUnit.DAYS.convert(dayDiff, TimeUnit.MILLISECONDS);



        if(newDiff>7)
        {
            refund =41.25;
            amount = amount - refund;
        }
    }





    @SuppressWarnings("resource")
    public void verifyOTP(){
        if(Status.equals("B")) // Status = booked
        {
            System.out.println("Enter OTP bro ");
            customerOTP = new Scanner(System.in).nextInt(); // taking customer OTP 

            if(customerOTP!=otp)
            {
                Status = "C"; // Cancelled
            }else{
                Status = "D";   // Delivered
            }
        }else{
            System.out.println("No booking found");
        }
    }



    @SuppressWarnings("resource")
    public void delPersonName(){
        System.out.println("Enter delivery person name ");
        delPersonName = new Scanner(System.in).nextLine();
    }
    
}
