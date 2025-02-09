package atm.stimulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame  implements ActionListener {

    String pin;

    JLabel l1,l2,l3,l4;
    JButton b1,b2;

    MiniStatement(String pin){
        this.pin = pin;

        setLayout((null));
        setSize(400, 600);
        setLocation(350, 50);


        l1 = new JLabel();
        l1.setBounds(20,100,400,400);
        add(l1);

        l2 = new JLabel("Payments");
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setBounds(170,20,400,25);
        add(l2);

        l3 = new JLabel();
        l3.setBounds(20,55,600,20);
        add(l3);

        l4 = new JLabel();
        l4.setBounds(20,450,400,20);
        add(l4);

        try{

            SQLConnection connection = new SQLConnection();
            String query = "select * from login where pin = '"+pin+"'";
            ResultSet resultSet=connection.statement.executeQuery(query);
            while (resultSet.next()){
                l3.setText("Card Number: " + resultSet.getString("Card_No"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        try {

            int balance = 0;
            SQLConnection connection1  = new SQLConnection();
            String query = "select * from process where pin = '"+pin+"'";
            ResultSet resultSet1 = connection1.statement.executeQuery(query);
            while (resultSet1.next()) {

                l1.setText(l1.getText() + "<html>"+resultSet1.getString("date")+ "&nbsp;&nbsp;" +resultSet1.getString("operation")+"&nbsp;&nbsp;"+resultSet1.getString("amount")+"<br><br><html>");

                if (resultSet1.getString("operation").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet1.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet1.getString("amount"));
                }
            }

            l4.setText("Current Balance: Rs. "+balance);


        }catch (Exception E){
            E.printStackTrace();
        }

        b1 = new JButton("Return");
        b1.setBounds(20,500,100,25);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        add(b1);

        b2 = new JButton("Quit");
        b2.setBounds(270,500,100,25);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);





        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            setVisible(false);
            new mainpage(pin);
        } else if (e.getSource() == b2) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
