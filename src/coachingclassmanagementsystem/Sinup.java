/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coachingclassmanagementsystem;

import com.toedter.calendar.JTextFieldDateEditor;
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
public class Sinup extends javax.swing.JFrame {

    /**
     * Creates new form Sinup
     */
    
    String fname,lname,uname,password,conPass,contactNo;
    Date dob;
    int Id=0;
    JTextFieldDateEditor dtedit;
    public Sinup() {
        
        initComponents();
        editeDate();
    }
     void editeDate()
     {
         dtedit=(JTextFieldDateEditor) txtdob.getDateEditor();
         dtedit.setEditable(false);
         
     }
     
    
    public void clear()
    {
          txtfname.setText("");
          txtlname.setText("");
          txtuname.setText("");
          txtpass.setText("");
          txtcpass.setText("");
          txtdob.setDate(null);
          txtcontact.setText("");
    }
    
      public int getId()
      {
          ResultSet rs=null;
        
        try
        {
           Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");
            String sql = "select max(Id) from adminreg";
            Statement st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next())
            { 
             Id=rs.getInt(1);
             Id++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return Id;
      }
      
      boolean validation()
      {
          fname=txtfname.getText().trim();
          lname=txtlname.getText().trim();
          uname=txtuname.getText().trim();
          password=txtpass.getText().trim();
          conPass=txtcpass.getText().trim();
          dob=txtdob.getDate();
          contactNo=txtcontact.getText().trim();
          
          
          if(fname.equals(""))
          {
              JOptionPane.showMessageDialog(this,"Please Enter FirstName");
              return false;
          }
          
          if(lname.equals(""))
          {
              JOptionPane.showMessageDialog(this,"Please Enter LastName");
              return false;
          }
          
          if(uname.equals(""))
          {
              JOptionPane.showMessageDialog(this,"Please Enter UserName");
              return false;
          }
          
          if(password.equals(""))
          {
              JOptionPane.showMessageDialog(this,"Please Enter Password");
              return false;
          }
          
          if(conPass.equals(""))
          {
              JOptionPane.showMessageDialog(this,"Please Confirm Password");
              return false;
          }
          
           if(dob == null)
          {
              JOptionPane.showMessageDialog(this,"Please Enter dob");
              return false;
          }
          if(contactNo.equals(""))
          {
              JOptionPane.showMessageDialog(this,"Please Enter Contact NO.");
              return false;
          }
         
           if(!password.equals(conPass))
          {
              JOptionPane.showMessageDialog(this,"Password not matched");
              return false;
          }
           
        return true;
        }
          
           public void checkPassword()
          {
            password=txtpass.getText();
            if(password.length()<5)
            {
                lbl_password_error.setText("password should be 6 digit");
            }
           
            else
            {
                 lbl_password_error.setText("");
            }
           
          }
           
            void insertDetails()
            {
               SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
               String mydob=format.format(dob);
                
                try
                {
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");
                   
                   String sql="insert into adminreg value(?,?,?,?,?,?,?)";
                   PreparedStatement smt=con.prepareStatement(sql);
                   smt.setInt(1,getId());
                   smt.setString(2,fname);
                   smt.setString(3,lname);
                   smt.setString(4,uname);
                   smt.setString(5,password);
                   smt.setString(6,mydob);
                   smt.setString(7,contactNo);
                   
                   int i=smt.executeUpdate();
                   if(i>0)
                   {
                    JOptionPane.showMessageDialog(this,"record inserted");
                    Login1 nw=new Login1();
                    nw.setVisible(true);
                    this.dispose();
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
             
            
          

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtlname = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtcontact = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnsubmit = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        txtcpass = new javax.swing.JPasswordField();
        txtpass = new javax.swing.JPasswordField();
        txtdob = new com.toedter.calendar.JDateChooser();
        txtuname = new javax.swing.JTextField();
        lbl_password_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create Account");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, 43));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/Imgs/white-close-icon.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 30, 40));

        jPanel2.setBackground(new java.awt.Color(139, 199, 253));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Microsoft Tai Le", 1, 20)); // NOI18N
        jLabel13.setText("First Name:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 120, 40));

        txtfname.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtfname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfnameKeyTyped(evt);
            }
        });
        jPanel2.add(txtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 280, 40));

        jLabel14.setFont(new java.awt.Font("Microsoft Tai Le", 1, 20)); // NOI18N
        jLabel14.setText("Last Name:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 120, 40));

        txtlname.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtlname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtlnameKeyTyped(evt);
            }
        });
        jPanel2.add(txtlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 280, 40));

        jLabel15.setFont(new java.awt.Font("Microsoft Tai Le", 1, 20)); // NOI18N
        jLabel15.setText("Contact NO:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, 180, 40));

        txtcontact.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtcontact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcontactKeyPressed(evt);
            }
        });
        jPanel2.add(txtcontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 530, 280, 40));

        jLabel16.setFont(new java.awt.Font("Microsoft Tai Le", 1, 20)); // NOI18N
        jLabel16.setText("User Name:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 120, 40));

        jLabel17.setFont(new java.awt.Font("Microsoft Tai Le", 1, 20)); // NOI18N
        jLabel17.setText("Passward:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 120, 40));

        jLabel18.setFont(new java.awt.Font("Microsoft Tai Le", 1, 20)); // NOI18N
        jLabel18.setText("Confirm Passward:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 180, 40));

        jLabel19.setFont(new java.awt.Font("Microsoft Tai Le", 1, 20)); // NOI18N
        jLabel19.setText("Date of Birth:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 180, 40));

        btnsubmit.setBackground(new java.awt.Color(153, 255, 255));
        btnsubmit.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnsubmit.setText("Register");
        btnsubmit.setActionCommand("Submit");
        btnsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubmitActionPerformed(evt);
            }
        });
        jPanel2.add(btnsubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 610, 110, 50));

        btnback.setBackground(new java.awt.Color(153, 255, 255));
        btnback.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel2.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 610, 110, 50));

        txtcpass.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtcpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcpassKeyReleased(evt);
            }
        });
        jPanel2.add(txtcpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 280, 40));

        txtpass.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassKeyPressed(evt);
            }
        });
        jPanel2.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 280, 40));
        jPanel2.add(txtdob, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 280, 40));

        txtuname.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        jPanel2.add(txtuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 280, 40));
        jPanel2.add(lbl_password_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 230, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        Login1 login=new Login1();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubmitActionPerformed
        // TODO add your handling code here:
       if(validation()){
           insertDetails();
       }
    }//GEN-LAST:event_btnsubmitActionPerformed

    private void txtpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyPressed
        // TODO add your handling code here:
        checkPassword();
    }//GEN-LAST:event_txtpassKeyPressed

    private void txtcpassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcpassKeyReleased
        // TODO add your handling code here:
        checkPassword();
    }//GEN-LAST:event_txtcpassKeyReleased

    private void txtcontactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontactKeyPressed
        // TODO add your handling code here:
        String number=txtcontact.getText();
        int length=number.length();
        char c=evt.getKeyChar();
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
        {
            if(length<10)
            {
                txtcontact.setEditable(true);
            }
            else
            {
                txtcontact.setEditable(false);
            }
        }else{
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txtcontact.setEditable(true);
            }
            else
            {
                txtcontact.setEditable(false);
            }
        }
        
    }//GEN-LAST:event_txtcontactKeyPressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtfnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfnameKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c)||(c==KeyEvent.VK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_PERIOD)))
        {
          JOptionPane.showMessageDialog(this,"Number not allow");
          getToolkit().beep();
        
        evt.consume();
        }
    }//GEN-LAST:event_txtfnameKeyTyped

    private void txtlnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtlnameKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c)||(c==KeyEvent.VK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_PERIOD)))
        {
          JOptionPane.showMessageDialog(this,"Number not allow");
          getToolkit().beep();
        
        evt.consume();
        }
    }//GEN-LAST:event_txtlnameKeyTyped

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
            java.util.logging.Logger.getLogger(Sinup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sinup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sinup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sinup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sinup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnsubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_password_error;
    private javax.swing.JTextField txtcontact;
    private javax.swing.JPasswordField txtcpass;
    private com.toedter.calendar.JDateChooser txtdob;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtlname;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables
}
