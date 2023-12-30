/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coachingclassmanagementsystem;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saita
 */
public class ViewReport extends javax.swing.JFrame {

    /**
     * Creates new form ViewReport
     */
     
    DefaultTableModel model;
    public ViewReport() {
        initComponents();
        GetClass();
        tableColumnsize();
    }
    
    void GetClass()
    {
        try 
        {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");
 
          PreparedStatement pst=con.prepareStatement("select distinct class from addstudent");
          ResultSet rs=pst.executeQuery();
          while(rs.next())
          {
              cmbClass.addItem(rs.getString("class"));
          }  
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
         
    }
    
    void settable()
    {
        String Selectclass=cmbClass.getSelectedItem().toString();
        SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy");
        String fromDate=dateformat.format(fromdate.getDate());
        String ToDate=dateformat.format(todate.getDate());
        int FeesAmount=0;
        int PaidAmount=0;
        int RemainAmount=0;
    
        try 
        {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root",""); 
          PreparedStatement pst=con.prepareStatement("select * from addstudent where admdate between ? and ? and class=?");
          pst.setString(1, fromDate);
          pst.setString(2, ToDate);
          pst.setString(3, Selectclass);
          ResultSet rs=pst.executeQuery();
          while(rs.next())
          {
              int Cid=rs.getInt(1);
              String sName=rs.getString(2);
              String admdt=rs.getString(7);              
              String sub=rs.getString(9);  
              int total=rs.getInt(12);
              int paid=rs.getInt(13);
              int remain=rs.getInt(14);
              String remark=rs.getString(11);              
              FeesAmount=FeesAmount+total;
              PaidAmount=PaidAmount+paid;
              RemainAmount=RemainAmount+remain;
              Object[] obj={Cid,sName,sub,admdt,total,paid,remain,remark};
              model=(DefaultTableModel)tbl.getModel();
              model.addRow(obj);
                            
              
          }  
          lblClass.setText(Selectclass);
          lblTotalAmount.setText(Integer.toString(FeesAmount));
          lblCollected.setText(Integer.toString(PaidAmount));
          lblRem.setText(Integer.toString(RemainAmount));
         
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
    }
    public void clear()
    {
          fromdate.setDate(null);          
          todate.setDate(null);
          cmbClass.setSelectedIndex(0);
          lblTotalAmount.setText("");
          lblCollected.setText("");
          lblRem.setText("");          
    }
    
    
    public void tableColumnsize()
    {
        tbl.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(280);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(280);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(50);
        tbl.getColumnModel().getColumn(5).setPreferredWidth(80);
        tbl.getColumnModel().getColumn(6).setPreferredWidth(80);
        tbl.getColumnModel().getColumn(7).setPreferredWidth(100);
        
        
        
    }
    
    public boolean validation()
    {
        if(fromdate.getDate()==null)
        {
          JOptionPane.showMessageDialog(this,"Please Select FromDates To Get Data");
          return false;

        }
        if(todate.getDate()==null)
        {
          JOptionPane.showMessageDialog(this,"Please Select toDates To Get Data");
          return false;

        }
        return true;
    }
    
    public void clearTable()
     {
         DefaultTableModel model=(DefaultTableModel)tbl.getModel();
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

        jPanel2 = new javax.swing.JPanel();
        stdId8 = new javax.swing.JLabel();
        cmbClass = new javax.swing.JComboBox<>();
        stdId9 = new javax.swing.JLabel();
        stdId10 = new javax.swing.JLabel();
        fromdate = new com.toedter.calendar.JDateChooser();
        stdId11 = new javax.swing.JLabel();
        todate = new com.toedter.calendar.JDateChooser();
        resetbtn = new javax.swing.JButton();
        submit6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        stdId12 = new javax.swing.JLabel();
        lblClass = new javax.swing.JLabel();
        lblTotalAmount = new javax.swing.JLabel();
        stdId16 = new javax.swing.JLabel();
        stdId17 = new javax.swing.JLabel();
        lblRem = new javax.swing.JLabel();
        stdId15 = new javax.swing.JLabel();
        lblCollected = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        submit5 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        b = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        c = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        d = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        e = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        g = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        a = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        add = new javax.swing.JPanel();
        q = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stdId8.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId8.setForeground(new java.awt.Color(51, 51, 51));
        stdId8.setText("Class:");
        jPanel2.add(stdId8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 140, 30));

        jPanel2.add(cmbClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 170, 50));

        stdId9.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId9.setForeground(new java.awt.Color(51, 51, 51));
        stdId9.setText("From Date:");
        jPanel2.add(stdId9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 110, 30));

