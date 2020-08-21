package studentdatabase;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

class WelcomeFrame extends JFrame implements ActionListener
{

    JLabel title,subtitle;
    JButton insertbtn,updatebtn,searchbtn,viewbtn,addbtn,exitbtn;

    public WelcomeFrame(String formtitle)
    {
        super(formtitle);
        setLayout(null);

        title = new JLabel("Student Database");
        title.setFont(new Font("Arial",Font.BOLD,60));
        title.setBounds(200,20,800,60);
        add(title);

        subtitle = new JLabel("Welcome " +LoginFrame.FirstName);
        subtitle.setFont(new Font("Arial",Font.ITALIC,30));
      
        subtitle.setBounds(300,170,500,40);
        add(subtitle);

        insertbtn=new JButton("Insert");
        insertbtn.setBounds(340,250,100,25);
        add(insertbtn);

        updatebtn=new JButton("Update");
        updatebtn.setBounds(340,300,100,25);
        add(updatebtn);

        searchbtn=new JButton("Search");
        searchbtn.setBounds(340,350,100,25);
        add(searchbtn);

        viewbtn=new JButton("View");
        viewbtn.setBounds(340,400,100,25);
        add(viewbtn);
        
       /* addbtn=new JButton("Add Info to File");
        addbtn.setBounds(340,450,150,25);
        add(addbtn);*/
        
        
        exitbtn=new JButton("Exit");
        exitbtn.setBounds(340,450,100,25);
        add(exitbtn);


        insertbtn.addActionListener(this);
        updatebtn.addActionListener(this);
        viewbtn.addActionListener(this);
        searchbtn.addActionListener(this);
       // addbtn.addActionListener(this);
        exitbtn.addActionListener(this);


    }
    public void actionPerformed(ActionEvent e)

    {
        String btnstr=e.getActionCommand();

        if(btnstr.equals("Insert"))
        {
            try
            {
                new RegisrationFrame("Register");
            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(null,"Error :"+e1);
            }
        }






        else if(btnstr.equals("Update"))
        {
            try
            {
                UpdateFrame obj=new UpdateFrame("Update");
                
                obj.setSize(1000,1000);
                obj.setVisible(true);
            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(null,"Error :"+e1);
            }
        }

        else if(btnstr.equals("View"))
        {
            try
            {
                ViewFrame obj=new ViewFrame("Student Database");
			
			obj.setSize(1000,1000);
			obj.setVisible(true);
            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(null,"Error :"+e1);
            }
        }

        else if(btnstr.equals("Search"))
        {
            try
            {
                SearchFrame obj=new SearchFrame("Student Database");
			obj.setSize(1000,1000);
			obj.setVisible(true);
            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(null,"Error :"+e1);
            }
        }


       /*  else if(btnstr.equals("Add Info to File"))
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
                Statement st= con.createStatement();
                String qry;
                qry="SELECT * FROM Student";
                ResultSet rs = st.executeQuery(qry);
                while(rs.next())
                {
                    String qry1;
                    qry1="SELECT StudentID,FirstName,LastName,Major,Phone,GPA,DOB INTO OUTFILE '/Students.txt'\n" +
                    "  FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '\"'\n" +
                    "  LINES TERMINATED BY '\\n'\n" +
                    "  FROM Student;";
                }
                
                JOptionPane.showMessageDialog(null,"Information is added into Student.csv file C drive");
                
                 st.close();
                con.close();
            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(null,"Error :"+e1);
            }
        }*/
        
        else if(btnstr.equals("Exit"))
        {
            try
            {
                System.exit(0);
            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(null,"Error :"+e1);
            }
        }

    }
}

/*
class Welcome
	{
		public static void main(String argv[])
		{
			WelcomeFrame obj=new WelcomeFrame("Student Database");
			obj.setDefaultCloseOperation(WelcomeFrame.EXIT_ON_CLOSE);
			obj.getContentPane().setBackground(new Color(0, 0, 0));
			obj.setSize(1000,1000);
			obj.setVisible(true);
		}

	}*/



