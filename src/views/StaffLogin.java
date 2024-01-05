/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;
import java.util.HashMap;
import models.Staff;
import models.DBManager;

/**
 *
 * @author 30397446
 */
public class StaffLogin extends javax.swing.JFrame {

    /**
     * Creates new form StaffLogin
     */
    public StaffLogin() {
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

        lblStaffLogin = new javax.swing.JLabel();
        lblStfUsername = new javax.swing.JLabel();
        lblStfPassword = new javax.swing.JLabel();
        txtStUsername = new javax.swing.JTextField();
        txtStfPassword = new javax.swing.JTextField();
        btnStfLogin = new javax.swing.JButton();
        btnStfBackToMainMenu = new javax.swing.JButton();
        lblErrorMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblStaffLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStaffLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStaffLogin.setText("STAFF LOGIN");

        lblStfUsername.setText("Username");

        lblStfPassword.setText("Password");

        txtStUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStUsernameActionPerformed(evt);
            }
        });

        btnStfLogin.setText("Login");
        btnStfLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStfLoginActionPerformed(evt);
            }
        });

        btnStfBackToMainMenu.setText("Return to Main Menu");
        btnStfBackToMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStfBackToMainMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStfUsername)
                            .addComponent(lblStfPassword))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnStfLogin))
                            .addComponent(txtStfPassword)
                            .addComponent(txtStUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnStfBackToMainMenu)))
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(lblStaffLogin)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblStaffLogin)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStfUsername)
                    .addComponent(txtStUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStfPassword)
                    .addComponent(txtStfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblErrorMessage)
                    .addComponent(btnStfLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnStfBackToMainMenu)
                .addGap(40, 40, 40))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnStfLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStfLoginActionPerformed
        String emailAddress = txtStUsername.getText();
        String password = txtStfPassword.getText();
        
        DBManager db = new DBManager();
        Staff staff = db.staffLogin(emailAddress, password);
        
        if(staff != null)
        {
            StaffHome staffHome = new StaffHome(staff);
            staffHome.setVisible(true);
            this.dispose();
        }else
        {
            lblErrorMessage.setForeground(Color.red);
            lblErrorMessage.setText("Try again...");
        }
              
    }//GEN-LAST:event_btnStfLoginActionPerformed

    private void btnStfBackToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStfBackToMainMenuActionPerformed
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnStfBackToMainMenuActionPerformed

    private void txtStUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStUsernameActionPerformed

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
            java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStfBackToMainMenu;
    private javax.swing.JButton btnStfLogin;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JLabel lblStaffLogin;
    private javax.swing.JLabel lblStfPassword;
    private javax.swing.JLabel lblStfUsername;
    private javax.swing.JTextField txtStUsername;
    private javax.swing.JTextField txtStfPassword;
    // End of variables declaration//GEN-END:variables
}