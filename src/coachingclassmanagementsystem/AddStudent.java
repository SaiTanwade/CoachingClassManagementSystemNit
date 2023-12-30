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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author saita
 */
public class AddStudent extends javax.swing.JFrame {

    /**
     * Creates new form AddStudent
     */
    
    String Sfullname="",Scontact="",Pcontact,stdClass,Subject="",Addr,Rem;
    Date adm;Date Sdob;
    String Gender="";
    int Id,paid,remain;
    int n=0;
    int Total=0;
    int ttl=0;
    int Discount;
     int TotalFinal;
//        int Total;
        int Final;
        int DiscountFee;
    public AddStudent() {
        
        initComponents();
//        txtTotal.setText("0");
        
//          txtPaid.setText("0");
        
        
//        setFeesValue();
       //get();
        txtStdId();
        getCourseid();
      
    }
    
    void getfeesValueAsText()
    {
         PrintReceipt su=new PrintReceipt();

        su.txtPhy.setText(lblphy.getText());
        su.txtChemi.setText(lblchemi.getText());
        su.txtBio.setText(lblbio.getText());
        su.txtMaths.setText(lblmaths.getText());
        su.txtTotal1.setText(txtTotal.getText());
        su.txtDisc1.setText(txtDisc.getText());
        su.txtFinal1.setText(txtFinal.getText());
        su.setVisible(true);
    } 
   
