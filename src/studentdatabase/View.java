package studentdatabase;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

class ViewFrame extends JFrame implements ActionListener
{

    JLabel title,subtitle;
    JButton view,viewfname,viewlname,viewmajor;

    public ViewFrame(String formtitle)
    {
        super(formtitle);
        setLayout(null);

        title = new JLabel("Student Database");
        title.setFont(new Font("Arial",Font.BOLD,60));
        
        title.setBounds(200,20,800,60);
        add(title);

        subtitle = new JLabel("Welcome  " +LoginFrame.FirstName);
        subtitle.setFont(new Font("Arial",Font.ITALIC,30));
        
        subtitle.setBounds(260,170,500,40);
        add(subtitle);

        view=new JButton("View");
        view.setBounds(275,250,150,25);
        add(view);

        viewfname=new JButton("View by First Name");
        viewfname.setBounds(275,300,150,25);
        add(viewfname);

        viewlname=new JButton("View by Last Name");
        viewlname.setBounds(275,350,150,25);
        add(viewlname);

        viewmajor=new JButton("View by Major");
        viewmajor.setBounds(275,400,150,25);
        add(viewmajor);

        view.addActionListener(this);
        viewfname.addActionListener(this);
        viewmajor.addActionListener(this);
        viewlname.addActionListener(this);


    }
    public void actionPerformed(ActionEvent e)

    {
        String btnstr=e.getActionCommand();

        if(btnstr.equals("View"))
        {
            try
            {
                ViewDB frame = new ViewDB();
                frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
                frame.pack();
                frame.setVisible(true);
            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(null,"Error :"+e1);
            }
        }






        else if(btnstr.equals("View by First Name"))
        {
            try
            {
                ViewFName frame = new ViewFName();
                frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
                frame.pack();
                frame.setVisible(true);
            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(null,"Error :"+e1);
            }
        }

        else if(btnstr.equals("View by Last Name"))
        {
            try
            {
                ViewLName frame = new ViewLName();
                frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
                frame.pack();
                frame.setVisible(true);
            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(null,"Error :"+e1);
            }
        }






        else if(btnstr.equals("View by Major"))
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


/*class View
	{
		public static void main(String argv[])
		{
			ViewFrame obj=new ViewFrame("Apartment Solutions");
			obj.setDefaultCloseOperation(ViewFrame.EXIT_ON_CLOSE);
			obj.getContentPane().setBackground(new Color(0, 0, 0));
			obj.setSize(1000,1000);
			obj.setVisible(true);
		}

	}*/



