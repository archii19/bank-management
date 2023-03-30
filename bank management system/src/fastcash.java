import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;

public class fastcash extends JFrame implements ActionListener {

    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;

    fastcash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(780,780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,780,780);
        add(image);

        JLabel text = new JLabel("Select Withdrawl amount");
        text.setBounds(200,250,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,13));
        image.add(text);

        deposit = new JButton("RS 100");
        deposit.setBounds(135,352,150,25);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(300,352,137,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(135,387,150,25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(300,387,137,25);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(135,422,150,25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(300,422,137,25);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("BACK");
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
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            String withdrawlamt = withdrawl.getText();
            Conn c = new Conn();
            try {
            
                String query = "insert into bank (pin, withdrawl, amount) values('"+pinnumber+"','"+withdrawlamt+"','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs"+amount+"debited successfully");
                setVisible(false);
                new transaction(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }

        
        } 
    }

    public static void main(String args[]){
        new fastcash("");

    }
    
}

