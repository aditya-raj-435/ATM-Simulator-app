package atm.stimulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    JTextField txt1,txt2;
    JButton b1;
    JRadioButton r1,r2,r3,r4,r5,r6;
    JCheckBox check1;
    JComboBox cb1,cb2,cb3,cb4;
    JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14,label15,label16,label17,label18;
    String formno;
    Signup2(String formno){

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

        this.formno = formno;

        label1 = new JLabel("Form No.");
        label1.setBounds(630,30,100,40);
        label1.setFont(new Font("Raleway",Font.ITALIC,20));
        add(label1);

        label12 = new JLabel(formno);
        label12.setBounds(720,30,100,40);
        label12.setFont(new Font("Raleway",Font.ITALIC,20));
        add(label12);

        label2 = new JLabel("Page 2");
        label2.setBounds(730,0,600,40);
        label2.setFont(new Font("Raleway",Font.ITALIC,10));
        add(label2);

        label3 = new JLabel("Applicant Information");
        label3.setBounds(260,60,600,30);
        label3.setFont(new Font("Raleway",Font.BOLD,25));
        add(label3);

        label4 = new JLabel("Residence Type*: ");
        label4.setBounds(15,120,600,30);
        label4.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label4);

        String s1[] = {"Owned","Rented/Leased","Ancestral/Parental","Company Provided"};
        cb1 = new JComboBox(s1);
        cb1.setBackground(Color.white);
        cb1.setFont(new Font("Raleway",Font.PLAIN,12));
        cb1.setBounds(140,120,250,30);
        add(cb1);

        label5 = new JLabel("Status*: ");
        label5.setBounds(445,120,600,30);
        label5.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label5);

        String s2[] = {"NA","Blind","Physically Challenged","Pardanashin","Normal","Illiterate"};
        cb2 = new JComboBox(s2);
        cb2.setBackground(Color.white);
        cb2.setFont(new Font("Raleway",Font.PLAIN,12));
        cb2.setBounds(515,120,250,30);
        add(cb2);

        label6 = new JLabel("Annual Income: ");
        label6.setBounds(15,170,600,30);
        label6.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label6);

        String s3[] = {"Null","<1,00,000","<5,00,000","<10,00,000",">10,00,000"};
        cb3 = new JComboBox(s3);
        cb3.setBackground(Color.white);
        cb3.setFont(new Font("Raleway",Font.PLAIN,12));
        cb3.setBounds(140,170,250,30);
        add(cb3);

        label7 = new JLabel("Occupation: ");
        label7.setBounds(420,170,600,30);
        label7.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label7);

        String s4[] = {"Student","Self-Employed","Salaried","Business","Retired","Other"};
        cb4 = new JComboBox(s4);
        cb4.setBackground(Color.white);
        cb4.setFont(new Font("Raleway",Font.PLAIN,12));
        cb4.setBounds(515,170,250,30);
        add(cb4);

        txt1 = new JTextField();
        txt1.setFont(new Font("Raleway",Font.PLAIN,12));
        txt1.setBounds(15,230,250,25);
        add(txt1);

        label8 = new JLabel("PAN* ");
        label8.setBounds(15,245,600,40);
        label8.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label8);

        txt2 = new JTextField();
        txt2.setFont(new Font("Raleway",Font.PLAIN,12));
        txt2.setBounds(280,230,250,25);
        add(txt2);

        label9 = new JLabel("Aadhaar Number*");
        label9.setBounds(280,245,600,40);
        label9.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label9);

        label12 = new JLabel("Existing Account*:");
        label12.setBounds(540,222,600,40);
        label12.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label12);

        r5 = new JRadioButton("Yes");
        r5.setBounds(660,222,60,40);
        r5.setFont(new Font("Raleway",Font.PLAIN,12));
        r5.setBackground(Color.white);
        add(r5);

        r6 = new JRadioButton("No");
        r6.setBounds(720,222,60,40);
        r6.setBackground(Color.white);
        r6.setFont(new Font("Raleway",Font.PLAIN,12));
        add(r6);

        ButtonGroup buttonGroup3 = new ButtonGroup();
        buttonGroup3.add(r5);
        buttonGroup3.add(r6);

        label10 = new JLabel("Married*:");
        label10.setBounds(15,295,600,40);
        label10.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label10);

        r1 = new JRadioButton("Yes");
        r1.setBounds(100,295,60,40);
        r1.setFont(new Font("Raleway",Font.PLAIN,12));
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setBounds(160,295,60,40);
        r2.setBackground(Color.white);
        r2.setFont(new Font("Raleway",Font.PLAIN,12));
        add(r2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);

        label11 = new JLabel("Minor*:");
        label11.setBounds(250,295,600,40);
        label11.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label11);

        r3 = new JRadioButton("Yes");
        r3.setBounds(330,295,60,40);
        r3.setFont(new Font("Raleway",Font.PLAIN,12));
        r3.setBackground(Color.white);
        add(r3);

        r4 = new JRadioButton("No");
        r4.setBounds(390,295,60,40);
        r4.setBackground(Color.white);
        r4.setFont(new Font("Raleway",Font.PLAIN,12));
        add(r4);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(r3);
        buttonGroup2.add(r4);

        label12 = new JLabel("Declaration*");
        label12.setBounds(15,350,600,40);
        label12.setFont(new Font("Raleway",Font.PLAIN,14));
        add(label12);

        check1 = new JCheckBox(" I hereby declare that all the information given above is true and correct to the best of my knowledge.");
        check1.setBounds(15,385,600,40);
        check1.setFont(new Font("Raleway",Font.PLAIN,12));
        check1.setBackground(Color.white);
        add(check1);

        b1 = new JButton("Next");
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(690,475,80,25);
        b1.addActionListener(this);
        add(b1);

        label13 = new JLabel("*Required");
        label13.setForeground(Color.red);
        label13.setBounds(5,440,600,40);
        label13.setFont(new Font("Raleway",Font.ITALIC,12));
        add(label13);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(800,550);
        setLocation(250,70);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String restype = (String) cb1.getSelectedItem();
        String status = (String) cb2.getSelectedItem();
        String income = (String) cb3.getSelectedItem();
        String occupation = (String) cb4.getSelectedItem();
        String pan = txt1.getText();
        String aadhaar = txt2.getText();
        String existing = null;
        if(r5.isSelected()){
            existing = "Yes";
        } else if (r6.isSelected()){
            existing = "No";
        }
        String married = null;
        if(r1.isSelected()){
            married = "Yes";
        } else if (r2.isSelected()){
            married = "No";
        }
        String minor = null;
        if(r3.isSelected()){
            minor = "Yes";
        } else if (r4.isSelected()){
            minor = "No";
        }
        try{
            if(e.getSource()==b1) {

            if(restype.equals("") || status.equals("") || income.equals("") || occupation.equals("") || pan.equals("") || aadhaar.equals("") || existing.equals("") || married.equals("") || minor.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the required credentials.");
            }else {
                SQLConnection connection = new SQLConnection();
                String query = "insert into signup2 values('" + formno + "','" + restype + "','" + status + "','" + income + "','" + occupation + "','" + pan + "','" + aadhaar + "','" + existing + "','" + married + "','" + minor + "')";
                //to input user entered values into the table in mysql - execute update
                connection.statement.executeUpdate(query);
                new Signup3(formno);
                setVisible(false);
            }

            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup2("");

    }

}
