import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw , back;
    String pinnumber;

    withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("  Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdraw = new JButton("withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if ( ae.getSource() == withdraw){
            // Date date = new Date();
            String number = amount.getText();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw ");
            } else{
                
                try{
                    Conn conn = new Conn();
                    String query = "insert into withdraw values('"+pinnumber+"','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs"+number+"withdraw successfully");
                    setVisible(false);
                    new transaction(pinnumber).setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }
                

            }

        }else if (ae.getSource() == back){
            setVisible(false);
            new transaction(pinnumber).setVisible(true);

        } 
    }

    public static void main(String args[]) {
        new withdrawl("");
    }
    
}
