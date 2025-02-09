package atm.stimulation.system;

import com.mysql.cj.util.StringInspector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balance extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5;
    JButton b1,b2,b3;
    String pin;

    balance(String pin){
        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.png"));
        Image i2 = i1.getImage().getScaledInstance(800,550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(0,0,800,550);
        add(image1);

        l1 = new JLabel("BALANCE");
        l1.setFont(new Font("System",Font.BOLD,30));
        l1.setBounds(20,20,400,30);
        image1.add(l1);

        l2 = new JLabel("Your Balance is: ");
        l2.setFont(new Font("System",Font.BOLD,20));
        l2.setBounds(400,100,400,35);
        image1.add(l2);

        l3 = new JLabel();
        l3.setFont(new Font("System",Font.PLAIN,16));
        l3.setBounds(200,120,600,35);
        image1.add(l3);


        b2 = new JButton("Return");
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setBounds(620,310,120,35);
        b2.addActionListener(this);
        image1.add(b2);

        b3 = new JButton("Quit");
        b3.setForeground(Color.white);
        b3.setBackground(Color.black);
        b3.setBounds(500,400,120,35);
        b3.addActionListener(this);
        image1.add(b3);

        int balance = 0;
        try{
            SQLConnection connection = new SQLConnection();
            String query = "select * from process where pin = '"+pin+"'";
            ResultSet resultSet = connection.statement.executeQuery(query);
            while(resultSet.next()){
                if(resultSet.getString("operation").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else{
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        l2.setText(""+balance);


        setLayout(null);
        setSize(800,550);
        setLocation(250,70);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b3) {
            System.exit(0);
        } else if (e.getSource()==b2) {
            setVisible(false);
            new mainpage(pin);
        }

    }

    public static void main(String[] args) {
        new balance("");
    }
}
