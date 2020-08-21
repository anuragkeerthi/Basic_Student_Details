/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabase;

/**
 *
 * @author MYDELL
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class LoginFrame extends JFrame implements ActionListener {

    public static int StudentID = 0, Phone = 0, Major = 0;
    public static double GPA = 0.0;
    public static String FirstName = "", LastName = "", DOB = "";


    JLabel title, subtitle, studentid;
    JTextField studentidtxt;
    JButton loginbtn, registerbtn;

    public LoginFrame(String formtitle) {
        super(formtitle);
        setLayout(null);


        title = new JLabel("Student Database");
        title.setFont(new Font("Arial", Font.BOLD, 60));
        title.setBounds(200, 20, 800, 60);
        add(title);

        subtitle = new JLabel(" ");
        subtitle.setFont(new Font("Arial", Font.ITALIC, 20));
        subtitle.setBounds(430, 165, 300, 40);
        add(subtitle);

        studentid = new JLabel("Enter Student ID:");
        studentid.setFont(new Font("Arial", Font.BOLD, 12));
        studentid.setBounds(280, 250, 100, 30);
        add(studentid);

        studentidtxt = new JTextField(20);
        studentidtxt.setBounds(380, 252, 150, 25);
        add(studentidtxt);

        loginbtn = new JButton("Login");
        
        loginbtn.setBounds(350, 310, 80, 25);
        add(loginbtn);

        registerbtn = new JButton("Register");
        
        registerbtn.setBounds(340, 360, 100, 25);
        add(registerbtn);

        loginbtn.addActionListener(this);
        registerbtn.addActionListener(this);


    }

    public void actionPerformed(ActionEvent e)

    {
        String btnstr = e.getActionCommand();

        if (btnstr.equals("Login")) {
            String studentid = studentidtxt.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
                Statement st = con.createStatement();
                String qry = "select * from Student where StudentID='" + studentid + "'";
                ResultSet rs = st.executeQuery(qry);
                if (rs.next()) {

                    StudentID = rs.getInt(1);
                    FirstName = rs.getString(2);
                    LastName = rs.getString(3);
                    Major = rs.getInt(4);
                    Phone = rs.getInt(5);
                    GPA = rs.getDouble((int) 6);


                    WelcomeFrame obj = new WelcomeFrame("Student Database");
                    
                    obj.setSize(1000, 1000);
                    obj.setVisible(true);
                } else
                    JOptionPane.showMessageDialog(null, "Student details not found");

                st.close();
                con.close();

            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error :" + e1);
            }


        } else if (btnstr.equals("Register")) {
            try {
                new RegisrationFrame("Register");
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error :" + e1);
            }
        }

    }

}

class login {
    public static void main(String argv[]) {
        LoginFrame obj = new LoginFrame("Login");
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        obj.setSize(1000, 1000);

        obj.setVisible(true);
    }
}

