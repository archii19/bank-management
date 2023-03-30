import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton Login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {
        setTitle("Automated Teller Machine");

        setLayout(null);

        ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank icon.jpg"));
        Image a2 = a1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon a3 = new ImageIcon(a2);
        JLabel lable = new JLabel(a3);
        lable.setBounds(70,10,100,100);
        add(lable);

        JLabel text =new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno =new JLabel("Card No.");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 250, 30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        add(cardTextField);

        JLabel pin =new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        add(pinTextField);

        Login = new JButton("SIGN IN");
        Login.setBounds(300, 300, 100, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");

        } else if (ae.getSource() == Login){ 
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber='" +cardnumber+"' and pin ='"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new transaction(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,"incorrect card number or Pin");
                }

            }catch (Exception e){
                System.out.println(e);
            }
        }else if (ae.getSource() == signup){
            setVisible(false);
            new signupone().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new Login();
    }
     
} 