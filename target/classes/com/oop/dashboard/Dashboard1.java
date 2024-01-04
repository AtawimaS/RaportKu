
package com.oop.dashboard;

import com.oop.form.*;
import Component.NavigateSemester;

import javax.swing.JOptionPane;
import Component.SemesterChangeListener;
import com.oop.login.Login;
import event.EventMenu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import javax.swing.border.Border;


import java.io.File;  
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.SwingWorker;
/**
 *
 * @author Will
 */
//encapsulation
public class Dashboard1 extends javax.swing.JFrame {
    private int open = 0;
    private int x, y;
    private String smtr;
    private UpdatePanel updatePanel = new UpdatePanel();

    public int getOpen() {
        return open;
    }

    public void setOpen(int newValue) {
        this.open = newValue;
    }

    public String getSmtr() {
        return smtr;
    }

    public void setSmtr(String newValue) {
        this.smtr = newValue;
    }

    public Dashboard1() {
        initComponents();
        createSemester();
        initializeEventMenu();
    }

    private void initializeEventMenu() {
        EventMenu event = new EventMenu() {
            @Override
            public void selected(int index) {
                if(index == 0){
                    jTabbedPane1.setSelectedIndex(1);
                }
                else if(index == 1){
                    jTabbedPane1.setSelectedIndex(2);
                }
                else if(index == 2){
//                    jTabbedPane1.setSelectedIndex(3);
                    if(open==0){
                        navigateSemester1.show();
                        navigateSemester1.setSize(x,500);
                        Thread th = new Thread(){
                            @Override
                            public void run(){
                                try{
                                    for(int i = 0;i<=x;i++){
                                        Thread.sleep(0,5);
                                        navigateSemester1.setSize(i,500);
                                    }
                                }catch(Exception e){
                                    JOptionPane.showMessageDialog(null, e);
                                }
                            }
                        };th.start();
                        x=124;
                        open=1;
                    }else if(open==1){
                        navigateSemester1.setSize(124,500);
                        Thread th = new Thread(){
                            @Override
                            public void run(){
                                try{
                                    for(int i = 124;i>=0;i--){
                                        Thread.sleep(0,5);
                                        navigateSemester1.setSize(i,500);
                                    }
                                }catch(Exception e){
                                    JOptionPane.showMessageDialog(null, e);
                                }
                            }
                        };th.start();
                        x=0;
                        open=0;
                    }
                }
                else if(index == 3){
                    System.out.println("Logout");
                        Login pindah = new Login();
                        pindah.show();
                        setVisible(false);
                        disposesmooth();
                        return; 
                }
                else{
                }
            }
        };
        navBar1.initMenu(event);
    }

    // Multithreading
    private void tutupSemesterPanel() {
        navigateSemester1.setSize(124, 500);
        startSizeReductionAnimation();
        x = 0;
        open = 0;
    }

