package BWDBManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class myFrame extends JFrame implements ActionListener {
    JButton button;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;


    JLabel l = new JLabel("BWDB Management System");
    private Package1 package1;
    private Package2 package2;
    private targetValue targetvalue;

    public myFrame(Package1 package1, Package2 package2, targetValue targetvalue) {
            this.package1 = package1;
            this.package2 = package2;
            this.targetvalue = targetvalue;

        super.setTitle("BWDB Management System");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setLocation(500,100);
       // setSize(500, 500);
        setLayout(null);
        setBounds(470, 230, 500, 400);
        getContentPane().setBackground(new Color(172,220,237));
        l.setText("BWDB Management System");
        l.setBounds(70,0,500,100);
        Font font = new Font("Serif", Font.BOLD, 30);
        Font font1 = new Font("Serif", Font.BOLD, 15);
        l.setFont(font);
        button = new JButton("Add Package 1");
        button.setFont(font1);
        button.setBounds(170,80,150,40);
        button1 = new JButton("View Package 1");
        button1.setFont(font1);
        button1.setBounds(170,120,150,40);
        button2 = new JButton("Add Package 2");
        button2.setFont(font1);
        button2.setBounds(170,160,150,40);
        button3 = new JButton("View Package 2");
        button3.setFont(font1);
        button3.setBounds(170,200,150,40);
        button4 = new JButton("View Target Value");
        button4.setFont(font1);
        button4.setBounds(170,240,150,40);
        button5 = new JButton("Exit Application");
        button5.setFont(font1);
        button5.setBounds(170,280,150,40);

        add(l);
        add(button);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
     button.addActionListener(this);
     button1.addActionListener(this);
     button2.addActionListener(this);
     button3.addActionListener(this);
     button4.addActionListener(this);
     button5.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            package1.Package_1();
        } else if (e.getSource() == button1) {
            package1.viewPackage1();
        } else if (e.getSource() == button2) {
            package2.Package_2();
        } else if (e.getSource() == button3) {
            package2.viewPackage2();
        } else if (e.getSource() == button4) {
            targetvalue.viewtargetValue();
        } else if (e.getSource() == button5) {
            System.exit(0); // Exits the application
        }
    }
}
