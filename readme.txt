Software Installations(These softwares has to be installed both in client and server machine) 
******************
1)Install the Jdk

2)Install the NetBeans

3)Install the mysql-essential-5.1.50-win32

3)Install the WampServer

4)Install the VMware 

5)Install the Windows 7 professional in Vmware


Procedure to run the project
***********************
1)In After the installation of Wamp Server,create database named "3d",
then import the sql file named "3d.sql" and also create databases named "ac" and import the sql files respectively

2)After  the installation of NetBeans,open the project named "3dCloud"

extract the library package and then rightclick give "AddJarfolder" and select "mysql-connector-java-5.0.7" file in harddisk

Then extract source package then run  the home.java file(Main File)
[For run,right click and give run file]


3)Running procedure will be explained in screenshots

Note:


For having Cloud setup,u have run the  serverpage in VMware machine


IpConfigurations and database setup  for cloud 
***************************************
1)In the upload.java and retrievereq.java files   GO to the coding part,  

Change "localhost" to "Server(in VMWARE machine) IPaddress"

2)In wampserver(in serverside),create database named "ac2",then import the sql file named "ac2.sql"


