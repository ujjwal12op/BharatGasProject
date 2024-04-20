

import Customers.*;
import gasBooking.*;
import gasSupplier.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static int count;
    // Count of cylinder , booked cylinders , deliverd cylinders , pending cylinders
    static int bcount = 0 , ccount =0 , dcount = 0,pcount = 0;
    static String dpname; // Delivery person name



    // Why we are using object of Delivery class? becasue it is having properties of each and every class of its previous classes
    @SuppressWarnings("deprecation")
    public static void CylinderCount(Delivery[] obj){ // Parsing the object 
        String[] months = new String[]{
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        for(Delivery delivery : obj){
            count = 0;
            System.out.println("in the month of " + (months[delivery.dt_2.getMonth()]));
            System.out.println("* In "+delivery.area);
            if(delivery.Status.equals("D")){
                count+= delivery.numberOfCylinders;
            }
            System.out.println("-"+count+"Cylinders deliverd");
        }
        System.out.println("\n");
    }


    @SuppressWarnings("deprecation")
    public static void CheckLateDel(Delivery[] obj)
    {
        String[] months = new String[]{
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        // since the size of month is 12 months.
        int month[] = new int[12];
        // if the status is delivered , then  we check if the amount is less than the refund amount.
        for(Delivery delivery : obj){
            if(delivery.Status.equals("D") && delivery.amount==783.75){
                // getting month of that corresponding date
                month[delivery.dt_2.getMonth()]+=1;
                // Ffebruary , month array -> at index 1st  
            }
        }

        System.out.println("---late delivery----");
        for(int i=0 ; i<12 ; i++)
        {
            if(month[i]!=0){
                System.out.println(" * In"+months[i]+"there are "+month[i]);
            }
        }
        System.out.println("\n");

    }


    public static void numOfSingleCylinders(Delivery[] obj)
    {
        System.out.println("----------Single Cylinder Holders --------------");
        for(int i = 0 ; i<obj.length ; i++)
        {
            if(obj[i].numberOfCylinders==1)
            {
                System.out.println("Customer name "+obj[i].name);
                System.out.println("Mobile number "+obj[i].mobile);
                System.out.println("Gas connection "+(i+101));
            }
        }
        System.out.println("\n");

    }


    @SuppressWarnings("resource")
    public static void DeliveryDetails(Delivery[] obj)
    {
        System.out.println("--------------Delivery details--------------");
        System.out.println("Enter the name of delivery details: ");
        dpname = new Scanner(System.in).next();
        for(Delivery delivery : obj){
            if(delivery.Status.equals("D")&&delivery.delPersonName.equals(dpname)){
                System.out.println("Customer name : "+delivery.name);
                System.out.println(" - "+delivery.street+ " "+ delivery.area +" "+delivery.pincode);
            }
        }
        System.out.println("\n");
    }

    public static void printReport(Delivery[] obj){
        System.out.println("-------Delivery Report ------------");
        for(int i = 0 ; i<obj.length ; i++)
        {
            if(obj[i].Status.equals("D")){
                dcount++;
            }
            else if(obj[i].Status.equals("B")){
                bcount++;
            }
            else if(obj[i].equals("C")){
                ccount++;
            }
            else if(obj[i].equals("P")){
                pcount++;
            }
            else{
                System.out.println("Status invalid");
            }
        }
        System.out.println("* Booked");
        System.out.println("-"+bcount+"booked");
        System.out.println("* Delivered");
        System.out.println("-"+dcount+"deliverd");
        System.out.println("* Cancelled ");
        System.out.println("-"+ccount+"Cancelled");
        System.out.println("* Pending ");
        System.out.println("-"+pcount+"Pending");
        System.out.println("\n");
    }


    public static void printInvoice(Delivery[] obj)
    {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String invoiceDate = sdf.format(d);

        for(int i=0 ; i<obj.length ; i++)
        {
            if(obj[i].Status.equals("D")){
                System.out.println("----------------------------------------------------");
                System.out.println("                               INVOICE                                ");
                System.out.println("------------------------------------------------------");
                System.out.println("Gas agency code "+gasAgency.agencyCode +"\t\t\t"+ "Date of invoice "+invoiceDate);
                System.out.println("Gas agency Name "+gasAgency.agencyName +"\t\t"+ "Agency Phone no "+gasAgency.phoneNumber);
                System.out.println("Gas connection No.:"+(i+101)+ "\t\t\t"+ "Customer Name " + obj[i].name);
                System.out.println("Booking date: "+ sdf.format(obj[i].dt_1)+"\t\t"+"Customer mobile number " + obj[i].mobile);
                System.out.println("---------------------------------------------------------------------------");
                System.out.println("Amount : "+obj[i].amount);
                System.out.println("Refund : "+obj[i].refund);
                System.out.println("Total amount "+(obj[i].amount - obj[i].refund));
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("Delivery Person name: "+obj[i].delPersonName+"\t\t"+"Delivery Person Mobile: "+obj[i].DelMobileNumber);
                System.out.println("Delivery Date: "+sdf.format(obj[i].dt_2));
                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("\n\n");
            }
        }
    }

     public static void main(String[] args) {
        
        System.out.println("**********************************************************");
        System.out.println("                                 Bharat Gas Agency                        ");
        System.out.println("*******************************************************************");
        Delivery[] deliveryObject = new Delivery[5];
        deliveryObject[0] = new Delivery("Ujjwal","Street 12","Mumbai","410206","70213648091", 1);
        deliveryObject[1] = new Delivery("Kamlesh","13","Mumbai1","4102061","70213648092", 2);
        deliveryObject[2] = new Delivery("Manish","Street 14","Mumbai2","4102062","70213648093", 1);
        deliveryObject[3] = new Delivery("Somali","Street 15","Mumbai3","4102063","70213648094", 2);
        deliveryObject[4] = new Delivery("Jonathan","Street 16","Mumbai4","4102064","70213648095", 1);
        
        for(Delivery delivery : deliveryObject){
            delivery.delPersonName();
            delivery.getLastDate();
            delivery.getDates();
            delivery.validate();
            delivery.amountCalc();
            delivery.verifyOTP();
        }
        System.out.println();
        CylinderCount(deliveryObject);
        CheckLateDel(deliveryObject);
        numOfSingleCylinders(deliveryObject);
        DeliveryDetails(deliveryObject);
        printReport(deliveryObject);
        printInvoice(deliveryObject);
    }
}
