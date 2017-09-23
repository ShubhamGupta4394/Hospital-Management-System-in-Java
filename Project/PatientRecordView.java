import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
public class PatientRecordView extends Frame
{
int l;
String pc;
String name1,add,pcn,his1,chis1,dob1,bg,gender,id;
Button b;
public PatientRecordView()
{
super("PatientRecordView");
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
rs=s.executeQuery("select * from patient");    
Font fo=new Font("Times New Roman",Font.BOLD,18);
//setForeground(Color.green);
g.setFont(fo);  
g.drawString("PATIENTS DETAILS",50,50);
int count=1;
while(rs.next()) 
{    
name1=rs.getString("name");
add=rs.getString("add");
pcn=rs.getString("CN");
his1=rs.getString("his");
chis1=rs.getString("chis");
dob1=rs.getString("DOB");
gender=rs.getString("Gender");
bg=rs.getString("BG"); 
id=rs.getString("pid");   
g.drawString("Record "+count,i,j);
g.drawString("Patient ID "+id+" Name: "+name1+" Address:"+add,i,j+19);
g.drawString("Contact NO: "+pcn+" Gender:"+gender+" DOB:"+dob1,i,j+38);
g.drawString("Blood Group:"+bg+" Problem:"+his1+" Current Problem:"+chis1,i,j+57);
j=j+80;
count++;
}     
 rs.close();  
 s.close();
 c.close(); 
}
catch(Exception e)
{
System.out.println("exception seriliazation"+ e);//Disply the exception if there is any exception occur in connecting Data base
}




}
}
