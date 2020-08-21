package studentdatabase;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

class SearchFrame extends JFrame implements ActionListener
{

    JLabel title,subtitle,value;
    JTextField valuetxt;
    JButton searchbtn;
    JRadioButton SID,LName,Major;
    

    public SearchFrame(String formtitle)
    {
        super(formtitle);
        setLayout(null);

        title = new JLabel("Student Database");
        title.setFont(new Font("Arial",Font.BOLD,60));
        
        title.setBounds(200,20,800,60);
        add(title);

        subtitle = new JLabel("Welcome " +LoginFrame.FirstName +"\n Search By");
        subtitle.setFont(new Font("Arial",Font.ITALIC,30));
        
        subtitle.setBounds(200,80,800,100);
        add(subtitle);

         SID = new JRadioButton("Student ID",true);
        SID.setBounds(340,220,100,25);
         LName = new JRadioButton("Last Name");
        LName.setBounds(340,270,100,25);
         Major = new JRadioButton("Major");
        Major.setBounds(340,320,100,25);
        
        value=new JLabel("Enter Value: ");
        value.setBounds(200,350,100,25);
        add(value);

        valuetxt=new JTextField(20);
        valuetxt.setBounds(300,350,150,25);
        add(valuetxt);
        
        searchbtn=new JButton("Search");
        searchbtn.setBounds(340,400,100,25);
        add(searchbtn);
 
        ButtonGroup group = new ButtonGroup();
        group.add(SID);
        group.add(LName);
        group.add(Major);
 
        setLayout(null);
 
        add(SID);
        add(LName);
        add(Major);
 
        pack();
        
        

        

        searchbtn.addActionListener(this);
        


    }
   public void actionPerformed(ActionEvent e)

    {
        String btnstr=e.getActionCommand();

        if(btnstr.equals("Search"))
        {
            if(SID.isSelected())
            {
                String Value;
                Value=valuetxt.getText();
                try
                {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
                Statement st= con.createStatement();
                String qry;
                qry="select * from Student where StudentID='"+Value+"'";
                ResultSet rs = st.executeQuery(qry);
                while(rs.next())
                {
                    JOptionPane.showMessageDialog(null,"StudentID:"+rs.getString(1)+"\nFirstName:"+rs.getString(2)+"\nLastName:"+rs.getString(3)+"\nMajor:"+rs.getString(4)+"\nPhone:"+rs.getString(5)+"\nGPA:"+rs.getString(6)+"\nDOB:"+rs.getString(7));
                }
                st.close();
                con.close();
                }
                catch(Exception e1)
                {
                    JOptionPane.showMessageDialog(null,"Error :"+e1);
                }
                }
            else if(LName.isSelected())
            {
                String Value;
                Value=valuetxt.getText();
                try
                {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
                Statement st= con.createStatement();
                String qry;
                qry="select * from Student where LastName='"+Value+"'";
                ResultSet rs = st.executeQuery(qry);
                while(rs.next())
                {
                    JOptionPane.showMessageDialog(null,"StudentID:"+rs.getString(1)+"\nFirstName:"+rs.getString(2)+"\nLastName:"+rs.getString(3)+"\nMajor:"+rs.getString(4)+"\nPhone:"+rs.getString(5)+"\nGPA:"+rs.getString(6)+"\nDOB:"+rs.getString(7));
                }
                st.close();
                con.close();
                }
                catch(Exception e1)
                {
                    JOptionPane.showMessageDialog(null,"Error :"+e1);
                }
                }
            
            else if(Major.isSelected())
            {
                String Value;
                Value=valuetxt.getText();
                try
                {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
                Statement st= con.createStatement();
                String qry;
                qry="select * from Student where Major='"+Value+"'";
                ResultSet rs = st.executeQuery(qry);
                while(rs.next())
                {
                    JOptionPane.showMessageDialog(null,"StudentID:"+rs.getString(1)+"\nFirstName:"+rs.getString(2)+"\nLastName:"+rs.getString(3)+"\nMajor:"+rs.getString(4)+"\nPhone:"+rs.getString(5)+"\nGPA:"+rs.getString(6)+"\nDOB:"+rs.getString(7));
                }
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
}


/*class Search
	{
		public static void main(String argv[])
		{
			SearchFrame obj=new SearchFrame("Student Database");
			obj.setDefaultCloseOperation(SearchFrame.EXIT_ON_CLOSE);
			obj.setSize(1000,1000);
			obj.setVisible(true);
		}

	}*/



