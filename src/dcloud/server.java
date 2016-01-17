

package dcloud;
import java.net.*;
import java.sql.*;
import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import java.math.BigInteger;
import java.security.MessageDigest;
/**
 *
 * @author admin
 */
public class server extends javax.swing.JFrame {
    public static String o1;
  public static String cip="d:\\enc.txt";

public static String fnam;
Socket sock,sc;
 ServerSocket ss,src;
 BufferedInputStream bis;
    BufferedOutputStream bos;
    byte[] data;
   int in, y;
    BufferedReader inm = null;
    PrintWriter outm = null;
    String path="c:\\rec.txt";
      String l=enc.in;

  public static String aa,bb,en;
    /** Creates new form server */
    public server() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(508, 517));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton4.setText("Server Initialize");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(330, 70, 170, 50);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("User");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 160, 100, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("Ring");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 230, 70, 30);

        jTextField1.setFont(new java.awt.Font("Verdana", 1, 12));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(220, 160, 160, 30);

        jTextField2.setFont(new java.awt.Font("Verdana", 1, 12));
        getContentPane().add(jTextField2);
        jTextField2.setBounds(220, 230, 160, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
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
        jButton1.setBounds(130, 330, 220, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dcloud/img/serverpage.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 510, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {

            ss = new ServerSocket(4444);
            System.out.println("i am server & listening...");
            JOptionPane.showMessageDialog(null, "Server Listening");
            sock = ss.accept();
            System.out.println("a client connect");

            try {
                byte[] receivedData = new byte[8192];
                bis = new BufferedInputStream(sock.getInputStream());
                bos = new BufferedOutputStream(new FileOutputStream(path));
                while ((in = bis.read(receivedData)) != -1) {
                    bos.write(receivedData, 0, in);
                }
                bos.close();

                JOptionPane.showMessageDialog(null, "Your File Received in Server Side Successfully");

                ss.close();
                sock.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        try
        {

           src=new ServerSocket(1000);
           sc=src.accept();


          System.out.println("Server Started");

         BufferedReader br=new BufferedReader(new InputStreamReader(sc.getInputStream()));
         aa=br.readLine();
bb=br.readLine();
o1=br.readLine();
fnam=br.readLine();

System.out.println("User in server:"+aa);
System.out.println("Ring in server:"+bb);
System.out.println("FilePath:"+o1);
System.out.println("FileName:"+fnam);

jTextField1.setText(aa);
jTextField2.setText(bb);
sc.close();
src.close();
        }catch(Exception e){

        System.out.println(e.getMessage());
        }

try
{


           Class.forName("com.mysql.jdbc.Driver");
      Connection con1=  DriverManager.getConnection("jdbc:mysql://localhost:3306/ac2","root","");
     PreparedStatement ps=con1.prepareStatement("insert into temp values(?,?,?,?,?)");


    if(bb.equals("first")||bb.equals("second"))
    {
           MessageDigest m=MessageDigest.getInstance("MD5");
           m.update(aa.getBytes(),0,aa.length());
           en=new BigInteger(1,m.digest()).toString(16);
           System.out.println("MD5: "+en);

    }
    else if(bb.equals("third"))
    {
        en="null";
    }





     ps.setString(1, aa);
     ps.setString(2, bb);
     ps.setString(3, o1);
     ps.setString(4, fnam);
     ps.setString(5, en);
     ps.executeUpdate();

}catch(Exception e1){
System.out.println(e1.getMessage());
}



    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       try
        {

           Class.forName("com.mysql.jdbc.Driver");
      Connection c =  DriverManager.getConnection("jdbc:mysql://localhost:3306/"+aa+"","root","");

Statement n;
n=c.createStatement();
ResultSet rss=n.executeQuery("show databases");
int i=2;
while(rss.next())
{

    String e=rss.getString(1);
      System.out.println(e);
    if(e.equals(aa))
    {
         i=1;
        break;
    }
}

if(i==1)
{

       if(bb.equals("third"))
        {
      Class.forName("com.mysql.jdbc.Driver");
        Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+aa+"","root","");
        PreparedStatement ps2=con2.prepareStatement("insert into third values(?,?)");
      ps2.setString(1, fnam);
        File f2=new File(o1);
        FileInputStream fis2=new FileInputStream(f2);

     ps2.setAsciiStream(2, fis2,(int)(f2.length()));
        ps2.executeUpdate();

 }

 if(bb.equals("second"))
        {
   try
   {
System.out.print("Encryption Process");
        File desFile = new File(cip);
     FileInputStream fis = null;
     FileOutputStream fos;
     CipherInputStream cis;

     // Creation of Secret key
     byte key[] = "abcdEFUH".getBytes();
     SecretKeySpec secretKey = new SecretKeySpec(key,"DES");

     // Creation of Cipher objects
    Cipher encrypt = Cipher.getInstance("DES");
    encrypt.init(Cipher.ENCRYPT_MODE, secretKey);

     // Open the Plaintext file
     try {
          fis = new FileInputStream(o1);
     } catch(IOException err) {
          System.out.println("Cannot open file!");
          System.exit(-1);
     }
     cis = new CipherInputStream(fis, encrypt);

     // Write to the Encrypted file
     fos = new FileOutputStream(desFile);
     byte[] b = new byte[8];
     int i1 = cis.read(b);
     while (i1 != -1) {
          fos.write(b, 0, i1);
          i1 = cis.read(b);
     }
     fos.flush();
     fos.close();
     cis.close();
     fis.close();



Class.forName("com.mysql.jdbc.Driver");
        Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+aa+"","root","");
        PreparedStatement ps2=con2.prepareStatement("insert into second values(?,?)");
        ps2.setString(1, fnam);
        File f2=new File(cip);
        FileInputStream fis2=new FileInputStream(f2);

     ps2.setAsciiStream(2, fis2,(int)(f2.length()));
        ps2.executeUpdate();
            }catch(Exception e5){}


BufferedReader br=new BufferedReader(new FileReader(o1));
BufferedWriter bw=new BufferedWriter(new FileWriter("c:\\"+aa+"\\second\\"+fnam+""));

String dd;
while((dd=br.readLine())!=null)
{

    bw.write(dd);
    bw.newLine();

 }
bw.close();






 }
if(bb.equals("first"))
        {
    enc w=new enc();
   w.en();
     Class.forName("com.mysql.jdbc.Driver");
        Connection con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+aa+"","root","");
        PreparedStatement ps3=con3.prepareStatement("insert into first values(?,?)");
        ps3.setString(1, fnam);
        File f3=new File(l);
        FileInputStream fis3=new FileInputStream(f3);

     ps3.setAsciiStream(2, fis3,(int)(f3.length()));
        ps3.executeUpdate();


        BufferedReader br1=new BufferedReader(new FileReader(o1));
BufferedWriter bw1=new BufferedWriter(new FileWriter("c:\\"+aa+"\\first\\"+fnam+""));

String dd;
while((dd=br1.readLine())!=null)
{

    bw1.write(dd);
    bw1.newLine();

 }
bw1.close();


 }
 }
 }




        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("catch block");
             mm n=new mm();
             n.mg();

          if(bb.equals("third"))
        {
              try{

      Class.forName("com.mysql.jdbc.Driver");
        Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+aa+"","root","");
        PreparedStatement ps2=con2.prepareStatement("insert into third values(?,?)");
         ps2.setString(1, fnam);
        File f2=new File(o1);
        FileInputStream fis2=new FileInputStream(f2);

     ps2.setAsciiStream(2, fis2,(int)(f2.length()));
        ps2.executeUpdate();
            }
              catch(Exception e1)
              {
System.out.println(e1.getMessage());
              }

 }

 if(bb.equals("second"))
        {
     try
     {
          enc w=new enc();
   w.en();

      Class.forName("com.mysql.jdbc.Driver");
        Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+aa+"","root","");
        PreparedStatement ps2=con2.prepareStatement("insert into second values(?,?)");
        ps2.setString(1, fnam);
        File f2=new File(l);
        FileInputStream fis2=new FileInputStream(f2);

     ps2.setAsciiStream(2, fis2,(int)(f2.length()));
        ps2.executeUpdate();



     BufferedReader br11=new BufferedReader(new FileReader(o1));
BufferedWriter bw11=new BufferedWriter(new FileWriter("c:\\"+aa+"\\second\\"+fnam+""));

String dd;
while((dd=br11.readLine())!=null)
{

    bw11.write(dd);
    bw11.newLine();

 }
bw11.close();

            }



     catch(Exception e1)
     {
System.out.println(e1.getMessage());
     }






 }
