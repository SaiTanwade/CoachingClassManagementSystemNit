/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coachingclassmanagementsystem;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author saita
 */
public class EditPrintReciept extends javax.swing.JFrame {

    /**
     * Creates new form EditPrintReciept
     */
    
    int Id,paid,remain;
    int n=0,a=0,b=0,c=0,d=0;
    int Total=0;
    int ttl=0;
    public EditPrintReciept() {
        initComponents();
         FeesPhy();
        FeesChemi();
        FeesBio();
        FeesMaths();
        Unuditable();
    }
    public void Unuditable()
    {
        txtTotal.setEditable(false);
        txtRemaining.setEditable(false);
        txtFinal.setEditable(false);
    }
    
    public boolean validation()
    {
        if(txtId.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Student Id To Get Record");
              return false;
              
          
        }
        if(txtStdName1.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Student Name");
              return false;
              
          
        }
        if(txtClass.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Student class");
              return false;
              
          
        }
        if(adm.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Admition Date");
              return false;
              
          
        }
        if(txtPhy.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Physics Fees");
              return false;
              
          
        }
        if(txtChemi.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Chemistry Fees");
              return false;
              
          
        }
        if(txtBio.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Biology Fees");
              return false;
              
          
        }
        if(txtMaths.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Maths Fees");
              return false;
              
          
        }
        
        if(txtTotal.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Total Fees");
              return false;
              
          
        }
        if(txtDisc.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Discount if you want else enter 0 ");
              return false;
              
          
        }
        if(txtPaid.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter paid Fees");
              return false;
              
          
        }
        if(txtRemaining.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Reamining Fees");
              return false;
              
          
        }
        
        return true;
    }

