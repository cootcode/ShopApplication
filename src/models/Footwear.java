package models;

/**
 *
 * @author 30397446
 */
public class Footwear extends Product{
    //Attributes
    private int size;
    
    //Getter methods
    public int getSize()
    {
        return size;
    }
    
    //Setter methods
    public void setSize(int sizeIn)
    {
        size = sizeIn;
    }
    
    //Constructor 0 parameters
    public Footwear()
    {
        super();
        size = 0;
    }
    
    //Constructor with 4 parameters without productId from Product superclass
    public Footwear(int sizeIn, String productNameIn, double priceIn, int stockLevelIn)
    {
        super(productNameIn, priceIn, stockLevelIn);
        size = sizeIn;
    }
    
    //Constructor with 5 parameters (everything included)
    public Footwear(int sizeIn, int productIdIn, String productNameIn, double priceIn, int stockLevelIn)
    {
        super(productIdIn, productNameIn, priceIn, stockLevelIn);
        size = sizeIn;
    }
}
