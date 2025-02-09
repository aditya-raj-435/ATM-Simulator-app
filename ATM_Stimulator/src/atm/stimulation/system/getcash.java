package atm.stimulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class getcash extends JFrame implements ActionListener {

    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    String pin;
    JTextField txt1;
    JLabel lbl1,lbl2;
    getcash(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.png"));
        Image i2 = i1.getImage().getScaledInstance(800,550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(0,0,800,550);
        add(image1);

        l1 = new JLabel("GET CASH");
        l1.setFont(new Font("System",Font.BOLD,30));
        l1.setBounds(20,20,400,30);
        image1.add(l1);

        l2 = new JLabel("ENTER AMOUNT TO BE WITHDRAWN");
        l2.setFont(new Font("System",Font.BOLD,20));
        l2.setBounds(400,100,400,35);
        image1.add(l2);

        lbl1 = new JLabel("Maximum amount to be withdrawn is Rs.10,000");
        lbl1.setFont(new Font("System",Font.PLAIN,16));
        lbl1.setBounds(200,120,600,35);
        image1.add(lbl1);

        txt1 = new JTextField();
        txt1.setBackground(Color.white);
        txt1.setFont(new Font("System",Font.BOLD,20));
        txt1.setBounds(450,200,250,35);
        image1.add(txt1);

        b1 = new JButton("Get Cash");
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(400,310,120,35);
        b1.addActionListener(this);
        image1.add(b1);

        b2 = new JButton("Clear");
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setBounds(620,310,120,35);
        b2.addActionListener(this);
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

        if(e.getSource()==b1) {

            try {
                String amount = txt1.getText();
                Date date = new Date();
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount to be withdrawn.");
                } else {
                    SQLConnection connection1 = new SQLConnection();
                    String query = "select * from process where pin = '" + pin + "'";
                    ResultSet resultSet = connection1.statement.executeQuery(query);
                    int balance = 0;
                    // to chk if data is saved in sql table - yes thn executes no thn doesn't
                    while (resultSet.next()) {
                        if (resultSet.getString("operation").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    // balance less thn the amount entered for withdrawal
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    }
                    String query1 = "insert into process values('" + pin + "','" + date + "','Withdrawal','" + amount + "')";
                    connection1.statement.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Rs." + amount + " is withdrawn.");
                    setVisible(false);
                    new mainpage(pin);
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else if (e.getSource()==b2){
            txt1.setText("");
        } else if (e.getSource()==b3) {
            setVisible(false);
            new mainpage(pin);
        }
    }

    public static void main(String[] args) {
        new getcash("");
    }
}
