package atm.stimulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    //globally declaring labels,text field, pass field n buttons
    JLabel label1,label2,label3;
    JTextField textField1;
    JPasswordField passwordField1;
    JButton button1, button2, button3;
    //Creating the login constructor
    Login(){
        //getting bank image from the folder and scaling it
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        //taking the image as a label as u cant add image directly
        JLabel image1 = new JLabel(i3);
        //where should the image be visible
        image1.setBounds(350,10,80,100);
        add(image1);

        //credit card image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
        Image i5 = i4.getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(680,325,100,100);
        add(image2);



        //to show a text in the frame - JLabel
        label1 = new JLabel("BANK IN A BOX");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Verdana",Font.BOLD,25));
        //x - right to left , y = top to bottom
        label1.setBounds(290,125,450,40);
        add(label1);

        label2 = new JLabel("Card Number: ");
        label2.setFont(new Font("Verdana",Font.BOLD,20));
        label2.setForeground(Color.BLACK);
        label2.setBounds(200,190,375,30);
        add(label2);

        //text field to enter card num
        textField1 = new JTextField(15) ;
        textField1.setBounds(375,190,230,30);
        textField1.setFont(new Font("Arial",Font.BOLD,14));
        add(textField1);

        label3 = new JLabel("PIN: ");
        label3.setFont(new Font("Verdana",Font.BOLD,20));
        label3.setForeground(Color.BLACK);
        label3.setBounds(200,250,375,30);
        add(label3);

        //pass field to enter pin
        passwordField1 = new JPasswordField(15);
        passwordField1.setBounds(375,250,230,30);
        passwordField1.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField1);

        button1 =  new JButton("Sign in");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.white);
        button1.setBackground(Color.black);
        button1.setBounds(250,310,100,30);
        button1.addActionListener(this);
        add(button1);

        button2 =  new JButton("Sign up");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.white);
        button2.setBackground(Color.black);
        button2.setBounds(400,310,100,30);
        button2.addActionListener(this);
        add(button2);

        button3 =  new JButton("Clear");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.white);
        button3.setBackground(Color.black);
        button3.setBounds(325,360,100,30);
        button3.addActionListener(this);
        add(button3);


        //background image
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.png"));
        Image i8 = i7.getImage().getScaledInstance(800,450, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image3 = new JLabel(i9);
        image3.setBounds(0,0,800,450);
        add(image3);


        //layout size view and availing the login frame
        //in here default layout is border layout n hence we set it to null, we can scale everything
        setLayout((null));
        setSize(800,450);
        setLocation(250,120);
        // to let the upper bar disappear
        setUndecorated(true);
        setVisible(true);


    }
    //override action performed - whenever we click the buttons this stores the action
    @Override
    public void actionPerformed(ActionEvent e) {
        //using try catch cuz thr can be exceptions (getsource is used to check if the user clicked on the button)
        try{
            if(e.getSource() == button1){
                SQLConnection connection = new SQLConnection();
                String card = textField1.getText();
                String pin = passwordField1.getText();
                String query = "select * from login where Card_No = '"+card+"' and pin = '"+pin+"'";
                ResultSet resultSet = connection.statement.executeQuery(query);
                if (resultSet.next()){
                    setVisible(false);
                    new mainpage(pin);
                } else {
                    JOptionPane.showMessageDialog(null,"Please enter the correct credentials");
                }
            } else if (e.getSource() == button2) {
                new Signup();
                setVisible(false);

            } else if (e.getSource() == button3) {
                textField1.setText("");
                passwordField1.setText("");
            }
        }catch(Exception E){
            E.printStackTrace();
        }


    }

    //creating a main class
    public static void main(String[] args) {
        //an object Login()
        new Login();

    }
}
