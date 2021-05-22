/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author sergiosayago
 * modified for MySQL by Ignasi Cos
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public static Connection c = null;
    public static Statement stmt = null;
    public static ResultSet rs = null;
    public static PreparedStatement pstmt = null;
    
    public Main() {
        initComponents();
        this.btn_query.setEnabled(false);
        this.btn_insert.setEnabled(false);
        this.btn_delete.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_connect = new javax.swing.JButton();
        btn_query = new javax.swing.JButton();
        btn_insert = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btn_connect.setText("Connect to Database");
        btn_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connectActionPerformed(evt);
            }
        });

        btn_query.setText("Query Data in the database");
        btn_query.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_queryActionPerformed(evt);
            }
        });

        btn_insert.setText("Insert Data into database");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete Data from database");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btn_query)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_connect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_insert))
                .addGap(18, 18, 18)
                .addComponent(btn_delete)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(btn_connect)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_query)
                    .addComponent(btn_insert)
                    .addComponent(btn_delete))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectActionPerformed
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/dreamhouse2020", "ignasi", "");
            //c = DriverManager.getConnection("jdbc:mysql://localhost:3306/dreamhouse2020?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "ignasi", "");
            
            JOptionPane.showMessageDialog(this, "Connection established", "Status", JOptionPane.INFORMATION_MESSAGE);
            
            enableButtons();
            
        } catch (Exception e) {
           
            JOptionPane.showMessageDialog(this, e.getMessage(), "Status", JOptionPane.INFORMATION_MESSAGE);
        
        }
        
            
    }//GEN-LAST:event_btn_connectActionPerformed

    private void btn_queryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_queryActionPerformed
        // TODO add your handling code here:
        Query queryPane = new Query(this, c, true);
        queryPane.pack();
        queryPane.setVisible(true);
    }//GEN-LAST:event_btn_queryActionPerformed

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
        // TODO add your handling code here:
        Insert insertPane = new Insert(this, c, true);
        insertPane.pack();
        insertPane.setVisible(true);
    }//GEN-LAST:event_btn_insertActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            // TODO add your handling code here:
            c.close();            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(this, ex.getMessage(), "Status", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        Delete deletePane = new Delete(this, c, true);
        deletePane.pack();
        deletePane.setVisible(true);        
        
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void enableButtons(){
        
        this.btn_query.setEnabled(true);
        
        this.btn_insert.setEnabled(true);
        
        this.btn_delete.setEnabled(true);
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_connect;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_query;
    // End of variables declaration//GEN-END:variables
}
