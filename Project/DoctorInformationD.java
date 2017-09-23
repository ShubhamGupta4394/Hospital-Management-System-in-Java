import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
public class DoctorInformationD extends Frame
{
String DNumber;
Button bsub;
DoctorInformationD()
{
super("Delete Doctor Information");
DNumber = JOptionPane.showInputDialog ("Enter Doctor Number to Delete"); 
if(DNumber!=null)
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
int k=s.executeUpdate("delete  * from doctor where did='"+DNumber+"'");
if(k!=0)                     
{
JOptionPane.showMessageDialog(null,"Doctor Details Deleted Successfully!!!","Message",JOptionPane.INFORMATION_MESSAGE);
setVisible(false);
}
if(k==0)
{
JOptionPane.showMessageDialog(null,"Doctor Not Found!!!!","Message",JOptionPane.INFORMATION_MESSAGE);
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