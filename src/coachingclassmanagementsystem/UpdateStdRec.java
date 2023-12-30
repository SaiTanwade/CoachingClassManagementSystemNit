/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coachingclassmanagementsystem;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
public class UpdateStdRec extends javax.swing.JFrame {

    /**
     * Creates new form UpdateStdRec
     */
    String Sfullname,Fname,Scontact,Pcontact,City,stdClass,Addr,Rem;
    Date adm;Date Sdob;
    String Gender="";
    int Id,Total,paid,remain;
    int n=0;
    int Total1=0;
    int ttl=0;
    String Subject="";
    
    
    DefaultTableModel model;
    DefaultTableModel model1;
    public UpdateStdRec() {
        initComponents();
        tablesize();
        settable();
        clearTable();
        searchRecordtable();
        UnEditable();
        
    }
    
     public void tablesize()
    {
        tbl.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(280);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(140);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(140);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(140);
        tbl.getColumnModel().getColumn(5).setPreferredWidth(140);
        tbl.getColumnModel().getColumn(6).setPreferredWidth(80);
        tbl.getColumnModel().getColumn(7).setPreferredWidth(150);
        tbl.getColumnModel().getColumn(8).setPreferredWidth(50);
        tbl.getColumnModel().getColumn(9).setPreferredWidth(50);
        tbl.getColumnModel().getColumn(10).setPreferredWidth(100);
        
    }
    public void UnEditable(){
        txtRemain.setEditable(false);
        txtTotal.setEditable(false);
        txtFinal.setEditable(false);
    }
//    boolean validation()
//    {
//        
////        //Id=Integer.parseInt(txtId.getText());
////        Sfullname=txtStdName.getText();
//////        Sdob=txtdob.getDate();
//////        adm=admDate.getDate();
////        Scontact=txtStdContact1.getText();
////        Pcontact=txtParentContact.getText();
////        stdClass=cmbClass.getSelectedItem().toString();
////        Addr=txtSearch.getText();
//////        Total=Integer.parseInt(txtFinal.getText());
//////        paid=Integer.parseInt(txtPaid.getText());
////        remain=Integer.parseInt(txtRemain.getText());
//////        
//////        Rem=txtRemark.getText(); 
//////          
////          Addr=txtAddress.getText();
////          Rem=txtRemark.getText();
//        
//        
////        if(txtId.equals(""))
////        {
////            JOptionPane.showMessageDialog(this,"Please Enter Course Id");
////              return false;
////        }
//        
//        if(txtStdName.equals(""))
//        {
//            JOptionPane.showMessageDialog(this,"Please Enter student Name");
//              return false;
//        }
//        
//        
//        return true;
//    }
   boolean Validation2()
     {
       
         if(txtId.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Id to get student record");
              return false;
              
          
        }
         if(txtStdName.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Student Name");
              return false;
            
        }
         if(txtStdContact1.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please Enter Student Number");
              return false;
        }
        
        if(txtParentContact.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please Enter Parent Contact Number");
              return false;
        }
//        if(cmbClass.setSelectedItem()==null)
//        {
//            JOptionPane.showMessageDialog(this,"Please Enter Parent Contact Number");
//              return false;
//        }
        
        if(txtRemark.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please Enter Remark");
              return false;
        }
        
        if(txtAddress.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please Enter Address");
              return false;
        }
          if(txtTotal.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Total Fees");
              return false;
              
          
        }
        if(txtDisc.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Discount if you want, else enter 0 ");
              return false;
              
          
        }
        if(txtFinal.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Final Fees After getting discount  ");
              return false;
              
          
        }
        if(txtPaid.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter paid Fees");
              return false;
              
          
        }
        if(txtRemain.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(this,"Please enter Reamining Fees");
              return false;
              
          
        }
        return true;
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
              String stddob=rs.getString("stddob");
              String admdate=rs.getString("admdate");
              String stdcontact=rs.getString("stdcontact");
              String pcontact=rs.getString("pcontact");
            
              String stdclass=rs.getString("class");
              String subjects=rs.getString("subject");
               String add=rs.getString("address");    
              int Total=rs.getInt("total");
               int paideee=rs.getInt("feespaid");
                int remaineee=rs.getInt("feesremaining");
                        
              String remark=rs.getString("remark"); 
              
              Object[] obj={Cid,stdName,stddob,admdate,stdcontact,pcontact,stdclass,subjects,add,Total,paideee,remaineee,remark};
              model1=(DefaultTableModel)tbl.getModel();
              model1.addRow(obj);
          }  
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
         
    }
    public void searchString(String str)
    {
        model1=(DefaultTableModel)tbl.getModel();
        TableRowSorter<DefaultTableModel> trs =new TableRowSorter<>(model1);
        tbl.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
        
    }
    public void clearTable()
     {
         DefaultTableModel model=(DefaultTableModel)tbl.getModel();
         model.setRowCount(0);
     }
    
    
     void para()
    {
        Id=Integer.parseInt(txtId.getText());
        Sfullname=txtStdName.getText();
//        Sdob=txtdob.getDate();
//        adm=admDate.getDate();
        Scontact=txtStdContact1.getText();
        Pcontact=txtParentContact.getText();
        stdClass=cmbClass.getSelectedItem().toString();
        Addr=txtSearch.getText();
        Total=Integer.parseInt(txtFinal.getText());
        paid=Integer.parseInt(txtPaid.getText());
        remain=Integer.parseInt(txtRemain.getText());        
        Rem=txtRemark.getText();
        Addr=txtAddress.getText();
    }
     
     
     
     
     //assign data to all text field after enterimg the id
    public void autoCustname1(){
        String Subject="";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");
            
            PreparedStatement pst=con.prepareStatement("select stdname,stdcontact,pcontact,class,subject,address,remark,total,feespaid,feesremaining from addstudent where id=?");
            
            pst.setString(1,txtId.getText());
            ResultSet rs= pst.executeQuery();

            if(rs.next())
            {
                             
            txtStdName.setText(rs.getString("stdname"));
           
            txtStdContact1.setText(rs.getString("stdcontact"));
            txtParentContact.setText(rs.getString("pcontact"));
            
            //admDate.setDate(rs.getDate("admdate"));
            String cls=rs.getString("class");
          switch(cls)
            {
                case"11th":
                    cmbClass.setSelectedIndex(1);
                    break;
                case"12th":
                    cmbClass.setSelectedIndex(2);
                    break;
            }
            
            String subject=rs.getString("subject");
           // System.out.println(subject);
           // String subject1=subject.trim();
            String [] sa=subject.split(" ");
            
//            for(String str: sa){
//                System.out.print("Hiiiiiii ");
//                System.out.println(Arrays.toString(sa));
//            }
            
            
            for(int i=0;i<sa.length;i++)
            {
                //System.out.println(sa[i]);
                if(sa[i].trim().equals("Physics"))
                { 
                     chbPhysics.setSelected(true);
                     
                }
                 if(sa[i].trim().equals("Chemistry"))
                {
                     chbChemistry.setSelected(true);
                }
                 if(sa[i].trim().equals("Maths"))
                {
                     chbMaths.setSelected(true);
                } 
                 if(sa[i].trim().equals("Biology"))
                {
                     chbBiology.setSelected(true);
                }
                
                
            }
         /*   
            System.out.println(subject1);
            switch(subject1)
            {
                case "Physics Chemistry":
                    chbPhysics.setSelected(true);
                    chbChemistry.setSelected(true);
                    chbBiology.setSelected(false);
                    chbMaths.setSelected(false);
                    break;
                case "Physics Maths":
                    chbPhysics.setSelected(true);
                    chbChemistry.setSelected(false);
                    chbBiology.setSelected(false);
                    chbMaths.setSelected(true);
                    break;
                case "Physics Chemistry Biology":
                    chbPhysics.setSelected(true);
                    chbChemistry.setSelected(true);
                    chbBiology.setSelected(true);
                    chbMaths.setSelected(false);
                    break;
                case "Chemistry":
                    chbChemistry.setSelected(true);
                    chbPhysics.setSelected(false);                    
                    chbBiology.setSelected(false);
                    chbMaths.setSelected(false);
                    break;
                case "Biology":
                    chbBiology.setSelected(true);
                    chbPhysics.setSelected(false);
                    chbChemistry.setSelected(false);                    
                    chbMaths.setSelected(false);                    
                    break;
                case "Maths":
                    chbMaths.setSelected(true);
                    chbPhysics.setSelected(false);
                    chbChemistry.setSelected(false);
                    chbBiology.setSelected(false);                    
                    break;
                default:
                   chbPhysics.setSelected(true);
                    chbChemistry.setSelected(true);
                    chbBiology.setSelected(true);
                    chbMaths.setSelected(true);
                    break;
            }
            */
            txtAddress.setText(rs.getString("address"));
            txtRemark.setText(rs.getString("remark"));
            txtFinal.setText(rs.getString("total"));
            txtPaid.setText(rs.getString("feespaid"));
            txtRemain.setText(rs.getString("feesremaining"));
          
                      
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
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
                
       void getfeesValueAsText()
    {
         PrintReceipt su=new PrintReceipt();

        su.txtPhy.setText(lblPhy.getText());
        su.txtChemi.setText(lblChemi.getText());
        su.txtBio.setText(lblBio.getText());
        su.txtMaths.setText(lblMaths.getText());
        su.txtTotal1.setText(txtTotal.getText());
        su.txtDisc1.setText(txtDisc.getText());
        su.txtFinal1.setText(txtFinal.getText());
        
        su.setVisible(true);
    }         
                
                  
                
            
        
    
    public void clear()
    { 
          txtId.setText("");
          txtStdName.setText("");          
//          txtdob.setDate(null);  
//          admDate.setDate(null);
          txtStdContact1.setText("");
          txtParentContact.setText("");
          cmbClass.setSelectedIndex(0); 
          chbPhysics.setSelected(false);
          chbChemistry.setSelected(false);
          chbBiology.setSelected(false);
          chbMaths.setSelected(false); 
          txtTotal.setText("");
          txtFinal.setText("");
          txtDisc.setText("");
          txtPaid.setText("");
          txtRemain.setText("");
          txtSearch.setText("");
          txtAddress.setText("");
          txtRemark.setText("");
          Subject=null;
          Gender=null;
          lblPhy.setText("");
          lblChemi.setText("");
          lblBio.setText("");
          lblMaths.setText("");
    }
    
    
    
    
    
     void update()
            {
                String Subject="";
               
            Id=Integer.parseInt(txtId.getText().trim());
        Sfullname=txtStdName.getText().trim();
//        Sdob=txtdob.getDate();
//         SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
//               String mydob=format.format(Sdob);
//        adm=admDate.getDate();
//        SimpleDateFormat format2=new SimpleDateFormat("dd-MM-yyyy");
//                 String admitionDate=format2.format(adm);
////               
        Scontact=txtStdContact1.getText().trim();
        Pcontact=txtParentContact.getText().trim();
        stdClass=cmbClass.getSelectedItem().toString();
       if(chbPhysics.isSelected())
                   {
                       Subject+=chbPhysics.getText()+"";
                   }
                   if(chbChemistry.isSelected())
                   {
                       Subject+=chbChemistry.getText()+"";
                   }
                   if(chbBiology.isSelected())
                   {
                       Subject+=chbBiology.getText()+"";
                   }
                   if(chbMaths.isSelected())
                   {
                       Subject+=chbMaths.getText()+"";
                   }
        Addr=txtAddress.getText().trim();
//        Total=Integer.parseInt(txtTotal.getText());
//        paid=Integer.parseInt(txtPaid.getText());
        remain=Integer.parseInt(txtRemain.getText().trim());
        
//        
        Rem=txtRemark.getText().trim();         
//       
                 
                try
                {
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
                   String sql=("update addstudent set stdname=?,stdcontact=?,pcontact=?,class=?,subject=?,address=?,total=?,feespaid=?,feesremaining=?,remark=? where id=?");
                   PreparedStatement smt=con.prepareStatement(sql);
                   smt.setString(1,Sfullname);
//                   smt.setString(2,mydob);
//                   smt.setString(3,admitionDate);
                   smt.setString(2,Scontact);
                   smt.setString(3,Pcontact);
//                   stdClass=cmbClass.getSelectedItem().toString();
                   smt.setString(4,stdClass);
//                   if(chbPhysics.isSelected())
//                   {
//                       Subject+=chbPhysics.getText()+",";
//                   }
//                   if(chbChemistry.isSelected())
//                   {
//                       Subject+=chbChemistry.getText()+",";
//                   }
//                   if(chbBiology.isSelected())
//                   {
//                       Subject+=chbBiology.getText()+",";
//                   }
//                   if(chbMaths.isSelected())
//                   {
//                       Subject+=chbMaths.getText()+",";
//                   }
                   smt.setString(5,Subject);
                   smt.setString(6,Addr);
                   smt.setInt(7,Total);
                   smt.setInt(8,paid);
                   smt.setInt(9,remain);                 
                   
                   smt.setString(10,Rem);                   
                   smt.setInt(11,Id); 
                   
                   
                   int i=smt.executeUpdate();
                   if(i>0)
                   {
                    JOptionPane.showMessageDialog(this,"record updated sucessfully");
                    clearTable();
                    settable();
//                    clearTable();
                    clear();
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
 
          PreparedStatement pst=con.prepareStatement("select id,stdname,stddob,admdate,stdcontact,pcontact,class,subject,address,total,feespaid,feesremaining,remark from addstudent");
          ResultSet rs=pst.executeQuery();
          while(rs.next())
          {
              int sid=rs.getInt(1);
              String SName=rs.getString(2);
              String dob=rs.getString(3); 
              String admd=rs.getString(4);
              String scontact=rs.getString(5); 
              String pcontact=rs.getString(6);
              String cls=rs.getString(7);
              String sub=rs.getString(8);
              String addres=rs.getString(9);
              int total=rs.getInt(10);
              int paide=rs.getInt(11);
              int remaine=rs.getInt(12);              
              String remark=rs.getString(13);
              
              Object[] obj={sid,SName,dob,admd,scontact,pcontact,cls,sub,addres,total,paide,remaine,remark};
              model=(DefaultTableModel)tbl.getModel();
              model.addRow(obj);
          }  
        }
//        Cid,stdName,stddob,admdate,stdcontact,pcontact,stdclass,subjects,add,Total,paideee,remaineee,remark
        catch(Exception e)
        {
         e.printStackTrace();
        }
         
    }
    void GetReaming()
      {
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root","");                   
//            st=con.createStatement();
            Total=Integer.parseInt(txtFinal.getText());
            paid=Integer.parseInt(txtPaid.getText());
            int ttl=Total-paid;
                    txtRemain.setText(Integer.toString(ttl));
          }
          catch(Exception e)
        {
           // JOptionPane.showMessageDialog(null,e);
        }
      
      }
    void getTotal()
      {
          int Total1=0;
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
          
      }
//     void search()
//    {
//        try 
//        {
//          Class.forName("com.mysql.cj.jdbc.Driver");
//          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/coachingclass","root",""); 
//          PreparedStatement pst=con.prepareStatement("select * from addstudent");
//          ResultSet rs=pst.executeQuery();
//          while(rs.next())
//          {
//              int Cid=rs.getInt("id");
//              String stdName=rs.getString("stdname");
//              String stddob=rs.getString("stddob");
//              String admdate=rs.getString("admdate");
//              String stdcontact=rs.getString("stdcontact");
//              String pcontact=rs.getString("pcontact");
//            
//              String stdclass=rs.getString("class");
//              String subjects=rs.getString("subject");
//               String add=rs.getString("address");    
//              int Total=rs.getInt("total");
//               int paideee=rs.getInt("feespaid");
//                int remaineee=rs.getInt("feesremaining");
//                        
//              String remark=rs.getString("remark"); 
//              
//              Object[] obj={Cid,stdName,stddob,admdate,stdcontact,pcontact,stdclass,subjects,add,Total,paideee,remaineee,remark};
//              model1=(DefaultTableModel)tbl.getModel();
//              model1.addRow(obj);
//          }  
//        }
//        catch(Exception e)
//        {
//         e.printStackTrace();
//        }
//     }
    
    
   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtStdName = new javax.swing.JTextField();
        stdId5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        stdId1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        stdId13 = new javax.swing.JLabel();
        stdId2 = new javax.swing.JLabel();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        stdId4 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtRemark = new javax.swing.JTextArea();
        stdId6 = new javax.swing.JLabel();
        txtStdContact1 = new javax.swing.JTextField();
        txtParentContact = new javax.swing.JTextField();
        stdId7 = new javax.swing.JLabel();
        stdId8 = new javax.swing.JLabel();
        cmbClass = new javax.swing.JComboBox<>();
        stdId11 = new javax.swing.JLabel();
        chbPhysics = new javax.swing.JCheckBox();
        lblPhy = new javax.swing.JLabel();
        chbChemistry = new javax.swing.JCheckBox();
        lblChemi = new javax.swing.JLabel();
        chbMaths = new javax.swing.JCheckBox();
        lblMaths = new javax.swing.JLabel();
        chbBiology = new javax.swing.JCheckBox();
        lblBio = new javax.swing.JLabel();
        stdId14 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        stdId15 = new javax.swing.JLabel();
        txtPaid = new javax.swing.JTextField();
        stdId12 = new javax.swing.JLabel();
        txtRemain = new javax.swing.JTextField();
        stdId17 = new javax.swing.JLabel();
        stdId18 = new javax.swing.JLabel();
        txtDisc = new javax.swing.JTextField();
        txtFinal = new javax.swing.JTextField();
        stdId16 = new javax.swing.JLabel();
        Home = new javax.swing.JButton();
        Clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtStdName.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        txtStdName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStdNameActionPerformed(evt);
            }
        });
        txtStdName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStdNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStdNameKeyTyped(evt);
            }
        });
        getContentPane().add(txtStdName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 370, 40));

        stdId5.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        stdId5.setForeground(new java.awt.Color(51, 51, 51));
        stdId5.setText("Student Name:");
        getContentPane().add(stdId5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 240, 30));

        tbl.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Std Id", "Std Name", "Std DOB", "Admition Date", "Std Contact", "Parent Contact", "Class", "Subject", "Address", "Total", "Fees paid", "Fees Remain", "Remark"
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

    getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 1250, 700));

    stdId1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
    stdId1.setForeground(new java.awt.Color(51, 51, 51));
    stdId1.setText("Search By Student Id:");
    getContentPane().add(stdId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 210, 30));

    txtId.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
    txtId.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    txtId.setToolTipText("");
    txtId.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            txtIdFocusLost(evt);
        }
    });
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
    getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 280, 40));

    stdId13.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
    stdId13.setForeground(new java.awt.Color(51, 51, 51));
    stdId13.setText("Address:");
    getContentPane().add(stdId13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 770, 140, 30));

    stdId2.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
    stdId2.setForeground(new java.awt.Color(51, 51, 51));
    stdId2.setText("Remark:");
    getContentPane().add(stdId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 910, 140, 30));

    Update.setBackground(new java.awt.Color(153, 204, 255));
    Update.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 25)); // NOI18N
    Update.setText("Update");
    Update.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            UpdateActionPerformed(evt);
        }
    });
    getContentPane().add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 180, 130, 50));

    Delete.setBackground(new java.awt.Color(153, 204, 255));
    Delete.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 25)); // NOI18N
    Delete.setText("Delete");
    Delete.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            DeleteActionPerformed(evt);
        }
    });
    getContentPane().add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 180, 110, 50));

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    stdId4.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
    stdId4.setForeground(new java.awt.Color(51, 51, 51));
    stdId4.setText("Search Student : ");
    jPanel1.add(stdId4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 110, 160, 40));

    txtSearch.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
    txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            txtSearchFocusLost(evt);
        }
    });
    txtSearch.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtSearchActionPerformed(evt);
        }
    });
    txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txtSearchKeyReleased(evt);
        }
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtSearchKeyTyped(evt);
        }
    });
    jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 110, 430, 40));

    jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 48)); // NOI18N
    jLabel9.setText("Update Std Record");
    jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 51), new java.awt.Color(51, 255, 51), new java.awt.Color(255, 0, 255), java.awt.Color.black));
    jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 430, -1));

    jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
    jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 480, 30));

    txtAddress.setColumns(20);
    txtAddress.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
    txtAddress.setRows(5);
    jScrollPane2.setViewportView(txtAddress);

    jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 750, 300, 120));

    txtRemark.setColumns(20);
    txtRemark.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
    txtRemark.setRows(5);
    jScrollPane3.setViewportView(txtRemark);

    jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 880, 300, 100));

    stdId6.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
    stdId6.setForeground(new java.awt.Color(51, 51, 51));
    stdId6.setText("Student Contact Number:");
    jPanel1.add(stdId6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 250, 30));

    txtStdContact1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
    txtStdContact1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    txtStdContact1.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txtStdContact1KeyPressed(evt);
        }
    });
    jPanel1.add(txtStdContact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 300, 40));

    txtParentContact.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
    txtParentContact.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    txtParentContact.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txtParentContactKeyPressed(evt);
        }
    });
    jPanel1.add(txtParentContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 300, 40));

    stdId7.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
    stdId7.setForeground(new java.awt.Color(51, 51, 51));
    stdId7.setText("Parent Contact Number:");
    jPanel1.add(stdId7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 220, 30));

    stdId8.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
    stdId8.setForeground(new java.awt.Color(51, 51, 51));
    stdId8.setText("Class:");
    jPanel1.add(stdId8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 140, 30));

    cmbClass.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
    cmbClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select ", "11th", "12th" }));
    jPanel1.add(cmbClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 190, 40));

    stdId11.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
    stdId11.setForeground(new java.awt.Color(51, 51, 51));
    stdId11.setText("Subject:");
    jPanel1.add(stdId11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 140, 30));

    chbPhysics.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
    chbPhysics.setText(" Physics ");
    chbPhysics.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chbPhysicsActionPerformed(evt);
        }
    });
    jPanel1.add(chbPhysics, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 100, 50));
    jPanel1.add(lblPhy, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 60, 20));

    chbChemistry.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
    chbChemistry.setText(" Chemistry");
    chbChemistry.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chbChemistryActionPerformed(evt);
        }
    });
    jPanel1.add(chbChemistry, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, 120, 50));
    jPanel1.add(lblChemi, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 60, 20));

    chbMaths.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
    chbMaths.setText(" Maths");
    chbMaths.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chbMathsActionPerformed(evt);
        }
    });
    jPanel1.add(chbMaths, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 100, 50));
    jPanel1.add(lblMaths, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 440, 60, 20));

    chbBiology.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
    chbBiology.setText("  Biology");
    chbBiology.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chbBiologyActionPerformed(evt);
        }
    });
    jPanel1.add(chbBiology, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 100, 50));
    jPanel1.add(lblBio, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, 70, 20));

    stdId14.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
    stdId14.setForeground(new java.awt.Color(51, 51, 51));
    stdId14.setText("Total fees:");
    jPanel1.add(stdId14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 220, 30));

    txtTotal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
    txtTotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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
    jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, 140, -1));

    stdId15.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
    stdId15.setForeground(new java.awt.Color(51, 51, 51));
    stdId15.setText("Paid Fees:");
    jPanel1.add(stdId15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 660, 140, 30));

    txtPaid.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
    txtPaid.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    txtPaid.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            txtPaidFocusLost(evt);
        }
    });
    txtPaid.addInputMethodListener(new java.awt.event.InputMethodListener() {
        public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            txtPaidCaretPositionChanged(evt);
        }
        public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
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
    jPanel1.add(txtPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 650, 140, 30));

    stdId12.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
    stdId12.setForeground(new java.awt.Color(51, 51, 51));
    stdId12.setText("Remaining Fees:");
    jPanel1.add(stdId12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 710, 160, 30));

    txtRemain.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
    txtRemain.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    txtRemain.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            txtRemainFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            txtRemainFocusLost(evt);
        }
    });
    txtRemain.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtRemainActionPerformed(evt);
        }
    });
    txtRemain.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txtRemainKeyPressed(evt);
        }
    });
    jPanel1.add(txtRemain, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 710, 140, 30));

    stdId17.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
    stdId17.setForeground(new java.awt.Color(51, 51, 51));
    stdId17.setText("Discount:");
    jPanel1.add(stdId17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 100, 30));

    stdId18.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
    stdId18.setForeground(new java.awt.Color(51, 51, 51));
    stdId18.setText("Final Fees:");
    jPanel1.add(stdId18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 140, 30));

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
    jPanel1.add(txtDisc, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 550, 140, 30));

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
    jPanel1.add(txtFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 600, 140, 30));

    stdId16.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
    stdId16.setForeground(new java.awt.Color(51, 51, 51));
    stdId16.setText("%");
    jPanel1.add(stdId16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 550, 40, -1));

    Home.setBackground(new java.awt.Color(153, 204, 255));
    Home.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 25)); // NOI18N
    Home.setText("Home");
    Home.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            HomeActionPerformed(evt);
        }
    });
    jPanel1.add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(1760, 180, 110, 50));

    Clear.setBackground(new java.awt.Color(153, 204, 255));
    Clear.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 25)); // NOI18N
    Clear.setText("Clear");
    Clear.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ClearActionPerformed(evt);
        }
    });
    jPanel1.add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 180, 110, 50));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1916, 1000));

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtStdNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStdNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStdNameActionPerformed

    private void txtStdNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStdNameKeyReleased
        // TODO add your handling code here:
        

    }//GEN-LAST:event_txtStdNameKeyReleased

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtParentContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParentContactKeyPressed
        // TODO add your handling code here:
        String number=txtParentContact.getText();
        int length=number.length();
        char c=evt.getKeyChar();
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
        {
            if(length<10)
            {
                txtParentContact.setEditable(true);
            }
            else
            {
                txtParentContact.setEditable(false);
            }
        }else{
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                txtParentContact.setEditable(true);
            }
            else
            {
                txtParentContact.setEditable(false);
            }
        }

       
    }//GEN-LAST:event_txtParentContactKeyPressed

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
               lblBio.setText(rs.getString(1));
               
            }        
           } 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Select Subject");
        }
    }
        else
        {
            lblBio.setText("");
        }
    }//GEN-LAST:event_chbBiologyActionPerformed

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
               lblChemi.setText(rs.getString(1));
              
            }        
           } 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Select Subject");
        }
    }
       else{
           lblChemi.setText("");
       }
    }//GEN-LAST:event_chbChemistryActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

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
//                
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
    }//GEN-LAST:event_txtTotalKeyPressed

    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_txtIdKeyReleased

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
//        try {
//            // TODO add your handling code here:
//            DefaultTableModel model=(DefaultTableModel)tbl.getModel();
//            int rowNo=tbl.getSelectedRow();
//            // TableModel model=RecordTable.getModel();
//            //txtCid.setText(model.getValueAt(rowNo,0).toString());
//            txtId.setText((String) model.getValueAt(rowNo,0).toString());
//            txtStdName.setText((String) model.getValueAt(rowNo,1));
//            Date date=new SimpleDateFormat("dd-MM-yyyy").parse((String)model.getValueAt(rowNo,2));
//            txtdob.setDate(date);
//            Date date2=new SimpleDateFormat("dd-MM-yyyy").parse((String)model.getValueAt(rowNo,3));
//            admDate.setDate(date2);
//            txtStdContact1.setText((String) model.getValueAt(rowNo,4).toString());
//            txtParentContact.setText((String) model.getValueAt(rowNo,5));
//            String cls=model.getValueAt(rowNo,6).toString();
//            switch(cls)
//            {
//                case"11th":
//                    cmbClass.setSelectedIndex(1);
//                    break;
//                case"12th":
//                    cmbClass.setSelectedIndex(2);
//                    break;
//            }
//            
////           
//            String subject=model.getValueAt(rowNo,7).toString();
//            
//            switch(subject)
//            {
//                case "Physics":
//                    chbPhysics.setSelected(true);
//                    chbChemistry.setSelected(false);
//                    chbBiology.setSelected(false);
//                    chbMaths.setSelected(false);
//                    break;
//                case "Chemistry":
//                    chbChemistry.setSelected(true);
//                    chbPhysics.setSelected(false);                    
//                    chbBiology.setSelected(false);
//                    chbMaths.setSelected(false);
//                    break;
//                case "Biology":
//                    chbBiology.setSelected(true);
//                    chbPhysics.setSelected(false);
//                    chbChemistry.setSelected(false);                    
//                    chbMaths.setSelected(false);                    
//                    break;
//                case "Maths":
//                    chbMaths.setSelected(true);
//                    chbPhysics.setSelected(false);
//                    chbChemistry.setSelected(false);
//                    chbBiology.setSelected(false);                    
//                    break;
//                default:
//                   chbPhysics.setSelected(true);
//                    chbChemistry.setSelected(true);
//                    chbBiology.setSelected(true);
//                    chbMaths.setSelected(true);
//                    break;
//                    
//            }
//            txtAddress.setText((String) model.getValueAt(rowNo,8));
//            txtTotal.setText((String) model.getValueAt(rowNo,9).toString());
//            
//            txtPaid.setText((String) model.getValueAt(rowNo,10).toString());
//            txtRemain.setText((String) model.getValueAt(rowNo,11).toString());       
//            txtRemark.setText((String) model.getValueAt(rowNo,12).toString());
//        } catch (ParseException ex) {
//            Logger.getLogger(UpdateStdRec.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
    }//GEN-LAST:event_tblMouseClicked

    private void txtStdContact1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStdContact1KeyPressed
        // TODO add your handling code here:
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

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
//         String str=txtStdName.getText();
//        searchString(str);
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel(); 
        TableRowSorter<DefaultTableModel> obj2=new TableRowSorter<>(tblModel);
        tbl.setRowSorter(obj2);
        obj2.setRowFilter (RowFilter.regexFilter (txtSearch.getText()));
        

    }//GEN-LAST:event_txtSearchKeyReleased

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
       // para();
       if(Validation2())
       {
       update();
//       getfeesValueAsText();
       }
             
        
    }//GEN-LAST:event_UpdateActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        if(txtId.getText().isEmpty())
       {
           JOptionPane.showMessageDialog(this,"Please Enter Student Id To Delete Student Data");
       }
        para();
        delete(Id);

    }//GEN-LAST:event_DeleteActionPerformed

    private void txtRemainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRemainActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemainActionPerformed

    private void txtRemainKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRemainKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtRemainKeyPressed

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

    private void txtRemainFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRemainFocusGained
        // TODO add your handling code here:
        GetReaming();
    }//GEN-LAST:event_txtRemainFocusGained

    private void txtTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusGained
        // TODO add your handling code here:
        txtTotal.setText("");
        getTotal();
        txtTotal.setText(String.valueOf(n));
    }//GEN-LAST:event_txtTotalFocusGained

    private void txtPaidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPaidFocusLost
        // TODO add your handling code here:
        GetReaming();
    }//GEN-LAST:event_txtPaidFocusLost

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
      // TODO add your handling code here:
      
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtSearchKeyTyped

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
       autoCustname1();
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost
        // TODO add your handling code here:
