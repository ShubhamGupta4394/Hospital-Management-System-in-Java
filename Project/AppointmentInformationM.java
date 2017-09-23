import java.io.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class AppointmentInformationM extends Frame 
{
Font foo=new Font("Times New Roman",Font.BOLD,18);
Label lpid,ldid,dapp,lpname,ldname,ldate,ltime,lap;
TextField tfpid,tfdid,tfpname,tfdname,tfap;
Button bsub,bclr,bback,ok;
String dname=" ",pname=" ";
String d,m,y,h,mm,t="AM",date1,time1;
String pid,did;
Choice chd,chm,chy,chh,chmm,cht;
String ANumber;
int count=0;
int count1=0;
AppointmentInformationM()
{
super("Modify Appointment");
ANumber = JOptionPane.showInputDialog ("Enter Appointment Number to modify"); 
if(ANumber!=null)
{
Connection c4=null;   
Statement s4=null;
ResultSet rs4=null;
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
c4=DriverManager.getConnection("jdbc:odbc:patientdbms");
s4=c4.createStatement();  
rs4=s4.executeQuery("select * from appointment ");  
String getaid;  
while(rs4.next()) 
{    
getaid=rs4.getString("aid");
if(getaid.equals(ANumber))
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
if(count1==0 && ANumber!=null)
{
JOptionPane.showMessageDialog(null,"Appointment Number not Found!!!","Message",JOptionPane.INFORMATION_MESSAGE);
}
}
void function()
{
setBackground(Color.gray);
setSize(1024,720);
setVisible(true);
setLayout(null);
ok=new Button("OK");
ok.setBounds(800,97,30,25);
add(ok);
lpid=new Label("Patient ID");
lpid.setBounds(650,97,70,25);
add(lpid);
tfpid=new TextField(30);
tfpid.setBounds(720,97,50,20);
add(tfpid);
ldid=new Label("Doctor ID");
ldid.setBounds(150,97,70,25);
add(ldid);
tfdid=new TextField(30);
tfdid.setBounds(220,97,50,20);
add(tfdid);
lpname=new Label("Patient Name");
lpname.setBounds(650,150,80,25);
add(lpname);
tfpname=new TextField();
tfpname.setBounds(800,150,130,20);
add(tfpname);

ldname=new Label("Doctor Name");
ldname.setBounds(150,150,80,25);
add(ldname);
tfdname=new TextField();
tfdname.setBounds(300,150,130,20);
add(tfdname);

lap=new Label("Appointment ID");
lap.setBounds(400,250,120,25);
add(lap);
tfap=new TextField();
tfap.setBounds(520,250,50,20);
add(tfap);
tfap.setText(ANumber);

ldate=new Label("Select Date(DD/MM/YYYY)");
ldate.setBounds(300,300,180,25);
add(ldate);
chd=new Choice();
chd.setBounds(500,300,50,20);
for(int i=1;i<=31;i++)
chd.addItem(""+i);
add(chd);

chm=new Choice();
chm.setBounds(560,300,50,20);
for(int i=1;i<=12;i++)
chm.addItem(""+i);
add(chm);

chy=new Choice();
chy.setBounds(620,300,70,20);
for(int i=1999;i<=2020;i++)
chy.addItem(""+i);
add(chy);

ltime=new Label("Select Time(HH/MM/AM-PM)");
ltime.setBounds(300,380,180,25);
add(ltime);
chh=new Choice();
chh.setBounds(500,380,50,20);
for(int i=0;i<=12;i++)
chh.addItem(""+i);
add(chh);

chmm=new Choice();
chmm.setBounds(560,380,50,20);
for(int i=0;i<=60;i++)
chmm.addItem(""+i);
add(chmm);

cht=new Choice();
cht.setBounds(620,380,70,20);
cht.addItem("AM");
cht.addItem("PM");
add(cht);

bsub=new Button("ADD");
bsub.setBounds(362,643,100,30);
add(bsub);	
bclr=new Button("CLEAR");
bclr.setBounds(470,643,100,30);
add(bclr);

bback=new Button("BACK");
bback.setBounds(580,643,100,30);
add(bback);
bback.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent event) {setVisible(false);}});
ok.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent event) {
count=1;
pid=tfpid.getText();
did=tfdid.getText();
Connection c=null;   
Statement s=null;
ResultSet rs=null;
ResultSet rs1=null;
ResultSet rs2=null;
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
c=DriverManager.getConnection("jdbc:odbc:patientdbms");
s=c.createStatement();  
rs=s.executeQuery("select * from patient ");  
String getpid;  
while(rs.next()) 
{    
getpid=rs.getString("pid");
if(getpid.equals(pid))
{
pname=rs.getString("name");
}
} 
rs.close();
rs1=s.executeQuery("select * from doctor"); 
String getdid;  
while(rs1.next()) 
{    
getdid=rs1.getString("did");
if(getdid.equals(did))
{
dname=rs1.getString("dname");
}
} 
rs1.close(); 
rs2=s.executeQuery("select * from appointment"); 
String getaid; 
int cp=0; 
while(rs2.next()) 
{    
getaid=rs2.getString("aid");
if(getaid.equals(ANumber))
{
cp++;
}
}  

rs2.close();
s.close();
c.close(); 
if(dname.equals(" ")||pname.equals(" ")&&cp!=0)
{
tfdid.setText("");
tfpid.setText("");
JOptionPane.showMessageDialog(null,"Record Not Found!!","Message",JOptionPane.INFORMATION_MESSAGE);
setVisible(false);
}
else
{
JOptionPane.showMessageDialog(null,"Enter Other Fields and ADD appointment!!","Message",JOptionPane.INFORMATION_MESSAGE);
setVisible(true);
}
}
catch(Exception e)
{
System.out.println("exception seriliazation"+ e);
}
tfpname.setText(pname);
tfdname.setText(dname);
}});
addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e){setVisible(false);}});
chd.addItemListener(new ItemListener() {public void itemStateChanged(ItemEvent e){
d=chd.getSelectedItem();
}});
chm.addItemListener(new ItemListener() {public void itemStateChanged(ItemEvent e){m=chm.getSelectedItem();}});
chy.addItemListener(new ItemListener() {public void itemStateChanged(ItemEvent e){ y=chy.getSelectedItem();}});
chh.addItemListener(new ItemListener() {public void itemStateChanged(ItemEvent e){h=chh.getSelectedItem();}});
chmm.addItemListener(new ItemListener() {public void itemStateChanged(ItemEvent e){mm=chmm.getSelectedItem();}});
cht.addItemListener(new ItemListener() {public void itemStateChanged(ItemEvent e){t=cht.getSelectedItem();}});

