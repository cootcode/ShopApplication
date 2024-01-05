package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author 30397446
 */
public class DBManager {
    
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private final String connectionString = "jdbc:ucanaccess://C:\\Users\\DawidG\\Downloads\\30397446_Shop STAGE12\\30397446_Shop STAGE12\\30397446_Shop\\data\\ShopDB.accdb";
    
    
    public void modifyProduct(Product product)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);      
            Statement statement = conn.createStatement(); 
            
            //Set default
            String measurement = "";
            String size = "null";
            
            if(product.getClass().getName().equals("models.Footwear" ))
            {
                size = String.valueOf(((Footwear)product).getSize());
            }
            else
            {
                measurement = ((Clothing)product).getMeasurement();
            }
            
            statement.executeUpdate("UPDATE Products SET " 
                    + "ProductName = '" + product.getProductName() +    "', "
                    + "Price = " + product.getPrice() +                 ", "
                    + "StockLevel = " + product.getStockLevel() +       ", "
                    + "Measurement = '" + measurement +                  "', " 
                    + "Size = " + size +                                " " 
                    + "WHERE ProductId = " + product.getProductId());
        }
        catch(Exception ex)
        {
            System.out.println("Error modifying product details: " + ex.getMessage());
        }
    }
    
        public void registerCustomer(Customer customer)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);      
            Statement statement = conn.createStatement(); 
            
            //executeUpdate required for using INSERT and no ResultSet needed
            statement.executeUpdate("INSERT INTO Customers (Username, Password, FirstName, "
                    + "LastName, AddressLine1, AddressLine2, Town, Postcode) VALUES ("
                    + "'" + customer.getUsername()       + "',"
                    + "'" + customer.getPassword()       + "',"
                    + "'" + customer.getFirstName()      + "',"
                    + "'" + customer.getLastName()       + "',"
                    + "'" + customer.getAddressLine1()   + "',"
                    + "'" + customer.getAddressLine2()   + "',"
                    + "'" + customer.getTown()           + "',"
                    + "'" + customer.getPostcode()       + "')");
        }
            catch(Exception ex)
        {
            System.out.println("Error inserting new customer: " + ex.getMessage());
        }
    }
        
    
    
    
    public void updateProductAvailability(int productId, int quantity) 
        //Either pass in AnimalID (int) OR whole Animal object
        //In assessment- need 2 parameters: ID AND Quantity
        //Quantity can either be int OR from whole OrderLine object
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);      
            Statement statement = conn.createStatement(); 
            
            //...SET StockLevel = StockLevel - Quantity WHERE.......
            statement.executeUpdate("UPDATE Products SET StockLevel = (StockLevel - " + quantity + ")"
                    + "WHERE ProductId = " + productId);
        }
        catch(Exception ex)
        {
            System.out.println("Error updating product availability: " + ex.getMessage());
        }
    }
    
    
    public void deleteProduct(Product product) // Either pass in AnimalID (int) OR whole Animal object
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);      
            Statement statement = conn.createStatement(); 
            
            statement.executeUpdate("DELETE FROM Products WHERE ProductId = " + product.getProductId());
        }
        catch(Exception ex)
        {
            System.out.println("Error deleting animal: " + ex.getMessage());
        }
    }   
    
    
    
    
        public void writeOrderLine(OrderLine ol, int OrderId)
    {
        int orderLineId = 0;
        
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);      
            Statement statement = conn.createStatement(); 
            
            //dont need to insert orderid because it will be auto generated
            statement.executeUpdate("INSERT INTO OrderLines (ProductId, Quantity, LineTotal, OrderId) VALUES (" +
                    "'" + ol.getProduct().getProductId()        + "'," +
                    "'" + ol.getQuantity()                      + "'," + 
                    "'" + OrderId                               + "'," +
                    "'" + ol.getLineTotal()                     + "')");
            
            ResultSet rs = statement.getGeneratedKeys();
            
            //check if statement is empty
            if (rs.next())
            {
                orderLineId = rs.getInt(1);
            }
            ol.setOrderLineId(orderLineId);
            
        }
        catch(Exception ex)
        {
            System.out.println("Error writing Order Line: " + ex.getMessage());
        }   
    }
    
    
    public int writeOrder(Order o, String customerUsername)
    {
        int orderId = 0;
        
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);      
            Statement statement = conn.createStatement(); 
            
            //dont need to insert orderid because it will be auto generated
            statement.executeUpdate("INSERT INTO Orders (OrderDate, Username, OrderTotal, Status) VALUES (" +
                    "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(o.getOrderDate())    + "'," +
                    "'" + customerUsername         + "'," +
                    "'" + o.getOrderTotal()        + "'," +
                    "'" + o.getStatus()            + "')");
            
            ResultSet rs = statement.getGeneratedKeys();
            
            //check if statement is empty
            if (rs.next())
            {
                orderId = rs.getInt(1);
            }
            o.setOrderId(orderId);
            
        }
        catch(Exception ex)
        {
            System.out.println("Error writing order: " + ex.getMessage());
        }
        finally
        {
            return orderId;
        }    
    }
        
    
    
    public HashMap<Integer, Product> loadProduct(){ // Integer "ProductId" - will be unique identifier
        
        HashMap<Integer, Product> loadedProducts = new HashMap();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            
            Statement stat = conn.createStatement();
            
            ResultSet rs = stat.executeQuery("SELECT * from Products");
            
            while(rs.next())
            {
                int productId = rs.getInt("ProductId");
                String productName = rs.getString("ProductName");
                double price = rs.getDouble("Price");
                int stockLevel = rs.getInt("StockLevel");
                String measurement = rs.getString("Measurement");
                int size = rs.getInt("Size");
                
                
                if (measurement == null || measurement.equals(""))
                {
                    //public Footwear(int sizeIn, int productIdIn, String productNameIn, double priceIn, int stockLevelIn)
                    Footwear footwear = new Footwear(size, productId, productName, price, stockLevel);
                    loadedProducts.put(productId, footwear);
                }
                else
                {
                    //public Clothing(String measurementIn, int productIdIn, String productNameIn, double priceIn, int stockLevelIn)
                    Clothing clothing = new Clothing(measurement, productId, productName, price, stockLevel);
                    loadedProducts.put(productId, clothing);
                }
                
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Error loading products: " + e.getMessage());
        }
        finally
        {
            return loadedProducts;
        }
    }
    
    
    
        //Customer login
        public Customer customerLogin(String emailAddress, String password){
        HashMap<String, Customer> loadedCustomers = loadCustomer();
        
        //check if the input emailaddress exists in database
        if(loadedCustomers.containsKey(emailAddress))
        {
            //email address is good and check if password is correct
            Customer customerWithThatEmail = loadedCustomers.get(emailAddress);
            if(customerWithThatEmail.getPassword().equals(password))
            {
                return customerWithThatEmail;
            }
            //return null and that means the password is wrong
            else{
                return null;
                }
        }
        //return null and that means email doesnt exist
        else{
            return null;
            }
        
        }
        
        //Staff login
        public Staff staffLogin(String emailAddress, String password){
        HashMap<String, Staff> loadedStaff = loadStaff();
        
        //check if the input emailaddress exists in database
        if(loadedStaff.containsKey(emailAddress))
        {
            //email address is good and check if password is correct
            Staff staffWithThatEmail = loadedStaff.get(emailAddress);
            if(staffWithThatEmail.getPassword().equals(password))
            {
                return staffWithThatEmail;
            }
            //return null and that means the password is wrong
            else{
                return null;
                }
        }
        //return null and that means email doesnt exist
        else{
            return null;
            }
        
        }
        
    
    
    public HashMap<String, Customer> loadCustomer(){ // String "email" - will be unique identifier
        
        HashMap<String, Customer> loadedCustomers = new HashMap();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            
            Statement stat = conn.createStatement();
            
            ResultSet rs = stat.executeQuery("SELECT * from Customers");
            
            while(rs.next())
            {
                String addressLine1 = rs.getString("AddressLine1");
                String addressLine2 = rs.getString("AddressLine2");
                String town = rs.getString("Town");
                String postcode = rs.getString("Postcode");
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                

                Customer customer = new Customer(addressLine1, addressLine2, town, postcode, username, password, firstName, lastName);
                
                loadedCustomers.put(username, customer);
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Error loading admins: " + e.getMessage());
        }
        finally
        {
            return loadedCustomers;
        }
    }
    
     public HashMap<String, Staff> loadStaff(){ // String "email" - will be unique identifier
        
        HashMap<String, Staff> loadedStaff = new HashMap();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            
            Statement stat = conn.createStatement();
            
            ResultSet rs = stat.executeQuery("SELECT * from Staff");
            
            while(rs.next())
            {
                String position = rs.getString("Position");
                double salary = rs.getDouble("Salary");
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                

                Staff staff = new Staff(position, salary, username, password, firstName, lastName);
                
                loadedStaff.put(username, staff);
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Error loading admins: " + e.getMessage());
        }
        finally
        {
            return loadedStaff;
        }
    }
     
         public HashMap<String, Customer> loadCustomerOrders(HashMap<String, Customer> Customers) //String- because key will be email address
    {
        
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString); //import Connection     
            Statement statement = conn.createStatement(); //import Statement 
            
            ResultSet rs = statement.executeQuery("SELECT * From Orders"); //import ResultSet

            while(rs.next())
            {
                int orderId = rs.getInt("OrderId");
                long orderTimestamp = rs.getTimestamp("OrderDate").getTime();
                Date orderDate = new Date(orderTimestamp);
                String CustomerUsername = rs.getString("Username");
                double orderTotal = rs.getDouble("OrderTotal");
                String status = rs.getString("Status");
                
                
                //public Order(int orderIdIn, Date orderDateIn, double orderTotalIn, String statusIn)
                Order order = new Order(orderId, orderDate, orderTotal, status);
                
                if(Customers.containsKey(CustomerUsername)) //Check zooKeeper exists with that email
                {
                    Customer cst = Customers.get(CustomerUsername); //Will get zooKeeper for order
                    cst.getOrders().put(orderId, order); //Will add order to that zooKeepers orders
                }
            }
        
        
        }
        catch(Exception ex)
        {
            System.out.println("Error loading orders: " + ex.getMessage());
        }
        finally
        {
            return Customers;
        }    
    }
}
