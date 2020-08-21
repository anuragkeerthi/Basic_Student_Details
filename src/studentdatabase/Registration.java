package studentdatabase;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;

class RegisrationFrame implements ActionListener
{
    JLabel title,StudentID,FirstName,LastName,Major,Phone,GPA,DOB;
    JTextField StudentIDtxt,FirstNametxt,LastNametxt,Majortxt,Phonetxt,GPAtxt,DOBtxt;
    JButton register;
    public RegisrationFrame(String formtitle)
    {

        JFrame f=new JFrame(formtitle);

        title=new JLabel("STUDENT REGISTRATION");
        title.setFont(new Font("Arial",Font.BOLD,35));
        title.setBounds(230,20,800,60);
        f.add(title);

        StudentID=new JLabel("Student ID: ");
        StudentID.setBounds(200,150,100,25);
        f.add(StudentID);

        StudentIDtxt=new JTextField(20);
        StudentIDtxt.setBounds(300,150,150,25);
        f.add(StudentIDtxt);

        FirstName=new JLabel("FirstName: ");
        FirstName.setBounds(200,200,100,25);
        f.add(FirstName);

        FirstNametxt=new JTextField(20);
        FirstNametxt.setBounds(300,200,150,25);
        f.add(FirstNametxt);

        LastName=new JLabel("Last Name: ");
        LastName.setBounds(200,250,100,25);
        f.add(LastName);

        LastNametxt=new JTextField(20);
        LastNametxt.setBounds(300,250,150,25);
        f.add(LastNametxt);

        Major=new JLabel("Major: ");
        Major.setBounds(200,300,100,25);
        f.add(Major);

        Majortxt=new JTextField(20);
        Majortxt.setBounds(300,300,150,25);
        f.add(Majortxt);

        Phone=new JLabel("Phone: ");
        Phone.setBounds(200,350,100,25);
        f.add(Phone);

        Phonetxt=new JTextField(20);
        Phonetxt.setBounds(300,350,150,25);
        f.add(Phonetxt);

        GPA=new JLabel("GPA:");
        GPA.setBounds(200,400,100,25);
        f.add(GPA);

        GPAtxt=new JTextField(20);
        GPAtxt.setBounds(300,400,150,25);
        f.add(GPAtxt);

        DOB=new JLabel("Date of Birth:");
        DOB.setBounds(200,450,100,25);
        f.add(DOB);

        DOBtxt=new JTextField("YYYY/MM/DD");
        DOBtxt.setBounds(300,450,150,25);
        f.add(DOBtxt);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
        Calendar cal = Calendar.getInstance();
        




        register=new JButton("REGISTER");
        register.setBounds(240,500,150,25);
        
        f.add(register);
        f.setSize(1000,1000);
        f.setLayout(null);
        f.setVisible(true);

        register.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {

        String StudentID,FirstName,LastName,Major,Phone,GPA,DOB;
        StudentID=StudentIDtxt.getText();
        FirstName=FirstNametxt.getText();
        LastName=LastNametxt.getText();
        Major=Majortxt.getText();
        Phone=Phonetxt.getText();
        GPA=GPAtxt.getText();
        DOB=DOBtxt.getText();

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
            Statement st=con.createStatement();
            String qry="insert into Student(StudentID,FirstName,LastName,Major,Phone,GPA,DOB) values('"+StudentID+"','"+FirstName+"','"+LastName+"','"+Major+"','"+Phone+"','"+GPA+"','"+DOB+"')";
            int n=st.executeUpdate(qry);
            if(n==0)
                JOptionPane.showMessageDialog(null,"Registration failed. Try again!");
            else
                JOptionPane.showMessageDialog(null,"Registration success");

            st.close();
            con.close();

        }
        catch(Exception e1)
        {
            JOptionPane.showMessageDialog(null,"Error :"+e1);
        }
    }
}

/*
class Registration
{
	public static void main(String argv[])
	{
       new RegisrationFrame("Register");
		
	}
}
*/
