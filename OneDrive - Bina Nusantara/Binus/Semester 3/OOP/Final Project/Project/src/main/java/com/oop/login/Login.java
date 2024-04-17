package com.oop.login;

import com.oop.main.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.plaf.metal.MetalBorders;

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
    
    private void disposesmooth(){
        Timer timer =new Timer(20, new ActionListener() {
            float opacity = 1.0f;
            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -=0.05f;
                if(opacity>0.0f){
                    Login.this.setOpacity(opacity);
                }else{
                    ((Timer)e.getSource()).stop();
                    Login.this.dispose();
                }
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        timer.start();
    }
    private boolean LoginCek(String username, String password){
        boolean connectionResult = DatabaseConnection.connect(username, password);
        
        return connectionResult;
    }
    private static class DatabaseConnection {
        static boolean connect(String username, String password) {
            try {
                // Replace the following with your database connection code
                String jdbcUrl = "jdbc:mysql://localhost:3306/rapotku";
                String dbUser = "root";
                String dbPassword = "";

                Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
                
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundLogin1 = new org.netbeans.modules.form.InvalidComponent();
        PanelLogin = new org.netbeans.modules.form.InvalidComponent();
        jLabel1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        menuButton1 = new org.netbeans.modules.form.InvalidComponent();
        jUsernameField1 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Quadrat-Serial", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPasswordField1.setText("Username");
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Password");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Username");

        jUsernameField1.setText("Username");
        jUsernameField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsernameField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLoginLayout = new javax.swing.GroupLayout(PanelLogin);
        PanelLogin.setLayout(PanelLoginLayout);
        PanelLoginLayout.setHorizontalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(menuButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLoginLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUsernameField1))
                .addContainerGap())
        );
        PanelLoginLayout.setVerticalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jUsernameField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(menuButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPasswordField1.getAccessibleContext().setAccessibleName("Password_box");

        javax.swing.GroupLayout backgroundLogin1Layout = new javax.swing.GroupLayout(backgroundLogin1);
        backgroundLogin1.setLayout(backgroundLogin1Layout);
        backgroundLogin1Layout.setHorizontalGroup(
            backgroundLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLogin1Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(PanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(254, 254, 254))
        );
        backgroundLogin1Layout.setVerticalGroup(
            backgroundLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLogin1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(PanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundLogin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundLogin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuButton1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void menuButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuButton1MouseClicked
        String username = jUsernameField1.getText();
        char[] passwordChars = jPasswordField1.getPassword();
        String password = new String(passwordChars);
        
       try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rapotku","root","");
            
            Statement stm = con.createStatement();
            
            String sql = "select * from dataguru where id_guru='"+username+"' and password='"+password+"'";
            ResultSet rs = stm.executeQuery(sql);
            
            if (!username.isEmpty() && password.length() > 0 ) {
                if(rs.next()){
                    disposesmooth();
                    Main pindah = new Main();
                    pindah.show();
                }else{
                    jUsernameField1.setText("");
                    jPasswordField1.setText("");
                    JOptionPane.showMessageDialog(menuButton1, "Harap isi username dan passwordnya dengan benar!!");
                }
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
//        String sql = "select * from dataguru where id_guru='"+username+"' and password='"+passwordChars+"'";
//        }else{
//            JOptionPane.showMessageDialog(menuButton1, "Username dan Password tidak boleh kosong!");
//        }
    }//GEN-LAST:event_menuButton1MouseClicked

    private void jUsernameField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsernameField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUsernameField1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.netbeans.modules.form.InvalidComponent PanelLogin;
    private org.netbeans.modules.form.InvalidComponent backgroundLogin1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JFormattedTextField jUsernameField1;
    private org.netbeans.modules.form.InvalidComponent menuButton1;
    // End of variables declaration//GEN-END:variables
}
