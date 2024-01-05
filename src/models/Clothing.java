package models;

/**
 *
 * @author 30397446
 */
public class Clothing extends Product{
    //Attributes
    private String measurement;
    
    //Getter methods
    public String getMeasurement()
    {
        return measurement;
    }
    
    //Setter methods
    public void setMeasurement(String measurementIn)
    {
        measurement = measurementIn;
    }
    
    //Constructors - 0 Parameters
    public Clothing()
    {
        super();
        measurement = "";
    }
    
    //Constructors - Clothing class 1 parameter + Product class parameters (everything - 4) = 5 in total
    //public Product(int productIdIn, String productNameIn, double priceIn, int stockLevelIn)
    public Clothing(String measurementIn, int productIdIn, String productNameIn, double priceIn, int stockLevelIn)
    {
        super(productIdIn, productNameIn, priceIn, stockLevelIn);
        measurement = measurementIn;
    }
    
    //Constructor - Clothing class 1 parameter + Product class parameters (except productId) = 4 in total
    public Clothing(String measurementIn, String productNameIn, double priceIn, int stockLevelIn)
    {
        super(productNameIn, priceIn, stockLevelIn);
        measurement = measurementIn;
    }
}
