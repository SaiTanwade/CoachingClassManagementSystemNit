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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saita
 */
public class ViewRecord extends javax.swing.JFrame {

    /**
     * Creates new form ViewRecord
     */
    DefaultTableModel model;
    public ViewRecord() {
        initComponents();
        settable();
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
              int Cid=rs.getInt(1);
              String sName=rs.getString(2);
//              String fName=rs.getString(3);
              String sDob=rs.getString(3);
              String sContact=rs.getString(5);
              String pContact=rs.getString(6);
              String sClass=rs.getString(8);
              String admDate=rs.getString(7);
                           
              String sub=rs.getString(9);
              String address=rs.getString(10);
              String remark=rs.getString(11);
              
              
              //int fee=rs.getInt(4);
              Object[] obj={Cid,sName,sDob,sContact,pContact,sClass,admDate,sub,address,remark};
              model=(DefaultTableModel)ViewTbl.getModel();
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
         DefaultTableModel model=(DefaultTableModel)ViewTbl.getModel();
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

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("coachingclass?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        addstudent_1Query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT a FROM Addstudent_1 a");
        addstudent_1List = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : addstudent_1Query.getResultList();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ViewTbl = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        b = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        c = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        d = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        f = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        g = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        a = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        add = new javax.swing.JPanel();
        q = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ViewTbl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ViewTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Std Id", "Std Name", "Date of Birth", "Std Contact", "Parent Contact", "Class ", "Admission Date", "Subjects", "address", "Remark"
            }
        )
        {
            public boolean isCellEditable(int row,int column)
            {
                return false;
            }
        }
    );
    ViewTbl.setEditingRow(2);
    ViewTbl.setRowHeight(25);
    ViewTbl.setRowMargin(2);
    jScrollPane2.setViewportView(ViewTbl);

    jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 1570, 770));

    jPanel3.setBackground(new java.awt.Color(178, 8, 58));
    jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/Imgs/view all record.png"))); // NOI18N
    jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 70, 90));

    jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 120, 110));

    jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 48)); // NOI18N
    jLabel10.setText("View Record");
    jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 51), new java.awt.Color(51, 255, 51), new java.awt.Color(255, 0, 255), java.awt.Color.black));
    jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

    jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
    jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 350, 30));

    getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 1670, 990));

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
    b.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 70));

    jPanel10.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 340, -1));

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

    jPanel10.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 340, -1));

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

    jPanel10.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 340, -1));

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

    jPanel10.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 750, 340, -1));

    g.setBackground(new java.awt.Color(6, 48, 49));
    g.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/logout,  USE.png"))); // NOI18N
    jLabel9.setText("   Logout");
    jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jLabel9MouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jLabel9MouseExited(evt);
        }
    });
    g.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 70));

    jPanel10.add(g, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 850, 340, -1));

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

    jPanel10.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 340, -1));

    add.setBackground(new java.awt.Color(6, 48, 49));
    add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    q.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
    q.setForeground(new java.awt.Color(255, 255, 255));
    q.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/Imgs/new-user.png"))); // NOI18N
    q.setText(" AddStudent");
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

    jPanel10.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 340, -1));

    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coachingclassmanagementsystem/imgs2/ggfdgfdgfg.png"))); // NOI18N
    jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 190, 150));
    jPanel10.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 240, 20));

    getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 1010));

    jPanel1.setBackground(new java.awt.Color(178, 8, 58));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 1670, 20));

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ViewRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ViewTbl;
    private javax.swing.JPanel a;
    private javax.swing.JPanel add;
    private java.util.List<coachingclassmanagementsystem.Addstudent_1> addstudent_1List;
    private javax.persistence.Query addstudent_1Query;
    private javax.swing.JPanel b;
    private javax.swing.JPanel c;
    private javax.swing.JPanel d;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JPanel f;
    private javax.swing.JPanel g;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel q;
    // End of variables declaration//GEN-END:variables
}
