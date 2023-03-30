import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class signupthree extends JFrame implements ActionListener{

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    signupthree( String formno){
        this.formno = formno;

        setLayout(null);

        JLabel l1= new JLabel ("page 3: Account details");
        l1.setFont(new Font("raleway",Font.BOLD,22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel ("Account type");
        type.setFont(new Font("raleway",Font.BOLD,22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("saving account");
        r1.setFont(new Font("raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 150, 20);
        add(r1);

        r2 = new JRadioButton("Fixed deposite account");
        r2.setFont(new Font("raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 20);
        add(r2);

        r3 = new JRadioButton("Current account");
        r3.setFont(new Font("raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 20);
        add(r3);

        r4 = new JRadioButton("Recurring deposite account");
        r4.setFont(new Font("raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel ("card number");
        card.setFont(new Font("raleway",Font.BOLD,22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel number = new JLabel ("xxxx-xxxx-xxxx-4185");
        number.setFont(new Font("raleway",Font.BOLD,22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel carddetail = new JLabel ("Your 16 digit card number");
        carddetail.setFont(new Font("raleway",Font.BOLD,12));
        carddetail.setBounds(100, 330, 300, 20);
        add(carddetail);

        JLabel pin = new JLabel ("pin");
        pin.setFont(new Font("raleway",Font.BOLD,22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pnumber = new JLabel ("xxxx");
        pnumber.setFont(new Font("raleway",Font.BOLD,22));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);

        JLabel pindetail = new JLabel ("Your 4 digit password");
        pindetail.setFont(new Font("raleway",Font.BOLD,12));
        pindetail.setBounds(100, 400, 300, 20);
        add(pindetail);

        JLabel services = new JLabel ("services required:");
        services.setFont(new Font("raleway",Font.BOLD,22));
        services.setBounds(100, 450, 400, 30);
        add(services);

        c1 = new JCheckBox("ATM card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("raleway",Font.BOLD,16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("internet banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("raleway",Font.BOLD,16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("raleway",Font.BOLD,16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("email and SMS alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("raleway",Font.BOLD,16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("checkbook");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("raleway",Font.BOLD,16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E- statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("raleway",Font.BOLD,16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("raleway",Font.BOLD,12));
        c7.setBounds(100, 650, 580, 30);
        add(c7);

        submit = new JButton("submit");
        submit.setBounds(150, 680, 100, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("raleway",Font.BOLD,14));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("cancel");
        cancel.setBounds(320, 680, 100, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("raleway",Font.BOLD,14));
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 820);
        setLocation(350,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "saving account";
            } else if (r2.isSelected()){
                accountType = "Fixed deposite account"; 
            } else if (r3.isSelected()){
                accountType = "Current account"; 
            } else if (r2.isSelected()){
                accountType = "Reccuring deposite account"; 
            }
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L ) + 504093600000000L);

            String pinnumber = "" + Math.abs((random.nextLong() % 9000L ) + 1000L);

            String facility = "";
            if (c1.isSelected()){
                facility = facility + " ATM card";
            } else if (c2.isSelected()){
                facility = facility + " Internet banking";
            } else if (c3.isSelected()){
                facility = facility + " Mobile banking";
            } else if (c4.isSelected()){
                facility = facility + " email & SMS alerts";
            }else if (c5.isSelected()){
                facility = facility + " check book";
            } else if (c6.isSelected()){
                facility = facility + " E-banking";
            }

            try {
                 if (accountType.equals("")){
                     JOptionPane.showMessageDialog(null, "Account type is required");
                 }else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "card number: " + cardnumber+ "\n pin: " + pinnumber);
                 }
                 setVisible(false);
                 new deposit(pinnumber).setVisible(false);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource () == cancel) {
            setVisible(false);
            new Login().setVisible(true);

        } 
    }
    public static void main(String args[]){
        new signupthree("");
    }
    
}
