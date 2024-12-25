package src.bms;

import src.bms.connection.Connect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class SignUp extends JFrame implements ActionListener {
    JButton submit;
    JTextField[] textFeilds;
    long random;
    String[] labels;


    public SignUp(){

        getContentPane().setBackground(Color.black);
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        labels = new String[]{"Name", "Age" , "Date of Birth","Gender", "Email" };

        // JLabel heading;
        JLabel heading = new JLabel("Form No:" + random);
        heading.setFont(new Font("Arial", Font.ROMAN_BASELINE, 32));
        heading.setBounds(200, 30, 400, 40);
        heading.setForeground(Color.white);
        add(heading);

        //Jlabels
        JLabel[] labelsFeilds = new JLabel[labels.length];
        int index = 0, heightYLabel = 100;

        for(;index<labels.length; index++){
            labelsFeilds[index] = new JLabel(labels[index] + ":");
            labelsFeilds[index].setBounds(30, heightYLabel, 150, 20);
            labelsFeilds[index].setFont(new Font("Arial", Font.BOLD, 16 ));
            labelsFeilds[index].setForeground(Color.white);
            heightYLabel = heightYLabel + 60;
            add(labelsFeilds[index]);
        }


        //JTextFeilds
        textFeilds = new JTextField[labels.length];
        index = 0;
        heightYLabel = 100;

        for(;index<labels.length; index++){
            textFeilds[index] = new JTextField();
            textFeilds[index].setBounds(180, heightYLabel, 300, 20);
            textFeilds[index].setFont(new Font("Arial", Font.ITALIC, 16 ));
            textFeilds[index].setForeground(Color.gray);
            heightYLabel = heightYLabel + 60;
            add(textFeilds[index]);
        }

        submit = new JButton("Submit");
        submit.setBounds(200, heightYLabel, 100,50);
        submit.setBackground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

         // frame
        setSize(600, 500);
        setLocation(350, 200);
    }
    public void actionPerformed(ActionEvent ae){
        String formNo = ""+random;
        String[][] textValues = new String[labels.length][2];
        boolean isValidForm = true;
        for(int i = 0 ; i <textValues.length; i++ ){
            textValues[i][0] = labels[i];
            textValues[i][1] = textFeilds[i].getText();
        }
        for(int i = 0 ; i <textValues.length; i++ ){
            if (textValues[i][0].equals("Name") && textValues[i][1].equals("")) {
                isValidForm = false;
                JOptionPane.showMessageDialog(null, "The name is empty");
            }else{
                isValidForm = true;
            }
        }

        if(isValidForm){
            Connect c = new Connect();
            String query = "insert into signup value('"+formNo+"', ";
            for(int i = 0 ; i < textValues.length ; i++ ){
                query  = query+"'"+textValues[i][1]+"', ";
            }
            query = query.substring(0, query.length()-2);
            query = query + ")";
            try {
                c.s.executeUpdate(query);
                new SignUp2(random).setVisible(true);
                setVisible(false);
            }catch (Exception E){
                System.out.println("Delete Failed because of" + E.getMessage());
                setVisible(false);
                new Login().setVisible(true);
            }
        }
    }

    public static void main(String[] args){
    }
}
