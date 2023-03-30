
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class transaction extends JFrame implements ActionListener {

    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;

    transaction(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(780,780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,780,780);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(200,250,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,13));
        image.add(text);

        deposit = new JButton("deposit");
        deposit.setBounds(135,352,150,25);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("cash withdrawl");
        withdrawl.setBounds(300,352,137,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("fast cash");
        fastcash.setBounds(135,387,150,25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("mini statement");
        ministatement.setBounds(300,387,137,25);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("pin change");
        pinchange.setBounds(135,422,150,25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("balance enquiry");
        balanceenquiry.setBounds(300,422,137,25);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("exit");
        exit.setBounds(300,455,137,20);
        exit.addActionListener(this);
        image.add(exit);


        setSize(750,750);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== exit){
            System.exit(0);
        } else if (ae.getSource() == deposit){

            setVisible(false);
            new deposit(pinnumber).setVisible(true);

        } else if (ae.getSource()== withdrawl){
            setVisible(false);
            new withdrawl(pinnumber).setVisible(true);

        } else if (ae.getSource()== fastcash){
            setVisible(false);
            new fastcash(pinnumber).setVisible(true);
        }  else if (ae.getSource()== pinchange){
            setVisible(false);
            new pinchange(pinnumber).setVisible(true);
        }      
    }

    public static void main(String args[]){
        new transaction("");

    }
    
}