    public void FeesPhy()
   {
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
               txtPhy.setText(rs.getString(1));
            
            }        
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Select Subject");
        }
       
   }
   public void FeesChemi()
   {
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
               txtChemi.setText(rs.getString(1));
            
            }        
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Select Subject");
        }
       
   }
   public void FeesBio()
   {
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
               txtBio.setText(rs.getString(1));
            
            }        
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Select Subject");
        }
       
   }
   public void FeesMaths()
   {
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
               txtMaths.setText(rs.getString(1));
            
            }        
           }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Select Subject");
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
   
    public void autoCustname(){
       
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");
            String a= (String)txtId.getText();
            PreparedStatement pst=con.prepareStatement("select * from addstudent where id ='"+a+"' ");
          
            ResultSet rs= pst.executeQuery();

            if(rs.next())
            {
                txtStdName1.setText(rs.getString(2));
                txtClass.setText(rs.getString(8));
                adm.setText(rs.getString(7));
                
//                txtPhy.setText(rs.getString(1));
//                txtChemi.setText(rs.getString(2));
//                txtBio.setText(rs.getString(1));
//                txtMaths.setText(rs.getString(2));
                txtRemark.setText(rs.getString(11));    
//                txtTotal.setText(rs.getString(12));
//                txtPaid.setText(rs.getString(13));
//                txtRemaining.setText(rs.getString(14));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    void GetTotal()
      {
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
//            st=con.createStatement();
           int a=Integer.parseInt(txtPhy.getText());
           int b=Integer.parseInt(txtChemi.getText());
            int c=Integer.parseInt(txtBio.getText());
             int d=Integer.parseInt(txtMaths.getText());
//            paid=Integer.parseInt(txtPaid.getText());
            int ttl=a+b+c+d;
            txtTotal.setText(Integer.toString(ttl));
          }
          catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
      
      }
    void GetReaming()
      {
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
//            st=con.createStatement();
            Total=Integer.parseInt(txtTotal.getText());
            paid=Integer.parseInt(txtPaid.getText());
            int ttl=Total-paid;
                    txtRemaining.setText(Integer.toString(ttl));
          }
          catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null,e);
        }
      
      }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        heading = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        stdId1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        stdId2 = new javax.swing.JLabel();
        stdId3 = new javax.swing.JLabel();
        stdId4 = new javax.swing.JLabel();
        stdId6 = new javax.swing.JLabel();
        stdId7 = new javax.swing.JLabel();
        stdId8 = new javax.swing.JLabel();
        stdId9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        stdId11 = new javax.swing.JLabel();
        stdId12 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        stdId13 = new javax.swing.JLabel();
        txtRemark = new javax.swing.JTextField();
        stdId14 = new javax.swing.JLabel();
        stdId15 = new javax.swing.JLabel();
        stdId16 = new javax.swing.JLabel();
        stdId17 = new javax.swing.JLabel();
        stdId5 = new javax.swing.JLabel();
        stdId18 = new javax.swing.JLabel();
        txtRemaining = new javax.swing.JTextField();
        txtPhy = new javax.swing.JTextField();
        txtChemi = new javax.swing.JTextField();
        txtBio = new javax.swing.JTextField();
        txtMaths = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtPaid = new javax.swing.JTextField();
        txtStdName1 = new javax.swing.JTextField();
        adm = new javax.swing.JTextField();
        txtClass = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        stdId19 = new javax.swing.JLabel();
        txtDisc = new javax.swing.JTextField();
        stdId20 = new javax.swing.JLabel();
        stdId21 = new javax.swing.JLabel();
        txtFinal = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        Home = new javax.swing.JButton();
        print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        heading.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        heading.setText("Welcome To Dnyansadhana...");
        jPanel3.add(heading, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 279, -1, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 40)); // NOI18N
        jLabel2.setText("  Dnyansadhana Coaching Classes ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 650, 60));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1220, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1220, 3));

        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 30)); // NOI18N
        jLabel6.setText("Akshya Nagar 1st Block 1st Cross, ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 480, 40));

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 25)); // NOI18N
        jLabel3.setText("Rammurthy nagar, Tuljapur-413624");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 410, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 190));

        stdId1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId1.setForeground(new java.awt.Color(51, 51, 51));
        stdId1.setText("Signature/Stamp");
        jPanel2.add(stdId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 800, 170, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 780, 210, 20));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 1140, 10));

        stdId2.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId2.setForeground(new java.awt.Color(51, 51, 51));
        stdId2.setText("Student Name:");
        jPanel2.add(stdId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 160, 30));

        stdId3.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId3.setForeground(new java.awt.Color(51, 51, 51));
        stdId3.setText("Sr No.");
        jPanel2.add(stdId3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 80, 30));

        stdId4.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId4.setForeground(new java.awt.Color(51, 51, 51));
        stdId4.setText("Subjects");
        jPanel2.add(stdId4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 90, 30));

        stdId6.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId6.setForeground(new java.awt.Color(51, 51, 51));
        stdId6.setText("Fees");
        jPanel2.add(stdId6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, 80, 30));

        stdId7.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId7.setForeground(new java.awt.Color(51, 51, 51));
        stdId7.setText("1.");
        jPanel2.add(stdId7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 50, 30));

        stdId8.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId8.setForeground(new java.awt.Color(51, 51, 51));
        stdId8.setText("Chemistry");
        jPanel2.add(stdId8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 90, 30));

        stdId9.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId9.setForeground(new java.awt.Color(51, 51, 51));
        stdId9.setText("Biology");
        jPanel2.add(stdId9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, 80, 30));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 1140, 20));

        stdId11.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId11.setForeground(new java.awt.Color(51, 51, 51));
        stdId11.setText("Total Fees  ");
        jPanel2.add(stdId11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 560, 230, 30));

        stdId12.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId12.setForeground(new java.awt.Color(51, 51, 51));
        stdId12.setText("Maths");
        jPanel2.add(stdId12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 520, 80, 30));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 720, 730, 10));

        stdId13.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId13.setForeground(new java.awt.Color(51, 51, 51));
        stdId13.setText("Remaining Fees");
        jPanel2.add(stdId13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 740, 150, 30));

        txtRemark.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtRemark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRemarkActionPerformed(evt);
            }
        });
        txtRemark.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRemarkKeyReleased(evt);
            }
        });
        jPanel2.add(txtRemark, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 780, 310, 60));

        stdId14.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId14.setForeground(new java.awt.Color(51, 51, 51));
        stdId14.setText("Remark:");
        jPanel2.add(stdId14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 780, 110, 30));

        stdId15.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId15.setForeground(new java.awt.Color(51, 51, 51));
        stdId15.setText("student Class:");
        jPanel2.add(stdId15, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 140, 30));

        stdId16.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId16.setForeground(new java.awt.Color(51, 51, 51));
        stdId16.setText("Adamission Date");
        jPanel2.add(stdId16, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, 160, 30));

        stdId17.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId17.setForeground(new java.awt.Color(51, 51, 51));
        stdId17.setText("Paid Fees");
        jPanel2.add(stdId17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 680, 130, 30));

        stdId5.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId5.setForeground(new java.awt.Color(51, 51, 51));
        stdId5.setText("std Id:");
        jPanel2.add(stdId5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 80, 30));

        stdId18.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId18.setForeground(new java.awt.Color(51, 51, 51));
        stdId18.setText("Physics");
        jPanel2.add(stdId18, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 80, 30));

        txtRemaining.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtRemaining.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRemainingFocusGained(evt);
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRemainingKeyReleased(evt);
            }
        });
        jPanel2.add(txtRemaining, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 740, 210, -1));

        txtPhy.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtPhy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhyActionPerformed(evt);
            }
        });
        txtPhy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhyKeyReleased(evt);
            }
        });
        jPanel2.add(txtPhy, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 400, 210, -1));

        txtChemi.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtChemi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChemiActionPerformed(evt);
            }
        });
        txtChemi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtChemiKeyReleased(evt);
            }
        });
        jPanel2.add(txtChemi, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 210, -1));

        txtBio.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtBio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBioActionPerformed(evt);
            }
        });
        txtBio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBioKeyReleased(evt);
            }
        });
        jPanel2.add(txtBio, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, 210, -1));

        txtMaths.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtMaths.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMathsFocusLost(evt);
            }
        });
        txtMaths.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMathsActionPerformed(evt);
            }
        });
        txtMaths.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMathsKeyReleased(evt);
            }
        });
        jPanel2.add(txtMaths, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, 210, -1));

        txtTotal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTotalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTotalFocusLost(evt);
            }
        });
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotalKeyReleased(evt);
            }
        });
        jPanel2.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 560, 210, -1));

        txtPaid.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtPaid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPaidFocusGained(evt);
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaidKeyReleased(evt);
            }
        });
        jPanel2.add(txtPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 680, 210, -1));

        txtStdName1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtStdName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStdName1ActionPerformed(evt);
            }
        });
        txtStdName1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStdName1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStdName1KeyTyped(evt);
            }
        });
        jPanel2.add(txtStdName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 400, 40));

        adm.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admActionPerformed(evt);
            }
        });
        adm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                admKeyReleased(evt);
            }
        });
        jPanel2.add(adm, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 280, 210, 40));

        txtClass.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClassActionPerformed(evt);
            }
        });
        txtClass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClassKeyReleased(evt);
            }
        });
        jPanel2.add(txtClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 200, 210, 40));

        txtId.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 400, 40));

        stdId19.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId19.setForeground(new java.awt.Color(51, 51, 51));
        stdId19.setText("Discount:");
        jPanel2.add(stdId19, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 600, 100, 30));

        txtDisc.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtDisc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
        jPanel2.add(txtDisc, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 600, 210, 30));

        stdId20.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId20.setForeground(new java.awt.Color(51, 51, 51));
        stdId20.setText("%");
        jPanel2.add(stdId20, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 600, 40, 20));

        stdId21.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId21.setForeground(new java.awt.Color(51, 51, 51));
        stdId21.setText("Final Fees:");
        jPanel2.add(stdId21, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 640, 140, 30));

        txtFinal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtFinal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFinal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
        jPanel2.add(txtFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 640, 210, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 1220, 860));

        Home.setBackground(new java.awt.Color(151, 236, 245));
        Home.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        print.setBackground(new java.awt.Color(151, 236, 245));
        print.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1392, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(884, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1949, 1062));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtRemarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRemarkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemarkActionPerformed

    private void txtRemarkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRemarkKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemarkKeyReleased

    private void txtRemainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRemainingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemainingActionPerformed

    private void txtRemainingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRemainingKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemainingKeyReleased

    private void txtPhyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhyActionPerformed

    private void txtPhyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhyKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhyKeyReleased

    private void txtChemiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChemiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChemiActionPerformed

    private void txtChemiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChemiKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChemiKeyReleased

    private void txtBioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBioActionPerformed

    private void txtBioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBioKeyReleased

    private void txtMathsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMathsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMathsActionPerformed

    private void txtMathsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMathsKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMathsKeyReleased

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
        GetTotal();
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtTotalKeyReleased

    private void txtPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaidActionPerformed

    private void txtPaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaidKeyReleased

    private void txtStdName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStdName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStdName1ActionPerformed

    private void txtStdName1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStdName1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStdName1KeyReleased

    private void admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_admActionPerformed

    private void admKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_admKeyReleased

    private void txtClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClassActionPerformed

    private void txtClassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClassKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClassKeyReleased

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
        autoCustname();
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdKeyReleased

    private void txtRemainingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRemainingKeyPressed
        // TODO add your handling code here:
        GetReaming();
    }//GEN-LAST:event_txtRemainingKeyPressed

    private void txtTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusGained
        // TODO add your handling code here:
        GetTotal();
    }//GEN-LAST:event_txtTotalFocusGained

    private void txtMathsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMathsFocusLost
        // TODO add your handling code here:
        GetTotal();
    }//GEN-LAST:event_txtMathsFocusLost

    private void txtPaidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPaidFocusGained
        // TODO add your handling code here:
