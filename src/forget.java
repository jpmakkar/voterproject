
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;



public class forget  extends JFrame implements ActionListener {
	Connection con;
	Statement st;
	ResultSet rs;
 
 
 JLabel l1=new JLabel("Email");
 JTextField t1 =new JTextField();
 
 JLabel l4=new JLabel("select q");
 JTextField t4 =new JTextField();
 JLabel l5=new JLabel("ans");
 JTextField t5 =new JTextField();
 
 JLabel l6=new JLabel("new password");
 JPasswordField t6 =new JPasswordField();

 JLabel l7=new JLabel("re enter password");
 JPasswordField t7 =new JPasswordField();
 JButton b1=new JButton("submit");
 JButton b2=new JButton("forget");
 JButton b4=new JButton("change pass");

public forget()
{
    this.setLayout(null);
    this.setVisible(true);
    this.setSize(600,700);
   
    l1.setBounds(90, 170,70,40);
      t1.setBounds(180, 170,90,40);
      
      
       
      
       l4.setBounds(90, 410,70,40);
      t4.setBounds(180, 410,90,40);
      l5.setBounds(90, 470,70,40);
      t5.setBounds(180, 470,90,40);
      l6.setBounds(90, 560,70,40);
      t6.setBounds(180, 560,90,40);
      l7.setBounds(90, 620,70,40);
      t7.setBounds(180, 620,90,40);
  
      add(l1);
      add(t1);
    
      add(l4);
      add(t4);

      add(l5);
      add(t5);
      add(l6);
      add(t6);
    
      add(l7);
      add(t7);

      
      b1.setBounds(90, 290,100,40);
      add(b1);
      b1.addActionListener(this);
      b2.setBounds(190,510,100,30);
      add(b2);
      b2.addActionListener(this);
      b4.setBounds(260,620,100,30);
      add(b4);
      b4.addActionListener(this);
      l4.setVisible(false);
      t4.setVisible(false);
      l5.setVisible(false);
     t5.setVisible(false);
      b2.setVisible(false);
      l6.setVisible(false);
      t6.setVisible(false);
      l7.setVisible(false);
     t7.setVisible(false);
      b4.setVisible(false);

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

public static void main(String[] args) {
    new forget();
 }

public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1)
    {
 	  

 	 	   try{
 	     	   rs=st.executeQuery("Select * from regis where email='"+t1.getText()+"'");
 	     	   if(rs.next())
 	     	   { l4.setVisible(true);
 	          t4.setVisible(true);
 	         l5.setVisible(true);
 	        t5.setVisible(true);
 	         b2.setVisible(true);
 	        t4.setText(rs.getString(9));
 	     	   }
 	     	   else{
 	     	   JOptionPane.showMessageDialog(null,"user not exist");
 	     	   }}
       catch(Exception ex)
       {
    	   JOptionPane.showMessageDialog(null,ex.getMessage());
       }}
	
	if(e.getSource()==b2)
    {
 	  

 	 	   try{
 	     	   rs=st.executeQuery("Select * from regis where ans='"+t5.getText()+"'");
 	     	   if(rs.next())
 	     	   { l6.setVisible(true);
 	          t6.setVisible(true);
 	         l7.setVisible(true);
 	        t7.setVisible(true);
 	         b4.setVisible(true);

 	     	   }
 	     	   else{
 	     	   JOptionPane.showMessageDialog(null,"user not exist");
 	     	   }}
       catch(Exception ex)
       {
    	   JOptionPane.showMessageDialog(null,ex.getMessage());
       }}

	if(e.getSource()==b4)
	{
		  
		 if(t6.getText().equals(t7.getText())) 
		 {  try{
		     	  st.executeUpdate("Update  regis set pass='"+t6.getText()+"'");
		     	   
		     	 JOptionPane.showMessageDialog(null,"pass changed");
		     	   }
	   catch(Exception ex)
	   {
		   JOptionPane.showMessageDialog(null,ex.getMessage());
	   }}
}
	
	
}
	}






