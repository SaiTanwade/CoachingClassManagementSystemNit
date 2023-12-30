package coachingclassmanagementsystem;


import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saita
 */
public class searchRecord extends javax.swing.JFrame {

    /**
     * Creates new form searchRecord
     */
    String Sfullname,Fname,Scontact,Pcontact,City,stdClass,Subject,Addr,Rem;
    Date adm;Date Sdob;
    String Gender="";
    int Id;
    
    DefaultTableModel model;
    public searchRecord() {
        initComponents();
        tablesize();
        searchRecordtable();
       
    }
    
//     public void clear()
//    {
//          txtId.setText("");
//          txtStdName.setText("");
//          txtFatherName.setText("");
//          txtdob.setDate(null);
//          //buttonGroup1.clearSelection();
//          txtStdContact.setText("");
//          txtParentContact.setText("");
//          AdmDate.setDate(null);
//          cmbClass.setSelectedIndex(0);
////          chbPhysics.setSelected(false);
////          chbChemistry.setSelected(false);
////          chbBiology.setSelected(false);
////          chbMaths.setSelected(false);
//          txtCity.setText("");
//          TxtAddress.setText("");
//          txtRemark.setText("");
//          
//    }
//    
    public void tablesize()
    {
        recordTbl.getColumnModel().getColumn(0).setPreferredWidth(50);
        recordTbl.getColumnModel().getColumn(1).setPreferredWidth(280);
        recordTbl.getColumnModel().getColumn(2).setPreferredWidth(260);
        recordTbl.getColumnModel().getColumn(3).setPreferredWidth(140);
        recordTbl.getColumnModel().getColumn(4).setPreferredWidth(140);
        recordTbl.getColumnModel().getColumn(5).setPreferredWidth(140);
        recordTbl.getColumnModel().getColumn(6).setPreferredWidth(80);
        recordTbl.getColumnModel().getColumn(7).setPreferredWidth(350);
        recordTbl.getColumnModel().getColumn(8).setPreferredWidth(150);
        recordTbl.getColumnModel().getColumn(9).setPreferredWidth(200);
        
    }
    
