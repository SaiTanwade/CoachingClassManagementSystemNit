/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coachingclassmanagementsystem;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author saita
 */
public class SearchStudentRecord extends javax.swing.JFrame {

    /**
     * Creates new form SearchStudentRecord
     */
    
    String Sfullname,Fname,Scontact,Pcontact,City,stdClass,Subject="",Addr,Rem;
    Date adm;Date Sdob;
    String Gender="";
    int Id;
    DefaultTableModel model;
    public SearchStudentRecord() {
        initComponents();
        settable();
       
    }
    
    void para()
    {
        Id=Integer.parseInt(txtId.getText());
        Sfullname=txtStdName.getText();
        Scontact=txtStdContact.getText();
        Pcontact=txtTotal.getText();
        Addr=txtAddress.getText();
        Rem=txtRemark.getText();         
       // fees=Integer.parseInt(c2.getText());
         
    }
     public void searchString(String str)
    {
        model=(DefaultTableModel)tbl.getModel();
        TableRowSorter<DefaultTableModel> trs =new TableRowSorter<>(model);
        tbl.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
        
    }
    
    public void clear()
    { 
          txtId.setText("");
          txtStdName.setText("");          
          txtdob.setDate(null);          
          txtStdContact.setText("");
          txtTotal.setText("");
          admDate.setDate(null);
          cmbClass.setSelectedIndex(0);
          chbPhysics.setSelected(false);
          chbChemistry.setSelected(false);
          chbBiology.setSelected(false);
          chbMaths.setSelected(false);          
          txtAddress.setText("");
          txtRemark.setText("");
          Subject=null;
          Gender=null;
    }
    
    boolean validation()
    {
        
        Id=Integer.parseInt(txtId.getText());
        Sfullname=txtStdName.getText();
        
        
        if(txtId.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Enter Course Id");
              return false;
        }
        
        if(txtStdName.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Enter Teacher Name");
              return false;
        }
        return true;
    }
    