bclr.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent event)
 {

tfpid.setText("");
tfdid.setText("");
tfpname.setText("");
tfdname.setText("");
tfap.setText("");
}});
bsub.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent event) 
{
if(count==0)
{
JOptionPane.showMessageDialog(null,"First Use OK Button to Verify!!!","Message",JOptionPane.INFORMATION_MESSAGE);
setVisible(true);
}
else
{
String date1=d+"/"+m+"/"+y;
String time1=h+":"+mm+" "+t;
String aid=tfap.getText();
JOptionPane.showMessageDialog(null,"Appointment Modifyed Successfully!!!","Message",JOptionPane.INFORMATION_MESSAGE);
setVisible(false);
Connection c=null;   
Statement s=null;
ResultSet rs=null; 
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
c=DriverManager.getConnection("jdbc:odbc:patientdbms");
s=c.createStatement();                      
int i=s.executeUpdate("update appointment set did='"+did+"',pid='"+pid+"',dname='"+dname+"',pname='"+pname+"',aid='"+aid+"',adate='"+date1+"',atime='"+time1+"' where aid='"+ANumber+"'");
rs.close();
s.close();
c.close();
}
catch(Exception e)
{
System.out.println("exception seriliazation"+ e);
}
}
}});
}
public void paint(Graphics g)
{
g.setFont(foo);
g.drawString("Modify Appointment",400,50);
g.drawString("Enter Patient ID and Doctor ID then press OK",200,90);
}
}