



import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;


public class log extends JFrame implements ActionListener
{
	Connection con;
	Statement st;
	ResultSet rs;
	JLabel name, pass;
        JTextField nameText;
        JPasswordField passText;
        JButton login, forget;
      

        public log()
        {
                name = new JLabel("Email:");
                pass = new JLabel("Password:");

                nameText = new JTextField();
                passText = new JPasswordField();

                login = new JButton("Login");
                forget = new JButton("Forget pass");

                login.addActionListener(this);
               forget.addActionListener(this);

                name.setBounds(50,50,90,50);
                add(name);
                pass.setBounds(50,120,70,50);
                add(pass);
                nameText.setBounds(140,60,50,30);
                add(nameText);
                passText.setBounds(140,130,50,30);
                add(passText);
                login.setBounds(70,190,90,30);
                add(login);
                forget.setBounds(170,190,120,30);
                add(forget);
                

                setTitle("Login Check");
                this.setSize(500,500);
               this.setLayout(null);
                this.setVisible(true);
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
        	if (ar.getSource()==login)
    		{
    			  
    			try{
    				rs=st.executeQuery("Select * from regis where email ='"+ nameText.getText()+"'and pass='"+passText.getText()+"'");
    				
    				if(rs.next())
    				{
    					
    					 new VOTING();
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(null,"invalid user name or password");
    				}
    			}
    			catch(Exception ex)
    		       {
    		    	   JOptionPane.showMessageDialog(null,ex.getMessage());
    		       }
    		}
        	if (ar.getSource()==forget)
    		{
    			  
    			new forget();
    		}
    			  
    			
        }

        public static void main(String args[])
        {
                new log();
        }
}




