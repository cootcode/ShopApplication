/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;
import java.util.HashMap;
import models.Customer;
import models.DBManager;

/**
 *
 * @author 30397446
 */
public class CustomerLogin extends javax.swing.JFrame {

    /**
     * Creates new form CustomerLogin
     */
    public CustomerLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCustomerLogin = new javax.swing.JLabel();
        lblCstUsername = new javax.swing.JLabel();
        lblCstPassword = new javax.swing.JLabel();
        txtCstUsername = new javax.swing.JTextField();
        txtCstPassword = new javax.swing.JTextField();
        btnCstLogin = new javax.swing.JButton();
        btnCstRegister = new javax.swing.JButton();
        btnCstBackToMainMenu = new javax.swing.JButton();
        lblCstErrorMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCustomerLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCustomerLogin.setText("CUSTOMER LOGIN");

        lblCstUsername.setText("Username");

        lblCstPassword.setText("Password");

        btnCstLogin.setText("Login");
        btnCstLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCstLoginActionPerformed(evt);
            }
        });

        btnCstRegister.setText("Register");
        btnCstRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCstRegisterActionPerformed(evt);
            }
        });

        btnCstBackToMainMenu.setText("Back to Main Menu");
        btnCstBackToMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCstBackToMainMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(lblCustomerLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lblCstErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(btnCstLogin))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCstUsername)
                                    .addComponent(lblCstPassword))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCstPassword)
                                    .addComponent(txtCstUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))
                            .addComponent(btnCstRegister)
                            .addComponent(btnCstBackToMainMenu))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblCustomerLogin)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCstUsername)
                    .addComponent(txtCstUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCstPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCstPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCstLogin)
                    .addComponent(lblCstErrorMessage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCstRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnCstBackToMainMenu)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCstLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCstLoginActionPerformed
        String emailAddress = txtCstUsername.getText();
        String password = txtCstPassword.getText();
        
        DBManager db = new DBManager();
        Customer customer = db.customerLogin(emailAddress, password);
        
        if(customer != null)
        {
            CustomerHome adminHome = new CustomerHome(customer);
            adminHome.setVisible(true);
            this.dispose();
        }else
        {
            lblCstErrorMessage.setForeground(Color.red);
            lblCstErrorMessage.setText("Try again...");
        }
    }//GEN-LAST:event_btnCstLoginActionPerformed

    private void btnCstBackToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCstBackToMainMenuActionPerformed
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCstBackToMainMenuActionPerformed

    private void btnCstRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCstRegisterActionPerformed
        CustomerRegistration customerRegister = new CustomerRegistration();
        customerRegister.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCstRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCstBackToMainMenu;
    private javax.swing.JButton btnCstLogin;
    private javax.swing.JButton btnCstRegister;
    private javax.swing.JLabel lblCstErrorMessage;
    private javax.swing.JLabel lblCstPassword;
    private javax.swing.JLabel lblCstUsername;
    private javax.swing.JLabel lblCustomerLogin;
    private javax.swing.JTextField txtCstPassword;
    private javax.swing.JTextField txtCstUsername;
    // End of variables declaration//GEN-END:variables
}
