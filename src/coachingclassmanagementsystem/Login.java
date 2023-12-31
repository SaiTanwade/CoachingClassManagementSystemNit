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

/**
 *
 * @author saita
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
    
    void userVerification(String userName,String password)
            {
                try
                {
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");
                   String sql="select * from adminreg where username=? and password=?";
                   PreparedStatement pst=con.prepareStatement(sql);
                   pst.setString(1,userName);
                   pst.setString(2,password);
                   ResultSet rs=pst.executeQuery();
                   if(rs.next())
                   {
                      // JOptionPane.showMessageDialog(this,"Login Sucessfull");
                       Home1 hm=new Home1();
                       hm.show();
                       this.dispose();
                   }
                   else{
                      JOptionPane.showMessageDialog(this,"Please Enter Correct UserName And Password");
                      
                   }
                }
                catch(Exception e)
                {
                   System.out.print(e);
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

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnCreateAcc = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnForgetPass = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnexit = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        btnlogin = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        btnlogin1 = new javax.swing.JButton();
        btnlogin2 = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(330, 310));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/Imgs/dnyan.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 170, 170));

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 1, 30)); // NOI18N
        jLabel2.setText("The Way Of Success... ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 280, -1));

        jPanel3.setBackground(new java.awt.Color(79, 184, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 255, 153), new java.awt.Color(153, 255, 153), new java.awt.Color(51, 51, 51), new java.awt.Color(204, 255, 255)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCreateAcc.setBackground(new java.awt.Color(246, 142, 115));
        btnCreateAcc.setFont(new java.awt.Font("Microsoft Himalaya", 0, 48)); // NOI18N
        btnCreateAcc.setText("    Create Account");
        btnCreateAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateAccMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCreateAccMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCreateAccMouseExited(evt);
            }
        });
        jPanel3.add(btnCreateAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 80));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 290, 80));

        jPanel8.setBackground(new java.awt.Color(79, 184, 255));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 153), new java.awt.Color(102, 204, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnForgetPass.setBackground(new java.awt.Color(246, 142, 115));
        btnForgetPass.setFont(new java.awt.Font("Microsoft Himalaya", 0, 48)); // NOI18N
        btnForgetPass.setText("    Forget Password");
        btnForgetPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnForgetPassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnForgetPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnForgetPassMouseExited(evt);
            }
        });
        jPanel8.add(btnForgetPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 80));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 290, 80));

        jPanel9.setBackground(new java.awt.Color(79, 184, 255));
        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 102), new java.awt.Color(153, 255, 153), new java.awt.Color(51, 51, 51), new java.awt.Color(102, 102, 102)));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel9MouseExited(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnexit.setBackground(new java.awt.Color(246, 142, 115));
        btnexit.setFont(new java.awt.Font("Microsoft Himalaya", 0, 48)); // NOI18N
        btnexit.setText("             Exit");
        jPanel9.add(btnexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 80));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 290, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 730));

        jPanel7.setBackground(new java.awt.Color(184, 252, 184));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/Imgs/login-profile.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 200, 190));

        jLabel11.setFont(new java.awt.Font("Microsoft Himalaya", 1, 43)); // NOI18N
        jLabel11.setText("Welcome");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 160, -1));

        jLabel12.setFont(new java.awt.Font("Microsoft Tai Le", 1, 20)); // NOI18N
        jLabel12.setText("Password:");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 120, 50));

        jLabel13.setFont(new java.awt.Font("Microsoft Tai Le", 1, 20)); // NOI18N
        jLabel13.setText("User Name:");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 120, 50));

        txtusername.setFont(new java.awt.Font("Microsoft Tai Le", 0, 20)); // NOI18N
        jPanel7.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 280, 40));

        txtpassword.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        jPanel7.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 280, 40));

        btnlogin.setBackground(new java.awt.Color(153, 255, 255));
        btnlogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnlogin.setText("Exit");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        btnlogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnloginKeyPressed(evt);
            }
        });
        jPanel7.add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 610, 110, 50));
        jPanel7.add(error, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 570, 260, 20));

        jCheckBox1.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 16)); // NOI18N
        jCheckBox1.setText("show password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel7.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, -1, -1));

        btnlogin1.setBackground(new java.awt.Color(153, 255, 255));
        btnlogin1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnlogin1.setText("Login");
        btnlogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogin1ActionPerformed(evt);
            }
        });
        btnlogin1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnlogin1KeyPressed(evt);
            }
        });
        jPanel7.add(btnlogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 610, 110, 50));

        btnlogin2.setBackground(new java.awt.Color(153, 255, 255));
        btnlogin2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnlogin2.setText("Create Account");
        btnlogin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogin2ActionPerformed(evt);
            }
        });
        btnlogin2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnlogin2KeyPressed(evt);
            }
        });
        jPanel7.add(btnlogin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 610, -1, 50));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 660, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateAccMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateAccMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(39,166,252);
        jPanel3.setBackground(clr);
    }//GEN-LAST:event_btnCreateAccMouseEntered

    private void btnCreateAccMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateAccMouseExited
        // TODO add your handling code here:
        Color clr=new Color(79,184,255);
        jPanel3.setBackground(clr);
    }//GEN-LAST:event_btnCreateAccMouseExited

    private void btnForgetPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForgetPassMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(39,166,252);
        jPanel8.setBackground(clr);
    }//GEN-LAST:event_btnForgetPassMouseEntered

    private void btnForgetPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForgetPassMouseExited
        // TODO add your handling code here:
        Color clr=new Color(79,184,255);
        jPanel8.setBackground(clr);
    }//GEN-LAST:event_btnForgetPassMouseExited

    private void jPanel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseEntered
        // TODO add your handling code here:
        Color clr=new Color(39,166,252);
        jPanel9.setBackground(clr);
    }//GEN-LAST:event_jPanel9MouseEntered

    private void jPanel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseExited
        // TODO add your handling code here:
        Color clr=new Color(79,184,255);
        jPanel9.setBackground(clr);
    }//GEN-LAST:event_jPanel9MouseExited

    private void btnCreateAccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateAccMouseClicked
        // TODO add your handling code here:
        Sinup Ac=new Sinup();
        setVisible(false);
        Ac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCreateAccMouseClicked

    private void btnForgetPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForgetPassMouseClicked
        // TODO add your handling code here:
        getPassword gp=new getPassword();
        setVisible(false);
        gp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnForgetPassMouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected())
        {
            txtpassword.setEchoChar((char)0);
        }
        else
        {
            txtpassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void btnlogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlogin1ActionPerformed

    private void btnlogin1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnlogin1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlogin1KeyPressed

    private void btnloginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnloginKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnloginKeyPressed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // TODO add your handling code here:
        String username=txtusername.getText();
        String password=txtpassword.getText();
        if(username.trim().equals("")||password.trim().equals(""))
        {
            error.setText("*please enter username and password");

        }
        else{
            userVerification(username, password);
        }
        txtusername.setText("");
        txtpassword.setText("");
    }//GEN-LAST:event_btnloginActionPerformed

    private void btnlogin2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnlogin2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlogin2KeyPressed

    private void btnlogin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogin2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlogin2ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCreateAcc;
    private javax.swing.JLabel btnForgetPass;
    private javax.swing.JLabel btnexit;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnlogin1;
    private javax.swing.JButton btnlogin2;
    private javax.swing.JLabel error;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
