import java.awt.*;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;


public class signuptwo extends JFrame implements  ActionListener{

    JTextField Pan , aadhar;
    JButton next;
    JRadioButton syes, sno ,eyes ,eno ;
    JComboBox religion, category ,income , occupation, education;
    String formno;
    

    signuptwo(String formno){

        this.formno = formno;

        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionaldetails = new JLabel(" page 2 : additional Details");
        additionaldetails.setFont(new Font("Raleway" , Font.BOLD ,22));
        additionaldetails.setBounds(290, 80, 400, 30);
        add(additionaldetails);

        JLabel name = new JLabel("Religion: ");
        name.setFont(new Font("Raleway" , Font.BOLD ,20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String valreligion[] = {"Hindu","Muslim","sikh","christian","others"};
        religion = new JComboBox(valreligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        
        JLabel fname = new JLabel("Category: ");
        fname.setFont(new Font("Raleway" , Font.BOLD ,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String valcategory[ ]={"genral","OBC","sc","ST","others"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income ");
        dob.setFont(new Font("Raleway" , Font.BOLD ,20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String incomecategory[ ]={"null","< 1,50,000","< 2,50,000","< 5,00,000","upto 10Lac"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender = new JLabel("educational ");
        gender.setFont(new Font("Raleway" , Font.BOLD ,20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("qualification:");
        email.setFont(new Font("Raleway" , Font.BOLD ,20));
        email.setBounds(100, 315, 200, 30);
        add(email);

        String educationvalues[]={"non graduate","graduate","post graduate","engineer","others"};
        education = new JComboBox(educationvalues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel marital = new JLabel("occupation :");
        marital.setFont(new Font("Raleway" , Font.BOLD ,20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        String occupationvalues[]={"salaried","self employed","business","student","retired"};
        occupation = new JComboBox(occupationvalues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address = new JLabel("Pan no. :");
        address.setFont(new Font("Raleway" , Font.BOLD ,20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        Pan = new JTextField();
        Pan.setFont(new Font("Raleway" , Font.BOLD ,14));
        Pan.setBounds(300, 440, 400, 30);
        add(Pan);

        JLabel city = new JLabel("Aadhar no. :");
        city.setFont(new Font("Raleway" , Font.BOLD ,20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway" , Font.BOLD ,14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        JLabel state = new JLabel("senior citizen :");
        state.setFont(new Font("Raleway" , Font.BOLD ,20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
        JLabel pin = new JLabel("exisiting account :");
        pin.setFont(new Font("Raleway" , Font.BOLD ,20));
        pin.setBounds(100, 590, 200, 30);
        add(pin);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected() ){ 
            seniorcitizen = "Yes";
        } else if (sno.isSelected() ){
            seniorcitizen = "No";
        }
        String exisitingaccount = null;
        if (eyes.isSelected() ){ 
            exisitingaccount = "Yes";
        } else if(eno.isSelected() ){
            exisitingaccount = "No";
        }
        String span = Pan.getText();
        String saadhar = aadhar.getText();
        
        try{
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+exisitingaccount+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new signupthree(formno).setVisible(true);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
 

    }
   public static void main(String args[]){
    new signuptwo("");
   } 
} 

