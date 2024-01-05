package models;

/**
 *
 * @author 30397446
 */
public class Staff extends User{
    //Attributes
    private String position;
    private double salary;
    
    public String displayGreeting()
    {
        String greeting = "<html>Hello " + getFirstName() + "<br>"
                + "You are logged in as a Staff member</html>";
        
        return greeting;
    }
    
    //Getter methods
    public String getPosition()
    {
        return position;
    }
    public double getSalary()
    {
        return salary;
    }
    
    //Setter methods
    public void setPosition(String positionIn)
    {
        position = positionIn;
    }
    public void setSalary(double salaryIn)
    {
        salary = salaryIn;
    }
    
    //Constructors - 0 Parameters
    public Staff()
    {
        super();
        position = "";
        salary = 0.0;
    }
    
    //Constructors - 5 parameters + User parameters (except isRegistered) 
    //public User(String usernameIn, String passwordIn, String firstNameIn, String lastNameIn)
    public Staff(String positionIn, double salaryIn, String usernameIn, String passwordIn, String firstNameIn, String lastNameIn)
    {
        super(usernameIn, passwordIn, firstNameIn, lastNameIn);//Call for superclass parameters constructor
        position = positionIn;
        salary = salaryIn;
    }
}
