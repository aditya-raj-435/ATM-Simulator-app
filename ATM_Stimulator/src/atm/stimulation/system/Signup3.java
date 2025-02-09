package atm.stimulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JButton b1;
    JComboBox cb1,cb2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
    JCheckBox c1,c2,c3,c4,c5;
    String formno;
    Signup3(String formno){


        super("Application");

        this.formno = formno;
        //getting bank image from the folder and scaling it
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank2.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        //taking the image as a label as u cant add image directly
        JLabel image1 = new JLabel(i3);
        //where should the image be visible
        image1.setBounds(25,10,100,100);
        add(image1);

        l1 = new JLabel("Form No.");
        l1.setBounds(630,30,600,40);
        l1.setFont(new Font("Raleway",Font.ITALIC,20));
        add(l1);

        l2 = new JLabel(formno);
        l2.setBounds(720,30,600,40);
        l2.setFont(new Font("Raleway",Font.ITALIC,20));
        add(l2);

        l3 = new JLabel("Page 2");
        l3.setBounds(730,0,600,40);
        l3.setFont(new Font("Raleway",Font.ITALIC,10));
        add(l3);

        l4 = new JLabel("Account Opening Section");
        l4.setBounds(260,60,600,30);
        l4.setFont(new Font("Raleway",Font.BOLD,20));
        add(l4);

        l5 = new JLabel("Account Type*: ");
        l5.setBounds(15,120,600,30);
        l5.setFont(new Font("Raleway",Font.PLAIN,14));
        add(l5);

        String s1[] = {"Current Account","Savings Account","Salary Account","Fixed Deposit Account","Recurring Deposit Account"};
        cb1 = new JComboBox(s1);
        cb1.setBackground(Color.white);
        cb1.setFont(new Font("Raleway",Font.PLAIN,12));
        cb1.setBounds(170,120,250,30);
        add(cb1);

        l6 = new JLabel("Mode of Operation*: ");
        l6.setBounds(15,170,600,30);
        l6.setFont(new Font("Raleway",Font.PLAIN,14));
        add(l6);

        String s2[] = {"Self","Either/Survivor","Former/Survivor","Jointly","Minor A/C operated by Guardian"};
        cb2 = new JComboBox(s2);
        cb2.setBackground(Color.white);
        cb2.setFont(new Font("Raleway",Font.PLAIN,12));
        cb2.setBounds(170,170,250,30);
        add(cb2);

        l7 = new JLabel("Select add on products ");
        l7.setBounds(450,110,600,30);
        l7.setFont(new Font("Raleway",Font.PLAIN,14));
        add(l7);

        c1 = new JCheckBox("Credit Card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.PLAIN,12));
        c1.setBounds(460,140,100,30);
        add(c1);

        c2 = new JCheckBox("Health insurance");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.PLAIN,12));
        c2.setBounds(600,140,150,30);
        add(c2);

        c3 = new JCheckBox("E-Statement");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.PLAIN,12));
        c3.setBounds(460,180,100,30);
        add(c3);

        c4 = new JCheckBox("PPF");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.PLAIN,12));
        c4.setBounds(600,180,100,30);
        add(c4);

        l8 = new JLabel("Card Number: ");
        l8.setBounds(250,250,600,30);
        l8.setFont(new Font("Raleway",Font.PLAIN,16));
        add(l8);

        l9 = new JLabel("Your 16-digit Card Number (Auto-Generated)");
        l9.setBounds(390,270,600,30);
        l9.setFont(new Font("Raleway",Font.PLAIN,10));
        add(l9);

        l10 = new JLabel("XXXX-XXXX-XXXX-XXXX");
        l10.setBounds(390,250,600,30);
        l10.setFont(new Font("Raleway",Font.PLAIN,14));
        add(l10);

        l11 = new JLabel("PIN: ");
        l11.setBounds(250,300,600,30);
        l11.setFont(new Font("Raleway",Font.PLAIN,16));
        add(l11);

        l12 = new JLabel("XXXX");
        l12.setBounds(390,300,600,30);
        l12.setFont(new Font("Raleway",Font.PLAIN,14));
        add(l12);

        l13 = new JLabel("Your 4-digit passcode (Auto-Generated)");
        l13.setBounds(390,320,600,30);
        l13.setFont(new Font("Raleway",Font.PLAIN,10));
        add(l13);

        l15 = new JLabel("Declaration*");
        l15.setBounds(15,350,600,40);
        l15.setFont(new Font("Raleway",Font.PLAIN,14));
        add(l15);

        c5 = new JCheckBox("I agree to abide by all the rules and regulations as determined by the bank from time to time.");
        c5.setBounds(15,385,600,30);
        c5.setFont(new Font("Raleway",Font.PLAIN,10));
        c5.setBackground(Color.white);
        add(c5);


        l17 = new JLabel("*Required");
        l17.setForeground(Color.red);
        l17.setBounds(5,420,600,40);
        l17.setFont(new Font("Raleway",Font.ITALIC,12));
        add(l17);

        b1 = new JButton("Submit");
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(670,450,80,25);
        b1.addActionListener(this);
        add(b1);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(800,550);
        setLocation(250,70);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String type = (String) cb1.getSelectedItem();
        String mode = (String) cb2.getSelectedItem();

        String addon = "";
        if(c1.isSelected()){
            addon += "Credit Card";
        } else if(c2.isSelected()){
            addon += "Health Insurance";
        } else if(c3.isSelected()) {
            addon += "E-Statement";
        } else if(c4.isSelected()){
            addon += "PPF";
        }

        Random ran1 = new Random();
        long first7 = (ran1.nextLong() % 90000000L) + 7409963000000000L;
        String card = "" + Math.abs(first7);

        long first3 = (ran1.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        try {
            if(e.getSource()==b1) {
                if (type.equals("") || mode.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the required credentials.");
                } else {
                    SQLConnection connection = new SQLConnection();
                    String query1 = "insert into signup3 values('" + formno + "','" + type + "','" + mode + "','" + addon + "','" + card + "','" + pin + "')";
                    String query2 = "insert into login values('" + formno + "','" + card + "','" + pin + "')";
                    //to input user entered values into the table in mysql - execute update
                    connection.statement.executeUpdate(query1);
                    connection.statement.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number : " + card + "\n Pin : " + pin);
                    new Deposit(pin);
                    setVisible(false);
                }
            }

        }catch (Exception E){
            E.printStackTrace();
        }



    }

    public static void main(String[] args) {

        new Signup3("");
    }
}
