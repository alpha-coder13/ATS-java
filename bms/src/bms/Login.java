package src.bms;

import javax.swing.*;
import java.awt.*;

public class Login  extends JFrame{
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

        JTextField cardText =  new JTextField();
        cardText.setBounds(400, 120, 300 , 20);
        add(cardText);


        // pin
        JLabel pin = new JLabel("Enter your pin :");
        pin.setBounds( 150, 180, 300 , 20);
        pin.setFont(new Font("Arial", Font.BOLD, 16 ));
        add(pin);

        JTextField pinText =  new JTextField();
        pinText.setBounds(400, 180, 300 , 20);
        add(pinText);


        // button for login form
        JButton loginButton = new JButton("Click to Login");
        loginButton.setBounds(400, 240, 150 , 40);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.white);
        add(loginButton);

        JButton clearButton = new JButton("clear");
        clearButton.setBounds(575, 240, 100 , 40);
        clearButton.setBackground(Color.BLACK);
        clearButton.setForeground(Color.white);
        add(clearButton);

        setSize(800 , 400); // sets the size of the frame
        setVisible(true); // sets the visibility of the frame // default is false;
        setResizable(false);
        setLocation(350 , 200);// sets the distance from the origin of the screen
    }
    public static void main(String[] args){
        new Login();
        System.out.println("This is main class of src.bms.Login");
    }
}
