/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * accverify.java
 *
 * Created on Mar 7, 2011, 7:05:56 PM
 */

package dcloud;
import java.io.*;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author admin
 */
public class accverify extends javax.swing.JFrame {
public static String ss=user2share.use;
public static String ss1=user2share.db;
     public static String ss2=user2share.tab;
      public static String ss4=user2share.f;
    /** Creates new form accverify */
    public accverify() {
        initComponents();

         jLabel2.setText(ss);
        jLabel3.setText(ss1);
         jLabel4.setText(ss2);
          jLabel5.setText(ss4);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(536, 505));
        getContentPane().setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dcloud/img/verifybut.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(170, 410, 150, 60);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 90, 130, 40);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 150, 140, 50);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 220, 130, 60);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(190, 290, 120, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dcloud/img/accverify.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 540, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:


        try
        {

        if(ss2.equals("first"))
        {
            System.out.println("FirstLevelAccess");
            if(ss.equals(ss1))
            {
                String kk=null;
                String kr=null;
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ac2","root","");
                Statement st;
                st=cn.createStatement();
                ResultSet rs=st.executeQuery("select * from temp where user = '"+ss1+"'");

                 while(rs.next())
                  {
                    kk=rs.getString(2);
                    kr=rs.getString(4);
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(4));

                  }

            if(ss2.equals(kk)&& ss4.equals(kr))

             {
                JOptionPane.showMessageDialog(null, "have  access to selected file");
userrequest rea=new userrequest();
rea.setVisible(true);
             }
//           else
//             {
//                JOptionPane.showMessageDialog(null,  " c level have  not access to selected file");
//             }

            }
        else
        {
                JOptionPane.showMessageDialog(null, "have not access to c level selected file");
        }
      }

        if(ss2.equals("second")||ss2.equals("third"))
        {
             System.out.println("not Ring1");
             String kk=null;
             String kr=null;
             Class.forName("com.mysql.jdbc.Driver");
             Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ac2","root","");
             Statement st;
             st=cn.createStatement();
             ResultSet rs=st.executeQuery("select * from temp where user = '"+ss1+"'");
             while(rs.next())
              {
                kk=rs.getString(2);
                kr=rs.getString(4);
                System.out.println("kk:"+kk);
                System.out.println("kr:"+kr);






              }
System.out.println("ss2:"+ss2);
                System.out.println("ss3:"+ss4);

if((kk.equals(ss2) && kr.equals(ss4)))
JOptionPane.showMessageDialog(null, "Granted");
userrequest rea=new userrequest();
rea.setVisible(true);


        }
        }
     catch(Exception e)
        {

         System.out.println(e.getMessage());

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new accverify().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

}