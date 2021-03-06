/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package com.uiconf;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author olegs
 */
@SuppressWarnings("serial")
public class ResponseLog extends javax.swing.JFrame {
    private List <String> historyLog;
    private int logSize = 50;
    private int currentPos = 0;
    /**
     * Creates new form ResponseLog
     */
    public ResponseLog() {
        initComponents();
        historyLog = new ArrayList<String>();
    }
    
    public void log(String text){
         logHtml(text);
    }
    
    private void logHtml(String text){
        currentPos = historyLog.size();
        addToLogList(text);
        getCurrent();
    }
    
    private void addToLogList(String text){
        if (historyLog.size() < logSize){
            historyLog.add(text);
        }else{
          historyLog = moveAllLeft(historyLog, text);
        }
    }
    
    private List <String> moveAllLeft(List <String> list, String item){
        for (int i = 0; i<list.size() - 1; i++){
            list.set(i, list.get(i + 1));
        }
        list.set(list.size() - 1, item);
        return list;
    }
    
    private void getPrevious(){
        if (currentPos < 1){
            responseLogHtml(historyLog.get(0));
        }else{
            responseLogHtml(historyLog.get(currentPos - 1));
        }
        if (currentPos > 0){
            currentPos --;
        }
    }
    
    private void getNext(){
        if (currentPos > historyLog.size() - 1){
            responseLogHtml(historyLog.get(historyLog.size() - 1));
        }else{
             responseLogHtml(historyLog.get(currentPos));
        }
        if (currentPos < historyLog.size() - 1){
            currentPos ++;
        }
    }
    
    private void getCurrent(){
        if (!historyLog.isEmpty()){
            responseLogHtml(historyLog.get(historyLog.size() - 1));
        }
    }
    
    public void responseLogHtml(String text) {
        txtResponseLog.setText(text);
        txtResponseLog.setCaretPosition(0);
        txtResponseLog.repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtResponseLog = new javax.swing.JEditorPane("text/html", "");
        btnPrev = new javax.swing.JButton();
        btnCurrent = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtResponseLog.setEditable(false);
        jScrollPane2.setViewportView(txtResponseLog);

        btnPrev.setText("<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnCurrent.setText("|");
        btnCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCurrentActionPerformed(evt);
            }
        });

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(btnPrev)
                        .addGap(18, 18, 18)
                        .addComponent(btnCurrent)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(btnCurrent)
                    .addComponent(btnNext))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        getPrevious();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurrentActionPerformed
       currentPos = historyLog.size() - 1;
        responseLogHtml(historyLog.get(currentPos));
    }//GEN-LAST:event_btnCurrentActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        getNext();
    }//GEN-LAST:event_btnNextActionPerformed
    
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
            java.util.logging.Logger.getLogger(ResponseLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResponseLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResponseLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResponseLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResponseLog().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCurrent;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JEditorPane txtResponseLog;
    // End of variables declaration//GEN-END:variables
}
