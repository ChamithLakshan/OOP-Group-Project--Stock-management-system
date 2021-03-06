/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class Product extends javax.swing.JFrame {
    Connection conn = DBconnection.getDBconnection().getConnection();
    PreparedStatement pst;
    DefaultTableModel df;
    ResultSet rs;

    /** Creates new form Product */
    public Product() {
        initComponents();
        load();
        this.setLocationRelativeTo(this);
    }
    public void load(){
         try {
            int a;             
            pst= conn.prepareStatement("select * from product");
            ResultSet rs=pst.executeQuery();            
            ResultSetMetaData rd =rs.getMetaData();            
            a = rd.getColumnCount();            
            df= (DefaultTableModel)jTable1.getModel();            
            df.setRowCount(0);
            
            while(rs.next()){
                Vector v2 = new Vector();
                for(int i=0; i<=a; i++){
                    v2.add(rs.getString("ProID"));
                    v2.add(rs.getString("ProName"));
                    v2.add(rs.getString("ProDescription"));
                    v2.add(rs.getString("ProBarcode"));
                    v2.add(rs.getString("ProCoPrice"));
                    v2.add(rs.getString("ProRePrice"));
                    v2.add(rs.getString("ProQty"));
                    v2.add(rs.getString("ProReLevel"));                                       
                }
                df.addRow(v2);            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BtnProAdd = new javax.swing.JLabel();
        BtnProEdit = new javax.swing.JLabel();
        BtnProDelete = new javax.swing.JLabel();
        BtnProCancel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ProROL = new javax.swing.JTextField();
        ProRen = new javax.swing.JTextField();
        ProCos = new javax.swing.JTextField();
        ProQty = new javax.swing.JTextField();
        ProBar = new javax.swing.JTextField();
        ProDes = new javax.swing.JTextField();
        ProName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Bauhaus 93", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PRODUCT");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 100));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        BtnProAdd.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        BtnProAdd.setForeground(new java.awt.Color(255, 255, 255));
        BtnProAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnProAdd.setText("ADD");
        BtnProAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        BtnProAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnProAddMouseClicked(evt);
            }
        });

        BtnProEdit.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        BtnProEdit.setForeground(new java.awt.Color(255, 255, 255));
        BtnProEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnProEdit.setText("EDIT");
        BtnProEdit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        BtnProEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnProEditMouseClicked(evt);
            }
        });

        BtnProDelete.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        BtnProDelete.setForeground(new java.awt.Color(255, 255, 255));
        BtnProDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnProDelete.setText("DELETE");
        BtnProDelete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        BtnProDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnProDeleteMouseClicked(evt);
            }
        });

        BtnProCancel.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        BtnProCancel.setForeground(new java.awt.Color(255, 255, 255));
        BtnProCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnProCancel.setText("CLEAR");
        BtnProCancel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        BtnProCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnProCancelMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("BACK");
        jLabel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnProAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnProCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnProDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnProEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(BtnProAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(BtnProEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(BtnProDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(BtnProCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 630));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 840, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Product  name", "Description", "Barcode", "Cost price", "Retail Price", "Quantity", "Restore limit"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 550, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Restore Limit");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, 110, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Retail Price");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 110, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cost Price");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 110, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 110, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Barcode");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 110, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Description");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 110, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Product Name");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 110, 30));
        jPanel1.add(ProROL, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 550, 210, 30));
        jPanel1.add(ProRen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 210, 30));
        jPanel1.add(ProCos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 210, 30));
        jPanel1.add(ProQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 210, 30));
        jPanel1.add(ProBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 210, 30));
        jPanel1.add(ProDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 210, 30));
        jPanel1.add(ProName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 210, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vecteezy-abstract-geometric-green-background_WS0321_generated.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 630));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        df= (javax.swing.table.DefaultTableModel)jTable1.getModel();
        
        int seclected = jTable1.getSelectedRow();
        int ProID = Integer.parseInt(df.getValueAt(seclected,0).toString());
        
        ProName.setText(df.getValueAt(seclected,1).toString());
        ProDes.setText(df.getValueAt(seclected,2).toString());
        ProBar.setText(df.getValueAt(seclected,3).toString());
        ProCos.setText(df.getValueAt(seclected,4).toString());
        ProRen.setText(df.getValueAt(seclected,5).toString());
        ProQty.setText(df.getValueAt(seclected,6).toString());
        ProROL.setText(df.getValueAt(seclected,7).toString());
        
        
        BtnProAdd.setEnabled(false);
        

    }//GEN-LAST:event_jTable1MouseClicked

    private void BtnProAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnProAddMouseClicked
        try {
            
            String proname=ProName.getText();
            String prodes=ProDes.getText();
            String probar=ProBar.getText();
            String procost=ProCos.getText();
            String proren=ProRen.getText();
            String proqty=ProQty.getText();
            String proreor=ProROL.getText();           
            
            pst = conn.prepareStatement("insert into product(ProName,ProDescription,ProBarcode,ProCoPrice,ProRePrice,ProQty,ProReLevel)VALUES(?, ?, ?, ?,?,?,?)");
            
            pst.setString(1, proname);
            pst.setString(2, prodes);
            pst.setString(3, probar);
            pst.setString(4, procost);
            pst.setString(5, proren);
            pst.setString(6, proqty);
            pst.setString(7, proreor);           
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Product Added");
            
            ProName.setText("");
            ProDes.setText("");
            ProBar.setText("");
            ProCos.setText("");
            ProRen.setText("");
            ProQty.setText("");
            ProROL.setText("");
            
            
            ProName.requestFocus();
            load();                      
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnProAddMouseClicked

    private void BtnProEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnProEditMouseClicked
        df= (javax.swing.table.DefaultTableModel)jTable1.getModel();
        
        int seclected = jTable1.getSelectedRow();
        int Proid = Integer.parseInt(df.getValueAt(seclected,0).toString());
        
            String proname=ProName.getText();
            String prodes=ProDes.getText();
            String probar=ProBar.getText();
            String procost=ProCos.getText();
            String proren=ProRen.getText();
            String proqty=ProQty.getText();
            String proreor=ProROL.getText();
        
        try {
          
            pst = conn.prepareStatement("update Product set ProName=?,ProDescription=?,ProBarcode=?,ProCoPrice=?,ProRePrice=?,ProQty=?,ProReLevel=? where ProID=?");
            
            pst.setString(1, proname);
            pst.setString(2, prodes);
            pst.setString(3, probar);
            pst.setString(4, procost);
            pst.setString(5, proren);
            pst.setString(6, proqty);
            pst.setString(7, proreor);
            pst.setInt(8,Proid);            
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Product Edited");
            
            ProName.setText("");
            ProDes.setText("");
            ProBar.setText("");
            ProCos.setText("");
            ProRen.setText("");
            ProQty.setText("");
            ProROL.setText("");
                        
            ProName.requestFocus();
            load();                      
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }// TODO add your handling code here:
    }//GEN-LAST:event_BtnProEditMouseClicked

    private void BtnProDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnProDeleteMouseClicked
        df= (javax.swing.table.DefaultTableModel)jTable1.getModel();
        
        int seclected = jTable1.getSelectedRow();
        int Proid = Integer.parseInt(df.getValueAt(seclected,0).toString()); 
        
        try {
            pst = conn.prepareStatement("delete from Product where ProID=?");
            pst.setInt(1, Proid);            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Product Deleted");
            
            ProName.setText("");
            ProDes.setText("");
            ProBar.setText("");
            ProCos.setText("");
            ProRen.setText("");
            ProQty.setText("");
            ProROL.setText(""); 
            
            ProName.requestFocus();
            load();
            BtnProAdd.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }// TODO add your handling code here:
    }//GEN-LAST:event_BtnProDeleteMouseClicked

    private void BtnProCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnProCancelMouseClicked
        ProName.setText("");
        ProDes.setText("");
        ProBar.setText("");
        ProCos.setText("");
        ProRen.setText("");
        ProQty.setText("");
        ProROL.setText("");
            
        BtnProAdd.requestFocus();
        load();
        BtnProAdd.setEnabled(true);
// TODO add your handling code here:
    }//GEN-LAST:event_BtnProCancelMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        this.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

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
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnProAdd;
    private javax.swing.JLabel BtnProCancel;
    private javax.swing.JLabel BtnProDelete;
    private javax.swing.JLabel BtnProEdit;
    private javax.swing.JTextField ProBar;
    private javax.swing.JTextField ProCos;
    private javax.swing.JTextField ProDes;
    private javax.swing.JTextField ProName;
    private javax.swing.JTextField ProQty;
    private javax.swing.JTextField ProROL;
    private javax.swing.JTextField ProRen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
