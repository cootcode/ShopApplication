package models;

/**
 *
 * @author 30397446
 */
public class Product {    
    //Attributes
    private int productId;
    private String productName;
    private double price;
    private int stockLevel;

    @Override
    public String toString()
    {
        String display = productName;
        return display;
    }
    //Getter methods
    public int getProductId()
    {
        return productId;
    }
    public String getProductName()
    {
        return productName;
    }
    public double getPrice()
    {
        return price;
    }
    public int getStockLevel()
    {
        return stockLevel;
    }
    
    
    
    //Setter methods
    public void setProductId(int productIdIn)
    {
        productId = productIdIn;
    }
    public void setProductName(String productNameIn)
    {
        productName = productNameIn;
    }
    public void setPrice(double priceIn)
    {
        price = priceIn;
    }
    public void setStockLevel(int stockLevelIn)
    {
        stockLevel = stockLevelIn;
    }
    
    
    //Constructor - 0 Parameters
    public Product()
    {
        productId = 0;
        productName = "";
        price = 0.0;
        stockLevel = 0;
    }
    
    
    //Constructor - 3 Parameters without ProductId
    public Product(String productNameIn, double priceIn, int stockLevelIn)
    {
        productId = 0;
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;
    }
    
    
    //Constructor - 4 Parameters
    public Product(int productIdIn, String productNameIn, double priceIn, int stockLevelIn)
    {
        productId = productIdIn;
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;
    }
}