if(bb.equals("first"))
        {
    try
    {
         enc w=new enc();
   w.en();

             Class.forName("com.mysql.jdbc.Driver");
        Connection con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+aa+"","root","");
        PreparedStatement ps3=con3.prepareStatement("insert into first values(?,?)");
      ps3.setString(1, fnam);
        File f3=new File(l);
        FileInputStream fis3=new FileInputStream(f3);

        ps3.setAsciiStream(2, fis3,(int)(f3.length()));
        ps3.executeUpdate();

         BufferedReader br12=new BufferedReader(new FileReader(o1));
BufferedWriter bw12=new BufferedWriter(new FileWriter("c:\\"+aa+"\\first\\"+fnam+""));

String dd;
while((dd=br12.readLine())!=null)
{

    bw12.write(dd);
    bw12.newLine();

 }
bw12.close();


            }
    catch(Exception e1)
    {
System.out.println(e1.getMessage());
    }
        }


        }



    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
class mm
{
   String ss2=server.aa;
void mg()
        {


    try
{
     Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");


          Statement s=con.createStatement();

        s.executeUpdate("create database "+ss2+"");

        File f=new File("c:\\"+ss2);
        if(!f.exists())
        {
            f.mkdir();
            System.out.println("folder creation");
        }

        else
        {
            System.out.println("Directory already Exist");
        }








        jj ob=new jj();
               ob.ac();

 System.out.println("jj called");

}
catch(Exception e)
{
    System.out.println(e.getMessage());


        }
}
}

