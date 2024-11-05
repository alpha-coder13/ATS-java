package src.bms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //interafce class to listen action performed

public class Login  extends JFrame implements ActionListener {

    JButton loginButton, clearButton, signUpButton;
    JTextField cardText;
    JPasswordField pinText;
    Login(){
        setTitle("Automated Teller machine"); // window header
        setLayout(null);//sets the layout of the document
        getContentPane().setBackground(Color.white);
        // currently removing the image part

        // to write something ont he frame , we use jlabel
         // heading
        JLabel text = new JLabel("Welcome to ATM");
        text .setBounds( 250, 40, 400 , 40);
        text.setFont(new Font("Arial", Font.BOLD, 32 ));
        add(text);

        // card number
        JLabel cardNumber = new JLabel("Enter your card number : ");
        cardNumber .setBounds( 150, 120, 300 , 20);
        cardNumber.setFont(new Font("Arial", Font.BOLD, 16 ));
        add(cardNumber);

        cardText =  new JTextField();
        cardText.setBounds(400, 120, 300 , 20);
        add(cardText);


        // pin
        JLabel pin = new JLabel("Enter your pin :");
        pin.setBounds( 150, 180, 300 , 20);
        pin.setFont(new Font("Arial", Font.BOLD, 16 ));
        add(pin);

        pinText =  new JPasswordField();
        pinText.setBounds(400, 180, 300 , 20);
        add(pinText);


        // button for login form
        loginButton = new JButton("Click to Login");
        loginButton.setBounds(400, 240, 150 , 40);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.white);
        loginButton.addActionListener(this);
        add(loginButton);

        clearButton = new JButton("clear");
        clearButton.setBounds(575, 240, 100 , 40);
        clearButton.setBackground(Color.BLACK);
        clearButton.setForeground(Color.white);
        clearButton.addActionListener(this);
        add(clearButton);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(450, 300, 100 , 40);
        signUpButton.setBackground(Color.BLACK);
        signUpButton.setForeground(Color.white);
        signUpButton.addActionListener(this);
        add(signUpButton);

        setSize(800 , 400); // sets the size of the frame
        setVisible(true); // sets the visibility of the frame // default is false;
        setResizable(false);
        setLocation(350 , 200);// sets the distance from the origin of the screen
    }
    public void actionPerformed(ActionEvent ae){ // overriding the method of the interface actionlisterner
        System.out.println(ae.getSource() == loginButton);  // ae is the ActionEvent class to get the event details
        // sample out put :  java.awt.event.ActionEvent[ACTION_PERFORMED,cmd=Click to Login,when=1730461760204,modifiers=Button1] on javax.swing.JButton[,400,240,150x40,alignmentX=0.0,alignmentY=0.5,border=javax.swing.plaf.BorderUIResource$CompoundBorderUIResource@31d294de,flags=296,maximumSize=,minimumSize=,preferredSize=,defaultIcon=,disabledIcon=,disabledSelectedIcon=,margin=javax.swing.plaf.InsetsUIResource[top=2,left=14,bottom=2,right=14],paintBorder=true,paintFocus=true,pressedIcon=,rolloverEnabled=true,rolloverIcon=,rolloverSelectedIcon=,selectedIcon=,text=Click to Login,defaultCapable=true]
        if(ae.getSource() == loginButton){
            // call login pages
        }else if(ae.getSource() == clearButton){
            cardText.setText("");
            pinText.setText("");
        }else if(ae.getSource() == signUpButton){
            // calls signup class
            this.setVisible(false);
            new SignUp().setVisible(true);
        }
    }
    public static void main(String[] args){
        new Login();
        System.out.println("This is main class of src.bms.Login");
    }
}
