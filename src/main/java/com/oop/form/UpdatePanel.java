/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package com.oop.form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.io.File;  
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UpdatePanel extends javax.swing.JPanel {
        
    Connection con;
    private String smtr;

    // ... Other variables and methods ...

    private void tampil(String semester) {
        String sqlDasar = "SELECT * FROM semester_";
        String sql = sqlDasar.concat(semester);
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5), rs.getString(6)});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public UpdatePanel() {
        initComponents();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/raportku", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void run() {
        try {
            smtr = readSemester();
            tampil(smtr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String readSemester() {
        String word = null;
        try {
            File myObj = new File("semester.txt");
            Scanner myReader = new Scanner(myObj);

            if (myReader.hasNext()) {
                word = myReader.next();
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return word;

        }
    private void deleteSemester(){
        File myObj = new File("semester.txt");
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMAT = new javax.swing.JTextField();
        txtIPA = new javax.swing.JTextField();
        txtIPS = new javax.swing.JTextField();
        txtBIN = new javax.swing.JTextField();
        txtBIG = new javax.swing.JTextField();
        DeleteButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Siswa", "Matematika", "IPA", "IPS", "BIN", "BIG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 463, 168));

        jLabel1.setText("ID Siswa :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 27, -1, -1));

        txtID.setEnabled(false);
        txtID.setFocusable(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 27, 90, -1));

        jLabel3.setText("Matematika : ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 30, -1, -1));

        jLabel4.setText("IPA : ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 58, -1, -1));

        jLabel5.setText("IPS :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 93, -1, -1));

        jLabel6.setText("BIN :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 121, -1, -1));

        jLabel7.setText("BIG :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));
        add(txtMAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 27, 87, -1));
        add(txtIPA, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 55, 87, -1));
        add(txtIPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 90, 87, -1));

        txtBIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBINActionPerformed(evt);
            }
        });
        add(txtBIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 118, 87, -1));
        add(txtBIG, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 147, 87, -1));

        DeleteButton.setText("DELETE");
        DeleteButton.setMaximumSize(new java.awt.Dimension(75, 30));
        DeleteButton.setMinimumSize(new java.awt.Dimension(75, 30));
        DeleteButton.setPreferredSize(new java.awt.Dimension(75, 30));
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 240, 60));

        UpdateButton.setText("UPDATE");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        add(UpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 240, 60));

        jButton7.setText("Show");
        jButton7.setMaximumSize(new java.awt.Dimension(75, 40));
        jButton7.setMinimumSize(new java.awt.Dimension(75, 40));
        jButton7.setPreferredSize(new java.awt.Dimension(75, 40));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 460, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtBINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBINActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

    DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();
    int selectedRow = jTable2.getSelectedRow();
    if (selectedRow != -1) {
        String tblID = getValueAsString(tblModel.getValueAt(selectedRow, 0));
        String tblMAT = getValueAsString(tblModel.getValueAt(selectedRow, 1));
        String tblIPA = getValueAsString(tblModel.getValueAt(selectedRow, 2));
        String tblIPS = getValueAsString(tblModel.getValueAt(selectedRow, 3));
        String tblBIN = getValueAsString(tblModel.getValueAt(selectedRow, 4));
        String tblBIG = getValueAsString(tblModel.getValueAt(selectedRow, 5));

        txtID.setText(tblID);
        txtMAT.setText(tblMAT);
        txtIPA.setText(tblIPA);
        txtIPS.setText(tblIPS);
        txtBIN.setText(tblBIN);
        txtBIG.setText(tblBIG);
    }
    }//GEN-LAST:event_jTable2MouseClicked

    private String getValueAsString(Object value) {
    return (value != null) ? value.toString() : "";
}

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
    String tblID = txtID.getText();
//    String tblNama = txtNama.getText();
    String tblMAT = txtMAT.getText();
    String tblIPA = txtIPA.getText();
    String tblIPS = txtIPS.getText();
    String tblBIN = txtBIN.getText();
    String tblBIG = txtBIG.getText();
    
    String smtr = readSemester();
    String smesterdasar = "semester_";
    String semester = smesterdasar.concat(smtr);
    String sql = "UPDATE " + semester + " SET matematika = " + tblMAT+", ipa = "+tblIPA+", ips = "+tblIPS+", bin = "+tblBIN+", big = "+tblBIG+" WHERE id_siswa = "+tblID;
    try{
        PreparedStatement pst = con.prepareStatement(sql);
        pst.executeUpdate();
    }catch(SQLException e){
    }
    tampil(smtr);
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        String tblID = txtID.getText(); // Ambil ID dari text field atau di mana pun Anda menyimpan ID
    
    String[] tables = {"semester_1", "semester_2", "semester_3", "semester_4", "semester_5", "semester_6"};
    
    for (String table : tables) {
        String sql = "DELETE FROM " + table + " WHERE id_siswa = ?";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, tblID);
            
            int affectedRows = pst.executeUpdate();
            
            if (affectedRows > 0) {
                System.out.println("Data berhasil dihapus dari " + table);
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            } else {
                System.out.println("Tidak ada data yang dihapus dari " + table);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        tampil(smtr);
    }
    String sql = "DELETE FROM datasiswa WHERE id_siswa ="+tblID;
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        smtr = readSemester();
        tampil(smtr);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtBIG;
    private javax.swing.JTextField txtBIN;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIPA;
    private javax.swing.JTextField txtIPS;
    private javax.swing.JTextField txtMAT;
    // End of variables declaration//GEN-END:variables
}
