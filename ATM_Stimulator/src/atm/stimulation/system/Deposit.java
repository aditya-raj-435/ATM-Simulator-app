package atm.stimulation.system;

import com.sun.net.httpserver.Authenticator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    String pin;
    JTextField txt1;
    Deposit(String pin){
        super("");
        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.png"));
        Image i2 = i1.getImage().getScaledInstance(800,550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(0,0,800,550);
        add(image1);

        l1 = new JLabel("DEPOSIT");
        l1.setFont(new Font("System",Font.BOLD,30));
        l1.setBounds(20,20,400,30);
        image1.add(l1);

        l2 = new JLabel("ENTER AMOUNT TO BE DEPOSITED");
        l2.setFont(new Font("System",Font.BOLD,20));
        l2.setBounds(400,100,400,35);
        image1.add(l2);

        txt1 = new JTextField();
        txt1.setBackground(Color.white);
        txt1.setFont(new Font("System",Font.BOLD,20));
        txt1.setBounds(450,200,250,35);
        image1.add(txt1);

        b1 = new JButton("Deposit");
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(400,310,120,35);
        image1.add(b1);

        b2 = new JButton("Clear");
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setBounds(620,310,120,35);
        b1.addActionListener(this);
        image1.add(b2);

        b3 = new JButton("Return");
        b3.setForeground(Color.white);
        b3.setBackground(Color.black);
        b3.setBounds(500,400,120,35);
        b3.addActionListener(this);
        image1.add(b3);




        setLayout(null);
        setSize(800,550);
        setLocation(250,70);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = txt1.getText();
            Date date = new Date();
            if (e.getSource()==b1){
                if(amount.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the amount to be deposited.");
                }else {
                    SQLConnection connection = new SQLConnection();
                    String query = "insert into process values('" + pin + "','" + date + "','Deposit','" + amount + "')";
                    connection.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+amount+" deposited in your account.");
                    setVisible(false);
                    new mainpage(pin);
                }
            } else if (e.getSource()==b2){
                txt1.setText("");
            } else if (e.getSource()==b3) {
                setVisible(false);
                new mainpage(pin);
            }
        }catch (Exception E){
            E.printStackTrace();

        }
    }

    public static void main(String[] args) {

        new Deposit("");
    }
}
