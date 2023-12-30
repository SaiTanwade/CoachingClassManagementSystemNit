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
public class PrintReceipt extends javax.swing.JFrame {

    /**
     * Creates new form PrintReceipt
     */int Total=0;
     int Id,paid,remain;
    int n=0;
    //home23=0,update22=0,course22=0,reciept22=0;
    
    int ttl=0;
    public PrintReceipt() {
        initComponents();
        GetRecord();
        Editable();
//        txtPhy.setText("0");
//        txtChemi.setText("0");
//        txtBio.setText("0");
//        txtMaths.setText("0");
       

        
        //getFees();
        //txtPhy.setText(n1)
    }
    
    void Editable()
    {
        txtTotal1.setEditable(false);
        txtRemaining.setEditable(false);
       // txtRemaining.setEditable(false);
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
            txtTotal1.setText(Integer.toString(ttl));
          }
          catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null,e);
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
        Total1=Integer.parseInt(txtTotal1.getText());
        Discount=Integer.parseInt(txtDisc1.getText());
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");
        Final=(Total1*Discount)/100; 
         DiscountFee=Total1-Final;
        txtFinal1.setText(Integer.toString(DiscountFee));
        
        }
        catch(Exception e)
        {
            
        }
        
    }
    void GetReaming()
      {
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
//            st=con.createStatement();
            Total=Integer.parseInt(txtTotal1.getText());
            paid=Integer.parseInt(txtPaid.getText());
            int ttl=Total-paid;
            txtRemaining.setText(Integer.toString(ttl));
          }
          catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null,e);
        }
      
      }
   
   
    public void GetRecord()
    {
       try
                {
                    
                    
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");
                   
                   String sql=("select * from addstudent order by id desc limit 1"); 
                   PreparedStatement smt=con.prepareStatement(sql);
                   ResultSet rs=smt.executeQuery();
                   rs.next();                   
                   TxtId.setText(rs.getString(1));
                   txtStdName1.setText(rs.getString(2));
                   adm.setText(rs.getString(7));
                   txtClass.setText(rs.getString(8));                   
                   txtRemark.setText(rs.getString(11));
                   
                   //txtTotal.setText(rs.getString(12));
                   txtPaid.setText(rs.getString(13));                   
                   txtRemaining.setText(rs.getString(14));
                   
                }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void autoCustname(){
       
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");
            String a= (String)TxtId.getText();
                

           
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
                txtTotal1.setText(rs.getString(12));
                txtPaid.setText(rs.getString(13));
                txtRemaining.setText(rs.getString(14));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }   
    }
      
    public boolean validation()
    {
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
        
        if(txtTotal1.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Total Fees");
              return false;
              
          
        }
        if(txtDisc1.getText().isEmpty())
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
        
        
       
    
    
    void getprint()
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
                jPanel13.print(g2);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        heading3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        stdId1 = new javax.swing.JLabel();
        adm = new javax.swing.JLabel();
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
        TxtId = new javax.swing.JLabel();
        txtStdName1 = new javax.swing.JLabel();
        txtClass = new javax.swing.JLabel();
        stdId5 = new javax.swing.JLabel();
        stdId18 = new javax.swing.JLabel();
        txtRemaining = new javax.swing.JTextField();
        txtPhy = new javax.swing.JTextField();
        txtChemi = new javax.swing.JTextField();
        txtBio = new javax.swing.JTextField();
        txtMaths = new javax.swing.JTextField();
        txtTotal1 = new javax.swing.JTextField();
        txtPaid = new javax.swing.JTextField();
        stdId19 = new javax.swing.JLabel();
        stdId21 = new javax.swing.JLabel();
        txtDisc1 = new javax.swing.JTextField();
        txtFinal1 = new javax.swing.JTextField();
        stdId20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        Home = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        heading3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        heading3.setText("Welcome To Dnyansadhana...");
        jPanel12.add(heading3, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 279, -1, -1));

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 40)); // NOI18N
        jLabel5.setText("  Dnyansadhana Coaching Classes ");
        jPanel12.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 650, 60));

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1220, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1220, 3));

        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 30)); // NOI18N
        jLabel6.setText("Akshya Nagar 1st Block 1st Cross, ");
        jPanel12.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 480, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 25)); // NOI18N
        jLabel2.setText("Rammurthy nagar, Tuljapur-413624");
        jPanel12.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 410, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/Imgs/dnyan.png"))); // NOI18N
        jPanel12.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 170, 160));

        jPanel13.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 190));

        stdId1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId1.setForeground(new java.awt.Color(51, 51, 51));
        stdId1.setText("Signature/Stamp");
        jPanel13.add(stdId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 800, 170, 30));

        adm.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        adm.setForeground(new java.awt.Color(51, 51, 51));
        jPanel13.add(adm, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, 160, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 780, 260, 20));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 1140, 10));

        stdId2.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId2.setForeground(new java.awt.Color(51, 51, 51));
        stdId2.setText("Student Name:");
        jPanel13.add(stdId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 150, 30));

        stdId3.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId3.setForeground(new java.awt.Color(51, 51, 51));
        stdId3.setText("Sr No.");
        jPanel13.add(stdId3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 80, 30));

        stdId4.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId4.setForeground(new java.awt.Color(51, 51, 51));
        stdId4.setText("Subjects");
        jPanel13.add(stdId4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 90, 30));

        stdId6.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId6.setForeground(new java.awt.Color(51, 51, 51));
        stdId6.setText("Fees");
        jPanel13.add(stdId6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, 80, 30));

        stdId7.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId7.setForeground(new java.awt.Color(51, 51, 51));
        stdId7.setText("1.");
        jPanel13.add(stdId7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 50, 30));

        stdId8.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId8.setForeground(new java.awt.Color(51, 51, 51));
        stdId8.setText("Chemistry");
        jPanel13.add(stdId8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 90, 30));

        stdId9.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId9.setForeground(new java.awt.Color(51, 51, 51));
        stdId9.setText("Biology");
        jPanel13.add(stdId9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, 80, 30));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 1140, 20));

        stdId11.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId11.setForeground(new java.awt.Color(51, 51, 51));
        stdId11.setText("Total Fees ");
        jPanel13.add(stdId11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 560, 130, 30));

        stdId12.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId12.setForeground(new java.awt.Color(51, 51, 51));
        stdId12.setText("Maths");
        jPanel13.add(stdId12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 520, 80, 30));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 720, 730, 10));

        stdId13.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId13.setForeground(new java.awt.Color(51, 51, 51));
        stdId13.setText("Remaining Fees");
        jPanel13.add(stdId13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 740, 150, 30));

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
        jPanel13.add(txtRemark, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 790, 310, 60));

        stdId14.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId14.setForeground(new java.awt.Color(51, 51, 51));
        stdId14.setText("Remark:");
        jPanel13.add(stdId14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 790, 110, 30));

        stdId15.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId15.setForeground(new java.awt.Color(51, 51, 51));
        stdId15.setText("student Class:");
        jPanel13.add(stdId15, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 140, 30));

        stdId16.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId16.setForeground(new java.awt.Color(51, 51, 51));
        stdId16.setText("Adamission Date");
        jPanel13.add(stdId16, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, 160, 30));

        stdId17.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId17.setForeground(new java.awt.Color(51, 51, 51));
        stdId17.setText("Paid Fees");
        jPanel13.add(stdId17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 680, 130, 30));

        TxtId.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        TxtId.setForeground(new java.awt.Color(51, 51, 51));
        jPanel13.add(TxtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 180, 40));

        txtStdName1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        txtStdName1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel13.add(txtStdName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 370, 30));

        txtClass.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        txtClass.setForeground(new java.awt.Color(51, 51, 51));
        jPanel13.add(txtClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, 160, 30));

        stdId5.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId5.setForeground(new java.awt.Color(51, 51, 51));
        stdId5.setText("std Id:");
        jPanel13.add(stdId5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 80, 30));

        stdId18.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId18.setForeground(new java.awt.Color(51, 51, 51));
        stdId18.setText("Physics");
        jPanel13.add(stdId18, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 80, 30));

        txtRemaining.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRemainingKeyReleased(evt);
            }
        });
        jPanel13.add(txtRemaining, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 740, 210, -1));

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
        jPanel13.add(txtPhy, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 210, -1));

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
        jPanel13.add(txtChemi, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 210, -1));

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
        jPanel13.add(txtBio, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, 210, -1));

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
        jPanel13.add(txtMaths, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, 210, -1));

        txtTotal1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtTotal1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTotal1FocusGained(evt);
            }
        });
        txtTotal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotal1ActionPerformed(evt);
            }
        });
        txtTotal1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotal1KeyReleased(evt);
            }
        });
        jPanel13.add(txtTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 560, 210, -1));

        txtPaid.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaidActionPerformed(evt);
            }
        });
        txtPaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaidKeyReleased(evt);
            }
        });
        jPanel13.add(txtPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 680, 210, -1));

        stdId19.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId19.setForeground(new java.awt.Color(51, 51, 51));
        stdId19.setText("Discount:");
        jPanel13.add(stdId19, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 600, 100, 30));

        stdId21.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId21.setForeground(new java.awt.Color(51, 51, 51));
        stdId21.setText("Final Fees:");
        jPanel13.add(stdId21, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 640, 140, 30));

        txtDisc1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtDisc1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDisc1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDisc1FocusLost(evt);
            }
        });
        txtDisc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDisc1KeyPressed(evt);
            }
        });
        jPanel13.add(txtDisc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 600, 210, 30));

        txtFinal1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtFinal1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFinal1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtFinal1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFinal1FocusGained(evt);
            }
        });
        txtFinal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFinal1ActionPerformed(evt);
            }
        });
        txtFinal1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFinal1KeyPressed(evt);
            }
        });
        jPanel13.add(txtFinal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 640, 210, 30));

        stdId20.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        stdId20.setForeground(new java.awt.Color(51, 51, 51));
        stdId20.setText("%");
        jPanel13.add(stdId20, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 600, 40, 20));

        jPanel14.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, 860));

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 48)); // NOI18N
        jLabel9.setText(" Print Receipt");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 51), new java.awt.Color(51, 255, 51), new java.awt.Color(255, 0, 255), java.awt.Color.black));
        jPanel14.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 310, -1));

        print.setBackground(new java.awt.Color(151, 236, 245));
        print.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel14.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 890, 110, 60));

        Home.setBackground(new java.awt.Color(151, 236, 245));
        Home.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });
        jPanel14.add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(1760, 890, 110, 60));

        getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1900, 995));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        
        if(validation())
        {
            getprint();
        }
    }//GEN-LAST:event_printActionPerformed

    private void txtPaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaidKeyReleased

    private void txtPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaidActionPerformed

    private void txtTotal1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotal1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotal1KeyReleased

    private void txtTotal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotal1ActionPerformed

    private void txtTotal1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotal1FocusGained
        // TODO add your handling code here:
        GetTotal();
    }//GEN-LAST:event_txtTotal1FocusGained

    private void txtMathsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMathsKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMathsKeyReleased

    private void txtMathsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMathsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMathsActionPerformed

    private void txtBioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBioKeyReleased

    private void txtBioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBioActionPerformed

    private void txtChemiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChemiKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChemiKeyReleased

    private void txtChemiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChemiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChemiActionPerformed

    private void txtPhyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhyKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhyKeyReleased

    private void txtPhyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhyActionPerformed

    private void txtRemainingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRemainingKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemainingKeyReleased

    private void txtRemainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRemainingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemainingActionPerformed

    private void txtRemainingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRemainingFocusLost
        // TODO add your handling code here:
        GetReaming();
    }//GEN-LAST:event_txtRemainingFocusLost

    private void txtRemainingFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRemainingFocusGained
        // TODO add your handling code here:
        GetReaming();
    }//GEN-LAST:event_txtRemainingFocusGained

    private void txtRemarkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRemarkKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemarkKeyReleased

    private void txtRemarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRemarkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemarkActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
        AddStudent as=new AddStudent();
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeActionPerformed

    private void txtDisc1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDisc1FocusLost
        // TODO add your handling code here:
        GetDiscount();
    }//GEN-LAST:event_txtDisc1FocusLost

    private void txtDisc1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDisc1KeyPressed
        // TODO add your handling code here:
        String number=txtTotal1.getText();
        int length=number.length();
        char c=evt.getKeyChar();
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
        {
            if(length<10)
            {
                txtTotal1.setEditable(true);
            }
            else
            {
                txtTotal1.setEditable(false);
            }
        }else{
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txtTotal1.setEditable(true);
            }
            else
            {
                txtTotal1.setEditable(false);
            }
        }
    }//GEN-LAST:event_txtDisc1KeyPressed

    private void txtFinal1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFinal1FocusGained
        // TODO add your handling code here:
        GetDiscount();
    }//GEN-LAST:event_txtFinal1FocusGained

    private void txtFinal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFinal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFinal1ActionPerformed

    private void txtFinal1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFinal1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFinal1KeyPressed

    private void txtMathsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMathsFocusLost
        // TODO add your handling code here:
        GetTotal();
    }//GEN-LAST:event_txtMathsFocusLost

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
            java.util.logging.Logger.getLogger(PrintReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintReceipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Home;
    private javax.swing.JLabel TxtId;
    private javax.swing.JLabel adm;
    private javax.swing.JLabel heading3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
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
    private javax.swing.JLabel txtClass;
    public javax.swing.JTextField txtDisc1;
    public javax.swing.JTextField txtFinal1;
    public javax.swing.JTextField txtMaths;
    public javax.swing.JTextField txtPaid;
    public javax.swing.JTextField txtPhy;
    public javax.swing.JTextField txtRemaining;
    private javax.swing.JTextField txtRemark;
    private javax.swing.JLabel txtStdName1;
    public javax.swing.JTextField txtTotal1;
    // End of variables declaration//GEN-END:variables
}
