/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.util.Date;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import models.Customer;
import models.DBManager;
import models.Order;
import models.OrderLine;
import models.Product;

/**
 *
 * @author 30397446
 */
public class CustomerBasket extends javax.swing.JFrame {
    
    private Customer loggedInCustomer;
    private Order currentOrder;
    /**
     * Creates new form CustomerBasket
     */
    public CustomerBasket(Customer customer, Order o) 
    {
        loggedInCustomer = customer;
        currentOrder = o;
        initComponents();
        
        DefaultTableModel basketModel = (DefaultTableModel)tblCurrentBasket.getModel();
                
        for(Map.Entry<Integer, OrderLine> orderLineMapEntry : currentOrder.getOrderLines().entrySet())
        {
            OrderLine actualOrderLine = orderLineMapEntry.getValue();
            Product productInOrderLine = actualOrderLine.getProduct();
            
            basketModel.addRow(new Object[] {
                actualOrderLine.getQuantity(),
                productInOrderLine.getProductName(),
                "£" + productInOrderLine.getPrice(),                
                "£" + actualOrderLine.getLineTotal()
            });
        }
        
        updateTotalLabel();
        
    }
    
    private void updateTotalLabel() 
    {
        double total = calculateTotal();
        lblTotal.setText("Total: £" + String.format("%.2f", total));
    }

    private double calculateTotal() 
    {
        DefaultTableModel model = (DefaultTableModel) tblCurrentBasket.getModel();
        int rowCount = model.getRowCount();
        double total = 0.0;

        for (int i = 0; i < rowCount; i++) {
            // Assuming the "Price Total" column is at index 3
            String priceTotalStr = model.getValueAt(i, 3).toString();

            // Remove the currency symbol and convert to double
            double priceTotal = Double.parseDouble(priceTotalStr.replace("£", ""));

            total += priceTotal;
        }

        return total;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCurrentBasket = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnBuy = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        lblErrorMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCurrentBasket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quantity", "Product Name", "Price(for each)", "Price Total"
            }
        ));
        jScrollPane1.setViewportView(tblCurrentBasket);

        btnBack.setText("ADD MORE PRODUCTS");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnBuy.setText("PLACE AN ORDER");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        lblTotal.setText("Total: £0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuy))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnBuy)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        ShopPageCustomers ShopPageCustomers = new ShopPageCustomers(loggedInCustomer, currentOrder);
        ShopPageCustomers.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
            currentOrder.setOrderDate(new Date());
            loggedInCustomer.setUsername(loggedInCustomer.getUsername());
            currentOrder.CalculateOrder();
            currentOrder.setStatus("Order Placed");
            
            
            DBManager db = new DBManager();
            //On assessment you would need to pass into 'writeOrder' the logged in customer's unique identifier
            int orderId = db.writeOrder(currentOrder, loggedInCustomer.getUsername());
            
            for(Map.Entry<Integer, OrderLine> olMapEntry : currentOrder.getOrderLines().entrySet())
            {
                OrderLine ol = olMapEntry.getValue();
                db.updateProductAvailability(ol.getProduct().getProductId(), ol.getQuantity());
                
            }
            
            
            ConfirmationPage confirmPage = new ConfirmationPage(loggedInCustomer);
            confirmPage.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnBuyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new CustomerBasket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBuy;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblCurrentBasket;
    // End of variables declaration//GEN-END:variables
}
