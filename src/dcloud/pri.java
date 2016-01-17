
package dcloud;
import java.io.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class pri extends javax.swing.JFrame {
public static String name=user.name;
public static String id=user.id;
public static int c,i,a,cr;
public static String rin;
    
    public pri() {
        initComponents();

          jTextField1.setText(name);
           jTextField2.setText(id);
    }

      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(540, 540));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 13));
        jLabel2.setText("Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 120, 150, 40);

        jTextField1.setFont(new java.awt.Font("Verdana", 1, 13));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(210, 120, 130, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 13));
        jLabel3.setText("Id");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 190, 90, 17);

        jTextField2.setFont(new java.awt.Font("Verdana", 1, 13));
        getContentPane().add(jTextField2);
        jTextField2.setBounds(210, 180, 130, 30);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 13));
        jLabel4.setText("Confidentiality Value");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 250, 170, 30);

        jTextField3.setFont(new java.awt.Font("Verdana", 1, 13));
        getContentPane().add(jTextField3);
        jTextField3.setBounds(210, 250, 130, 30);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 13));
        jLabel5.setText("Integrity Value");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 320, 160, 20);

        jTextField4.setFont(new java.awt.Font("Verdana", 1, 13));
        getContentPane().add(jTextField4);
        jTextField4.setBounds(210, 320, 130, 30);

        jTextField5.setFont(new java.awt.Font("Verdana", 1, 13));
        getContentPane().add(jTextField5);
        jTextField5.setBounds(209, 380, 130, 30);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 13));
        jLabel6.setText("Availabilty value");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 390, 150, 20);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 13));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(210, 450, 90, 40);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 13));
        jButton2.setText("Process");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(330, 450, 110, 40);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dcloud/img/pri.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 540, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

         try
        {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ac","root","");
            PreparedStatement ps=con.prepareStatement("insert into pri values(?,?,?,?,?,?)");

         

            c=Integer.parseInt(jTextField3.getText());
            i=Integer.parseInt(jTextField4.getText());
            a=Integer.parseInt(jTextField5.getText());

             cr=(c+(1/a)*10)/2;

        System.out.println("Critical rating is:  "+cr);

        if(cr>0 && cr<=20)
        {
            rin="third";
        }
        else if(cr>20 && cr<=35)
        {
            rin="second";
        }

        else if(cr>35 && cr<70)
        {
            rin="first";
        }




ps.setString(1, id);
ps.setString(2, name);
ps.setInt(3, c);
ps.setInt(4, i);
ps.setInt(5, a);
ps.setString(6, rin);

ps.executeUpdate();

ps.close();
JOptionPane.showMessageDialog(null, "Updated");



        }catch(Exception e){

        System.out.println(e.getMessage());

        }




    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

       
        ring nn=new ring();
        nn.setVisible(true);


    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

}
