import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
public class AppointmentRecordView extends Frame
{
Button b;
public AppointmentRecordView()
{
super("AppointmentRecordView");
setSize(1024,720);
setVisible(true);
setLayout(null);
setBackground(Color.gray);
b=new Button("Back");
b.setBounds(900,50,100,30);
add(b);
b.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent event) {setVisible(false);}});
addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e){setVisible(false);}});
}
public void paint(Graphics g)
{
Connection c=null;      
Statement s=null;   
ResultSet rs=null; 
try
{
int i=30,j=100;
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
c=DriverManager.getConnection("jdbc:odbc:patientdbms");
s=c.createStatement();  
rs=s.executeQuery("select * from appointment");    
Font fo=new Font("Times New Roman",Font.BOLD,18);
g.setFont(fo);  
g.drawString("APPOINTMENT DETAILS",50,50);
while(rs.next()) 
{    
String did=rs.getString("did");
String dname=rs.getString("dname");
String pid=rs.getString("pid");
String pname=rs.getString("pname");
String date=rs.getString("adate");
String time=rs.getString("atime");
String aid=rs.getString("aid");
g.drawString("Record ID:"+aid,i,j);
g.drawString("Patient ID "+pid+"  Patient Name: "+pname,i,j+19);
g.drawString("Doctor ID "+did+"  Doctor Name: "+dname,i,j+38);
g.drawString("Date :"+date+"    Time :"+time,i,j+54);
j=j+80;
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