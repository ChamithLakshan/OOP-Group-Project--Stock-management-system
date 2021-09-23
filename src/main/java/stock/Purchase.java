/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stock;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class Purchase extends javax.swing.JFrame {
    Connection conn = DBconnection.getDBconnection().getConnection();
    PreparedStatement pst;
    PreparedStatement pst1;
    PreparedStatement pst2;
    DefaultTableModel df;
    ResultSet rs;

    /** Creates new form Purchase */
    public Purchase() {
        initComponents();
        Vendor();
        this.setLocationRelativeTo(this);    
    }
    public void Vendor(){
        try {
            pst=conn.prepareStatement("select Distinct Name from vendor");
            rs = pst.executeQuery();
            ComVendor.removeAllItems();
            
            while(rs.next()){
                ComVendor.addItem(rs.getString("Name"));
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void purchase(){
        String pcode= txtProCode.getText();
        
        try {
            pst = conn.prepareStatement("select *from product where ProBarcode = ?");
            pst.setString(1, pcode);
            rs=pst.executeQuery();
            
            if(rs.next()==false){
                JOptionPane.showMessageDialog(this, "Barcode not Found"); 
                txtProCode.setText("");
            }else{
                String pname=rs.getString("ProName");
                String Coprice=rs.getString("ProCoPrice");
                
                txtProName.setText(pname.trim());
                txtProPrice.setText(Coprice.trim());
                txtProQty.requestFocus();
                            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    public void purch(){
        int price= Integer.parseInt(txtProPrice.getText());
        int qty= Integer.parseInt(txtProQty.getText());
        
        int total= price*qty;
        df = (DefaultTableModel)tabPurch.getModel();
        df.addRow(new Object[]{
            txtProCode.getText(),
            txtProName.getText(),
            txtProPrice.getText(),
            txtProQty.getText(),
            total       
        }
   
        );
        
        int sum=0;
        
        for(int i=0; i<tabPurch.getRowCount();i++){
            sum= sum+Integer.parseInt(tabPurch.getValueAt(i, 4).toString());        
        }
        txtProTotCost.setText(String.valueOf(sum));        
        txtProCode.setText("");
        txtProName.setText("");
        txtProPrice.setText("");
        txtProQty.setText("");
    }
    public void dbadd(){
        
        DateTimeFormatter dt= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now= LocalDateTime.now();
        String date = dt.format(now);
        String vendor = ComVendor.getSelectedItem().toString();
        String subtotal = txtProTotCost.getText();
        String pay = txtProPay.getText();
        String bal = txtProBal.getText();
        int lastid=0;
        
        String query1 = "insert into purchase(Date,PurVendor,Subtotal,Pay,Balance)values(?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS);
            
            pst.setString(1,date);
            pst.setString(2,vendor);
            pst.setString(3,subtotal);
            pst.setString(4,pay);
            pst.setString(5,bal);
            
            pst.executeUpdate();
            
            rs =pst.getGeneratedKeys();
            
            if(rs.next()){
                lastid= rs.getInt(1);
            }            
            String query2 ="insert into purchase_item(PurchID,ProID,RetPrice,Qty,Total)values(?,?,?,?,?)";
            pst1 =conn.prepareStatement(query2);
            String productid;
            String price;
            String qty;
            int total=0;
            
            for(int i=0; i<tabPurch.getRowCount();i++){
                productid = (String)tabPurch.getValueAt(i, 0);
                price = (String)tabPurch.getValueAt(i, 2);
                qty = (String)tabPurch.getValueAt(i, 3);
                total = (int)tabPurch.getValueAt(i, 4);
                
                pst1.setInt(1, lastid);
                pst1.setString(2, productid);
                pst1.setString(3, price);
                pst1.setString(4, qty); 
                pst1.setInt(5, total);
                   
                pst1.executeUpdate();
                    
            }
            
            String query3 ="update product set ProQty = ProQty + ? where ProBarcode =?";
            pst2= conn.prepareStatement(query3);
            
             for(int i=0; i<tabPurch.getRowCount();i++){
                productid = (String)tabPurch.getValueAt(i, 0);
                qty = (String)tabPurch.getValueAt(i, 3);
               
                pst2.setString(1,  qty);
                pst2.setString(2,  productid);                  
                pst2.executeUpdate();                    
            }
            JOptionPane.showMessageDialog(this, "Purchase Completed");
           
        } catch (SQLException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabPurch = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComVendor = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        BtnPurchAddDB = new javax.swing.JLabel();
        BtnBack = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtProBal = new javax.swing.JTextField();
        txtProName = new javax.swing.JTextField();
        txtProPrice = new javax.swing.JTextField();
        txtProQty = new javax.swing.JTextField();
        txtProTotCost = new javax.swing.JTextField();
        txtProPay = new javax.swing.JTextField();
        txtProCode = new javax.swing.JTextField();
        BtnPurchAdd = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabPurch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product code", "Product name", "Price", "Quantity", "Total"
            }
        ));
        jScrollPane1.setViewportView(tabPurch);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 830, 280));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jLabel2.setFont(new java.awt.Font("Bauhaus 93", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PURCHASE");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Vendor");

        ComVendor.setEditable(true);
        ComVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComVendorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 378, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ComVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));

        BtnPurchAddDB.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        BtnPurchAddDB.setForeground(new java.awt.Color(255, 255, 255));
        BtnPurchAddDB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnPurchAddDB.setText("ADD");
        BtnPurchAddDB.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        BtnPurchAddDB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnPurchAddDBMouseClicked(evt);
            }
        });

        BtnBack.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        BtnBack.setForeground(new java.awt.Color(255, 255, 255));
        BtnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnBack.setText("Back");
        BtnBack.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        BtnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addComponent(BtnPurchAddDB, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 442, Short.MAX_VALUE)
                .addComponent(BtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnPurchAddDB, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 1020, 60));

        jLabel14.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Product Name");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 110, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Price");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 110, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Quantity");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 80, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Total Cost");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, 110, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Payment");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 310, 110, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Balance");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 400, 110, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Product Code");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, 30));
        jPanel1.add(txtProBal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 430, 140, 30));
        jPanel1.add(txtProName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 210, 30));
        jPanel1.add(txtProPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 110, 30));
        jPanel1.add(txtProQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 110, 30));
        jPanel1.add(txtProTotCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 260, 140, 30));
        jPanel1.add(txtProPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 340, 140, 30));

        txtProCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProCodeKeyPressed(evt);
            }
        });
        jPanel1.add(txtProCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 170, 30));

        BtnPurchAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnPurchAdd.setForeground(new java.awt.Color(255, 255, 255));
        BtnPurchAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnPurchAdd.setText("ADD");
        BtnPurchAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 4, true));
        BtnPurchAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnPurchAddMouseClicked(evt);
            }
        });
        jPanel1.add(BtnPurchAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 110, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vecteezy-abstract-geometric-green-background_WS0321_generated.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 610));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComVendorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComVendorActionPerformed

    private void BtnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBackMouseClicked
        this.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_BtnBackMouseClicked

    private void txtProCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProCodeKeyPressed
        if(evt.getExtendedKeyCode()==KeyEvent.VK_ENTER){
               purchase();
        }// TODO add your handling code here:
    }//GEN-LAST:event_txtProCodeKeyPressed

    private void BtnPurchAddDBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPurchAddDBMouseClicked
        int pay = Integer.parseInt(txtProPay.getText());
          int subtotal = Integer.parseInt(txtProTotCost.getText());
          
          int bal = subtotal - pay;
          
          txtProBal.setText(String.valueOf(bal));
      
        dbadd();
       this.setVisible(false);
       new Purchase().setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_BtnPurchAddDBMouseClicked

    private void BtnPurchAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPurchAddMouseClicked

        purch();// TODO add your handling code here:
    }//GEN-LAST:event_BtnPurchAddMouseClicked
 
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
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Purchase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnBack;
    private javax.swing.JLabel BtnPurchAdd;
    private javax.swing.JLabel BtnPurchAddDB;
    private javax.swing.JComboBox<String> ComVendor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabPurch;
    private javax.swing.JTextField txtProBal;
    private javax.swing.JTextField txtProCode;
    private javax.swing.JTextField txtProName;
    private javax.swing.JTextField txtProPay;
    private javax.swing.JTextField txtProPrice;
    private javax.swing.JTextField txtProQty;
    private javax.swing.JTextField txtProTotCost;
    // End of variables declaration//GEN-END:variables

}
