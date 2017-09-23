import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class PatientInformationM extends Frame 
{	
Label lmain,lpi,lname,ladd,ltel,lmi,lbg,ldob,lhis,lcur,lpno,lgender,ldtip;
TextField tfname,tftel,tfdob,tfpno;
TextArea taadd,tahis,tacur;
Choice chbg,chpi;
CheckboxGroup cbmf;
Checkbox cbm,cbf;
Button bsub,bclr,bback;
String CHBG,CHB="A -ve";
String PNumber;
int number,x;
int count1=0;
PatientInformationM()
{
super("Modify Patient Information");
PNumber = JOptionPane.showInputDialog ( "Enter Patient Number to modify" ); 
if(PNumber!=null)
{
Connection c4=null;   
Statement s4=null;
ResultSet rs4=null;
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
c4=DriverManager.getConnection("jdbc:odbc:patientdbms");
s4=c4.createStatement();  
rs4=s4.executeQuery("select * from patient ");  
String getpid;  
while(rs4.next()) 
{    
getpid=rs4.getString("pid");
if(getpid.equals(PNumber))
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
if(count1==0&&PNumber!=null)
{
JOptionPane.showMessageDialog(null,"Patient Number not Found!!!","Message",JOptionPane.INFORMATION_MESSAGE);
}
}
public void function()
{

setSize(1024,720);
setVisible(true);
setLayout(null);
setBackground(Color.gray);
lmain=new Label("Add Patient Information");
lmain.setBounds(440,35,160,15);
add(lmain);
lpi=new Label("Add Personal Information");
lpi.setBounds(40,70,150,15);
add(lpi);
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
lpno=new Label("Patient No.:");
lpno.setBounds(570,97,70,25);
add(lpno);
tftel=new TextField(30);
tftel.setBounds(640,138,250,20);
add(tftel);
tfpno=new TextField(30);
tfpno.setBounds(643,97,50,20);
add(tfpno);
tfpno.setText(PNumber);
lbg=new Label("Blood Group :");
lbg.setBounds(104,306,79,15);
add(lbg);
chbg=new Choice();
chbg.setBounds(270,306,53,15);
chbg.addItem("A -ve");
chbg.addItem("A +ve");
chbg.addItem("B -ve");
chbg.addItem("B +ve");
chbg.addItem("AB -ve");
chbg.addItem("AB +ve");
chbg.addItem("O +ve");
chbg.addItem("O -ve");
add(chbg);

ldob=new Label("Date of Birth :");
ldob.setBounds(575,306,120,15);
add(ldob);

ldtip=new Label("(dd-mm-yyyy)");
ldtip.setBounds(782,305,100,20);
add(ldtip);
tfdob=new TextField(15);
tfdob.setBounds(696,305,80,20);
add(tfdob);

lhis=new Label("History :");
lhis.setBounds(104,365,50,15);
add(lhis);
tahis=new TextArea();
tahis.setBounds(270,365,250,100);
add(tahis);
lcur=new Label("Current Problem :");
lcur.setBounds(575,365,100,15);
add(lcur);

tacur=new TextArea();
tacur.setBounds(720,365,250,100);
add(tacur);

bsub=new Button("ADD");
bsub.setBounds(362,643,100,30);
add(bsub);	
bclr=new Button("CLEAR");
bclr.setBounds(470,643,100,30);
add(bclr);

bback=new Button("BACK");
bback.setBounds(580,643,100,30);
add(bback);

lgender=new Label("Gender :");
lgender.setBounds(596,223,50,15);
add(lgender);
	
cbmf=new CheckboxGroup();
cbm=new Checkbox("Male",cbmf,true);
cbf=new Checkbox("Female",cbmf,false);
cbm.setBounds(698,223,50,15);
add(cbm);
cbf.setBounds(760,223,60,15);
add(cbf);
CHBG="Male";
cbm.addItemListener(new ItemListener() {public void itemStateChanged(ItemEvent e){CHBG="Male";}});
cbf.addItemListener(new ItemListener() {public void itemStateChanged(ItemEvent e){CHBG="Female";}});
chbg.addItemListener(new ItemListener() {public void itemStateChanged(ItemEvent e){
CHB=chbg.getSelectedItem();
}});
bsub.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent event)
 {
String name1=tfname.getText();
String add=taadd.getText();
String pcn=tftel.getText();
String his1=tahis.getText();
String chis1=tacur.getText();
String dob1=tfdob.getText();
String pno=tfpno.getText();

Connection c=null;   
Statement s=null;
ResultSet rs=null; 


try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
c=DriverManager.getConnection("jdbc:odbc:patientdbms");
s=c.createStatement();  
int k=s.executeUpdate("update patient set name='"+name1+"',CN='"+pcn+"',DOB='"+dob1+"',chis='"+chis1+"',his='"+his1+"',Gender='"+CHBG+"',add='"+add+"',BG='"+CHB+"',pid='"+pno+"' where pid='"+PNumber+"'");
if(k!=0)                     
{
JOptionPane.showMessageDialog(null,"Patient Details Modefied Successfully!!!","Message",JOptionPane.INFORMATION_MESSAGE);
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
}});
bclr.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent event)
 {
tfname.setText("");
tftel.setText("");
tfdob.setText("");
tfpno.setText("");
taadd.setText("");
tahis.setText("");
tacur.setText("");
}});
bback.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent event) {setVisible(false);}});
addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e){setVisible(false);}});

}
}