     void update(int StdId,String StudentName,Date Stdob,Date adm,String StdContact,String Pacontact,String stdClass,String Subjects,String Address,String Remark,int Total)
            {
                SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
               String mydob=format.format(Sdob);
               SimpleDateFormat format2=new SimpleDateFormat("dd-MM-yyyy");
                 String admitionDate=format2.format(adm);
                try
                {
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
                   String sql=("update addstudent set stdname=?,stddob=?,admdate=? stdcontact=?,pcontact=?,class=? subject=?,address=?,remark=?,total=? where id=?");
                   PreparedStatement smt=con.prepareStatement(sql);
                   smt.setString(1,StudentName);
                   smt.setString(2,mydob);
                   smt.setString(3,admitionDate);
                   smt.setString(4,StdContact);
                   smt.setString(5,Pacontact);
                   stdClass=cmbClass.getSelectedItem().toString();
                   smt.setString(6,stdClass);
                   if(chbPhysics.isSelected())
                   {
                       Subject+=chbPhysics.getText()+",";
                   }
                   if(chbChemistry.isSelected())
                   {
                       Subject+=chbChemistry.getText()+",";
                   }
                   if(chbBiology.isSelected())
                   {
                       Subject+=chbBiology.getText()+",";
                   }
                   if(chbMaths.isSelected())
                   {
                       Subject+=chbMaths.getText()+",";
                   }
                   smt.setString(7,Subjects);                   
                   smt.setString(8,Address);
                   smt.setString(9,Remark);                   
                   smt.setInt(10,StdId); 
                   smt.setInt(11,Total);
                   
                   int i=smt.executeUpdate();
                   if(i>0)
                   {
                    JOptionPane.showMessageDialog(this,"record updated sucessfully");
                    clearTable();
                    settable();
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
     
     void delete(int Id)
            {
                try
                {
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");
                   
                   String sql=("delete from addstudent where id=?");
                   PreparedStatement smt=con.prepareStatement(sql);
                   smt.setInt(1,Id);                   
                   int i=smt.executeUpdate();
                   if(i>0)
                   {
                    JOptionPane.showMessageDialog(this,"record deleted sucessfully");
                    clearTable();
                   settable();
                   }
                   else{
                       JOptionPane.showMessageDialog(this,"record deletion failed");
                   }
                   con.close(); 
                   clear();
                   
                }
                catch(Exception e)
                 {
                     JOptionPane.showMessageDialog(this,"record deletion failed");
                    e.printStackTrace();
                }
                      
            }
     
     
    
    void settable()
    {
        try 
        {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");
 
          PreparedStatement pst=con.prepareStatement("select * from addstudent");
          ResultSet rs=pst.executeQuery();
          while(rs.next())
          {
              int sid=rs.getInt(1);
              String SName=rs.getString(2);
              String dob=rs.getString(3); 
              String admd=rs.getString(4);
              String scontact=rs.getString(5); 
              String pcontact=rs.getString(6);
              String sub=rs.getString(7);
              int total=rs.getInt(8);
              String addres=rs.getString(9);
              String remark=rs.getString(10);
              
              Object[] obj={sid,SName,dob,admd,scontact,pcontact,sub,total,addres,remark};
              model=(DefaultTableModel)tbl.getModel();
              model.addRow(obj);
          }  
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
         
    }
    
    
     public void clearTable()
     {
         DefaultTableModel model=(DefaultTableModel)tbl.getModel();
         model.setRowCount(0);
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
              String admdate=rs.getString("admdate");
              String stdcontact=rs.getString("stdcontact");
              String pcontact=rs.getString("pcontact");              
              String stdclass=rs.getString("class");
              String subjects=rs.getString("subject");          
              int Total=rs.getInt("total");
              String remark=rs.getString("remark"); 
              
              Object[] obj={Cid,stdName,fname,stddob,admdate,stdcontact,pcontact,stdclass,subjects,Total,remark};
              model=(DefaultTableModel)tbl.getModel();
              model.addRow(obj);
          }  
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
         
    }
//    public void searchString(String str)
//    {
//        model=(DefaultTableModel)tbl.getModel();
//        TableRowSorter<DefaultTableModel> trs =new TableRowSorter<>(model);
//        tbl.setRowSorter(trs);
//        trs.setRowFilter(RowFilter.regexFilter(str));
//        
//    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        stdId1 = new javax.swing.JLabel();
        stdId3 = new javax.swing.JLabel();
        stdId9 = new javax.swing.JLabel();
        stdId5 = new javax.swing.JLabel();
        stdId6 = new javax.swing.JLabel();
        stdId8 = new javax.swing.JLabel();
        stdId2 = new javax.swing.JLabel();
        stdId12 = new javax.swing.JLabel();
        stdId11 = new javax.swing.JLabel();
        stdId4 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtStdName = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtStdContact = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtdob = new com.toedter.calendar.JDateChooser();
        cmbClass = new javax.swing.JComboBox<>();
        chbMaths = new javax.swing.JCheckBox();
        chbPhysics = new javax.swing.JCheckBox();
        chbChemistry = new javax.swing.JCheckBox();
        chbBiology = new javax.swing.JCheckBox();
        txtRemark = new javax.swing.JTextField();
        lblbio = new javax.swing.JLabel();
        lblphy = new javax.swing.JLabel();
        lblchemi = new javax.swing.JLabel();
        lblmaths = new javax.swing.JLabel();
        admDate = new com.toedter.calendar.JDateChooser();
        add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        stdId13 = new javax.swing.JLabel();
        txtParentContact = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stdId1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId1.setForeground(new java.awt.Color(51, 51, 51));
        stdId1.setText("std Id:");
        jPanel2.add(stdId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 140, 30));

        stdId3.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId3.setForeground(new java.awt.Color(51, 51, 51));
        stdId3.setText("Student Full Name:");
        jPanel2.add(stdId3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 210, 30));

        stdId9.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId9.setForeground(new java.awt.Color(51, 51, 51));
        stdId9.setText("Student DOB:");
        jPanel2.add(stdId9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 140, 30));

