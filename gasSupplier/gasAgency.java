package gasSupplier;

//  Here we have created the package gasAgency and also created an interface gas agency

public interface gasAgency {
    public String agencyName= "BharatGas";
    public int agencyCode = 1234;
    public int phoneNumber = 98926716;
    public int pincode = 20131;

    //  Java 8 allows us to define the methods in interfaces
    
    default void agencyDisplay(){
        System.out.println("the agency name is "+agencyName);
        System.out.println("The agency code is "+agencyCode);
        System.out.println("The phone number is "+phoneNumber);
        System.out.println("The pincode number is "+pincode);
    }
}
