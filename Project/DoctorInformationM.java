import java.io.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class DoctorInformationM extends Frame 
{
Label lmain,ldi,lname,ladd,ltel,lspecial,ldid,ldspec;
TextField tfname,tftel,tfdid;
TextArea taadd,taspecial;
Button bsub,bclr,bback;
String DNumber;
int count1=0;
DoctorInformationM()
{
super("Modify Doctor Information");
DNumber = JOptionPane.showInputDialog ( "Enter Doctor no to modify" ); 
if(DNumber!=null)
{
Connection c4=null;   
Statement s4=null;
ResultSet rs4=null;
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
c4=DriverManager.getConnection("jdbc:odbc:patientdbms");
s4=c4.createStatement();  
rs4=s4.executeQuery("select * from doctor");  
String getdid;  
while(rs4.next()) 
{    
getdid=rs4.getString("did");
if(getdid.equals(DNumber))
{
count1++;
function();
}
}
rs4.close();
s4.close();
c4.close();
}
catch(Exception e)
{
System.out.println("exception seriliazation"+ e);
} 

}
if(count1==0&& DNumber!=null)
{
JOptionPane.showMessageDialog(null,"Doctor Number not Found!!!","Message",JOptionPane.INFORMATION_MESSAGE);
}
}
public void function()
{
	setBackground(Color.gray);
	setSize(1024,720);
	setVisible(true);
	setLayout(null);

	lmain=new Label("Doctor Information");
	lmain.setBounds(440,35,107,15);
	add(lmain);

	ldi=new Label("Doctor Information");
	ldi.setBounds(40,70,120,15);
	add(ldi);

	lname=new Label("Name :");
	lname.setBounds(104,97,70,25);
	add(lname);

	tfname=new TextField(30);
	tfname.setBounds(270,97,250,20);
	add(tfname);

	ladd=new Label("Address :");
	ladd.setBounds(104,138,70,15);
	add(ladd);

	taadd=new TextArea();
	taadd.setBounds(270,138,250,100);
	add(taadd);

	ltel=new Label("Contact :");
	ltel.setBounds(575,138,50,25);
	add(ltel);

	ldid=new Label("Doctor ID:");
	ldid.setBounds(570,97,70,25);
	add(ldid);
	//chdi=new Choice();
	//chdi.setBounds(643,97,50,20);
	//for(int i=1;i<=10;i++)
	//chdi.addItem(""+i);
	//add(chdi);
	
	tfdid=new TextField(30);
	tfdid.setBounds(643,97,50,20);
	add(tfdid);
	tfdid.setText(DNumber);
	tftel=new TextField(30);
	tftel.setBounds(640,138,200,20);
	add(tftel);
	

	ldspec=new Label("Specialization :");
	ldspec.setBounds(104,310,100,25);
	add(ldspec);

	taspecial=new TextArea();
	taspecial.setBounds(270,310,250,100);
	add(taspecial);
     	
	bsub=new Button("ADD");
	bsub.setBounds(362,643,100,30);
	add(bsub);	

	bclr=new Button("CLEAR");
	bclr.setBounds(470,643,100,30);
	add(bclr);

	bback=new Button("BACK");
	bback.setBounds(580,643,100,30);
	add(bback);
bsub.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent event) 
{
String dname=tfname.getText();
String did=tfdid.getText();
String dcn=tftel.getText();
String dadd=taadd.getText();
String dspe=taspecial.getText();
Connection c=null;   
Statement s=null;
ResultSet rs=null; 
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
c=DriverManager.getConnection("jdbc:odbc:patientdbms");
s=c.createStatement();  
int k=s.executeUpdate("update doctor set did='"+did+"',dname='"+dname+"',dadd='"+dadd+"',dcno='"+dcn+"',dspe='"+dspe+"' where did='"+DNumber+"'");                      

if(k!=0)                     
{
JOptionPane.showMessageDialog(null,"Doctor Details Modefied Successfully!!!","Message",JOptionPane.INFORMATION_MESSAGE);
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
}});
bclr.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent event)
 {
tfdid.setText("");
taspecial.setText("");
tfname.setText("");
tftel.setText("");
taadd.setText("");

}});
bback.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent event) {setVisible(false);}});


addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e){setVisible(false);}});

}
}