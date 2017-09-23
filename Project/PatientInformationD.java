import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
public class PatientInformationD extends Frame
{
String PNumber;
Button bsub;
PatientInformationD()
{
super("Delete Patient Information");
PNumber = JOptionPane.showInputDialog ( "Enter Patient Number to Delete" ); 
if(PNumber!=null)
function();
}
/*fuction method will connect to ODBC
and it will search the Database and delete that particular record*/
public void function()
{
Connection c=null;   
Statement s=null;
ResultSet rs=null; 
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
c=DriverManager.getConnection("jdbc:odbc:patientdbms");
s=c.createStatement();  
int k=s.executeUpdate("delete  * from patient where pid='"+PNumber+"'");
if(k!=0)                     
{
JOptionPane.showMessageDialog(null,"Patient Details Deleted Successfully!!!","Message",JOptionPane.INFORMATION_MESSAGE);
setVisible(false);
}
if(k==0)
{
JOptionPane.showMessageDialog(null,"Patient Not Found!!!!","Message",JOptionPane.INFORMATION_MESSAGE);
setVisible(false);
}
rs.close();
s.close();
c.close();
}
catch(Exception e)
{
System.out.println("exception seriliazation"+ e);
}
}
}