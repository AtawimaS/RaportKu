
package com.oop.dashboard;

import com.oop.slider.*;
import Component.NavigateSemester;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Component.SemesterChangeListener;
import java.awt.Color;

/**
 *
 * @author Will
 */
public class Dashboard1 extends javax.swing.JFrame {
    int open=0,open1=0;
    int x,y;
    int Semester;
    private NavigateSemester NavigateSemester;
    public Dashboard1() {
        initComponents();
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
//        SemesterPanel = new NavigateSemester(this);
    }
    
    private void tutupSemesterPanel(){
        navigateSemester1.setSize(124,500);
        Thread th = new Thread(){
            @Override
            public void run(){
                try{
                    for(int i = 500;i>=0;i--){
                        Thread.sleep(0,5);
                        navigateSemester1.setSize(124,i);
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        };th.start();
        x=0;
        open=0;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navigatePanel = new Component.NavigatePanel();
        menuButton1 = new Component.MenuButton();
        menuButton2 = new Component.MenuButton();
        menuButton3 = new Component.MenuButton();
        menuButton4 = new Component.MenuButton();
        jButton1 = new javax.swing.JButton();
        navigateSemester1 = new Component.NavigateSemester();
        Semester1Button = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Semester1Button1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Semester1Button2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Semester1Button3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Semester1Button4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Semester1Button5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        formCreate1 = new com.oop.form.FormCreate();
        formUpdate1 = new com.oop.form.FormUpdate();
        formView1 = new com.oop.form.FormView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuButton1.setText("Create");

        menuButton2.setText("Update");
        menuButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuButton2MouseClicked(evt);
            }
        });
        menuButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton2ActionPerformed(evt);
            }
        });

        menuButton3.setText("View");
        menuButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton3ActionPerformed(evt);
            }
        });

        menuButton4.setText("Exit");

        jButton1.setText("=");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout navigatePanelLayout = new javax.swing.GroupLayout(navigatePanel);
        navigatePanel.setLayout(navigatePanelLayout);
        navigatePanelLayout.setHorizontalGroup(
            navigatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigatePanelLayout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addGroup(navigatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menuButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        navigatePanelLayout.setVerticalGroup(
            navigatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(menuButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menuButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menuButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menuButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );

        getContentPane().add(navigatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 500));

        Semester1Button.setToolTipText("");
        Semester1Button.setOpaque(false);
        Semester1Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Semester1ButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Semester1ButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Semester1ButtonMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Semester 1");

        javax.swing.GroupLayout Semester1ButtonLayout = new javax.swing.GroupLayout(Semester1Button);
        Semester1Button.setLayout(Semester1ButtonLayout);
        Semester1ButtonLayout.setHorizontalGroup(
            Semester1ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Semester1ButtonLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        Semester1ButtonLayout.setVerticalGroup(
            Semester1ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Semester1ButtonLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        Semester1Button1.setOpaque(false);
        Semester1Button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Semester1Button1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Semester1Button1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Semester1Button1MouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Semester 2");

        javax.swing.GroupLayout Semester1Button1Layout = new javax.swing.GroupLayout(Semester1Button1);
        Semester1Button1.setLayout(Semester1Button1Layout);
        Semester1Button1Layout.setHorizontalGroup(
            Semester1Button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Semester1Button1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Semester1Button1Layout.setVerticalGroup(
            Semester1Button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Semester1Button1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        Semester1Button2.setOpaque(false);
        Semester1Button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Semester1Button2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Semester 3");

        javax.swing.GroupLayout Semester1Button2Layout = new javax.swing.GroupLayout(Semester1Button2);
        Semester1Button2.setLayout(Semester1Button2Layout);
        Semester1Button2Layout.setHorizontalGroup(
            Semester1Button2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Semester1Button2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Semester1Button2Layout.setVerticalGroup(
            Semester1Button2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Semester1Button2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        Semester1Button3.setOpaque(false);
        Semester1Button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Semester1Button3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Semester 4");

        javax.swing.GroupLayout Semester1Button3Layout = new javax.swing.GroupLayout(Semester1Button3);
        Semester1Button3.setLayout(Semester1Button3Layout);
        Semester1Button3Layout.setHorizontalGroup(
            Semester1Button3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Semester1Button3Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Semester1Button3Layout.setVerticalGroup(
            Semester1Button3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Semester1Button3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        Semester1Button4.setOpaque(false);
        Semester1Button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Semester1Button4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Semester 5");

        javax.swing.GroupLayout Semester1Button4Layout = new javax.swing.GroupLayout(Semester1Button4);
        Semester1Button4.setLayout(Semester1Button4Layout);
        Semester1Button4Layout.setHorizontalGroup(
            Semester1Button4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Semester1Button4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Semester1Button4Layout.setVerticalGroup(
            Semester1Button4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Semester1Button4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        Semester1Button5.setOpaque(false);
        Semester1Button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Semester1Button5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Semester 6");

        javax.swing.GroupLayout Semester1Button5Layout = new javax.swing.GroupLayout(Semester1Button5);
        Semester1Button5.setLayout(Semester1Button5Layout);
        Semester1Button5Layout.setHorizontalGroup(
            Semester1Button5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Semester1Button5Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Semester1Button5Layout.setVerticalGroup(
            Semester1Button5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Semester1Button5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout navigateSemester1Layout = new javax.swing.GroupLayout(navigateSemester1);
        navigateSemester1.setLayout(navigateSemester1Layout);
        navigateSemester1Layout.setHorizontalGroup(
            navigateSemester1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Semester1Button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Semester1Button1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Semester1Button2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Semester1Button3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Semester1Button4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Semester1Button5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        navigateSemester1Layout.setVerticalGroup(
            navigateSemester1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigateSemester1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Semester1Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(Semester1Button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(Semester1Button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(Semester1Button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(Semester1Button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(Semester1Button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(navigateSemester1, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 0, 120, 0));

        jTabbedPane1.addTab("tab1", formCreate1);

        javax.swing.GroupLayout formUpdate1Layout = new javax.swing.GroupLayout(formUpdate1);
        formUpdate1.setLayout(formUpdate1Layout);
        formUpdate1Layout.setHorizontalGroup(
            formUpdate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        formUpdate1Layout.setVerticalGroup(
            formUpdate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", formUpdate1);

        javax.swing.GroupLayout formView1Layout = new javax.swing.GroupLayout(formView1);
        formView1.setLayout(formView1Layout);
        formView1Layout.setHorizontalGroup(
            formView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        formView1Layout.setVerticalGroup(
            formView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", formView1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, -37, 740, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuButton3ActionPerformed

    private void menuButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuButton2MouseClicked
//        int x=10;
        if(open==0){
            navigateSemester1.show();
            navigateSemester1.setSize(124,x);
            Thread th = new Thread(){
                @Override
                public void run(){
                    try{
                        for(int i = 0;i<=x;i++){
                            Thread.sleep(0,5);
                            navigateSemester1.setSize(124,i);
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };th.start();
            x=500;
            open=1;
        }else if(open==1){
            navigateSemester1.setSize(124,500);
            Thread th = new Thread(){
                @Override
                public void run(){
                    try{
                        for(int i = 500;i>=0;i--){
                            Thread.sleep(0,5);
                            navigateSemester1.setSize(124,i);
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };th.start();
            x=0;
            open=0;
        }
    }//GEN-LAST:event_menuButton2MouseClicked

    private void menuButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButton2ActionPerformed

    }//GEN-LAST:event_menuButton2ActionPerformed

    private void Semester1ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1ButtonMouseClicked
        Semester=1;
        tutupSemesterPanel();
    }//GEN-LAST:event_Semester1ButtonMouseClicked

    private void Semester1Button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button1MouseClicked
        Semester=2;
        tutupSemesterPanel();
    }//GEN-LAST:event_Semester1Button1MouseClicked

    private void Semester1Button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button2MouseClicked
        Semester=3;
        tutupSemesterPanel();
    }//GEN-LAST:event_Semester1Button2MouseClicked

    private void Semester1Button3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button3MouseClicked
        Semester=4;
        tutupSemesterPanel();
    }//GEN-LAST:event_Semester1Button3MouseClicked

    private void Semester1Button4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button4MouseClicked
        Semester=5;
        tutupSemesterPanel();
    }//GEN-LAST:event_Semester1Button4MouseClicked

    private void Semester1Button5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button5MouseClicked
        Semester=6;
        tutupSemesterPanel();
    }//GEN-LAST:event_Semester1Button5MouseClicked

    private void Semester1ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1ButtonMouseEntered
        Semester1Button.setOpaque(true);
        Semester1Button.setBackground(new Color(128,128,128,100));
    }//GEN-LAST:event_Semester1ButtonMouseEntered

    private void Semester1ButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1ButtonMouseExited
        Semester1Button.setOpaque(false);
        Semester1Button.setBackground(new Color(128,128,128,0));
    }//GEN-LAST:event_Semester1ButtonMouseExited

    private void Semester1Button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button1MouseEntered
        Semester1Button1.setOpaque(true);
        Semester1Button1.setBackground(new Color(128,128,128,100));
    }//GEN-LAST:event_Semester1Button1MouseEntered

    private void Semester1Button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button1MouseExited
        Semester1Button1.setOpaque(false);
        Semester1Button1.setBackground(new Color(128,128,128,0));
    }//GEN-LAST:event_Semester1Button1MouseExited

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(open1 == 0){
            navigatePanel.show();
            navigatePanel.setSize(160, 540); // Change navigateSemester1 to navigatePanel
            int y = 50; 
            Thread th = new Thread() {
                @Override
                public void run() {
                    try {
                        for (int j = 160; j >= y; j--) { // Change navigateSemester1 to navigatePanel
                            Thread.sleep(0, 7);
                            navigatePanel.setSize(j, 540); // Change navigateSemester1 to navigatePanel
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };
            th.start();
            // y = navigatePanel.getX() - 120; // Remove this line if you have already initialized y
            open1 = 1;
        } else if(open1 == 1){
            navigatePanel.setSize(50, 540);
            Thread th = new Thread(){
                @Override
                public void run(){
                    try{
                        for(int j = 50; j <= 160; j++){
                            Thread.sleep(0, 7);
                            navigatePanel.setSize(j, 540);
                        }
                    } catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };
            th.start();
            open1 = 0;
        }
    }//GEN-LAST:event_jButton1MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                FlatLaf.registerCustomDefaultsSource("");
                new Dashboard1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Semester1Button;
    private javax.swing.JPanel Semester1Button1;
    private javax.swing.JPanel Semester1Button2;
    private javax.swing.JPanel Semester1Button3;
    private javax.swing.JPanel Semester1Button4;
    private javax.swing.JPanel Semester1Button5;
    private com.oop.form.FormCreate formCreate1;
    private com.oop.form.FormUpdate formUpdate1;
    private com.oop.form.FormView formView1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private Component.MenuButton menuButton1;
    private Component.MenuButton menuButton2;
    private Component.MenuButton menuButton3;
    private Component.MenuButton menuButton4;
    private Component.NavigatePanel navigatePanel;
    private Component.NavigateSemester navigateSemester1;
    // End of variables declaration//GEN-END:variables
}
