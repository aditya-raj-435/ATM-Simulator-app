package atm.stimulation.system;

import com.mysql.cj.jdbc.ha.BalanceStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainpage extends JFrame implements ActionListener {
    JButton l1, l2, l3, l4, l5, l6, l7, l8;
    String pin;

    mainpage(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(0, 0, 800, 550);
        add(image1);

        l1 = new JButton("Deposit");
        l1.setFont(new Font("System", Font.PLAIN, 16));
        l1.setBounds(350, 20, 180, 50);
        l1.addActionListener(this);
        image1.add(l1);

        l2 = new JButton("Get Cash");
        l2.setFont(new Font("System", Font.PLAIN, 16));
        l2.setBounds(570, 20, 180, 50);
        l2.addActionListener(this);
        image1.add(l2);

        l3 = new JButton("Fast Cash");
        l3.setFont(new Font("System", Font.PLAIN, 16));
        l3.setBounds(350, 100, 180, 50);
        l3.addActionListener(this);
        image1.add(l3);

        l5 = new JButton("Payments");
        l5.setFont(new Font("System", Font.PLAIN, 16));
        l5.setBounds(570, 100, 180, 50);
        l5.addActionListener(this);
        image1.add(l5);

        l6 = new JButton("Savings");
        l6.setFont(new Font("System", Font.PLAIN, 16));
        l6.setBounds(350, 180, 180, 50);
        l6.addActionListener(this);
        image1.add(l6);

        l7 = new JButton("Change Pin");
        l7.setFont(new Font("System", Font.PLAIN, 16));
        l7.setBounds(570, 180, 180, 50);
        l7.addActionListener(this);
        image1.add(l7);

        l4 = new JButton("Return");
        l4.setFont(new Font("System", Font.PLAIN, 16));
        l4.setBounds(460, 300, 150, 30);
        l4.addActionListener(this);
        image1.add(l4);

        l8 = new JButton("Quit");
        l8.setFont(new Font("System", Font.PLAIN, 16));
        l8.setBounds(250, 300, 150, 30);
        l8.addActionListener(this);
        image1.add(l8);

        setLayout((null));
        setSize(800, 450);
        setLocation(250, 120);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == l1) {
            new Deposit(pin);
            setVisible(false);
        } else if (e.getSource() == l8) {
            System.exit(0);
        } else if (e.getSource() == l2) {
            new getcash(pin);
            setVisible(false);
        } else if (e.getSource() == l4) {
            new Login();
            setVisible(false);
        } else if (e.getSource() == l6) {
            new balance(pin);
        } else if (e.getSource()==l3){
            new FastCash(pin);
            setVisible(false);
        } else if (e.getSource()==l7){
            new PinChange(pin);
            setVisible(false);
        } else if(e.getSource()==l5){
            new MiniStatement(pin);
            setVisible(false);

        }

    }

    public static void main(String[] args) {
        new mainpage("");
    }
}