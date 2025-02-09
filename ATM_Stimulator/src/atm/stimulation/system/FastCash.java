package atm.stimulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6,b7,b8;
    JLabel l1;
    String pin;
    FastCash(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(0, 0, 800, 550);
        add(image1);

        l1 = new JLabel("Fast Cash");
        l1.setFont(new Font("System",Font.BOLD,30));
        l1.setBounds(20,20,400,30);
        image1.add(l1);

        l1 = new JLabel("Select amount");
        l1.setFont(new Font("System",Font.PLAIN,20));
        l1.setBounds(20,60,400,30);
        image1.add(l1);

        b1 = new JButton("100");
        b1.setFont(new Font("System", Font.PLAIN, 16));
        b1.setBounds(350, 20, 180, 50);
        b1.addActionListener(this);
        image1.add(b1);

        b2 = new JButton("200");
        b2.setFont(new Font("System", Font.PLAIN, 16));
        b2.setBounds(570, 20, 180, 50);
        b2.addActionListener(this);
        image1.add(b2);

        b3 = new JButton("500");
        b3.setFont(new Font("System", Font.PLAIN, 16));
        b3.setBounds(350, 100, 180, 50);
        b3.addActionListener(this);
        image1.add(b3);

        b5 = new JButton("1000");
        b5.setFont(new Font("System", Font.PLAIN, 16));
        b5.setBounds(570, 100, 180, 50);
        b5.addActionListener(this);
        image1.add(b5);

        b6 = new JButton("5000");
        b6.setFont(new Font("System", Font.PLAIN, 16));
        b6.setBounds(350, 180, 180, 50);
        b6.addActionListener(this);
        image1.add(b6);

        b7 = new JButton("10000");
        b7.setFont(new Font("System", Font.PLAIN, 16));
        b7.setBounds(570, 180, 180, 50);
        b7.addActionListener(this);
        image1.add(b7);

        b4 = new JButton("Return");
        b4.setFont(new Font("System", Font.PLAIN, 16));
        b4.setBounds(460, 300, 150, 30);
        b4.addActionListener(this);
        image1.add(b4);

        b8 = new JButton("Quit");
        b8.setFont(new Font("System", Font.PLAIN, 16));
        b8.setBounds(250, 300, 150, 30);
        b8.addActionListener(this);
        image1.add(b8);

        setLayout((null));
        setSize(800, 450);
        setLocation(250, 120);
        setUndecorated(true);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            new Deposit(pin);
            setVisible(false);
        } else if (e.getSource() == b8) {
            System.exit(0);
        } else if (e.getSource() == b4) {
            setVisible(false);
            new mainpage(pin);
        } else {
            String amount = ((JButton)e.getSource()).getText();
            Date date = new Date();
            SQLConnection connection = new SQLConnection();
            try{
                String query = "select * from process where pin = '"+pin+"'";
                ResultSet resultSet = connection.statement.executeQuery(query);
                int balance = 0;
                while (resultSet.next()) {
                    if (resultSet.getString("operation").equals("Deposit")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");

                }
                String query1 = "insert into process values('" + pin + "','" + date + "','Fast Cash','" + amount + "')";
                connection.statement.executeUpdate(query1);
                JOptionPane.showMessageDialog(null,"Rs."+amount+" is withdrawn.");



            }catch (Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new mainpage(pin);
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
