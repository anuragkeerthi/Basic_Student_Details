package studentdatabase;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class UpdateFrame extends JFrame implements ActionListener
{

    JLabel title,subtitle,StudentID,FirstName,LastName,Major,Phone,GPA,DOB;
    JTextField StudentIDtxt,FirstNametxt,LastNametxt,Majortxt,Phonetxt,GPAtxt,DOBtxt;
    JButton updatebtn;
    public UpdateFrame(String formtitle)
    {
        super(formtitle);
        setLayout(null);

        title = new JLabel("Student Database");
        title.setFont(new Font("Arial",Font.BOLD,60));
        title.setBounds(200,20,800,60);
        add(title);

        subtitle = new JLabel("Insert New Details for StudentID: " +LoginFrame.StudentID );
        subtitle.setFont(new Font("Arial",Font.ITALIC,30));
        
        subtitle.setBounds(200,100,600,40);
        add(subtitle);

        FirstName=new JLabel("FirstName: ");
        
        FirstName.setBounds(200,200,100,25);
        add(FirstName);

        FirstNametxt=new JTextField(LoginFrame.FirstName,30);
        FirstNametxt.setBounds(300,200,150,25);
        add(FirstNametxt);

        LastName=new JLabel("Last Name: ");
        LastName.setBounds(200,250,100,25);
        add(LastName);

        LastNametxt=new JTextField(LoginFrame.LastName,30);
        LastNametxt.setBounds(300,250,150,25);
        add(LastNametxt);

        Major=new JLabel("Major: ");
        Major.setBounds(200,300,100,25);
        add(Major);

        Majortxt=new JTextField(LoginFrame.Major);
        Majortxt.setBounds(300,300,150,25);
        add(Majortxt);

        Phone=new JLabel("Phone: ");
        Phone.setBounds(200,350,100,25);
        add(Phone);

        Phonetxt=new JTextField(LoginFrame.Phone);
        Phonetxt.setBounds(300,350,150,25);
        add(Phonetxt);

        GPA=new JLabel("GPA:");
        GPA.setBounds(200,400,100,25);
        add(GPA);

        GPAtxt=new JTextField(20);
        GPAtxt.setBounds(300,400,150,25);
        add(GPAtxt);

        DOB=new JLabel("Date of Birth:");
        DOB.setBounds(200,450,100,25);
        add(DOB);

        DOBtxt=new JTextField("YYYY/MM/DD");
        DOBtxt.setBounds(300,450,150,25);
        add(DOBtxt);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();


        updatebtn=new JButton("Update");
        updatebtn.setBounds(325,500,80,30);
        
        add(updatebtn);

       updatebtn.addActionListener(this);


    }

    public void actionPerformed(ActionEvent e)
    {
        String btnstr=e.getActionCommand();

        if(btnstr.equals("Update"))
        {

            String FirstName,LastName,Major,Phone,GPA,DOB;

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
                Statement st= con.createStatement();
                String qry;
                qry = "update Student set FirstName='"+FirstName+"' , LastName='"+LastName +"',Major='"+Major+"',Phone='"+Phone+"',GPA='"+GPA+"',DOB='"+DOB+"' where StudentID=" +LoginFrame.StudentID;
                int n;
                n = st.executeUpdate(qry);
                if(n==0)
                {
                    JOptionPane.showMessageDialog(null,"Updating Failed!");
                }
                else
                    JOptionPane.showMessageDialog(null,"Successfully Updated");

                st.close();
                con.close();

            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(null,"Error :"+e1);
            }


        }

    }
}



/*
public class Update
	{
		public static void main(String argv[])
		{

			UpdateFrame obj=new UpdateFrame("Update");
			obj.getContentPane().setBackground(new Color(100, 150, 200));
			obj.setSize(1000,1000);
			obj.setVisible(true);
		}

	}*/
