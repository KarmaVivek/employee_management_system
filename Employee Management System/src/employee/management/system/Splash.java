package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {

    private JLabel heading;
    private Timer flashTimer;
    private boolean isVisible = true;

    Splash() {
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        heading = new JLabel("Employee Management System");
        add(heading);
        heading.setBounds(80, 30, 1100, 60);
        heading.setFont(new Font("", Font.PLAIN, 65));
        heading.setForeground(Color.RED);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 120, 1000, 500);
        add(image);

        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400, 400, 200, 40);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        image.add(clickhere);

        flashTimer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isVisible = !isVisible;
                heading.setVisible(isVisible);
            }
        });
        flashTimer.start(); // Start the timer to flash the heading

        // Add an ActionListener to the button to close the splash screen
        clickhere.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flashTimer.stop(); // Stop the flashing
                dispose(); // Close the splash screen
            }
        });

        setSize(1100, 700);
        setLocation(200, 100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {
        new Splash();
    }
}