//        GetReaming();
    }//GEN-LAST:event_txtPaidFocusGained

    private void txtTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusLost
        // TODO add your handling code here:
//        GetReaming();
    }//GEN-LAST:event_txtTotalFocusLost

    private void txtRemainingFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRemainingFocusGained
        // TODO add your handling code here:
        GetReaming();
    }//GEN-LAST:event_txtRemainingFocusGained

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        if(validation())
        {
        PrinterJob job=PrinterJob.getPrinterJob();
        job.setJobName("Print Data");
        job.setPrintable(new Printable()
        {
            public int print(Graphics pg,PageFormat pf,int PageNum){
                pf.setOrientation(PageFormat.LANDSCAPE);
                if(PageNum>0){
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2=(Graphics2D)pg;
                g2.translate(pf.getImageableX(),pf.getImageableY());
                g2.scale(0.47,0.47);
                jPanel2.print(g2);
                return Printable.PAGE_EXISTS; 
            }
        });
        boolean ok=job.printDialog();
        if(ok){
            try {
                job.print();
            } catch (PrinterException ex) {
                Logger.getLogger(PrintReceipt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }//GEN-LAST:event_printActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
        AddStudent as=new AddStudent();
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeActionPerformed

    private void txtDiscFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiscFocusLost
        // TODO add your handling code here:
        GetDiscount();
    }//GEN-LAST:event_txtDiscFocusLost

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

    private void txtStdName1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStdName1KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c)||(c==KeyEvent.VK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_PERIOD)))
        {
          JOptionPane.showMessageDialog(this,"Number not allow");
          getToolkit().beep();
        
        evt.consume();
        }
    }//GEN-LAST:event_txtStdName1KeyTyped

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
            java.util.logging.Logger.getLogger(EditPrintReciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditPrintReciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditPrintReciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditPrintReciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditPrintReciept().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Home;
    public javax.swing.JTextField adm;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton print;
    private javax.swing.JLabel stdId1;
    private javax.swing.JLabel stdId11;
    private javax.swing.JLabel stdId12;
    private javax.swing.JLabel stdId13;
    private javax.swing.JLabel stdId14;
    private javax.swing.JLabel stdId15;
    private javax.swing.JLabel stdId16;
    private javax.swing.JLabel stdId17;
    private javax.swing.JLabel stdId18;
    private javax.swing.JLabel stdId19;
    private javax.swing.JLabel stdId2;
    private javax.swing.JLabel stdId20;
    private javax.swing.JLabel stdId21;
    private javax.swing.JLabel stdId3;
    private javax.swing.JLabel stdId4;
    private javax.swing.JLabel stdId5;
    private javax.swing.JLabel stdId6;
    private javax.swing.JLabel stdId7;
    private javax.swing.JLabel stdId8;
    private javax.swing.JLabel stdId9;
    public javax.swing.JTextField txtBio;
    public javax.swing.JTextField txtChemi;
    public javax.swing.JTextField txtClass;
    private javax.swing.JTextField txtDisc;
    private javax.swing.JTextField txtFinal;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtMaths;
    public javax.swing.JTextField txtPaid;
    public javax.swing.JTextField txtPhy;
    public javax.swing.JTextField txtRemaining;
    private javax.swing.JTextField txtRemark;
    public javax.swing.JTextField txtStdName1;
    public javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
