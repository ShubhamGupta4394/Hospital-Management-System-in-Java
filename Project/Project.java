import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
/*
<applet code="Project.class" height=500 width=500>
</applet>
*/
public class Project extends Applet implements ActionListener
{
int ch=0;
Button bd,ba,bp,bexit,bc,b1,bb;
/*bd is used to open Doctor Section
ba is used to open Appointment Section
bp is used to open Patient Section
bexit is used to exit
bc is used for cancel
b1 is used for Submit
bb is used to back*/ 
Font fo,fo1;//used to make font 
int flag=0;
TextField t1,t2;//t1 is text field for Username and t2 for password
Label linfo,linfo1,linfo2,linfo3,l1,l2,l;
/*
linfo is used for Display to Select Appropriate Message 
linfo1 is used as label for Display Appropriate message for Patient
linfo2 is used as label for Display Appropriate message for Doctor
linfo3 is used as label for Display Appropriate message for Appointment
l1 is used for Username Label
l2 is used for Passowrd Label
l is use for Admin Login Label
*/
Button pba,pbm,pbv,pbd;
Label plinfo1,plinfo2,plinfo3,plinfo4;
Button dba,dbm,dbv,dbd;
Label dlinfo1,dlinfo2,dlinfo3,dlinfo4;
Button aba,abm,abv,abd;
Label alinfo1,alinfo2,alinfo3,alinfo4;
/*
plinfo1  variable is used as Label to add Patient Inforamtion
plinfo2 variable is used as Label to modify Patient Information
plinfo3 variable is used as Label to View Patient Inforamtion
pba variable is used as Button to go to new Frame for adding patient
pbm variable is used as Button to go to new Frame for modifying patient
pbv variable is used as Button to go to new Frame for display record of patient
dlinfo1 variable is used as Label to add Doctor Inforamtion
dlinfo2 variable is used as Label to modify Doctor Information
dlinfo3 variable is used as Label to View Doctor Inforamtion
dba variable is used as Button to go to new Frame for adding doctor
dbm variable is used as Button to go to new Frame for modifying doctor
dbv variable is used as Button to go to new Frame for display record of doctor
alinfo1 variable is used as Label to add appointment Inforamtion
alinfo2 variable is used as Label to modify appointment Information
alinfo3 variable is used as Label to View appointment Inforamtion
aba variable is used as Button to go to new Frame for adding appointment
abm variable is used as Button to go to new Frame for modifying appointment
abv variable is used as Button to go to new Frame for display record of appointment
*/
public void init()
{
bb=new Button("Back");
setBackground(Color.gray);
l=new Label("Admin User Login:");
l1=new Label("Username");
l2=new Label("Password");
l.setBounds(5,50,200,20);
l1.setBounds(50,80,80,20);
l2.setBounds(50,130,80,20);
add(l);
add(l1);
add(l2);
t1=new TextField();
t2=new TextField();
t2.setEchoChar('*');//it is used to set EchoCharacter for Password field
t1.setBounds(150,80,100,20);
t2.setBounds(150,130,100,20);
b1=new Button("Submit");
b1.setBounds(150,180,100,20);
bc=new Button("Cancel");
bc.setBounds(40,180,100,20);
add(bc);
add(b1);
add(t1);
add(t2);
setBackground(Color.gray);
fo=new Font("Times New Roman",Font.BOLD,28);
fo1=new Font("Times New Roman",Font.BOLD,18);
setLayout(null);
setSize(300,300);
setVisible(true);
setLocation((700)/2,((400)/2));
bc.addActionListener(this);
b1.addActionListener(this);
}
public void remove1()
{
remove(bc);
remove(t1);
remove(t2);
remove(l1);
remove(l);
remove(l2);
remove(b1);
}
public void afterlogin()
{
resize(1024,650);
linfo=new Label("SELECT THE APPROPRIATE OPTION");
linfo.setBounds(30,137,210,20);
add(linfo);
linfo1=new Label("1. For Inserting,Retrieving Patients related Data:");
linfo1.setBounds(50,205,335,20);
add(linfo1);
linfo2=new Label("2. For Inserting,Retrieving Doctors related Data:");
linfo2.setBounds(50,275,335,20);
add(linfo2);
linfo3=new Label("3. For Making Appointment:");
linfo3.setBounds(50,345,150,20);
add(linfo3);
bd=new Button("Doctor");
bd.setBounds(430,270,180,30);
bp=new Button("Patient");
bp.setBounds(430,200,180,30);
ba=new Button("Appointment");
ba.setBounds(430,340,180,30);
bexit=new Button("Exit");
bexit.setBounds(730,515,100,30);
add(bexit);
add(bd);
add(bp);
add(ba);
bd.addActionListener(this);
ba.addActionListener(this);
bp.addActionListener(this);
bexit.addActionListener(this);
}
//remove2 method is used to remove all components present after Login
public void remove2()
{
remove(linfo);
remove(linfo1);
remove(linfo2);
remove(linfo3);
remove(bexit);
remove(bd);
remove(bp);
remove(ba);
}
//PaitientInfo will display Patient related frame in same screen after removing all  previous components 
public void PaitientInfo()
{
pba=new Button("Add_Record");
pbm=new Button("Modify_Record");
pbv=new Button("View_Record");
pbd=new Button("Delete_Record");
pba.setBounds(340,180,180,30);		
pbm.setBounds(340,280,180,30);
pbv.setBounds(340,380,180,30);
pbd.setBounds(340,480,180,30);
bb.setBounds(500,545,100,30);
plinfo1=new Label("1. Add  Patients  Information:");
plinfo2=new Label("2. Modify  Patients  Information:");
plinfo3=new Label("3. View  Patients  Information:");
plinfo4=new Label("4. Delete Patient Information");
plinfo1.setBounds(200,150,210,20);
plinfo2.setBounds(200,250,210,20);
plinfo3.setBounds(200,350,210,20);
plinfo4.setBounds(200,450,210,20);
add(plinfo1);
add(plinfo2);
add(plinfo3);
add(plinfo4);
add(bb);
add(pba);
add(pbm);
add(pbv);
add(pbd);
bb.addActionListener(this);
pba.addActionListener(this);
pbm.addActionListener(this);
pbv.addActionListener(this);
pbd.addActionListener(this);
}
public void removePI()
{
remove(plinfo1);
remove(plinfo2);
remove(plinfo3);
remove(plinfo4);
remove(bb);
remove(pba);
remove(pbm);
remove(pbv);
remove(pbd);
}

//DoctorInfo will display Doctor related frame in same screen after removing all  previous components 
public void DoctorInfo()
{
dba=new Button("Add_Record");
dbm=new Button("Modify_Record");
dbv=new Button("View_Record");
dbd=new Button("Delete_Record");
dba.setBounds(340,180,180,30);		
dbm.setBounds(340,280,180,30);
dbv.setBounds(340,380,180,30);
dbd.setBounds(340,480,180,30);
bb.setBounds(500,545,100,30);
dlinfo1=new Label("1. Add  Doctor's  Information:");
dlinfo2=new Label("2. Modify  Doctor's  Information:");
dlinfo3=new Label("3. View  Doctor's  Information:");
dlinfo4=new Label("4. Delete  Doctor's  Information:");
dlinfo1.setBounds(200,150,210,20);
dlinfo2.setBounds(200,250,210,20);
dlinfo3.setBounds(200,350,210,20);
dlinfo4.setBounds(200,450,210,20);
add(dlinfo1);
add(dlinfo2);
add(dlinfo3);
add(dlinfo4);
add(bb);
add(dba);
add(dbm);
add(dbv);
add(dbd);
bb.addActionListener(this);
dba.addActionListener(this);
dbm.addActionListener(this);
dbv.addActionListener(this);
dbd.addActionListener(this);
}
public void removeDI()
{
remove(dlinfo1);
remove(dlinfo2);
remove(dlinfo3);
remove(dlinfo4);
remove(dba);
remove(dbm);
remove(bb);
remove(dbv);
remove(dbd);
}
//AppointmentInfo will display Appointment related frame in same screen after removing all  previous components 
public void AppointmentInfo()
{
aba=new Button("Add_Record");
abm=new Button("Modify_Record");
abv=new Button("View_Record");
abd=new Button("Delete_Record");
aba.setBounds(340,180,180,30);		
abm.setBounds(340,280,180,30);
abv.setBounds(340,380,180,30);
abd.setBounds(340,480,180,30);
bb.setBounds(500,545,100,30);
alinfo1=new Label("1. Add  Appointment:");
alinfo2=new Label("2. Modify Appointment:");
alinfo3=new Label("3. View Appointments:");
alinfo4=new Label("4. Delete Appointments:");
alinfo1.setBounds(200,150,210,20);
alinfo2.setBounds(200,250,210,20);
alinfo3.setBounds(200,350,210,20);
alinfo4.setBounds(200,450,210,20);
add(alinfo1);
add(alinfo2);
add(alinfo3);
add(alinfo4);
add(bb);
add(aba);
add(abm);
add(abv);
add(abd);
bb.addActionListener(this);
aba.addActionListener(this);
abm.addActionListener(this);
abv.addActionListener(this);
abd.addActionListener(this);
}
public void removeAI()
{
remove(alinfo1);
remove(alinfo2);
remove(alinfo3);
remove(alinfo4);
remove(aba);
remove(abm);
remove(bb);
remove(abv);
remove(abd);
}

public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();//this will help to get the String of text and buttion clicked
String un=t1.getText();//getting text in to an String variable 
String ps=t2.getText();//getting text in to an String variable 
if((un.equals("apollo"))&&(ps.equals("apollo"))&&(s.equals("Submit")))//Checking condition for Login 
{
JOptionPane.showMessageDialog(null,"Welcome","Message",JOptionPane.INFORMATION_MESSAGE);//Displaying Welcome Message
remove1();//Removing the Previous components for making Applet to View in Different Details
afterlogin();//this function will display appropriate applet messages and information
ch=1;
repaint();
}
else if(s.equals("Submit"))
{
JOptionPane.showMessageDialog(null,"you are not Autherised user","Message",JOptionPane.ERROR_MESSAGE);
}//it will display unautherised user
else if(s.equals("Cancel"))
{
t1.setText("");
t2.setText("");
}
else if(s.equals("Exit"))
{
JOptionPane.showMessageDialog(null,"PRESS  X TO EXIT","Message",JOptionPane.INFORMATION_MESSAGE);
}
/*if user want to exit it will take care and display message since applet is
 Browser base programing in order to close applet we should close Browser*/
else if(s.equals("Patient"))//if user want to Enter in Patient Section 
{
remove2(); 
PaitientInfo();
flag=9;
repaint();
}//this will remove app previous dispaly and new frame with new details will be displayed
else if(s.equals("Doctor"))
{
remove2();
DoctorInfo();
flag=8;
repaint();
}//this will remove app previous dispaly and new frame with new details will be displayed
else if(s.equals("Appointment"))
{
remove2();
AppointmentInfo();
flag=7;
repaint();
}//this will remove app previous dispaly and new frame with new details will be displayed
else if(ae.getSource()==abm)
{
new AppointmentInformationM();//constructor of Appointment Information Modefied will be called 
}
else if(ae.getSource()==pba)
{
new PatientInformation();//Constructor of Adding Patient Information will be called
}
else if(ae.getSource()==dbd)
{
new DoctorInformationD();//this will invoke Doctor Delete Constructor
}
else if(ae.getSource()==dbv)
{
new DoctorRecordView();//this will lead to call the Doctor Record View Constructor
}
else if(ae.getSource()==abv)
{
new AppointmentRecordView();// this will call Appointment View Record Constrcutor
}
else if(ae.getSource()==abd)
{
new AppointmentInformationD();//this will invoke Appointment Delete Constructor
}
else if(ae.getSource()==pbv)
{
new PatientRecordView();//this will call Patient Recored View Constructor
}
else if(ae.getSource()==dba)
{
new DoctorInformation();//this will call Doctor Information constructor to add Doctor Details
}
else if(ae.getSource()==aba)
{
new AppointmentInformation();//this will take care of Appointment Information Constructor to make Appointment
}
else if(ae.getSource()==pbd)
{
new PatientInformationD();//this will invoke Patient Delete Constructor
}
else if(ae.getSource()==pbm)
{
new PatientInformationM();//this will call Patieent Information Constructor
}
else if(ae.getSource()==dbm)
{
new DoctorInformationM();//this will call Doctor Information Modefied Constructor 
}
else if(s.equals("Back"))
{
if(flag==9)//Remove Patient Details Details 
{
removePI();
afterlogin();
}
else if(flag==8)//Remove Doctor Frame Details
{
removeDI();
afterlogin();
}
else if(flag==7)//Remove Appointment Frame Details
{
removeAI();
afterlogin();
}
repaint();
flag=0;
}
}
public void paint(Graphics g)
{
if(ch==0)
g.drawString("APOLLO HOSPITAL MANAGEMENT SYSTEM",10,40);
if(ch==1)
{
g.setFont(fo);
g.drawString("APOLLO HOSPITAL MANAGEMENT SYSTEM",250,60);
g.setFont(fo1);
g.drawString("Made By-Shubham(12BIT0112),Ashutosh(12BIT0176),Awadhesh(12BIT0128)",0,630);
}
}
}

