/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import models.DBManager;
import models.Product;
import models.Staff;

/**
 *
 * @author 30397446
 */
public class ShopPageStaff extends javax.swing.JFrame {

    private HashMap<Integer, Product> products;
    private Staff loggedInStaff;
    /**
     * Creates new form ShopPageStaff
     */
    public ShopPageStaff(Staff staff) {
        loggedInStaff = staff;
        initComponents();
        
        DBManager db = new DBManager();
        products = db.loadProduct();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReturnToStaffHome = new javax.swing.JButton();
        lblEditProducts = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCategories = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstProducts = new javax.swing.JList<>();
        lblCategories = new javax.swing.JLabel();
        lblProducts = new javax.swing.JLabel();
        btnEditProduct = new javax.swing.JButton();
        btnRemoveProduct = new javax.swing.JButton();
        lblConfirmation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnReturnToStaffHome.setText("RETURN TO STAFF HOME");
        btnReturnToStaffHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnToStaffHomeActionPerformed(evt);
            }
        });

        lblEditProducts.setText("EDIT PRODUCTS");

        lstCategories.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Footwear", "Clothing" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstCategories.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCategoriesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstCategories);

        jScrollPane2.setViewportView(lstProducts);

        lblCategories.setText("CATEGORIES");

        lblProducts.setText("PRODUCTS");

        btnEditProduct.setText("EDIT PRODUCT");
        btnEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProductActionPerformed(evt);
            }
        });

        btnRemoveProduct.setText("DELETE PRODUCT");
        btnRemoveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReturnToStaffHome)
                        .addGap(57, 57, 57)
                        .addComponent(lblEditProducts))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategories)
                            .addComponent(btnEditProduct))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProducts)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemoveProduct, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReturnToStaffHome)
                    .addComponent(lblEditProducts))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCategories)
                    .addComponent(lblProducts))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditProduct)
                    .addComponent(btnRemoveProduct))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnToStaffHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnToStaffHomeActionPerformed
        StaffHome staffHome = new StaffHome(loggedInStaff);
        staffHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReturnToStaffHomeActionPerformed

    private void lstCategoriesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCategoriesValueChanged
        // TODO add your handling code here:
        DefaultListModel productList = new DefaultListModel();        
        String selectedAnimalType = lstCategories.getSelectedValue();
        
        //Loop through a HashMap
        //.entrySet() makes the HashMap iterable (loopable)
        //Map.Entry is 1 item within a HashMap
        for(Map.Entry<Integer, Product> productHashMapEntry : products.entrySet())
        {
            Product product = productHashMapEntry.getValue();
            
            //.getClass().getName() gets the object type (as a String)
            if (product.getClass().getName().equals("models." + selectedAnimalType))
            {
                productList.addElement(product);
            }
        }        
        lstProducts.setModel(productList);
    }//GEN-LAST:event_lstCategoriesValueChanged

    private void btnRemoveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveProductActionPerformed
        if(lstProducts.getSelectedIndex() == -1)
        {
            lblConfirmation.setText("Error: Please Select Product");
        }
        else
        {
            Object selectedObjectInListBox = lstProducts.getSelectedValue();
            Product productSelected = (Product)selectedObjectInListBox;      
            
            //Delete Animal from database
            DBManager db = new DBManager();
            db.deleteProduct(productSelected);
            
            //Delete from HashMap
            products.remove(productSelected.getProductId());
            
            //Remove from listBox
            DefaultListModel productList = (DefaultListModel)lstProducts.getModel();
            productList.remove(lstProducts.getSelectedIndex());
            
            lblConfirmation.setText("Product Deleted Successfully");
        }
    }//GEN-LAST:event_btnRemoveProductActionPerformed

    private void btnEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProductActionPerformed
        //StaffModifyProduct modifyProduct = new StaffModifyProduct(loggedInStaff, )
        if(lstProducts.getSelectedIndex() == -1)
        {
            lblConfirmation.setText("Error: Please Select Product");
        }
        else
        {
            Object selectedObjectInListBox = lstProducts.getSelectedValue();
            Product productSelected = (Product)selectedObjectInListBox; 
            
            StaffModifyProduct modifyProduct = new StaffModifyProduct(productSelected, loggedInStaff);
            modifyProduct.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnEditProductActionPerformed

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
            java.util.logging.Logger.getLogger(ShopPageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShopPageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShopPageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShopPageStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ShopPageStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditProduct;
    private javax.swing.JButton btnRemoveProduct;
    private javax.swing.JButton btnReturnToStaffHome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCategories;
    private javax.swing.JLabel lblConfirmation;
    private javax.swing.JLabel lblEditProducts;
    private javax.swing.JLabel lblProducts;
    private javax.swing.JList<String> lstCategories;
    private javax.swing.JList<String> lstProducts;
    // End of variables declaration//GEN-END:variables
}