package src.bms;

import src.bms.connection.Connect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JButton cancel, submit;
    String formNum;
    public SignUp3(String formNo){
        setLayout(null);
        formNum = formNo;
        JLabel head = new JLabel("Page last : Account Description");
        head.setBounds(150,20,400,30);
        head.setFont(new Font("Raleway", Font.BOLD, 20));
        add(head);

        JLabel t1 = new JLabel("AccountType");
        t1.setBounds(10,70,200,30);
        t1.setFont(new Font("Raleway", Font.BOLD, 20));
        add(t1);

        r1 = new JRadioButton("Savings account");
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("Arial",Font.BOLD, 16));
        r1.setBounds(10, 120, 250, 20);
        add(r1);

        r2 = new JRadioButton("Current account");
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("Arial",Font.BOLD, 16));
        r2.setBounds(10, 160, 250, 20);
        add(r2);

        r3 = new JRadioButton("Savings + Current account");
        r3.setBackground(Color.WHITE);
        r3.setFont(new Font("Arial",Font.BOLD, 16));
        r3.setBounds(310, 120, 250, 20);
        add(r3);

        r4 = new JRadioButton("Reccurring account");
        r4.setBackground(Color.WHITE);
        r4.setFont(new Font("Arial",Font.BOLD, 16));
        r4.setBounds(310, 160, 250, 20);
        add(r4);

        ButtonGroup buttonGrp = new ButtonGroup();
        buttonGrp.add(r1);
        buttonGrp.add(r2);
        buttonGrp.add(r3);
        buttonGrp.add(r4);

        JLabel t2 = new JLabel("Card Number Format:");
        t2.setBounds(10,200,250,30);
        t2.setFont(new Font("Raleway", Font.BOLD, 20));
        add(t2);

        JLabel t3 = new JLabel("XXXX-XXXX-XXXX-4184");
        t3.setBounds(300,200,400,30);
        t3.setFont(new Font("Raleway", Font.BOLD, 20));
        add(t3);


        JLabel t4 = new JLabel("PIN Format:");
        t4.setBounds(10,250,150,30);
        t4.setFont(new Font("Raleway", Font.BOLD, 20));
        add(t4);

        JLabel t5 = new JLabel("XXXX");
        t5.setBounds(170,250,100,30);
        t5.setFont(new Font("Raleway", Font.BOLD, 20));
        add(t5);


        JLabel t6 = new JLabel("Your Card Number");
        t6.setBounds(10,300,250,20);
        t6.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(t6);

        JLabel t7 = new JLabel();
        t7.setBounds(270,300,250,20);
        t7.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(t7);


        JLabel t8 = new JLabel("Your PIN");
        t8.setBounds(10,340,150,20);
        t8.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(t8);

        JLabel t9 = new JLabel();
        t9.setBounds(170,340,100,20);
        t9.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(t9);

        submit = new JButton("Submit");
        submit.setBounds(170,380,100,50);
        submit.setBackground(Color.white);
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(270,380,100,50);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        add(cancel);
        // frame;
        setSize(600,600);
        setLocation(300,300);
        setBackground(Color.WHITE);
        setVisible(false);
    }
    public void actionPerformed(ActionEvent E){
        if(E.getSource() == submit){
            String accountType = "", ATM_NUMBER = "", PIN="";
            if(r1.isSelected()){
                accountType = r1.getText();
            }else if(r2.isSelected()){
                accountType = r2.getText();
            }else if(r3.isSelected()){
                accountType = r3.getText();
            }else if(r4.isSelected()){
                accountType = r4.getText();
            }

            Long atm_number = Math.abs((new Random().nextLong())%100000L);
            ATM_NUMBER = "5006001" + atm_number;

            Long pin = Math.abs((new Random().nextLong())%10000L);
            PIN = PIN +pin;

            String db_query_additionalData = "insert into additionalDetail_acc value('"+formNum+"', '"+accountType+"', '"+ATM_NUMBER+"', '"+PIN+"');";
            String db_query_Login = "insert into login value('"+ATM_NUMBER+"', '"+PIN+"');";
            try{
                Connect c = new Connect();
                c.s.executeUpdate(db_query_additionalData);
                c.s.executeUpdate(db_query_Login);
                setVisible(false);
                new Login().setVisible(true);
            }catch(Exception Ex){
                System.out.println(Ex.getMessage());
            }
        }else if(E.getSource() == cancel){
            String db_query_delete_1 = "delete from additionaldetails where form_no ="+formNum;
            String db_query_delete_2 = "delete from signup where form_no ="+formNum;
            try{
                Connect c =  new Connect();
                c.s.executeUpdate(db_query_delete_1);
                c.s.executeUpdate(db_query_delete_2);
                setVisible(false);
                new Login().setVisible(true);
            }catch (Exception Ex){
                System.out.println("Delete Failed because of" + Ex.getMessage());
            }
        }
    }
    public static void main(String[] args){
    }
}
