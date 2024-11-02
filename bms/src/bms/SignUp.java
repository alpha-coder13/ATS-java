package src.bms;

import javax.swing.*;
import java.awt.*;

public class SignUp extends JFrame {
    public SignUp(){

        getContentPane().setBackground(Color.black);
        setLayout(null);

        //Jlabels
        JLabel[] labelsFeilds = new JLabel[5];
        String[] labels = {"Name", "Age" , "Date of Birth","Gender", "Email" };
        int index = 0, heightYLabel = 30;

        for(;index< 5; index++){
            labelsFeilds[index] = new JLabel(labels[index] + ":");
            labelsFeilds[index].setBounds(30, heightYLabel, 150, 20);
            labelsFeilds[index].setFont(new Font("Arial", Font.BOLD, 16 ));
            labelsFeilds[index].setForeground(Color.white);
            heightYLabel = heightYLabel + 60;
            add(labelsFeilds[index]);
        }


        //JTextFeilds
        JTextField[] textFeilds = new JTextField[5];
        index = 0;
        heightYLabel = 30;

        for(;index< 5; index++){
            textFeilds[index] = new JTextField(labels[index]);
            textFeilds[index].setBounds(180, heightYLabel, 300, 20);
            textFeilds[index].setFont(new Font("Arial", Font.ITALIC, 16 ));
            textFeilds[index].setForeground(Color.gray);
            heightYLabel = heightYLabel + 60;
            add(textFeilds[index]);
        }


         // frame
        setSize(600, 500);
        setVisible(true);
        setLocation(350, 200);
    }

    public static void main(String[] args){
        new SignUp();
    }
}