        stdId10.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId10.setForeground(new java.awt.Color(51, 51, 51));
        stdId10.setText("Select Date: ");
        jPanel2.add(stdId10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 120, 30));
        jPanel2.add(fromdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 170, 40));

        stdId11.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId11.setForeground(new java.awt.Color(51, 51, 51));
        stdId11.setText("To Date:");
        jPanel2.add(stdId11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 110, 30));
        jPanel2.add(todate, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 170, 40));

        resetbtn.setBackground(new java.awt.Color(153, 204, 255));
        resetbtn.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 25)); // NOI18N
        resetbtn.setText("Print Report");
        resetbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });
        jPanel2.add(resetbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 160, 40));

        submit6.setBackground(new java.awt.Color(153, 204, 255));
        submit6.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 25)); // NOI18N
        submit6.setText("Submit");
        submit6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submit6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit6ActionPerformed(evt);
            }
        });
        jPanel2.add(submit6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 120, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stdId12.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId12.setForeground(new java.awt.Color(51, 51, 51));
        stdId12.setText("Class:");
        jPanel3.add(stdId12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, 30));

        lblClass.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        lblClass.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(lblClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 110, 30));

        lblTotalAmount.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        lblTotalAmount.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(lblTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 220, 30));

        stdId16.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId16.setForeground(new java.awt.Color(51, 51, 51));
        stdId16.setText("Total Fees Amount :");
        jPanel3.add(stdId16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 220, 30));

        stdId17.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId17.setForeground(new java.awt.Color(51, 51, 51));
        stdId17.setText("Total Remaining Fees Amount :");
        jPanel3.add(stdId17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 280, 30));

        lblRem.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        lblRem.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(lblRem, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 220, 30));

        stdId15.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId15.setForeground(new java.awt.Color(51, 51, 51));
        stdId15.setText("Total Collected Amount :");
        jPanel3.add(stdId15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 220, 30));

        lblCollected.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        lblCollected.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(lblCollected, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 140, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, 640, 250));

        tbl.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sid", "Student name", "Subjects", "Admission Date", "Fees Amount", "Colllected amount", "Remaining Amount", "Remark"
            }
        )
        {
            public boolean isCellEditable(int row,int column)
            {
                return false;
            }
        }
    );
    tbl.setRowHeight(25);
    jScrollPane1.setViewportView(tbl);

    jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 1400, 530));

    jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 48)); // NOI18N
    jLabel9.setText("* View Report *");
    jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 51), new java.awt.Color(51, 255, 51), new java.awt.Color(255, 0, 255), java.awt.Color.black));
    jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 340, 60));

    jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
    jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 430, 10));

    submit5.setBackground(new java.awt.Color(153, 204, 255));
    submit5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 25)); // NOI18N
    submit5.setText("Reset");
    submit5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    submit5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            submit5ActionPerformed(evt);
        }
    });
    jPanel2.add(submit5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 120, 40));

    jPanel11.setBackground(new java.awt.Color(178, 8, 58));
    jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/erygtrhytrhtrh.png"))); // NOI18N
    jPanel11.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 80));

    jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 120, 120));

    getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 1570, 990));

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

    jPanel10.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 340, -1));

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

    jPanel10.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 340, -1));

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

    jPanel10.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 340, -1));

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

    jPanel10.add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 740, 340, -1));

    g.setBackground(new java.awt.Color(6, 48, 49));
    g.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 255, 255));
    jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/logout,  USE.png"))); // NOI18N
    jLabel10.setText("   Logout");
    jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jLabel10MouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jLabel10MouseExited(evt);
        }
    });
    g.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 70));

    jPanel10.add(g, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 840, 340, -1));

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

    jPanel10.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 340, -1));

    add.setBackground(new java.awt.Color(6, 48, 49));
    add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    q.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
    q.setForeground(new java.awt.Color(255, 255, 255));
    q.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/Imgs/new-user.png"))); // NOI18N
    q.setText("  AddStudent");
    q.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            qMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            qMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            qMouseExited(evt);
        }
    });
    add.add(q, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 270, 70));

    jPanel10.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 340, -1));

    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/6565656.png"))); // NOI18N
    jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 190, 150));
    jPanel10.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 190, 20));

    getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 1010));

    jPanel1.setBackground(new java.awt.Color(178, 8, 58));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 1610, 20));

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
        // TODO add your handling code here:
        if(validation()){
        SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy");
        String FromDate=dateformat.format(fromdate.getDate());
        String ToDate=dateformat.format(todate.getDate());
        MessageFormat header=new MessageFormat("Report From"+FromDate+"To"+ToDate);
        MessageFormat footer=new MessageFormat("page{0,number,integer}");
        try
        {
            tbl.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }
        catch(Exception e)
                {
                    e.getMessage();
                }
        }
    }//GEN-LAST:event_resetbtnActionPerformed

    private void submit6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit6ActionPerformed
        // TODO add your handling code here:
       if(validation())
       {  clearTable(); 
        settable();
       }
        
        //clear();
    }//GEN-LAST:event_submit6ActionPerformed

    private void submit5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit5ActionPerformed
        // TODO add your handling code here:
        clearTable();
        clear();
         //   validation();
    }//GEN-LAST:event_submit5ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        UpdateStdRec up=new UpdateStdRec();
        up.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

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

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        NewJFrame nf=new NewJFrame();
        nf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

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

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        EditPrintReciept er=new EditPrintReciept();
        er.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

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

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        ViewRecord vr=new ViewRecord();
        vr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

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

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        // TODO add your handling code here:
        Color clr=new Color(178,8,58);
        g.setBackground(clr);
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        // TODO add your handling code here:
        Color clr=new Color(6,48,49);
        g.setBackground(clr);
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        Home1 hm=new Home1();
        hm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        Color clr=new Color(178,8,58);
        a.setBackground(clr);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        Color clr=new Color(6,48,49);
        a.setBackground(clr);
    }//GEN-LAST:event_jLabel2MouseExited

    private void qMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qMouseClicked
        // TODO add your handling code here:
        AddStudent as=new AddStudent();
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_qMouseClicked

    private void qMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(178,8,58);
        add.setBackground(clr);
    }//GEN-LAST:event_qMouseEntered

    private void qMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qMouseExited
        // TODO add your handling code here:
        Color clr=new Color(6,48,49);
        add.setBackground(clr);
    }//GEN-LAST:event_qMouseExited

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
            java.util.logging.Logger.getLogger(ViewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel a;
    private javax.swing.JPanel add;
    private javax.swing.JPanel b;
    private javax.swing.JPanel c;
    private javax.swing.JComboBox<String> cmbClass;
    private javax.swing.JPanel d;
    private javax.swing.JPanel e;
    private com.toedter.calendar.JDateChooser fromdate;
    private javax.swing.JPanel g;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblCollected;
    private javax.swing.JLabel lblRem;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JLabel q;
    private javax.swing.JButton resetbtn;
    private javax.swing.JLabel stdId10;
    private javax.swing.JLabel stdId11;
    private javax.swing.JLabel stdId12;
    private javax.swing.JLabel stdId15;
    private javax.swing.JLabel stdId16;
    private javax.swing.JLabel stdId17;
    private javax.swing.JLabel stdId8;
    private javax.swing.JLabel stdId9;
    private javax.swing.JButton submit5;
    private javax.swing.JButton submit6;
    private javax.swing.JTable tbl;
    private com.toedter.calendar.JDateChooser todate;
    // End of variables declaration//GEN-END:variables
}