        stdId5.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId5.setForeground(new java.awt.Color(51, 51, 51));
        stdId5.setText("Student Contact Number:");
        jPanel2.add(stdId5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 250, 30));

        stdId6.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId6.setForeground(new java.awt.Color(51, 51, 51));
        stdId6.setText("Parent Contact Number:");
        jPanel2.add(stdId6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 220, 30));

        stdId8.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId8.setForeground(new java.awt.Color(51, 51, 51));
        stdId8.setText("Class:");
        jPanel2.add(stdId8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 140, 30));

        stdId2.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId2.setForeground(new java.awt.Color(51, 51, 51));
        stdId2.setText("Remark:");
        jPanel2.add(stdId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 870, 140, 30));

        stdId12.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId12.setForeground(new java.awt.Color(51, 51, 51));
        stdId12.setText("Total fees:");
        jPanel2.add(stdId12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 140, 30));

        stdId11.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId11.setForeground(new java.awt.Color(51, 51, 51));
        stdId11.setText("Subject:");
        jPanel2.add(stdId11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 140, 30));

        stdId4.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId4.setForeground(new java.awt.Color(51, 51, 51));
        stdId4.setText("Admission Date:");
        jPanel2.add(stdId4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 160, 30));

        txtAddress.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        jPanel2.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 680, 310, 120));

        txtStdName.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtStdName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStdNameKeyReleased(evt);
            }
        });
        jPanel2.add(txtStdName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 380, 40));

        txtId.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtId.setToolTipText("");
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 280, 40));

        txtStdContact.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtStdContact.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtStdContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStdContactKeyPressed(evt);
            }
        });
        jPanel2.add(txtStdContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 300, 40));

        txtTotal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalKeyPressed(evt);
            }
        });
        jPanel2.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 630, 310, 40));
        jPanel2.add(txtdob, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 160, 40));

        cmbClass.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        cmbClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select ", "11th", "12th" }));
        jPanel2.add(cmbClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 190, 40));

        chbMaths.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        chbMaths.setText(" Maths");
        jPanel2.add(chbMaths, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 580, 100, 50));

        chbPhysics.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        chbPhysics.setText(" Physics ");
        jPanel2.add(chbPhysics, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 100, 50));

        chbChemistry.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        chbChemistry.setText(" Chemistry");
        chbChemistry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbChemistryActionPerformed(evt);
            }
        });
        jPanel2.add(chbChemistry, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 520, 120, 50));

        chbBiology.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        chbBiology.setText("  Biology");
        chbBiology.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbBiologyActionPerformed(evt);
            }
        });
        jPanel2.add(chbBiology, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 580, 100, 50));

        txtRemark.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        jPanel2.add(txtRemark, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 840, 310, 100));

        lblbio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(lblbio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 570, 60, 30));

        lblphy.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(lblphy, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 470, 60, 30));

        lblchemi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(lblchemi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 470, 60, 30));

        lblmaths.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(lblmaths, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 570, 60, 30));
        jPanel2.add(admDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 130, 40));

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
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 180, 110, 50));

        Update.setBackground(new java.awt.Color(153, 204, 255));
        Update.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 25)); // NOI18N
        Update.setText("Update");
        Update.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel2.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 180, 110, 50));

        Delete.setBackground(new java.awt.Color(153, 204, 255));
        Delete.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 25)); // NOI18N
        Delete.setText("Delete");
        Delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel2.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 180, 110, 50));

        stdId13.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId13.setForeground(new java.awt.Color(51, 51, 51));
        stdId13.setText("Address:");
        jPanel2.add(stdId13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 700, 140, 30));

        txtParentContact.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtParentContact.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtParentContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtParentContactKeyPressed(evt);
            }
        });
        jPanel2.add(txtParentContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 300, 40));

        tbl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Std Id", "Std Name", "Father Name", "Date of Birth", "Std Contact", "Parent Contact", "Class ", "Admission Date", "Subjects", "address", "Remark"
            }
        ));
        tbl.setEditingRow(2);
        tbl.setRowHeight(25);
        tbl.setRowMargin(2);
        jScrollPane2.setViewportView(tbl);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 1260, 710));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1950, 990));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyPressed
        // TODO add your handling code here:
        String number=txtTotal.getText();
        int length=number.length();
        char c=evt.getKeyChar();
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
        {
            if(length<10)
            {
                txtTotal.setEditable(true);
            }
            else
            {
                txtTotal.setEditable(false);
            }
        }else{
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txtTotal.setEditable(true);
            }
            else
            {
                txtTotal.setEditable(false);
            }
        }
    }//GEN-LAST:event_txtTotalKeyPressed

    private void txtStdContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStdContactKeyPressed
        // TODO add your handling code here:
        String number=txtStdContact.getText();
        int length=number.length();
        char c=evt.getKeyChar();
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
        {
            if(length<10)
            {
                txtStdContact.setEditable(true);
            }
            else
            {
                txtStdContact.setEditable(false);
            }
        }else{
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txtStdContact.setEditable(true);
            }
            else
            {
                txtStdContact.setEditable(false);
            }
        }
    }//GEN-LAST:event_txtStdContactKeyPressed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void chbChemistryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbChemistryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbChemistryActionPerformed

    private void chbBiologyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbBiologyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbBiologyActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        // TODO add your handling code here:
        //        DefaultTableModel model=(DefaultTableModel)tbl.getModel();
        //        int index=tbl.getSelectedRows();
        //        a1.setText((String)model.getValueAt(index,0).toString);

    }//GEN-LAST:event_addMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_addActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        para();
