package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Login extends JFrame implements ActionListener {

    JTextField tfuser;
    JTextField tfpwd;

    Login(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lbluser=new JLabel("Username");
        lbluser.setBounds(40,30,100,30);
        lbluser.setFont(new Font("serif", Font.BOLD,18));
        add(lbluser);

        tfuser=new JTextField();
        tfuser.setBounds(150,30,150,30);
        add(tfuser);


        JLabel lblpwd=new JLabel("Password");
        lblpwd.setBounds(40,90,100,30);
        lblpwd.setFont(new Font("serif", Font.BOLD,18));
        add(lblpwd);

        tfpwd=new JTextField();
        tfpwd.setBounds(150,90,150,30);
        add(tfpwd);

        JButton login = new JButton("Login");
        login.setBounds(150, 150, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360,10,200,200);
        add(image);

        setSize(600,300);
        setVisible(true);
        setLocation(450,250);


    }
    public void actionPerformed(ActionEvent ae) {

        try{
            String username= tfuser.getText();
            String password= tfpwd.getText();
            Conn c= new Conn();
            String query="select * from login where username='"+username+"'and password='"+password+"'";

            ResultSet rs =c.s.executeQuery(query);
            if(rs.next()) {
                setVisible(false);
                new Home();

            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(false);
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new Login();
    }
}
