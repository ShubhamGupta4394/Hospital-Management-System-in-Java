import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
public class DoctorRecordView extends Frame
{

Button b;
public DoctorRecordView()
{
super("DoctorRecordView");
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
String name,dadd,dcno,spe,id;
Connection c=null;      
Statement s=null;   
ResultSet rs=null; 
//setForeground(Color.green);
try
{
//String PNumber;
//int number;
int i=30,j=100;
//PNumber = JOptionPane.showInputDialog ( "Enter patient no" ); 
//number= Integer.parseInt ( PNumber); 
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
c=DriverManager.getConnection("jdbc:odbc:patientdbms");
s=c.createStatement();  
rs=s.executeQuery("select * from doctor");    
Font fo=new Font("Times New Roman",Font.BOLD,18);
g.setFont(fo);  
g.drawString("DOCTOR'S DETAILS",50,50);
int count=0;;
while(rs.next()) 
{    
count++;
name=rs.getString("dname");
dadd=rs.getString("dadd");
dcno=rs.getString("dcno");
spe=rs.getString("dspe");
id=rs.getString("did");   
g.drawString("Record:"+count,i,j);
g.drawString("Doctor ID "+id+"    Name: "+name,i,j+19);
g.drawString("Address:"+dadd+"    Contact NO:"+dcno+"    Specialization:"+spe,i,j+38);

j=j+65;
//count++;
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