//        update(StdId,StudentName,Stdob,admd,StdContact,Pcontact,Clas,Subjects,Address,Remark);

    }//GEN-LAST:event_UpdateActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        para();
        delete(Id);       
     
    }//GEN-LAST:event_DeleteActionPerformed

    private void txtParentContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParentContactKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtParentContactKeyPressed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtStdNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStdNameKeyReleased
        // TODO add your handling code here:
        String str=txtStdName.getText();
        searchString(str);
    }//GEN-LAST:event_txtStdNameKeyReleased

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
            java.util.logging.Logger.getLogger(SearchStudentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchStudentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchStudentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchStudentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchStudentRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton Update;
    private javax.swing.JButton add;
    private com.toedter.calendar.JDateChooser admDate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chbBiology;
    private javax.swing.JCheckBox chbChemistry;
    private javax.swing.JCheckBox chbMaths;
    private javax.swing.JCheckBox chbPhysics;
    private javax.swing.JComboBox<String> cmbClass;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblbio;
    private javax.swing.JLabel lblchemi;
    private javax.swing.JLabel lblmaths;
    private javax.swing.JLabel lblphy;
    private javax.swing.JLabel stdId1;
    private javax.swing.JLabel stdId11;
    private javax.swing.JLabel stdId12;
    private javax.swing.JLabel stdId13;
    private javax.swing.JLabel stdId2;
    private javax.swing.JLabel stdId3;
    private javax.swing.JLabel stdId4;
    private javax.swing.JLabel stdId5;
    private javax.swing.JLabel stdId6;
    private javax.swing.JLabel stdId8;
    private javax.swing.JLabel stdId9;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtParentContact;
    private javax.swing.JTextField txtRemark;
    private javax.swing.JTextField txtStdContact;
    private javax.swing.JTextField txtStdName;
    private javax.swing.JTextField txtTotal;
    private com.toedter.calendar.JDateChooser txtdob;
    // End of variables declaration//GEN-END:variables
}
