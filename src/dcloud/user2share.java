/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * user2share.java
 *
 * Created on Mar 7, 2011, 10:48:31 AM
 */

package dcloud;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class user2share extends javax.swing.JFrame {
public static String m,f;
int i,j;
public static String db,tab;
ServerSocket ss;
Socket s;
public static String use;
    /** Creates new form user2share */
    public user2share() {
        initComponents();

            try
        {

  Class.forName("com.mysql.jdbc.Driver");
  Connection c =  DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");

Statement n;
n=c.createStatement();
ResultSet rss=n.executeQuery("show databases");
while(rss.next())
{

jComboBox1.addItem(rss.getString(1));
    }
        }catch(Exception e){}


    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(519, 507));
        getContentPane().setLayout(null);

        jComboBox1.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox1.setFont(new java.awt.Font("Maiandra GD", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "User 2 Share" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(142, 140, 180, 31);

        jComboBox2.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox2.setFont(new java.awt.Font("Maiandra GD", 1, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ring", "first", "second", "third" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(142, 200, 180, 28);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dcloud/img/processbut.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 360, 160, 70);

        jComboBox3.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox3.setFont(new java.awt.Font("Maiandra GD", 1, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Listed Files" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(142, 270, 180, 32);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton2.setText("Server Initialize");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(340, 80, 160, 40);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dcloud/img/user2share.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 520, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try
{
    f =jComboBox3.getSelectedItem().toString();

    int count=jComboBox3.getItemCount();
    System.out.println(count);

    if(count>=2)
    {
 accverify ll=new accverify();
        ll.main(null);
  }
    else
    {
        JOptionPane.showMessageDialog(null,"No files in the selected Access Level");
    }



}catch(Exception e){

System.out.println(e.getMessage());
        }



       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:

         int count=jComboBox3.getItemCount();
        try
        {

             db=jComboBox1.getSelectedItem().toString();
             tab=jComboBox2.getSelectedItem().toString();

             System.out.println("Database is:"+db);
             System.out.println("Table is:"+tab);

            Class.forName("com.mysql.jdbc.Driver");
            Connection c =  DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db+"","root","");
            Statement s;
            s=c.createStatement();
            ResultSet rs=s.executeQuery("select fname from "+tab+"");
            while(rs.next())
            {

             jComboBox3.addItem(rs.getString(1));
            }

int j=1;
            for(i=1;i<count;i++)
            {
                jComboBox3.removeItemAt(j);
            }
c.close();
        }catch(Exception e){}
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:

       

    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try
        {


        ss=new ServerSocket(3000);
         JOptionPane.showMessageDialog(null, "Server Listening");
        s=ss.accept();
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
       // JOptionPane.showMessageDialog(null, "Server Started");
        use=br.readLine();
System.out.println("User in user2share is:"+use);

        }catch(Exception e){
        System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user2share().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
