/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.oop.dashboard;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Graph.chart1.ModelChart;


import java.io.File;  
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Will
 */

public class Dashboard_Siswa extends javax.swing.JFrame {
    Connection con;
    String nim;
    public Dashboard_Siswa() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/raportku", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        initComponents();
        nim = readNIM();
        chart.setTitle("Graph");
        chart.addLegend("Matematika", Color.WHITE, Color.WHITE);
        chart.addLegend("IPA", Color.WHITE, Color.WHITE);
        chart.addLegend("IPS", Color.WHITE, Color.WHITE);
        chart.addLegend("BIN", Color.WHITE, Color.WHITE);
        chart.addLegend("BIG", Color.WHITE, Color.WHITE);
        chart.addLegend("Rerata", Color.WHITE, Color.WHITE);
        String sql = "CALL tampilnilaiNim("+nim+")";
//        System.out.println(sql);
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            List<ModelData> lists = new ArrayList<>();
            while (rs.next()) {
                int matematika = rs.getInt(1);
                int ipa = rs.getInt(2);
                int ips = rs.getInt(3);
                int bin = rs.getInt(4);
                int big = rs.getInt(5);
                float rerata = rs.getFloat(6); 
                String semester = rs.getString(7); 
                lists.add(new ModelData(semester, matematika, ipa, ips,bin,big,rerata));
            }
            rs.close();
            pst.close();
            for (int i = 0; i < lists.size(); i++) {
                ModelData d = lists.get(i);
                chart.addData(new ModelChart(d.getSemester(), new double[]{d.getMatematika(), d.getIpa(), d.getIps(), d.getBin(), d.getBig(), d.getRerataSemester()}));
            }

            chart.start();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private String readNIM() {
        String word = null;
        try {
            File myObj = new File("nim.txt");
            Scanner myReader = new Scanner(myObj);

            if (myReader.hasNext()) {
                word = myReader.next();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error reading nim.txt: " + e.getMessage());
        }
        return word;
    }
    private void deletenim(){
        File myObj = new File("nim.txt");
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
    public void run() {
        try {
            nim = readNIM();
            tampil(nim);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void tampil(String nim) {
        String sql = "CALL tampilnilaiNim("+nim+")";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                int matematika = rs.getInt(1);
                int ipa = rs.getInt(2);
                int ips = rs.getInt(3);
                int bin = rs.getInt(4);
                int big = rs.getInt(5);
                float rerata = rs.getFloat(6); 
                String semester = rs.getString(7); 
                model.addRow(new Object[]{matematika, ipa, ips, bin, big, rerata, semester});
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelShadow1 = new Graph.panel1.PanelShadow();
        chart = new Graph.chart1.CurveLineChart();
        create_button1 = new Component.create_button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Matematika", "IPA", "IPS", "BIN", "BIG", "Rata", "Semester"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        panelShadow1.setBackground(new java.awt.Color(0, 0, 0));
        panelShadow1.setColorGradient(new java.awt.Color(102, 102, 102));
        panelShadow1.setMaximumSize(new java.awt.Dimension(500, 300));
        panelShadow1.setMinimumSize(new java.awt.Dimension(500, 300));
        panelShadow1.setPreferredSize(new java.awt.Dimension(500, 300));

        chart.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );

        create_button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create_button1MouseClicked(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SHOW");

        javax.swing.GroupLayout create_button1Layout = new javax.swing.GroupLayout(create_button1);
        create_button1.setLayout(create_button1Layout);
        create_button1Layout.setHorizontalGroup(
            create_button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );
        create_button1Layout.setVerticalGroup(
            create_button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(create_button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(create_button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void create_button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create_button1MouseClicked
        nim = readNIM();
        tampil(nim);
        deletenim();
    }//GEN-LAST:event_create_button1MouseClicked

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
            java.util.logging.Logger.getLogger(Dashboard_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard_Siswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Graph.chart1.CurveLineChart chart;
    private Component.create_button create_button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private Graph.panel1.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