//        autoCustname1();
        
    }//GEN-LAST:event_txtIdFocusLost

    private void txtRemainFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRemainFocusLost
        // TODO add your handling code here:
        GetReaming();
    }//GEN-LAST:event_txtRemainFocusLost

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
               lblPhy.setText(rs.getString(1));
            
            }        
           } 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Select Subject");
        }
       }
       else{
           lblPhy.setText("");
       }
    }//GEN-LAST:event_chbPhysicsActionPerformed

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
               lblMaths.setText(rs.getString(1));
               
            }        
           } 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Select Subject");
        }
    }
        else{
            lblMaths.setText("");
        }
    }//GEN-LAST:event_chbMathsActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
        Home1 hm=new Home1();
        hm.setVisible(true);
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

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_ClearActionPerformed

    private void txtPaidCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtPaidCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaidCaretPositionChanged

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
            java.util.logging.Logger.getLogger(UpdateStdRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateStdRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateStdRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateStdRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateStdRec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Home;
    private javax.swing.JButton Update;
    private javax.swing.JCheckBox chbBiology;
    private javax.swing.JCheckBox chbChemistry;
    private javax.swing.JCheckBox chbMaths;
    private javax.swing.JCheckBox chbPhysics;
    private javax.swing.JComboBox<String> cmbClass;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBio;
    private javax.swing.JLabel lblChemi;
    private javax.swing.JLabel lblMaths;
    private javax.swing.JLabel lblPhy;
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
    private javax.swing.JLabel stdId4;
    private javax.swing.JLabel stdId5;
    private javax.swing.JLabel stdId6;
    private javax.swing.JLabel stdId7;
    private javax.swing.JLabel stdId8;
    private javax.swing.JTable tbl;
    private javax.swing.JTextArea txtAddress;
    public javax.swing.JTextField txtDisc;
    public javax.swing.JTextField txtFinal;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtParentContact;
    private javax.swing.JTextField txtRemain;
    private javax.swing.JTextArea txtRemark;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStdContact1;
    private javax.swing.JTextField txtStdName;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
