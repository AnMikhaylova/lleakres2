/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;


import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import lleak.channel.ChanCol;
import lleak.helpers.*;

/**
 *
 * @author tassy
 */
public class ParamDynamicsMenu extends javax.swing.JDialog {

    private ChanSelection parent = null;
    String selChan = null;
    ArrayList<ChanCol> columns = null;
    ChanTxtReader ctr = null;
    private DefaultListModel<String> lmod1 = new DefaultListModel<>();
    private DefaultListModel<String> lmod2 = new DefaultListModel<>();
    private DefaultListModel<String> lmod3 = new DefaultListModel<>();
    private DefaultListModel<String> lmod4 = new DefaultListModel<>();

    /**
     * Creates new form ParamDynamicsMenu
     */
    public ParamDynamicsMenu(ChanSelection parent, String selChan) {
        this.parent = parent;
        this.selChan = selChan;
        initComponents();
        setInf();
        jList1.setModel(lmod1);
        lmod2.clear();
        jList2.setModel(lmod2);
        jList3.setModel(lmod3);
        lmod4.clear();
        jList4.setModel(lmod4);
        setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setText("Выберите нужные координаты точек:");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jButton2.setText(">>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("<<");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Выберите переменные для отображения:");

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList3);

        jList4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList4);

        jButton5.setText(">>");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("<<");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Очистить выбор");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Выбрать всё");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton1.setText("Назад");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("OK");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton9.setText("Сохранить выбранное");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(197, 197, 197))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(108, 108, 108)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2)
                                .addGap(2, 2, 2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton5)
                                    .addComponent(jButton6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(87, 87, 87)))
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane3))
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(93, 93, 93)))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setInf() {
        lmod1.clear();
        //ChanProfReader cpr = new ChanProfReader(parent.getParent().getRootDir() + parent.getParent().getCr().getChan());
        ctr = new ChanTxtReader(parent.getParent().getRootDir() + selChan);
        GeomReader gr = new GeomReader(parent.getParent().getRootDir() + ctr.getGeom());

        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        decimalFormat.setDecimalFormatSymbols(dfs);

        ArrayList<Double> pointsInTime = gr.getChanCoord();
        for (Double p : pointsInTime) {
            lmod1.addElement(decimalFormat.format(p));
        }

        columns = ChanCol.readCSV(parent.getParent().getRootDir() + "meta.csv");
        lmod3.clear();
        for (ChanCol c : columns) {
            if (!c.getVarname().equals("x") && !c.getVarname().equals("t")) {
                lmod3.addElement(c.getFullname());
            }
        }

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // back
        this.setVisible(false);
        parent.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // select coord
        String selVal = jList1.getSelectedValue();
        int ind = jList1.getSelectedIndex();
        if (!selVal.isEmpty()) {
            lmod2.addElement(selVal);
            lmod1.remove(ind);
            jList1.setModel(lmod1);
            jList2.setModel(lmod2);

            //TODO: сортировка списков после добавления/удаления
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // unselect coord
        String selVal = jList2.getSelectedValue();
        int ind = jList2.getSelectedIndex();
        if (!selVal.isEmpty()) {
            lmod1.addElement(selVal);
            lmod2.remove(ind);
            jList1.setModel(lmod1);
            jList2.setModel(lmod2);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // select arg
        String selVal = jList3.getSelectedValue();
        int ind = jList3.getSelectedIndex();
        if (!selVal.isEmpty()) {
            lmod4.addElement(selVal);
            lmod3.remove(ind);
            jList3.setModel(lmod3);
            jList4.setModel(lmod4);

            //TODO: сортировка списков после добавления/удаления
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // unselect arg
        String selVal = jList4.getSelectedValue();
        int ind = jList4.getSelectedIndex();
        if (!selVal.isEmpty()) {
            lmod3.addElement(selVal);
            lmod4.remove(ind);
            jList3.setModel(lmod3);
            jList4.setModel(lmod4);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // clear

        lmod3.clear();
        for (ChanCol c : columns) {
            lmod3.addElement(c.getFullname());
        }
        jList3.setModel(lmod3);
        lmod4.clear();
        jList4.setModel(lmod4);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // select all

        lmod4.clear();
        for (ChanCol c : columns) {
            lmod4.addElement(c.getFullname());
        }
        jList4.setModel(lmod4);

        lmod3.clear();
        jList3.setModel(lmod3);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // OK

        String strSelVals = null;
        String strSelParams = null;
        if (lmod2.isEmpty() || lmod4.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Выберите координаты точек и переменные",
            "Ошибка", JOptionPane.ERROR_MESSAGE);
        } else {

            ArrayList<String> selVals = new ArrayList<>();
            ArrayList<String> arr = new ArrayList<>();
            ArrayList<String> selParams = new ArrayList<>();
            Enumeration<String> vals = lmod2.elements();
            Enumeration<String> params = lmod4.elements();

            while (vals.hasMoreElements()) {
                selVals.add(vals.nextElement());
            }

            while (params.hasMoreElements()) {
                arr.add(params.nextElement());
            }

            for (String s : arr) {
                for (ChanCol c : columns) {
                    if (s.equals(c.getFullname())) {
                        selParams.add(c.getVarname());
                    }

                }
            }

            strSelVals = selVals.toString().replaceAll("\\n", ",").replaceAll("[\\]\\[]", "");
            strSelParams = selParams.toString().replaceAll("\\n", ",").replaceAll("[\\]\\[]", "");

        }

        String rDir = "\"" + parent.getParent().getRDir() + "Rscript.exe" + "\"";

        FileWriter nFile = null;
        try {
            nFile = new FileWriter(parent.getParent().getRootDir() + "selvals.txt");
            nFile.write(strSelVals);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ошибка ввода/вывода\n" + parent.getParent().getRootDir() + "selvals.txt",
            "Ошибка", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ParamDynamicsMenu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (nFile != null) {
                try {
                    nFile.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Ошибка ввода/вывода\n" + parent.getParent().getRootDir() + "selvals.txt",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(ParamDynamicsMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        ProcessBuilder processBuilder = new ProcessBuilder("script.bat", rDir, parent.getParent().getRootDir()
                + ctr.getOutfile(), parent.getParent().getRootDir() + "meta.csv", strSelParams, "d");
        Process p;

        try {
            String message = "Подождите, идёт сохранение графиков\nДиректория для сохранения: " + parent.getParent().getRootDir() + "pics";            
            final JOptionPane jop = new JOptionPane(message, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
            JDialog dialog = jop.createDialog(null, "Загрузка");

            
            p = processBuilder.start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        p.waitFor();
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Ошибка",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
                        Thread.currentThread().interrupt();
                        Logger.getLogger(ParamDynamicsMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dialog.dispose();
                }

            }).start();

            dialog.setVisible(true);
            
            

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ошибка ввода/вывода",
            "Ошибка", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ParamDynamicsMenu.class.getName()).log(Level.SEVERE, null, ex);
        } 


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // save
        
        String strSelVals = null;
        String strSelParams = null;
        if (lmod2.isEmpty() || lmod4.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Выберите координаты точек и переменные",
            "Ошибка", JOptionPane.ERROR_MESSAGE);
        } else {

            ArrayList<String> selVals = new ArrayList<>();
            ArrayList<String> arr = new ArrayList<>();
            ArrayList<String> selParams = new ArrayList<>();
            Enumeration<String> vals = lmod2.elements();
            Enumeration<String> params = lmod4.elements();

            while (vals.hasMoreElements()) {
                selVals.add(vals.nextElement());
            }

            while (params.hasMoreElements()) {
                arr.add(params.nextElement());
            }

            for (String s : arr) {
                for (ChanCol c : columns) {
                    if (s.equals(c.getFullname())) {
                        selParams.add(c.getVarname());
                    }

                }
            }

            strSelVals = selVals.toString().replaceAll("\\n", ",").replaceAll("[\\]\\[]", "");
            strSelParams = selParams.toString().replaceAll("\\n", ",").replaceAll("[\\]\\[]", "");

        }
        
        String rDir = "\"" + parent.getParent().getRDir() + "Rscript.exe" + "\"";


        FileWriter nFile = null;
        try {
            nFile = new FileWriter(parent.getParent().getRootDir() + "selvals.txt");
            nFile.write(strSelVals);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ошибка ввода/вывода\n" + parent.getParent().getRootDir() + "selvals.txt",
            "Ошибка", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ParamDynamicsMenu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (nFile != null) {
                try {
                    nFile.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Ошибка ввода/вывода\n" + parent.getParent().getRootDir() + "selvals.txt",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(ParamDynamicsMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        FileWriter argFile = null;
        
        try {
            argFile = new FileWriter(parent.getParent().getRootDir() + "args.txt");
            argFile.write(rDir + "\n");
            argFile.write("\"" + parent.getParent().getRootDir() + ctr.getOutfile() + "\"" + "\n");
            argFile.write("\"" + parent.getParent().getRootDir() + "meta.csv" + "\"" + "\n");
            argFile.write("\"" + strSelParams + "\"" + "\n");
            argFile.write("d");
            String message = "Данные сохранены в файл: " + parent.getParent().getRootDir() + "args.txt";            
            JOptionPane.showMessageDialog(this, message,"Сообщение", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ошибка ввода/вывода\n" + parent.getParent().getRootDir() + "selvals.txt",
            "Ошибка", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ParamDynamicsMenu.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if (argFile != null){
                try {
                    argFile.close();
                } catch (IOException ex) {
                     JOptionPane.showMessageDialog(this, "Ошибка ввода/вывода\n" + parent.getParent().getRootDir() + "selvals.txt",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(ParamDynamicsMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