    private void startSizeReductionAnimation() {
        SwingWorker<Void, Integer> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 124; i >= 0; i--) {
                    Thread.sleep(5);
                    publish(i);
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                navigateSemester1.setSize(chunks.get(0), 500);
            }
        };
        worker.execute();
    }

    // Multithreading
    private void disposesmooth() {
        Timer timer = new Timer(20, new ActionListener() {
            float opacity = 1.0f;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= 0.05f;
                if (opacity > 0.0f) {
                    Dashboard1.this.setOpacity(opacity);
                } else {
                    ((Timer) e.getSource()).stop();
                    Dashboard1.this.dispose();
                }
            }
        });
        timer.start();
    }

    private void createSemester() {
        try {
            File myObj = new File("semester.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void writeSemester(String semester) {
        try (FileWriter myWriter = new FileWriter("semester.txt")) {
            myWriter.write(semester);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneMoving = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
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
        formFirst2 = new com.oop.form.FormFirst();
        formCreate1 = new com.oop.form.FormCreate();
        formView2 = new com.oop.form.FormView();
        updatePanel1 = new com.oop.form.UpdatePanel();
        navBar1 = new Component.NavBar();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 500));
        setName("Form"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(900, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneMoving.setName("paneMoving"); // NOI18N
        paneMoving.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                paneMovingMouseDragged(evt);
            }
        });
        paneMoving.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneMovingMousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("X");
        jLabel10.setName("jLabel10"); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });

        javax.swing.GroupLayout paneMovingLayout = new javax.swing.GroupLayout(paneMoving);
        paneMoving.setLayout(paneMovingLayout);
        paneMovingLayout.setHorizontalGroup(
            paneMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMovingLayout.createSequentialGroup()
                .addContainerGap(993, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        paneMovingLayout.setVerticalGroup(
            paneMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMovingLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        getContentPane().add(paneMoving, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1010, 30));

        navigateSemester1.setName("navigateSemester1"); // NOI18N

        Semester1Button.setToolTipText("");
        Semester1Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Semester1Button.setName("Semester1Button"); // NOI18N
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
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout Semester1ButtonLayout = new javax.swing.GroupLayout(Semester1Button);
        Semester1Button.setLayout(Semester1ButtonLayout);
        Semester1ButtonLayout.setHorizontalGroup(
            Semester1ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Semester1ButtonLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Semester1ButtonLayout.setVerticalGroup(
            Semester1ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Semester1ButtonLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        Semester1Button1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Semester1Button1.setName("Semester1Button1"); // NOI18N
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
        jLabel2.setName("jLabel2"); // NOI18N

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

        Semester1Button2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Semester1Button2.setName("Semester1Button2"); // NOI18N
        Semester1Button2.setOpaque(false);
        Semester1Button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Semester1Button2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Semester1Button2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Semester1Button2MouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Semester 3");
        jLabel3.setName("jLabel3"); // NOI18N

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

        Semester1Button3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Semester1Button3.setName("Semester1Button3"); // NOI18N
        Semester1Button3.setOpaque(false);
        Semester1Button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Semester1Button3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Semester1Button3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Semester1Button3MouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Semester 4");
        jLabel4.setName("jLabel4"); // NOI18N

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

        Semester1Button4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Semester1Button4.setName("Semester1Button4"); // NOI18N
        Semester1Button4.setOpaque(false);
        Semester1Button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Semester1Button4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Semester1Button4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Semester1Button4MouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Semester 5");
        jLabel5.setName("jLabel5"); // NOI18N

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

        Semester1Button5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Semester1Button5.setName("Semester1Button5"); // NOI18N
        Semester1Button5.setOpaque(false);
        Semester1Button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Semester1Button5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Semester1Button5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Semester1Button5MouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Semester 6");
        jLabel6.setName("jLabel6"); // NOI18N

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

        getContentPane().add(navigateSemester1, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 20, 120, 0));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setName("jTabbedPane1"); // NOI18N
        jTabbedPane1.setOpaque(true);

        formFirst2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        formFirst2.setName("formFirst2"); // NOI18N
        jTabbedPane1.addTab("tab5", formFirst2);

        formCreate1.setName("formCreate1"); // NOI18N
        jTabbedPane1.addTab("tab1", formCreate1);

        formView2.setName("formView2"); // NOI18N
        jTabbedPane1.addTab("tab4", formView2);

        updatePanel1.setName("updatePanel1"); // NOI18N
        jTabbedPane1.addTab("tab4", updatePanel1);

        Border emptyBorder = BorderFactory.createEmptyBorder();
        jTabbedPane1.setBorder(emptyBorder);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, -25, 840, 520));

        navBar1.setName("navBar1"); // NOI18N
        getContentPane().add(navBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 160, 480));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setName("jPanel1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void Semester1ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1ButtonMouseClicked
        smtr = "1";
        tutupSemesterPanel();
        writeSemester(smtr);
        jTabbedPane1.setSelectedIndex(3);
        updatePanel.run();
    }//GEN-LAST:event_Semester1ButtonMouseClicked

    private void Semester1Button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button1MouseClicked
        smtr = "2";
        tutupSemesterPanel();
        writeSemester(smtr);
        jTabbedPane1.setSelectedIndex(3);
        updatePanel.run();

    }//GEN-LAST:event_Semester1Button1MouseClicked

    private void Semester1Button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button2MouseClicked
        smtr = "3";
        tutupSemesterPanel();
        writeSemester(smtr);
        jTabbedPane1.setSelectedIndex(3);
        updatePanel.run();

    }//GEN-LAST:event_Semester1Button2MouseClicked

    private void Semester1Button3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button3MouseClicked
        smtr = "4";
        tutupSemesterPanel();
        writeSemester(smtr);
        jTabbedPane1.setSelectedIndex(3);
        updatePanel.run();

    }//GEN-LAST:event_Semester1Button3MouseClicked

    private void Semester1Button4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button4MouseClicked
        smtr = "5";
        tutupSemesterPanel();
        writeSemester(smtr);
        jTabbedPane1.setSelectedIndex(3);
        updatePanel.run();

    }//GEN-LAST:event_Semester1Button4MouseClicked

    private void Semester1Button5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button5MouseClicked
        smtr = "6";
        tutupSemesterPanel();
        writeSemester(smtr);
        jTabbedPane1.setSelectedIndex(3);
        updatePanel.run();

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

     int xx,xy;
    private void paneMovingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneMovingMousePressed
         xx=evt.getX();
         xy=evt.getY();
    }//GEN-LAST:event_paneMovingMousePressed

    private void paneMovingMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneMovingMouseDragged
       int x = evt.getXOnScreen()-xx;
       int y = evt.getYOnScreen()-xy;
       setLocation(x, y);
    }//GEN-LAST:event_paneMovingMouseDragged

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        jLabel10.setForeground(Color.red);
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        jLabel10.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void Semester1Button2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button2MouseEntered
        Semester1Button2.setOpaque(true);
        Semester1Button2.setBackground(new Color(128,128,128,100));
    }//GEN-LAST:event_Semester1Button2MouseEntered

    private void Semester1Button3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button3MouseEntered
        Semester1Button3.setOpaque(true);
        Semester1Button3.setBackground(new Color(128,128,128,100));
    }//GEN-LAST:event_Semester1Button3MouseEntered

    private void Semester1Button4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button4MouseEntered
        Semester1Button4.setOpaque(true);
        Semester1Button4.setBackground(new Color(128,128,128,100));
    }//GEN-LAST:event_Semester1Button4MouseEntered

    private void Semester1Button5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button5MouseEntered
        Semester1Button5.setOpaque(true);
        Semester1Button5.setBackground(new Color(128,128,128,100));
    }//GEN-LAST:event_Semester1Button5MouseEntered

    private void Semester1Button2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button2MouseExited
        Semester1Button2.setOpaque(false);
        Semester1Button2.setBackground(new Color(128,128,128,0));
    }//GEN-LAST:event_Semester1Button2MouseExited

    private void Semester1Button3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button3MouseExited
        Semester1Button3.setOpaque(false);
        Semester1Button3.setBackground(new Color(128,128,128,0));
    }//GEN-LAST:event_Semester1Button3MouseExited

    private void Semester1Button4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button4MouseExited
        Semester1Button4.setOpaque(false);
        Semester1Button4.setBackground(new Color(128,128,128,0));
    }//GEN-LAST:event_Semester1Button4MouseExited

    private void Semester1Button5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Semester1Button5MouseExited
        Semester1Button5.setOpaque(false);
        Semester1Button5.setBackground(new Color(128,128,128,0));
    }//GEN-LAST:event_Semester1Button5MouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
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
    private com.oop.form.FormFirst formFirst2;
    private com.oop.form.FormView formView2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private Component.NavBar navBar1;
    private Component.NavigateSemester navigateSemester1;
    private javax.swing.JPanel paneMoving;
    private com.oop.form.UpdatePanel updatePanel1;
    // End of variables declaration//GEN-END:variables
}
