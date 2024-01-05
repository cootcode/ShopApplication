package models;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 30397446
 */
public class Order {
    //Attributes
    private int orderId;
    private Date orderDate;
    private double orderTotal;
    private String status;
    private HashMap<Integer,OrderLine> orderLines;
    
        public void addOrderLine(OrderLine ol)
    {
        int orderLineID = 0;
        
        while(orderLines.containsKey(orderLineID))
        {
            orderLineID++;
        }
        
        ol.setOrderLineId(orderLineID);
        orderLines.put(orderLineID, ol);
    }
    
        public void CalculateOrder()
        {
        orderTotal = 0;
        
            for(Map.Entry<Integer, OrderLine> olMapEntry : orderLines.entrySet())
                {
                    OrderLine ol = olMapEntry.getValue();
                    orderTotal = orderTotal + ol.getLineTotal();
                }
        }
        
        
    //Getter methods
    public int getOrderId(){return orderId;}
    public Date getOrderDate(){return orderDate;}
    public double getOrderTotal(){return orderTotal;}
    public String getStatus(){return status;}
    public HashMap<Integer,OrderLine> getOrderLines(){return orderLines;}
    
    //Setter methods
    public void setOrderId(int orderIdIn){orderId = orderIdIn;}
    public void setOrderDate(Date orderDateIn){orderDate = orderDateIn;}
    public void setOrdertotal(double orderTotalIn){orderTotal = orderTotalIn;}
    public void setStatus(String statusIn){status = statusIn;}
    public void setOrderLines(HashMap<Integer,OrderLine> orderLinesIn){orderLines = orderLinesIn;}
    
    //Constructor - set orderdate to new Date() and orderLines to new HashMap()
    public Order(){
        orderId = 0;
        orderDate = new Date();
        orderTotal = 0.0;
        status = "";
        orderLines = new HashMap();
    }
    //Constructor - All except orderLines(4)
    public Order(int orderIdIn, Date orderDateIn, double orderTotalIn, String statusIn){
        orderId = orderIdIn;
        orderDate = orderDateIn;
        orderTotal = orderTotalIn;
        status = statusIn;
        orderLines = new HashMap();
    }
}
