import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
public class AppointmentInformationD extends Frame
{
String ANumber;
Button bsub;
AppointmentInformationD()
{
super("Delete Appointment Information");
ANumber = JOptionPane.showInputDialog ("Enter Appointment Number to Delete"); 
if(ANumber!=null)
function();
}
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
int k=s.executeUpdate("delete  * from appointment where aid='"+ANumber+"'");
if(k!=0)                     
{
JOptionPane.showMessageDialog(null,"Appointment Details Deleted Successfully!!!","Message",JOptionPane.INFORMATION_MESSAGE);
setVisible(false);
}
if(k==0)
{
JOptionPane.showMessageDialog(null,"Appointment Not Found!!!!","Message",JOptionPane.INFORMATION_MESSAGE);
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