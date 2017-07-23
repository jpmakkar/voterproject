import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

public class regcan extends JFrame implements ActionListener
{
	Connection con;
	Statement st;
	JLabel l=new JLabel("Candidate    REGISTRATION    PROCESS");
	JLabel l0=new JLabel("A User has to Register  before He/she is elegibe for Voting.");
	JLabel l1=new JLabel("Name");
	JLabel l2=new JLabel("Father's Name");
	JLabel l3=new JLabel("Date of Birth");
	JLabel l4=new JLabel("Address");
	JLabel l5=new JLabel("Email");
	JLabel l6=new JLabel("Party Symbol");
	JLabel l8=new JLabel("Total Income");
	JLabel l9=new JLabel("Party Name");
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JTextField t5=new JTextField();
	JTextField t6=new JTextField();
	
	JTextField t8=new JTextField();
	JTextField t9=new JTextField();
	JButton b1=new JButton("Submit");
	
	public regcan()
	{
		
		setTitle("Registration Form");
        this.setSize(500,500);
       this.setLayout(null);
        this.setVisible(true);
        
        
        l.setBounds(50,30,290,50);
        l0.setBounds(50,70,390,50);  
        l1.setBounds(50,110,90,50);  
        l2.setBounds(50,150,90,50);  
        l3.setBounds(50,190,90,50);  
        l4.setBounds(50,230,90,50);  
        l5.setBounds(50,270,90,50);  
        l6.setBounds(50,310,90,50);
        
        l8.setBounds(50,350,90,50);
        l9.setBounds(50,390,90,50);  
        t1.setBounds(150,120,90,30);  
        t2.setBounds(150,160,90,30);  
        t3.setBounds(150,200,90,30);  
        t4.setBounds(150,240,90,30);  
        t5.setBounds(150,280,90,30);  
        t6.setBounds(150,320,90,30);  
        t8.setBounds(150,360,90,30);
        t9.setBounds(150,400,90,30);
        b1.setBounds(120,440,90,30); 
        add(l);
        add(l0);
        add(l1);
        add(l2);
        add(l3);
        add(t9);
        add(l4);
        add(l5);
        add(l6);
        
        add(l9);
        add(l8);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        
        add(t8);
        add(b1);
        
        b1.addActionListener(this);
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        	con=DriverManager.getConnection("jdbc:mysql://localhost/voter","root","nsmakkar23");
        	st=con.createStatement();
        	
        }
        catch(Exception ex)
        {
        	JOptionPane.showMessageDialog(null,ex.getMessage());
        	
        }
        
	}

	public void actionPerformed(ActionEvent ar)
	{
		if (ar.getSource()==b1)
		{
			 
			try{
				st.executeUpdate("Insert into regis2 values (0,'"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"','"+t8.getText()+"','"+t9.getText()+"')");
				JOptionPane.showMessageDialog(null,"one candidate inserted");
			}
			catch(Exception ex)
		       {
		    	   JOptionPane.showMessageDialog(null,ex.getMessage());
		       }
		}
			 
	}
	public static void main(String args[])
    {
            new regcan();
    }
}


