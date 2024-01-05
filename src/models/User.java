package models;

/**
 *
 * @author 30397446
 */
public class User {
    //Attributes
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    
    //Getter methods
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    
    
    //Setter methods
    public void setUsername(String usernameIn)
    {
        username = usernameIn;
    }
    public void setPassword(String passwordIn)
    {
        password = passwordIn;
    }
    public void setFirstName(String firstNameIn)
    {
        firstName = firstNameIn;
    }
    public void setLastName(String lastNameIn)
    {
        lastName = lastNameIn;
    }
    
    
    //Constructor - 0 parameters
    public User()
    {
        username = "";
        password = "";
        firstName = "";
        lastName = "";
    }
    
    
    //Constructor - 4 parameters
    public User(String usernameIn, String passwordIn, String firstNameIn, String lastNameIn)
    {
        username = usernameIn;
        password = passwordIn;
        firstName = firstNameIn;
        lastName = lastNameIn;
    }
}