class jj

{
    String ss1=server.aa;
void ac()
        {


    try
{
    Class.forName("com.mysql.jdbc.Driver");
        Connection con12=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ss1+"","root","");

        Statement ps2=con12.createStatement();
        ps2.executeUpdate("create table third(fname varchar(500) ,file text(30000))");
          ps2.executeUpdate("create table second(fname varchar(500) ,file text(30000))");
           ps2.executeUpdate("create table first(fname varchar(500) ,file text(30000))");



File f=new File("c:\\"+ss1+"\\third");
        if(!f.exists())
        {
            f.mkdir();
        }

        else
        {
            System.out.println("Directory already Exist");
        }


File f1=new File("c:\\"+ss1+"\\second");
        if(!f1.exists())
        {
            f1.mkdir();
        }

        else
        {
            System.out.println("Directory already Exist");
        }

File f2=new File("c:\\"+ss1+"\\first");
        if(!f2.exists())
        {
            f2.mkdir();
        }

        else
        {
            System.out.println("Directory already Exist");
        }






}
catch(Exception e)
{
    System.out.println(e.getMessage());
        }
}
    }


class enc

{
    public static String in="d:\\enc.txt";

void en()
    {
System.out.println("Enc function is called");
    String cc=server.o1;


    try  {
     File desFile = new File(in);
     FileInputStream fis = null;
     FileOutputStream fos;
     CipherInputStream cis;

     // Creation of Secret key
     byte key[] = "abcdEFUH".getBytes();
     SecretKeySpec secretKey = new SecretKeySpec(key,"DES");

     // Creation of Cipher objects
    Cipher encrypt = Cipher.getInstance("DES");
    encrypt.init(Cipher.ENCRYPT_MODE, secretKey);

     // Open the Plaintext file
     try {
          fis = new FileInputStream(cc);
     } catch(IOException err) {
          System.out.println("Cannot open file!");
          System.exit(-1);
     }
     cis = new CipherInputStream(fis, encrypt);

     // Write to the Encrypted file
     fos = new FileOutputStream(desFile);
     byte[] b = new byte[8];
     int i = cis.read(b);
     while (i != -1) {
          fos.write(b, 0, i);
          i = cis.read(b);
     }
     fos.flush();
     fos.close();
     cis.close();
     fis.close();
     } catch(Exception e){
          e.printStackTrace();
     }
}
}
