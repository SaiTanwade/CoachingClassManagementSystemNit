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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saita
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    String TeacherName,Subject;
    int CourseId,fees;
    DefaultTableModel model;
    public NewJFrame() {
        initComponents();
        txtCourseId();
        settable();
        getcourseid();
        //clearTable();
    }
    
    void txtCourseId()
    {
        a1.setEditable(false);
    }
    
    void para()
    {
         
        CourseId=Integer.parseInt(a1.getText());
        TeacherName=b1.getText();
        Subject=c1.getText();        
        fees=Integer.parseInt(c2.getText());
         
    }
    
    public void clear()
    {
          a1.setText("");
          b1.setText("");
          c1.setText("");
          c2.setText("");
          
    }
    
    boolean validation()
    {
        
       CourseId=Integer.parseInt(a1.getText());
        TeacherName=b1.getText();
        Subject=c1.getText();        
        fees=Integer.parseInt(c2.getText());
        
       // para();
       
        if(b1.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Enter Teacher Name");
              return false;
        }
        
        if(c1.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Enter Subject Name");
              return false;
        }
        
        return true;
    }
    
    boolean validation2()
    {
        if(a1.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please Select Course Id From Table To Update Data");
              return false;
        }
         if(c2.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please Select Subject Fees");
              return false;
        }
        return true;
    }
    
     void update(int CourseId,String TeacherName,String Subject,int fees)
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
                   smt.setInt(4,CourseId);                   
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
 
          PreparedStatement pst=con.prepareStatement("select * from sai");
          ResultSet rs=pst.executeQuery();
          while(rs.next())
          {
              int Cid=rs.getInt(1);
              String tName=rs.getString(2);
              String sub=rs.getString(3);              
              int fee=rs.getInt(4);
              Object[] obj={Cid,tName,sub,fee};
              model=(DefaultTableModel)tbl.getModel();
              model.addRow(obj);
          }  
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
         
    }
    
    void getcourseid()
     {
         
        try
                {
                    
                    
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");
                   
                   String sql=("Select Max(CourseId)from sai"); 
                   PreparedStatement smt=con.prepareStatement(sql);
                   ResultSet rs=smt.executeQuery();
                   if(rs.next()==true)
                   {
                       CourseId=rs.getInt(1);
                       CourseId++;
                       a1.setText(Integer.toString(CourseId));
                   }
                }
        catch(Exception e)
        {
            System.out.println(e);
        }
     }
     
    
    void insert()
    {
        try
        {  
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
                   String sql="insert into sai values(?,?,?,?)";
                   PreparedStatement smt=con.prepareStatement(sql);
                   smt.setInt(1,CourseId);
                   smt.setString(2,TeacherName);
                   smt.setString(3,Subject);                     
                   smt.setInt(4,fees);
                   
                   int i=smt.executeUpdate();
                   if(i>0)
                   {
                    JOptionPane.showMessageDialog(this,"record inserted");
                    clearTable();
                    settable();
                   }
                   else{
                       JOptionPane.showMessageDialog(this,"record not inserted");
                   }
                   con.close();
                   clear();
                   
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        stdId4 = new javax.swing.JLabel();
        stdId1 = new javax.swing.JLabel();
        stdId2 = new javax.swing.JLabel();
        stdId3 = new javax.swing.JLabel();
        c2 = new javax.swing.JTextField();
        a1 = new javax.swing.JTextField();
        b1 = new javax.swing.JTextField();
        c1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        Clear = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        b = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        d = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        e = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        f = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        g = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        a = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        c = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stdId4.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId4.setForeground(new java.awt.Color(51, 51, 51));
        stdId4.setText("Course Id:");
        jPanel2.add(stdId4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 140, 30));

        stdId1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId1.setForeground(new java.awt.Color(51, 51, 51));
        stdId1.setText("Teacher Name:");
        jPanel2.add(stdId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 140, 30));

        stdId2.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId2.setForeground(new java.awt.Color(51, 51, 51));
        stdId2.setText("Subject Name");
        jPanel2.add(stdId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 140, 30));

        stdId3.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId3.setForeground(new java.awt.Color(51, 51, 51));
        stdId3.setText("Subject Fees:");
        jPanel2.add(stdId3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 140, 30));

        c2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        c2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c2KeyTyped(evt);
            }
        });
        jPanel2.add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 610, 280, 40));

        a1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        a1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a1ActionPerformed(evt);
            }
        });
        a1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                a1KeyTyped(evt);
            }
        });
        jPanel2.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 280, 40));

        b1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        jPanel2.add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 280, 40));

        c1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        jPanel2.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 500, 280, 40));

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 48)); // NOI18N
        jLabel9.setText("Edit Course Details");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 51), new java.awt.Color(51, 255, 51), new java.awt.Color(255, 0, 255), java.awt.Color.black));
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 480, 30));

        add.setBackground(new java.awt.Color(153, 204, 255));
        add.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 25)); // NOI18N
        add.setText("Add");
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
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 770, 110, 50));

        Update.setBackground(new java.awt.Color(153, 204, 255));
        Update.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 25)); // NOI18N
        Update.setText("Update");
        Update.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel2.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 770, 110, 50));

        Delete.setBackground(new java.awt.Color(153, 204, 255));
        Delete.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 25)); // NOI18N
        Delete.setText("Delete");
        Delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel2.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 770, 110, 50));

        tbl.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "course Id", "Teacher Name", "Subject", "Fees"
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
    tbl.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl);

    jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 780, 710));

    Clear.setBackground(new java.awt.Color(153, 204, 255));
    Clear.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 25)); // NOI18N
    Clear.setText("Refersh");
    Clear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    Clear.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ClearActionPerformed(evt);
        }
    });
    jPanel2.add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 770, 110, 50));

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

    jPanel10.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 340, -1));

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

    jPanel10.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 340, -1));

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

    jPanel10.add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 340, -1));

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

    jPanel10.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 340, -1));

    g.setBackground(new java.awt.Color(6, 48, 49));
    g.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 255, 255));
    jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/logout,  USE.png"))); // NOI18N
    jLabel10.setText("   Logout");
    jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel10MouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jLabel10MouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jLabel10MouseExited(evt);
        }
    });
    g.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 70));

    jPanel10.add(g, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 820, 340, -1));

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

    jPanel10.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 340, -1));

    c.setBackground(new java.awt.Color(6, 48, 49));
    c.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 255, 255));
    jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/Imgs/new-user.png"))); // NOI18N
    jLabel6.setText("   Add Student");
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

    jPanel10.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 340, -1));

    jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/cource.png"))); // NOI18N
    jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 180, 150));
    jPanel10.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 200, 10));

    getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 1010));

    jPanel1.setBackground(new java.awt.Color(178, 8, 58));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 1610, 20));

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b1ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
       if(a1.getText().isEmpty()||b1.getText().isEmpty()||c1.getText().isEmpty()||c2.getText().isEmpty())
       {
           JOptionPane.showMessageDialog(this,"Please Enter All Data");
       }
       else{
          para();
          insert();
          getcourseid();
//          settable();
       }
       
    }//GEN-LAST:event_addActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        if(a1.getText().isEmpty()||b1.getText().isEmpty()||c1.getText().isEmpty()||c2.getText().isEmpty())
       {
           JOptionPane.showMessageDialog(this,"Please Enter All Data");
       }
        else
        {
        para();
        update(CourseId,TeacherName,Subject,fees);
        }
        
    }//GEN-LAST:event_UpdateActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        if(a1.getText().isEmpty()||b1.getText().isEmpty()||c1.getText().isEmpty()||c2.getText().isEmpty())
       {
           JOptionPane.showMessageDialog(this,"Please select Course Id From Table Or Enter Required Data To Delete the Data");
       }
        else
        {
        para();
        delete(CourseId);
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void a1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_a1KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_a1KeyTyped

    private void c2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c2KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_c2KeyTyped

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_addMouseClicked

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        //To Select the Perticular row 
        DefaultTableModel model=(DefaultTableModel)tbl.getModel();
        int rowNo=tbl.getSelectedRow();
       // TableModel model=RecordTable.getModel();
        //txtCid.setText(model.getValueAt(rowNo,0).toString());
        a1.setText((String) model.getValueAt(rowNo,0).toString());
        b1.setText((String) model.getValueAt(rowNo,1));
        c1.setText((String) model.getValueAt(rowNo,2));
        c2.setText((String) model.getValueAt(rowNo,3).toString());
    }//GEN-LAST:event_tblMouseClicked

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
        AddStudent as=new AddStudent();
        as.setVisible(true);
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
        ViewRecord1 vr=new ViewRecord1();
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

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        ViewReport vrp=new ViewReport();
        vrp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

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

    private void a1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_a1ActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
        clear();
        getcourseid();
    }//GEN-LAST:event_ClearActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        Login1 lg=new Login1();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Update;
    private javax.swing.JPanel a;
    private javax.swing.JTextField a1;
    private javax.swing.JButton add;
    private javax.swing.JPanel b;
    private javax.swing.JTextField b1;
    private javax.swing.JPanel c;
    private javax.swing.JTextField c1;
    private javax.swing.JTextField c2;
    private javax.swing.JPanel d;
    private javax.swing.JPanel e;
    private javax.swing.JPanel f;
    private javax.swing.JPanel g;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel stdId1;
    private javax.swing.JLabel stdId2;
    private javax.swing.JLabel stdId3;
    private javax.swing.JLabel stdId4;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
}
