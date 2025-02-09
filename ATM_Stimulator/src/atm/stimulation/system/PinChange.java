package atm.stimulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JButton b2,b4,b8;

    JLabel l1,l2,l3;

    JPasswordField p1,p2;

    String pin;
    PinChange(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.png"));
        Image i2 = i1.getImage().getScaledInstance(800,550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(0,0,800,550);
        add(image1);

        l1 = new JLabel("PIN Change");
        l1.setFont(new Font("System",Font.BOLD,30));
        l1.setBounds(20,20,400,35);
        image1.add(l1);

        l2 = new JLabel("Enter New PIN");
        l2.setFont(new Font("System",Font.PLAIN,20));
        l2.setBounds(20,120,400,30);
        image1.add(l2);

        p1 = new JPasswordField();
        p1.setFont(new Font("System",Font.PLAIN,20));
        p1.setBounds(250,120,200,30);
        image1.add(p1);

        l3 = new JLabel("Re-enter New PIN");
        l3.setFont(new Font("System",Font.PLAIN,20));
        l3.setBounds(20,180,400,30);
        image1.add(l3);

        p2 = new JPasswordField();
        p2.setFont(new Font("System",Font.PLAIN,20));
        p2.setBounds(250,180,200,30);
        image1.add(p2);


        b2 = new JButton("Change");
        b2.setFont(new Font("System", Font.PLAIN, 16));
        b2.setBounds(300, 250, 150, 30);
        b2.addActionListener(this);
        image1.add(b2);

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

        try{

            String pin1 = p1.getText();
            String pin2 = p2.getText();


            //not p1 = p2
            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Please recheck the pin entered");
                return;
            }
            if (e.getSource()==b2) {
                if (pin1.equals("") || pin2.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter PIN.");
                    return;
                }

                SQLConnection connection = new SQLConnection();
                String query1 = "update process set pin = '"+pin1+"' where pin = '"+pin+"'";
                String query2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String query3 = "update signup3 set pin = '"+pin1+"' where pin = '"+pin+"'";

                connection.statement.executeUpdate(query1);
                connection.statement.executeUpdate(query2);
                connection.statement.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully.");
                setVisible(false);
                new mainpage(pin);

            } else if (e.getSource()==b4){
                setVisible(false);
                new mainpage(pin);
            } else if (e.getSource()==b8) {
                System.exit(0);
            }



        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