    void searchRecordtable()
    {
        try 
        {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root",""); 
          PreparedStatement pst=con.prepareStatement("select * from addstudent");
          ResultSet rs=pst.executeQuery();
          while(rs.next())
          {
              int Cid=rs.getInt("id");
              String stdName=rs.getString("stdname");
              String fname=rs.getString("fathername"); 
              String stddob=rs.getString("stddob");
              String stdcontact=rs.getString("stdcontact");
              String pcontact=rs.getString("pcontact");
              String admdate=rs.getString("admdate");
              String stdclass=rs.getString("class");
              String subjects=rs.getString("subject");          
              //int fee=rs.getInt(4);
              String remark=rs.getString("remark"); 
              
              Object[] obj={Cid,stdName,fname,stddob,stdcontact,pcontact,stdclass,subjects,admdate,remark};
              model=(DefaultTableModel)recordTbl.getModel();
              model.addRow(obj);
          }  
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
         
    }
    public void searchString(String str)
    {
        model=(DefaultTableModel)recordTbl.getModel();
        TableRowSorter<DefaultTableModel> trs =new TableRowSorter<>(model);
        recordTbl.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
        
    }
    
    void update(int CourseIds,String TeacherName,String Subject,int fees)
            {
                try
                {
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
                   String sql=("update sai set TeacherName=?,Subject=?,fees=? where CourseId=?");
                   PreparedStatement smt=con.prepareStatement(sql);
                   smt.setString(1,TeacherName);
                   smt.setString(2,Subject);
                   smt.setInt(3,fees);
                  // smt.setInt(4,CourseId);                   
                   int i=smt.executeUpdate();
                   if(i>0)
                   {
                    JOptionPane.showMessageDialog(this,"record updated sucessfully");
                    clearTable();
                    //settable();
                   }
                   else{
                       JOptionPane.showMessageDialog(this,"record updation failed");
                   }
                   con.close();                 
                }
                catch(Exception e)
                 {
                     JOptionPane.showMessageDialog(this,"record updation failed");
                    e.printStackTrace();
                }
                      
            }
    
    void delete(int CourseId)
            {
                try
                {
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");
                   
                   String sql=("delete from sai where CourseId=?");
                   PreparedStatement smt=con.prepareStatement(sql);
                   smt.setInt(1,CourseId);                   
                   int i=smt.executeUpdate();
                   if(i>0)
                   {
                    JOptionPane.showMessageDialog(this,"record deleted sucessfully");
                    clearTable();
                   //settable();
                   }
                   else{
                       JOptionPane.showMessageDialog(this,"record deletion failed");
                   }
                   con.close(); 
                   //clear();
                   
                }
                catch(Exception e)
                 {
                     JOptionPane.showMessageDialog(this,"record deletion failed");
                    e.printStackTrace();
                }
                      
            }
     
    public void clearTable()
     {
         DefaultTableModel model=(DefaultTableModel)recordTbl.getModel();
         model.setRowCount(0);
     }

     
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btncrsDetails = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnCreateAcc5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnFees = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnViewRecord = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnReport = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recordTbl = new javax.swing.JTable();
        stdId5 = new javax.swing.JLabel();
        b1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(83, 161, 250));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(79, 184, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 255, 153), new java.awt.Color(153, 255, 153), new java.awt.Color(51, 51, 51), new java.awt.Color(204, 255, 255)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setBackground(new java.awt.Color(246, 142, 115));
        btnHome.setFont(new java.awt.Font("Microsoft Himalaya", 0, 48)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/Imgs/home.png"))); // NOI18N
        btnHome.setText("        Home");
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
        jPanel3.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 80));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 360, 80));

        jPanel6.setBackground(new java.awt.Color(79, 184, 255));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 255, 153), new java.awt.Color(153, 255, 153), new java.awt.Color(51, 51, 51), new java.awt.Color(204, 255, 255)));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncrsDetails.setBackground(new java.awt.Color(246, 142, 115));
        btncrsDetails.setFont(new java.awt.Font("Microsoft Himalaya", 0, 48)); // NOI18N
        btncrsDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/Imgs/view all record.png"))); // NOI18N
        btncrsDetails.setText("   Course Details");
        btncrsDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncrsDetailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncrsDetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncrsDetailsMouseExited(evt);
            }
        });
        jPanel6.add(btncrsDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 80));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 360, -1));

        jPanel8.setBackground(new java.awt.Color(79, 184, 255));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 255, 153), new java.awt.Color(153, 255, 153), new java.awt.Color(51, 51, 51), new java.awt.Color(204, 255, 255)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCreateAcc5.setBackground(new java.awt.Color(246, 142, 115));
        btnCreateAcc5.setFont(new java.awt.Font("Microsoft Himalaya", 0, 48)); // NOI18N
        btnCreateAcc5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/Imgs/logout.png"))); // NOI18N
        btnCreateAcc5.setText("       Logout");
        btnCreateAcc5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateAcc5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCreateAcc5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCreateAcc5MouseExited(evt);
            }
        });
        jPanel8.add(btnCreateAcc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 80));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 850, 360, -1));

        jPanel9.setBackground(new java.awt.Color(79, 184, 255));
        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 255, 153), new java.awt.Color(153, 255, 153), new java.awt.Color(51, 51, 51), new java.awt.Color(204, 255, 255)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFees.setBackground(new java.awt.Color(246, 142, 115));
        btnFees.setFont(new java.awt.Font("Microsoft Himalaya", 0, 48)); // NOI18N
        btnFees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/Imgs/printer-.png"))); // NOI18N
        btnFees.setText("     Fees Reciept");
        btnFees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFeesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFeesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFeesMouseExited(evt);
            }
        });
        jPanel9.add(btnFees, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 80));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 360, -1));

        jPanel5.setBackground(new java.awt.Color(79, 184, 255));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 255, 153), new java.awt.Color(153, 255, 153), new java.awt.Color(51, 51, 51), new java.awt.Color(204, 255, 255)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnViewRecord.setBackground(new java.awt.Color(246, 142, 115));
        btnViewRecord.setFont(new java.awt.Font("Microsoft Himalaya", 0, 48)); // NOI18N
        btnViewRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/Imgs/view all record.png"))); // NOI18N
        btnViewRecord.setText("     View Record");
        btnViewRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewRecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnViewRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnViewRecordMouseExited(evt);
            }
        });
        jPanel5.add(btnViewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 80));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 360, -1));

        jPanel7.setBackground(new java.awt.Color(79, 184, 255));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 255, 153), new java.awt.Color(153, 255, 153), new java.awt.Color(51, 51, 51), new java.awt.Color(204, 255, 255)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReport.setBackground(new java.awt.Color(246, 142, 115));
        btnReport.setFont(new java.awt.Font("Microsoft Himalaya", 0, 48)); // NOI18N
        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/Imgs/view all record.png"))); // NOI18N
        btnReport.setText("     View Report");
        btnReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportMouseExited(evt);
            }
        });
        jPanel7.add(btnReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 80));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 690, 360, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 1020));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recordTbl.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        recordTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Std Id", "Std Name", "Father Name", "Std DOB", "Std Contact", "Parent Contact", "Class", "Subject", "Admition Date", "Remark"
            }
        ));
        recordTbl.setRowHeight(25);
        jScrollPane1.setViewportView(recordTbl);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 1400, 700));

        stdId5.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId5.setForeground(new java.awt.Color(51, 51, 51));
        stdId5.setText("Search By student Name:");
        jPanel2.add(stdId5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 250, 30));

        b1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        b1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                b1KeyReleased(evt);
            }
        });
        jPanel2.add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 430, 40));

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 48)); // NOI18N
        jLabel9.setText("Search Record");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 51), new java.awt.Color(51, 255, 51), new java.awt.Color(255, 0, 255), java.awt.Color.black));
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 440, 30));

        add.setBackground(new java.awt.Color(153, 204, 255));
        add.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 25)); // NOI18N
        add.setText("Search");
        add.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, 130, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 1480, 1020));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        // TODO add your handling code here:
        Home Ac=new Home();
        setVisible(false);
        Ac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(39,166,252);
        jPanel3.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        // TODO add your handling code here:
        Color clr=new Color(79,184,255);
        jPanel3.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseExited

    private void btncrsDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncrsDetailsMouseClicked
        // TODO add your handling code here:
        NewJFrame nf=new NewJFrame();
        setVisible(false);
        nf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btncrsDetailsMouseClicked

    private void btncrsDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncrsDetailsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btncrsDetailsMouseEntered

    private void btncrsDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncrsDetailsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btncrsDetailsMouseExited

    private void btnCreateAcc5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateAcc5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateAcc5MouseClicked

    private void btnCreateAcc5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateAcc5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateAcc5MouseEntered

    private void btnCreateAcc5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateAcc5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateAcc5MouseExited

    private void btnFeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFeesMouseClicked

    private void btnFeesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFeesMouseEntered

    private void btnFeesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFeesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFeesMouseExited

    private void btnViewRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRecordMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewRecordMouseClicked

    private void btnViewRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRecordMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewRecordMouseEntered

    private void btnViewRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRecordMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewRecordMouseExited

    private void btnReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportMouseClicked

    private void btnReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportMouseEntered

    private void btnReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportMouseExited

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b1ActionPerformed

    private void b1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b1KeyReleased
        // TODO add your handling code here:
        String str=b1.getText();
        searchString(str);
        
    }//GEN-LAST:event_b1KeyReleased

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel6MouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        // TODO add your handling code here:
        //        DefaultTableModel model=(DefaultTableModel)tbl.getModel();
        //        int index=tbl.getSelectedRows();
        //        a1.setText((String)model.getValueAt(index,0).toString);

    }//GEN-LAST:event_addMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        String str=b1.getText();
        searchString(str);      

    }//GEN-LAST:event_addActionPerformed

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
            java.util.logging.Logger.getLogger(searchRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField b1;
    private javax.swing.JLabel btnCreateAcc5;
    private javax.swing.JLabel btnFees;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnReport;
    private javax.swing.JLabel btnViewRecord;
    private javax.swing.JLabel btncrsDetails;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable recordTbl;
    private javax.swing.JLabel stdId5;
    // End of variables declaration//GEN-END:variables
}
