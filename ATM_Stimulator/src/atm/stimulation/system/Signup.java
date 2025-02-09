package atm.stimulation.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JRadioButton r1,r2;
    JButton b1;

    JDateChooser date;

    //generate random form no.
    Random ran=new Random();
    long ran1=(ran.nextLong()%9000L) + 1000L;
    String first = " " +Math.abs(ran1);
    JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14,label15,label16,label17;
    JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11;
    Signup(){
        super("Application");
        //getting bank image from the folder and scaling it
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank2.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        //taking the image as a label as u cant add image directly
        JLabel image1 = new JLabel(i3);
        //where should the image be visible
        image1.setBounds(25,10,100,100);
        add(image1);


        label1 = new JLabel("Form No." + first);
        label1.setBounds(630,30,600,40);
        label1.setFont(new Font("Raleway",Font.ITALIC,20));
        add(label1);

        label2 = new JLabel("Page 1");
        label2.setBounds(730,0,600,40);
        label2.setFont(new Font("Raleway",Font.ITALIC,10));
        add(label2);

        label3 = new JLabel("Applicant Information");
        label3.setBounds(260,60,600,30);
        label3.setFont(new Font("Raleway",Font.BOLD,25));
        add(label3);

        txt1 = new JTextField();
        txt1.setFont(new Font("Raleway",Font.PLAIN,12));
        txt1.setBounds(10,120,200,25);
        add(txt1);

        label4 = new JLabel("First name* ");
        label4.setBounds(10,135,600,40);
        label4.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label4);

        txt2 = new JTextField();
        txt2.setFont(new Font("Raleway",Font.PLAIN,12));
        txt2.setBounds(290,120,200,25);
        add(txt2);

        label5 = new JLabel("Middle name ");
        label5.setBounds(290,135,600,40);
        label5.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label5);

        txt3 = new JTextField();
        txt3.setFont(new Font("Raleway",Font.PLAIN,12));
        txt3.setBounds(570,120,200,25);
        add(txt3);

        label6 = new JLabel("Last name*");
        label6.setBounds(570,135,600,40);
        label6.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label6);

        txt4 = new JTextField();
        txt4.setFont(new Font("Raleway",Font.PLAIN,12));
        txt4.setBounds(10,180,760,25);
        add(txt4);

        label7 = new JLabel("Address line 1*");
        label7.setBounds(10,195,600,40);
        label7.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label7);

        txt11 = new JTextField();
        txt11.setFont(new Font("Raleway",Font.PLAIN,12));
        txt11.setBounds(10,240,760,25);
        add(txt11);

        label8 = new JLabel("Address line 2* ");
        label8.setBounds(10,255,600,40);
        label8.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label8);

        txt5 = new JTextField();
        txt5.setFont(new Font("Raleway",Font.PLAIN,12));
        txt5.setBounds(10,300,200,25);
        add(txt5);

        label9 = new JLabel("City*");
        label9.setBounds(10,315,600,40);
        label9.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label9);

        txt6 = new JTextField();
        txt6.setFont(new Font("Raleway",Font.PLAIN,12));
        txt6.setBounds(290,300,200,25);
        add(txt6);

        label10 = new JLabel("State*");
        label10.setBounds(290,315,600,40);
        label10.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label10);

        txt7 = new JTextField();
        txt7.setFont(new Font("Raleway",Font.PLAIN,12));
        txt7.setBounds(570,300,200,25);
        add(txt7);

        label11 = new JLabel("Zip Code*");
        label11.setBounds(570,315,600,40);
        label11.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label11);

        txt8 = new JTextField();
        txt8.setFont(new Font("Raleway",Font.PLAIN,12));
        txt8.setBounds(10,360,200,25);
        add(txt8);

        label12 = new JLabel("Phone Number(Primary)*");
        label12.setBounds(10,375,600,40);
        label12.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label12);

        txt9 = new JTextField();
        txt9.setFont(new Font("Raleway",Font.PLAIN,12));
        txt9.setBounds(290,360,200,25);
        add(txt9);

        label13 = new JLabel("Phone Number(Alternate)");
        label13.setBounds(290,375,600,40);
        label13.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label13);

        txt10 = new JTextField();
        txt10.setFont(new Font("Raleway",Font.PLAIN,12));
        txt10.setBounds(570,360,200,25);
        add(txt10);

        label14 = new JLabel("Email Address*");
        label14.setBounds(570,375,600,40);
        label14.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label14);

        label15 = new JLabel("Gender*:");
        label15.setBounds(10,428,600,40);
        label15.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label15);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.PLAIN,12));
        r1.setBackground(Color.white);
        r1.setBounds(100,435,60,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.PLAIN,12));
        r2.setBackground(Color.white);
        r2.setBounds(180,435,100,30);
        add(r2);
// to deselect one of the buttons when the other is chosen
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        label16 = new JLabel("Date of Birth*:");
        label16.setBounds(400,430,600,40);
        label16.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label16);

        date = new JDateChooser();
        date.setForeground(Color.white);
        date.setBounds(520,435,200,25);
        add(date);

        label17 = new JLabel("*Required");
        label17.setForeground(Color.red);
        label17.setBounds(5,460,600,40);
        label17.setFont(new Font("Raleway",Font.ITALIC,12));
        add(label17);

        //next button
        b1 = new JButton("Next");
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(690,475,80,25);
        b1.addActionListener(this);
        add(b1);



        //bg color
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(800,550);
        setLocation(250,70);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){

        String formno = first;
        String fname = txt1.getText();
        String mname = txt2.getText();
        String lname = txt3.getText();
        String address1 = txt11.getText();
        String address2 = txt4.getText();
        String city = txt5.getText();
        String state = txt6.getText();
        String zipcode = txt7.getText();
        String num1 = txt8.getText();
        String num2 = txt9.getText();
        String email = txt10.getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        } else if (r2.isSelected()){
            gender = "Female";
        }
//        String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();

        try{
            if(txt1.getText().equals("") || txt3.getText().equals("") || txt4.getText().equals("") || txt5.getText().equals("") || txt6.getText().equals("") || txt7.getText().equals("") || txt8.getText().equals("") || txt10.getText().equals("") || txt11.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the required credentials.");
            }else {
                SQLConnection connection1 = new SQLConnection();
                    String query = "insert into signup values('"+formno+"','"+fname+"','"+mname+"','"+lname+"','"+address1+"','"+address2+"','"+city+"','"+state+"','"+zipcode+"','"+num1+"','"+num2+"','"+email+"','"+gender+"')";
                    //to input user entered values into the table in mysql - executeupdate
                    connection1.statement.executeUpdate(query);
                    new Signup2(formno);
                    setVisible(false);
                }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup();

    }
}