    void GetReaming()
      {
          int TotalFinal;
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
//            st=con.createStatement();
            TotalFinal=Integer.parseInt(txtFinal.getText());
            paid=Integer.parseInt(txtPaid.getText());
             ttl= TotalFinal-paid;
            txtRemaining.setText(Integer.toString(ttl));
          }
          catch(Exception e)
        {
          //  JOptionPane.showMessageDialog(null,e);
        }
           
      }
    
    void txtStdId()
    {
        txtId.setEditable(false);
        txtTotal.setEditable(false);
        txtRemaining.setEditable(false);
        txtTotal.setEditable(false);
        txtFinal.setEditable(false);
        
    }
    
    public void clear()
    {
          txtId.setText("");
          txtStdName.setText("");
          txtdob.setDate(null);
          buttonGroup1.clearSelection();
          txtStdContact1.setText("");
          txtParentContact1.setText("");
          txtTotal.setText("");
         AdmDate.setDate(null);
         cmbClass.setSelectedIndex(0);
         chbPhysics.setSelected(false);
         chbChemistry.setSelected(false);
         chbBiology.setSelected(false);
         chbMaths.setSelected(false);
         lblphy.setText("");
         lblchemi.setText("");
         lblbio.setText("");
         lblmaths.setText("");
         txtFinal.setText("");
         txtDisc.setText("");
          TxtAddress.setText("");
          txtRemark.setText("");
          Subject=null;
          Gender=null;
          txtRemaining.setText("");
          txtPaid.setText("");
          
    }
    public void checkSContact()
          {
            Scontact=txtStdContact1.getText();
            if(Scontact.length()<9)
            {
                lblscontact.setText("Contact should be 10 digit");
            }           
           
            else
            {
                 lblscontact.setText("");
                
            }
           
          }
            public void checkPContact()
          {
            Pcontact=txtParentContact1.getText();
            
            if(Pcontact.length()<9)
            {
                lblpcontact.setText("Contact should be 10 digit");
            }
           
            else
            {
                 
                 lblpcontact.setText("");
            }
           
          }
    
    
    boolean validation()
      {   
       Id=Integer.parseInt(txtId.getText().trim());
          Sfullname=txtStdName.getText().trim();
          Sdob=txtdob.getDate();
         //Gender=buttonGroup1.setSelected(true);
          Scontact=txtStdContact1.getText().trim();
          Pcontact=txtParentContact1.getText().trim();
          adm=AdmDate.getDate();
         stdClass=cmbClass.getItemAt(0);
//          Subject=chbPhysics.getSelected();
//          Subject=chbChemistry.getSelected();
//          Subject=chbBiology.getSelected();
//          Subject=chbMaths.getSelected();
//          Total=Integer.parseInt(txtTotal.getText());
//          paid=Integer.parseInt(txtPaid.getText());
//          remain=Integer.parseInt(txtRemaining.getText());         
          Addr=TxtAddress.getText().trim();
          Rem=txtRemark.getText().trim();
          
          if(txtId.equals(""))
          {
              JOptionPane.showMessageDialog(this,"Please Enter Id");
              return false;
          }
          
         if(txtRemark.equals(""))
          {
              JOptionPane.showMessageDialog(this,"Please Enter Remark");
              return false;
          }
          if(Sfullname.equals(""))
          {
              JOptionPane.showMessageDialog(this,"Please Enter Student Name");
              return false;
          }
          
         if(Sdob == null)
          {
              JOptionPane.showMessageDialog(this,"Please Enter dob");
              return false;
          }
          
//          if(Gender.equals(""))
//          {
//              JOptionPane.showMessageDialog(this,"Please Select Gender");
//              return false;
//          }
          
         if(Scontact.equals(""))
          {
              JOptionPane.showMessageDialog(this,"Please Enter Student contact Number");
              return false;
          }
          
          
          if(Pcontact.equals(""))
          {
              JOptionPane.showMessageDialog(this,"Please Parent contact Number");
              return false;
          }
          
          if(adm == null)
          {
              JOptionPane.showMessageDialog(this,"Please Enter Admition Date");
              return false;
          }
//           if(txtTotal.equals(""))
//          {
//              JOptionPane.showMessageDialog(this,"Please Enter Total Amount");
//              return false;
//          }
//           if(txtPaid.equals(""))
//          {
//              JOptionPane.showMessageDialog(this,"Please Enter paidAmount");
//              return false;
//          }
//           if(txtRemaining.equals(""))
//          {
//              JOptionPane.showMessageDialog(this,"Please Enter Total Remaining Fees");
//              return false;
//          }
          if(Addr.equals(""))
          {
              JOptionPane.showMessageDialog(this,"Please Enter Address");
              return false;
          }
          if(Rem.equals(""))
          {
              JOptionPane.showMessageDialog(this,"Please Enter Remark");
              return false;
          }
          return true;
      }
     boolean Validation2()
     {
          if(txtTotal.getText().trim().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Total Fees");
              return false;
              
          
        }
        if(txtDisc.getText().trim().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Discount if you want else enter 0 ");
              return false;
              
          
        }
        if(txtPaid.getText().trim().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter paid Fees");
              return false;
              
          
        }
        if(txtRemaining.getText().trim().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Reamining Fees");
              return false;
              
          
        }
        int s1=cmbClass.getSelectedIndex();
        if(s1==-1)
        {
           JOptionPane.showMessageDialog(this,"Please Select Class"); 
           return false;
        }
        return true;
     }
    
    void getCourseid()
     {
         
        try
                {
                    
                    
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");
                   
                   String sql=("Select Max(Id)from addstudent"); 
                   PreparedStatement smt=con.prepareStatement(sql);
                   ResultSet rs=smt.executeQuery();
                   if(rs.next()==true)
                   {
                       Id=rs.getInt(1);
                       Id++;
                       txtId.setText(Integer.toString(Id));
                   }
                }
        catch(Exception e)
        {
            System.out.println(e);
        }
     }
    
      void getTotal()
      {
          int Total=0;
          n=0;
        if(chbPhysics.isSelected())
        {
        Connection con;
        Statement st;
        ResultSet rs1=null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
            st=con.createStatement();
            rs1=st.executeQuery("select fees from sai where subject='Physics'");
            while(rs1.next())
            {
               n = n +rs1.getInt(1); 
            }        
        } 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Select subject");
        }
            }
        
         if(chbChemistry.isSelected())
        {
            Connection con;
        Statement st;
        ResultSet rs2=null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
            st=con.createStatement();
            rs2=st.executeQuery("select fees from sai where subject='Chemistry'");
            while(rs2.next())
            {
               n = n +rs2.getInt(1); 
            }        
        } 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Select Subject");
        }
            }
          if(chbBiology.isSelected())
        {
            Connection con;
        Statement st;
        ResultSet rs3=null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
            st=con.createStatement();
            rs3=st.executeQuery("select fees from sai where subject='Biology'");
            while(rs3.next())
            {
               n = n +rs3.getInt(1); 
            }        
        } 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Select Subject");
        }
            }
           if(chbMaths.isSelected())
        {
            Connection con;
        Statement st;
        ResultSet rs4=null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
            st=con.createStatement();
            rs4=st.executeQuery("select fees from sai where subject='Maths'");
            while(rs4.next())
            {
               n = n +rs4.getInt(1); 
            }        
        } 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Select Subject");
        }
            }
           
//           if(!rbtnMale.isSelected())
//                   {
//                       Gender="Male";
//                   }
//                   if(rbtnFemale.isSelected())
//                   {
//                       Gender="Female";
//                   }
//           
           
           
          
      }
      
