package models;


import java.util.HashMap;

/**
 *
 * @author 30397446
 */
public class Customer extends User{
    //Attributes
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    private boolean isRegistered;
    private HashMap<Integer,Order> orders;
    
    
    public String displayGreeting()
    {
        String greeting = "<html>Hello " + getFirstName() + "<br>"
                + "You are logged in as a Customer</html>";
        
        return greeting;
    }
    
    
    //Getter methods
    public String getAddressLine1()
    {
        return addressLine1;
    }
    public String getAddressLine2()
    {
        return addressLine2;
    }
    public String getTown()
    {
        return town;
    }
    public String getPostcode()
    {
        return postcode;
    }
    public boolean getIsRegistered()
    {
        return isRegistered;
    }
    //HashMap for orders getter method
    public HashMap<Integer, Order> getOrders(){
        return orders;
    }
    
    //Setter methods
    public void setAddressLine1(String addressLine1In)
    {
        addressLine1 = addressLine1In;
    }
    public void setAddressLine2(String addressLine2In)
    {
        addressLine2 = addressLine2In;
    }
    public void setTown(String townIn)
    {
        town = townIn;
    }
    public void setPostcode(String postcodeIn)
    {
        postcode = postcodeIn;
    }
    public void setIsRegistered(boolean isRegisteredIn)
    {
        isRegistered = isRegisteredIn;
    }
    //Setter method for order HashMap
    public void setOrders(HashMap<Integer, Order> ordersIn){
        orders = ordersIn;
    }
    
    //Constructors - 0 Parameters
    public Customer()
    {
        super();//call for Product superclass parameters constructor
        addressLine1 = "";
        addressLine2 = "";
        town = "";
        postcode = "";
        isRegistered = false;
        orders = new HashMap();
    }
    
    
    //Constructors - 5 parameters + User parameters (except isRegistered) 
    //public User(String usernameIn, String passwordIn, String firstNameIn, String lastNameIn)
    public Customer(String addressLine1In, String addressLine2In, String townIn, String postcodeIn, String usernameIn, String passwordIn, String firstNameIn, String lastNameIn)
    {
        super(usernameIn, passwordIn, firstNameIn, lastNameIn); // Call for User superclass parameters constructor
        addressLine1 = addressLine1In;
        addressLine2 = addressLine2In;
        town = townIn;
        postcode = postcodeIn;
        isRegistered = false;
        orders = new HashMap();
    }
}
