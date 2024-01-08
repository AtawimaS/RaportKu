/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.oop.login;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.oop.dashboard.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Color;
import java.sql.PreparedStatement;
import javax.swing.JFrame;


/**
 *
 * @author Will
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setResizable(false);
        setupKeyListener();
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
    
    private void setupKeyListener() {
        jUsernameField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jPasswordField1.requestFocusInWindow();
                    jPasswordField1.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        jPasswordField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Simulate button click
                    menuButton1.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
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

        backgroundLogin1 = new Component.BackgroundLogin();
        login_rectangle1 = new Component.login_rectangle();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jUsernameField1 = new javax.swing.JFormattedTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        menuButton1 = new Component.MenuButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 500));
        setMinimumSize(new java.awt.Dimension(1000, 500));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Username");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Password");

        jUsernameField1.setText("Username");
        jUsernameField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUsernameField1MouseClicked(evt);
            }
        });
        jUsernameField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsernameField1ActionPerformed(evt);
            }
        });

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPasswordField1.setText("Username");
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseClicked(evt);
            }
        });
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Quadrat-Serial", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RaportKu");
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        menuButton1.setText("Login");
        menuButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout login_rectangle1Layout = new javax.swing.GroupLayout(login_rectangle1);
        login_rectangle1.setLayout(login_rectangle1Layout);
        login_rectangle1Layout.setHorizontalGroup(
            login_rectangle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(login_rectangle1Layout.createSequentialGroup()
                .addGroup(login_rectangle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(login_rectangle1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(login_rectangle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jUsernameField1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField1)))
                    .addGroup(login_rectangle1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(menuButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        login_rectangle1Layout.setVerticalGroup(
            login_rectangle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(login_rectangle1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jUsernameField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(menuButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout backgroundLogin1Layout = new javax.swing.GroupLayout(backgroundLogin1);
        backgroundLogin1.setLayout(backgroundLogin1Layout);
        backgroundLogin1Layout.setHorizontalGroup(
            backgroundLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLogin1Layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(login_rectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );
        backgroundLogin1Layout.setVerticalGroup(
            backgroundLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLogin1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(login_rectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        getContentPane().add(backgroundLogin1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jUsernameField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsernameField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUsernameField1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jUsernameField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUsernameField1MouseClicked
        jUsernameField1.setText("");
    }//GEN-LAST:event_jUsernameField1MouseClicked

    private void jPasswordField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseClicked
        jPasswordField1.setText("");
    }//GEN-LAST:event_jPasswordField1MouseClicked

    private void menuButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuButton1MouseClicked
        String username = jUsernameField1.getText();
        char[] passwordChars = jPasswordField1.getPassword();
        String password = new String(passwordChars);

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/raportku", "root", "")) {
            // Teacher authentication
            String teacherSql = "SELECT * FROM dataguru WHERE id_guru=? AND password=?";
            try (PreparedStatement teacherStmt = con.prepareStatement(teacherSql)) {
                teacherStmt.setString(1, username);
                teacherStmt.setString(2, password);
                try (ResultSet rs = teacherStmt.executeQuery()) {
                    if (rs.next()) {
                        WriteFile(username);
                        Dashboard1 pindah = new Dashboard1();
                        pindah.show();
                        this.setVisible(false);
                        disposesmooth();
                        return; // Exit the method if authentication succeeds
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Student authentication
            String studentSql = "SELECT * FROM datasiswa WHERE nama_siswa=? AND id_siswa=?";
            try (PreparedStatement studentStmt = con.prepareStatement(studentSql)) {
                studentStmt.setString(1, username);
                studentStmt.setString(2, password);
                try (ResultSet ra = studentStmt.executeQuery()) {
                    if (ra.next()) {
                        WriteFile(password);
                        Dashboard_Siswa pindah = new Dashboard_Siswa();
                        pindah.show();
                        this.setVisible(false);
                        disposesmooth();
                    } else {
                        jUsernameField1.setText("");
                        jPasswordField1.setText("");
                        JOptionPane.showMessageDialog(menuButton1, "Harap isi username dan passwordnya dengan benar!!");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menuButton1MouseClicked

    private void WriteFile(String password) {
    try {
        File file = new File("nim.txt");
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("File 'nim.txt' berhasil dibuat.");
            } else {
                System.out.println("Gagal membuat file 'nim.txt'.");
            }
        }
        FileWriter writer = new FileWriter(file);
        writer.write(password);
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

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
    private Component.BackgroundLogin backgroundLogin1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JFormattedTextField jUsernameField1;
    private Component.login_rectangle login_rectangle1;
    private Component.MenuButton menuButton1;
    // End of variables declaration//GEN-END:variables
}