//      void GetFeesInfo()
//      {
//          PrintReceipt prf=new PrintReceipt(lblphy.getText());
////          prf.label1.setText(txtParentContact1.getText());
//          prf.setVisible(true);
//      }
    void insertDetails()
            {
                
                
                Sdob=txtdob.getDate();
                adm=AdmDate.getDate();
             
                
               SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
               String mydob=format.format(Sdob);
               SimpleDateFormat format2=new SimpleDateFormat("dd-MM-yyyy");
                 String admitionDate=format2.format(adm);
                
                try
                {
                    txtTotal.setText("0");
                  Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");
                   
                   String sql="insert into addstudent values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                   PreparedStatement smt=con.prepareStatement(sql);
                   smt.setInt(1,Id);
                   smt.setString(2,Sfullname);
                  
                   smt.setString(3,mydob);
                  
//                   if(!rbtnMale.isSelected()||!rbtnFemale.isSelected())
//                   {
//                     JOptionPane.showMessageDialog(this,"Please Select Gender");
//                     return ;
//                    }
//                      else
//                     {
                        if(rbtnMale.isSelected())
                        {
                         Gender="Male";
                         }
                        if(rbtnFemale.isSelected())
                        {
                          Gender="Female";
                         } 
//                    }
                   smt.setString(4,Gender);
                   smt.setString(5,Scontact);
                   smt.setString(6,Pcontact);
                   smt.setString(7,admitionDate);
                   stdClass=cmbClass.getSelectedItem().toString();
                   smt.setString(8,stdClass);
                   
                   if(chbPhysics.isSelected())
                   {
                       Subject+=chbPhysics.getText();
                   }
                   if(chbChemistry.isSelected())
                   {
                       Subject+=chbChemistry.getText();
                   }
                   if(chbBiology.isSelected())
                   {
                       Subject+=chbBiology.getText();
                   }
                   if(chbMaths.isSelected())
                   {
                       Subject+=chbMaths.getText();
                   }
                   String subject1=Subject.trim();
                   smt.setString(9,subject1);
                  
                   smt.setString(10,Addr);
                   smt.setString(11,Rem);
                   DiscountFee=Integer.parseInt(txtFinal.getText());
                   smt.setInt(12,DiscountFee);
                   //txtTotal.setText(String.valueOf(n));
                  // paid=Integer.parseInt(txtPaid.getText());
                   smt.setInt(13,paid);
                   remain=Integer.parseInt(txtRemaining.getText());
                   smt.setInt(14,remain);
                   
                   getTotal();
                   int i=smt.executeUpdate();
                   if(i>0)
                   {
                    JOptionPane.showMessageDialog(this,"record inserted");
                    
                   }
                   else{
                       JOptionPane.showMessageDialog(this,"record not inserted");
                   }
                   con.close();
                  // clear();
                   
                }
                catch(Exception e)
                 {
                    e.printStackTrace();
                }
            }
    
    public void GetDiscount()
    {
        try
        {
        int Discount;
        int Total1;
        int Final;
        int DiscountFee;
        Total1=Integer.parseInt(txtTotal.getText());
        Discount=Integer.parseInt(txtDisc.getText());
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");
        Final=(Total1*Discount)/100; 
         DiscountFee=Total1-Final;
        txtFinal.setText(Integer.toString(DiscountFee));
        
        }
        catch(Exception e)
        {
            
        }
        
    }

       
            
        
       
          

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
        gender = new javax.swing.JLabel();
        txtStdName = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtParentContact1 = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        rbtnFemale = new javax.swing.JRadioButton();
        rbtnMale = new javax.swing.JRadioButton();
        txtdob = new com.toedter.calendar.JDateChooser();
        AdmDate = new com.toedter.calendar.JDateChooser();
        cmbClass = new javax.swing.JComboBox<>();
        chbMaths = new javax.swing.JCheckBox();
        chbPhysics = new javax.swing.JCheckBox();
        chbChemistry = new javax.swing.JCheckBox();
        chbBiology = new javax.swing.JCheckBox();
        btnSubmit = new javax.swing.JButton();
        lblbio = new javax.swing.JLabel();
        lblphy = new javax.swing.JLabel();
        lblchemi = new javax.swing.JLabel();
        lblmaths = new javax.swing.JLabel();
        stdId13 = new javax.swing.JLabel();
        txtStdContact1 = new javax.swing.JTextField();
        stdId14 = new javax.swing.JLabel();
        txtPaid = new javax.swing.JTextField();
        txtRemaining = new javax.swing.JTextField();
        stdId15 = new javax.swing.JLabel();
        lblscontact = new javax.swing.JLabel();
        lblpcontact = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtAddress = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRemark = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        stdId16 = new javax.swing.JLabel();
        txtDisc = new javax.swing.JTextField();
        stdId17 = new javax.swing.JLabel();
        stdId18 = new javax.swing.JLabel();
        txtFinal = new javax.swing.JTextField();
        Rehersh = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        b = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        c = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        d = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        e = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        f = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        g = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        a = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stdId1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId1.setForeground(new java.awt.Color(51, 51, 51));
        stdId1.setText("std Id:");
        jPanel2.add(stdId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 140, 30));

        stdId3.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId3.setForeground(new java.awt.Color(51, 51, 51));
        stdId3.setText("Student Full Name:");
        jPanel2.add(stdId3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 180, 30));

        stdId9.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId9.setForeground(new java.awt.Color(51, 51, 51));
        stdId9.setText("Student DOB:");
        jPanel2.add(stdId9, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 100, 140, 30));

        stdId5.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId5.setForeground(new java.awt.Color(51, 51, 51));
        stdId5.setText("Student Contact Number:");
        jPanel2.add(stdId5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 250, 30));

        stdId6.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId6.setForeground(new java.awt.Color(51, 51, 51));
        stdId6.setText("Parent Contact Number:");
        jPanel2.add(stdId6, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 320, 240, 30));

        stdId8.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId8.setForeground(new java.awt.Color(51, 51, 51));
        stdId8.setText("Class:");
        jPanel2.add(stdId8, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 430, 140, 30));

        stdId2.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId2.setForeground(new java.awt.Color(51, 51, 51));
        stdId2.setText("Remark:");
        jPanel2.add(stdId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 740, 140, 30));

        stdId12.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId12.setForeground(new java.awt.Color(51, 51, 51));
        stdId12.setText("Address:");
        jPanel2.add(stdId12, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 520, 140, 30));

        stdId11.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId11.setForeground(new java.awt.Color(51, 51, 51));
        stdId11.setText("%");
        jPanel2.add(stdId11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 740, 40, -1));

        stdId4.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId4.setForeground(new java.awt.Color(51, 51, 51));
        stdId4.setText("Admission Date:");
        jPanel2.add(stdId4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 210, 160, 40));

        gender.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        gender.setForeground(new java.awt.Color(51, 51, 51));
        gender.setText("Gender:");
        jPanel2.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 100, 30));

        txtStdName.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtStdName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtStdName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStdNameKeyTyped(evt);
            }
        });
        jPanel2.add(txtStdName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 430, 40));

        txtId.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtId.setToolTipText("");
        txtId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 430, 40));

        txtParentContact1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtParentContact1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtParentContact1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtParentContact1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtParentContact1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtParentContact1KeyReleased(evt);
            }
        });
        jPanel2.add(txtParentContact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 310, 280, 40));

        txtTotal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTotal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTotalFocusGained(evt);
            }
        });
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
        jPanel2.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 670, 180, 40));

        buttonGroup1.add(rbtnFemale);
        rbtnFemale.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        rbtnFemale.setText("  Female");
        jPanel2.add(rbtnFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 130, 60));

        buttonGroup1.add(rbtnMale);
        rbtnMale.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        rbtnMale.setText(" Male");
        jPanel2.add(rbtnMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 120, 60));

        txtdob.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(txtdob, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 90, 280, 40));

        AdmDate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(AdmDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 210, 280, 40));

        cmbClass.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        cmbClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "11th", "12th" }));
        cmbClass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(cmbClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 420, 190, 40));

        chbMaths.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        chbMaths.setText(" Maths");
        chbMaths.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbMathsActionPerformed(evt);
            }
        });
        jPanel2.add(chbMaths, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 590, 110, 50));

        chbPhysics.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        chbPhysics.setText(" Physics ");
        chbPhysics.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chbPhysicsStateChanged(evt);
            }
        });
        chbPhysics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chbPhysicsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                chbPhysicsMouseReleased(evt);
            }
        });
        chbPhysics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbPhysicsActionPerformed(evt);
            }
        });
        jPanel2.add(chbPhysics, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, 100, 50));

        chbChemistry.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        chbChemistry.setText(" Chemistry");
        chbChemistry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbChemistryActionPerformed(evt);
            }
        });
        jPanel2.add(chbChemistry, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 510, 120, 50));

        chbBiology.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        chbBiology.setText("  Biology");
        chbBiology.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbBiologyActionPerformed(evt);
            }
        });
        jPanel2.add(chbBiology, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, 100, 50));

        btnSubmit.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnSubmit.setText("Get Admission");
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSubmitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSubmitMouseExited(evt);
            }
        });
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel2.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 880, 160, 60));

        lblbio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(lblbio, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 610, 60, 20));

        lblphy.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(lblphy, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 530, 60, 20));

        lblchemi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(lblchemi, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 530, 60, 20));

        lblmaths.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(lblmaths, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 610, 60, 20));

        stdId13.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId13.setForeground(new java.awt.Color(51, 51, 51));
        stdId13.setText("Subject:");
        jPanel2.add(stdId13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 140, 30));

        txtStdContact1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtStdContact1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtStdContact1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtStdContact1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStdContact1FocusLost(evt);
            }
        });
        txtStdContact1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStdContact1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStdContact1KeyReleased(evt);
            }
        });
        jPanel2.add(txtStdContact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 430, 40));

        stdId14.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId14.setForeground(new java.awt.Color(51, 51, 51));
        stdId14.setText("Paid Fees:");
        jPanel2.add(stdId14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 850, 130, 30));

        txtPaid.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtPaid.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPaid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtPaid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPaidFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPaidFocusLost(evt);
            }
        });
        txtPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaidActionPerformed(evt);
            }
        });
        txtPaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPaidKeyPressed(evt);
            }
        });
        jPanel2.add(txtPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 840, 180, 40));

        txtRemaining.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtRemaining.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtRemaining.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtRemaining.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRemainingFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRemainingFocusLost(evt);
            }
        });
        txtRemaining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRemainingActionPerformed(evt);
            }
        });
        txtRemaining.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRemainingKeyPressed(evt);
            }
        });
        jPanel2.add(txtRemaining, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 900, 180, 40));

        stdId15.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId15.setForeground(new java.awt.Color(51, 51, 51));
        stdId15.setText("Remaining Fees");
        jPanel2.add(stdId15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 910, 150, 30));
        jPanel2.add(lblscontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 240, 20));
        jPanel2.add(lblpcontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 360, 270, 20));

        jPanel3.setBackground(new java.awt.Color(252, 210, 143));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/56656565665.png"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 80));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 120, 100));

        TxtAddress.setColumns(20);
        TxtAddress.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        TxtAddress.setRows(5);
        jScrollPane1.setViewportView(TxtAddress);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 510, -1, 140));

        txtRemark.setColumns(20);
        txtRemark.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtRemark.setRows(5);
        jScrollPane2.setViewportView(txtRemark);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 740, 330, 140));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("₹");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 610, 10, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("₹");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, 10, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("₹");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 530, 10, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("₹");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 610, 10, 20));

        stdId16.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId16.setForeground(new java.awt.Color(51, 51, 51));
        stdId16.setText("Total Fees :");
        jPanel2.add(stdId16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 670, 140, 30));

        txtDisc.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtDisc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDisc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiscFocusLost(evt);
            }
        });
        txtDisc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDiscKeyPressed(evt);
            }
        });
        jPanel2.add(txtDisc, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 730, 180, 40));

        stdId17.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId17.setForeground(new java.awt.Color(51, 51, 51));
        stdId17.setText("Discount:");
        jPanel2.add(stdId17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 730, 100, 30));

        stdId18.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId18.setForeground(new java.awt.Color(51, 51, 51));
        stdId18.setText("Final Fees:");
        jPanel2.add(stdId18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 790, 140, 30));

        txtFinal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtFinal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFinal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFinalFocusGained(evt);
            }
        });
        txtFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFinalActionPerformed(evt);
            }
        });
        txtFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFinalKeyPressed(evt);
            }
        });
        jPanel2.add(txtFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 780, 180, 40));

        Rehersh.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        Rehersh.setText("Refersh");
        Rehersh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RehershMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RehershMouseExited(evt);
            }
        });
        Rehersh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RehershActionPerformed(evt);
            }
        });
        jPanel2.add(Rehersh, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 880, 160, 60));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/222-1.jpg"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 1220, 990));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 1610, 990));

        jPanel10.setBackground(new java.awt.Color(6, 48, 49));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b.setBackground(new java.awt.Color(6, 48, 49));
        b.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/update.png"))); // NOI18N
        jLabel5.setText("   Update Std Rec");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        b.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 70));

        jPanel10.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 340, -1));

        c.setBackground(new java.awt.Color(6, 48, 49));
        c.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/course details.png"))); // NOI18N
        jLabel6.setText("   Course Details");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        c.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 70));

        jPanel10.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 340, -1));

        d.setBackground(new java.awt.Color(6, 48, 49));
        d.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/fees receipt.png"))); // NOI18N
        jLabel4.setText("   Fees Receipt");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        d.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 70));

        jPanel10.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 340, -1));

        e.setBackground(new java.awt.Color(6, 48, 49));
        e.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/view record sdfd.png"))); // NOI18N
        jLabel7.setText("   View Record");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        e.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 70));

        jPanel10.add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 340, -1));

        f.setBackground(new java.awt.Color(6, 48, 49));
        f.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/view report.png"))); // NOI18N
        jLabel8.setText("  View Report");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        f.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 70));

        jPanel10.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 340, -1));

        g.setBackground(new java.awt.Color(6, 48, 49));
        g.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/logout,  USE.png"))); // NOI18N
        jLabel9.setText("   Logout");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        g.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 70));

        jPanel10.add(g, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 860, 340, -1));

        a.setBackground(new java.awt.Color(6, 48, 49));
        a.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/HOME WH p.png"))); // NOI18N
        jLabel2.setText("   Home");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        a.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 70));

        jPanel10.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 340, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/sdfgdfgfg.png"))); // NOI18N
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 190, 150));
        jPanel10.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 170, 20));

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 1010));

        jPanel1.setBackground(new java.awt.Color(252, 210, 143));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 1610, 20));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
       if(validation()&&Validation2()){
           //Total();           
        insertDetails();

        getfeesValueAsText();
                    
           //int Total=0;  
       }
        getCourseid();
//       GetFeesInfo();   
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtParentContact1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParentContact1KeyPressed
        // TODO add your handling code here:
        checkPContact();
        String number=txtParentContact1.getText();
        int length=number.length();
        char c=evt.getKeyChar();
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
        {
            if(length<10)
            {
                txtParentContact1.setEditable(true);
            }
            else
            {
                txtParentContact1.setEditable(false);
            }
        }else{
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txtParentContact1.setEditable(true);
            }
            else
            {
                txtParentContact1.setEditable(false);
            }
        }
        
    }//GEN-LAST:event_txtParentContact1KeyPressed

    private void txtTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyPressed
        // TODO add your handling code here:
//        String number=txtTotal.getText();
//        int length=number.length();
//        char c=evt.getKeyChar();
//        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
//        {
//            if(length<10)
//            {
//                txtTotal.setEditable(true);
//            }
//            else
//            {
//                txtTotal.setEditable(false);
//            }
//        }else{
//            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
//            {
//                txtTotal.setEditable(true);
//            }
//            else
//            {
//                txtTotal.setEditable(false);
//            }
//        }
//        
        
        
    }//GEN-LAST:event_txtTotalKeyPressed

    private void chbPhysicsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chbPhysicsStateChanged
       
    }//GEN-LAST:event_chbPhysicsStateChanged

    private void chbPhysicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbPhysicsActionPerformed
        // TODO add your handling code here:
       if(chbPhysics.isSelected()){
        Connection con;
        Statement st;
        ResultSet rs=null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
            st=con.createStatement();           
            rs=st.executeQuery("select fees from sai where Subject='Physics'");
            while(rs.next())
            {
               lblphy.setText(rs.getString(1));
            
            }        
           } 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Select Subject");
        }
       }
       else{
           lblphy.setText("");
       }
    
               
    
    }//GEN-LAST:event_chbPhysicsActionPerformed

    private void chbPhysicsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chbPhysicsMousePressed
        // TODO add your handling code here:
            
    }//GEN-LAST:event_chbPhysicsMousePressed

    private void chbPhysicsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chbPhysicsMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_chbPhysicsMouseReleased

    private void chbChemistryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbChemistryActionPerformed
        // TODO add your handling code here:
       if(chbChemistry.isSelected()) { 
       
        Connection con;
        Statement st;
        ResultSet rs=null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
            st=con.createStatement();
            rs=st.executeQuery("select fees from sai where Subject='Chemistry'");
            while(rs.next())
            {
               lblchemi.setText(rs.getString(1));
              
            }        
           } 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Select Subject");
        }
    }
       else{
           lblchemi.setText("");
       }
    }//GEN-LAST:event_chbChemistryActionPerformed

    private void chbBiologyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbBiologyActionPerformed
        // TODO add your handling code here:
        if(chbBiology.isSelected()){ 
       
        Connection con;
        Statement st;
        ResultSet rs=null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
            st=con.createStatement();          
            rs=st.executeQuery("select fees from sai where Subject='Biology'");
            while(rs.next())
            {
               lblbio.setText(rs.getString(1));
               
            }        
           } 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Select Subject");
        }
    }
        else
        {
            lblbio.setText("");
        }
    }//GEN-LAST:event_chbBiologyActionPerformed

    private void chbMathsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbMathsActionPerformed
        // TODO add your handling code here:
        if(chbMaths.isSelected()){ 
        Connection con;
        Statement st;
        ResultSet rs=null;        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
            st=con.createStatement();
            rs=st.executeQuery("select fees from sai where Subject='Maths'");
            while(rs.next())
            {
               lblmaths.setText(rs.getString(1));
               
            }        
           } 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Select Subject");
        }
    }
        else{
            lblmaths.setText("");
        }
    }//GEN-LAST:event_chbMathsActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusGained
        //int n=0;
        txtTotal.setText("");
        getTotal();
        txtTotal.setText(String.valueOf(n));
        
        

        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalFocusGained

    private void txtStdContact1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStdContact1KeyPressed
        // TODO add your handling code here:
        checkSContact();
         String number=txtStdContact1.getText();
        int length=number.length();
       char c=evt.getKeyChar();
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
        {
            if(length<10)
            {
                txtStdContact1.setEditable(true);
            }
            else
            {
                txtStdContact1.setEditable(false);
            }
        }else{
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txtStdContact1.setEditable(true);
            }
            else
            {
                txtStdContact1.setEditable(false);
            }
        }
       
    }//GEN-LAST:event_txtStdContact1KeyPressed

    private void txtPaidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPaidFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaidFocusGained

    private void txtPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaidActionPerformed

    private void txtPaidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyPressed
        // TODO add your handling code here:
        String number=txtPaid.getText();
        int length=number.length();
        char c=evt.getKeyChar();
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
        {
            if(length<10)
            {
                txtPaid.setEditable(true);
            }
            else
            {
                txtPaid.setEditable(false);
            }
        }else{
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txtPaid.setEditable(true);
            }
            else
            {
                txtPaid.setEditable(false);
            }
        }

    }//GEN-LAST:event_txtPaidKeyPressed

    private void txtRemainingFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRemainingFocusGained
        // TODO add your handling code here:
        if(txtRemaining.equals(""))
       {
           JOptionPane.showMessageDialog(this,"Please Enter paid fees to Get Remaining Fees");
       }
        else{
            GetReaming();
        }
       
    }//GEN-LAST:event_txtRemainingFocusGained

    private void txtRemainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRemainingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemainingActionPerformed

    private void txtRemainingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRemainingKeyPressed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtRemainingKeyPressed

    private void txtPaidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPaidFocusLost
       // TODO add your handling code here:
       if(txtRemaining.equals(""))
       {
           JOptionPane.showMessageDialog(this,"Please Enter paid fees to Get Remaining Fees");
       }
       else{
            GetReaming();
        }
    }//GEN-LAST:event_txtPaidFocusLost

    private void txtStdContact1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStdContact1KeyReleased
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtStdContact1KeyReleased

    private void txtParentContact1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParentContact1KeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtParentContact1KeyReleased

    private void txtStdContact1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStdContact1FocusLost
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtStdContact1FocusLost

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        // TODO add your handling code here:
        Color clr=new Color(178,8,58);
        b.setBackground(clr);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        // TODO add your handling code here:
        Color clr=new Color(6,48,49);
        b.setBackground(clr);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // TODO add your handling code here:
        Color clr=new Color(178,8,58);
        c.setBackground(clr);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        // TODO add your handling code here:
        Color clr=new Color(6,48,49);
        c.setBackground(clr);
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        Color clr=new Color(178,8,58);
        d.setBackground(clr);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:\
        Color clr=new Color(6,48,49);
        d.setBackground(clr);

    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        // TODO add your handling code here:
        Color clr=new Color(178,8,58);
        e.setBackground(clr);
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        // TODO add your handling code here:
        Color clr=new Color(6,48,49);
        e.setBackground(clr);
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        // TODO add your handling code here:
        Color clr=new Color(178,8,58);
        f.setBackground(clr);
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        // TODO add your handling code here:
        Color clr=new Color(6,48,49);
        f.setBackground(clr);
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
        Color clr=new Color(178,8,58);
        g.setBackground(clr);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here:
        Color clr=new Color(6,48,49);
        g.setBackground(clr);
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        Color clr=new Color(178,8,58);
        a.setBackground(clr);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        Color clr=new Color(6,48,49);
        a.setBackground(clr);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        Home1 hm=new Home1();
        hm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        UpdateStdRec up=new UpdateStdRec();
        up.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        NewJFrame nf=new NewJFrame();
        nf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        EditPrintReciept er=new EditPrintReciept();
        er.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        ViewRecord1 vr=new ViewRecord1();
        vr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        ViewReport vrp=new ViewReport();
        vrp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void txtRemainingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRemainingFocusLost
        // TODO add your handling code here:
        if(txtRemaining.equals(""))
       {
           JOptionPane.showMessageDialog(this,"Please Enter paid fees to Get Remaining Fees");
       }
        else{
            GetReaming();
        }
    }//GEN-LAST:event_txtRemainingFocusLost

    private void txtDiscKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscKeyPressed
        // TODO add your handling code here:
        String number=txtDisc.getText();
        int length=number.length();
        char c=evt.getKeyChar();
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
        {
            if(length<10)
            {
                txtDisc.setEditable(true);
            }
            else
            {
                txtDisc.setEditable(false);
            }
        }else{
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txtDisc.setEditable(true);
            }
            else
            {
                txtDisc.setEditable(false);
            }
        }
    }//GEN-LAST:event_txtDiscKeyPressed

    private void txtFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFinalFocusGained
        // TODO add your handling code here:
        GetDiscount();
    }//GEN-LAST:event_txtFinalFocusGained

    private void txtFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFinalActionPerformed

    private void txtFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFinalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFinalKeyPressed

    private void txtDiscFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiscFocusLost
        // TODO add your handling code here:
        GetDiscount();
    }//GEN-LAST:event_txtDiscFocusLost

    private void btnSubmitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(106,205,252);
        btnSubmit.setBackground(clr);
    }//GEN-LAST:event_btnSubmitMouseEntered

    private void btnSubmitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseExited
        // TODO add your handling code here:
        Color clr=new Color(240,240,240);
        btnSubmit.setBackground(clr);
    }//GEN-LAST:event_btnSubmitMouseExited

    private void RehershMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RehershMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(106,205,252);
        Rehersh.setBackground(clr);
    }//GEN-LAST:event_RehershMouseEntered

    private void RehershMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RehershMouseExited
        // TODO add your handling code here:
        Color clr=new Color(240,240,240);
        Rehersh.setBackground(clr);
    }//GEN-LAST:event_RehershMouseExited

    private void RehershActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RehershActionPerformed
        // TODO add your handling code here:
        clear();
        getCourseid();
    }//GEN-LAST:event_RehershActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        Login1 lg=new Login1();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void txtStdNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStdNameKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c)||(c==KeyEvent.VK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_PERIOD)))
        {
          JOptionPane.showMessageDialog(this,"Number not allow");
          getToolkit().beep();
        
        evt.consume();
        }
    }//GEN-LAST:event_txtStdNameKeyTyped

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
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser AdmDate;
    private javax.swing.JButton Rehersh;
    private javax.swing.JTextArea TxtAddress;
    private javax.swing.JPanel a;
    private javax.swing.JPanel b;
    private javax.swing.JButton btnSubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel c;
    private javax.swing.JCheckBox chbBiology;
    private javax.swing.JCheckBox chbChemistry;
    private javax.swing.JCheckBox chbMaths;
    private javax.swing.JCheckBox chbPhysics;
    private javax.swing.JComboBox<String> cmbClass;
    private javax.swing.JPanel d;
    private javax.swing.JPanel e;
    private javax.swing.JPanel f;
    private javax.swing.JPanel g;
    private javax.swing.JLabel gender;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lblbio;
    public javax.swing.JLabel lblchemi;
    public javax.swing.JLabel lblmaths;
    private javax.swing.JLabel lblpcontact;
    public javax.swing.JLabel lblphy;
    private javax.swing.JLabel lblscontact;
    private javax.swing.JRadioButton rbtnFemale;
    private javax.swing.JRadioButton rbtnMale;
    private javax.swing.JLabel stdId1;
    private javax.swing.JLabel stdId11;
    private javax.swing.JLabel stdId12;
    private javax.swing.JLabel stdId13;
    private javax.swing.JLabel stdId14;
    private javax.swing.JLabel stdId15;
    private javax.swing.JLabel stdId16;
    private javax.swing.JLabel stdId17;
    private javax.swing.JLabel stdId18;
    private javax.swing.JLabel stdId2;
    private javax.swing.JLabel stdId3;
    private javax.swing.JLabel stdId4;
    private javax.swing.JLabel stdId5;
    private javax.swing.JLabel stdId6;
    private javax.swing.JLabel stdId8;
    private javax.swing.JLabel stdId9;
    public javax.swing.JTextField txtDisc;
    public javax.swing.JTextField txtFinal;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtParentContact1;
    private javax.swing.JTextField txtRemaining;
    private javax.swing.JTextArea txtRemark;
    private javax.swing.JTextField txtStdContact1;
    private javax.swing.JTextField txtStdName;
    public javax.swing.JTextField txtTotal;
    private com.toedter.calendar.JDateChooser txtdob;
    // End of variables declaration//GEN-END:variables
}
