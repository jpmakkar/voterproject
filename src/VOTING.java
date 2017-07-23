import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class VOTING  extends JFrame implements ActionListener  {
	Connection con;
	Statement st;
	ResultSet rs;
	int ac,bal1,bal2,bal3;
	Object acc;
	JLabel l1=new JLabel("Select the candidate you want to vote");
	JComboBox ch=new JComboBox();
	
	 JTextField t1 =new JTextField();
	JButton b3=new JButton("confirm");

	public VOTING()
	{
		
	    this.setLayout(null);
	    this.setVisible(true);
	    this.setSize(600,700);
	   
	    l1.setBounds(90, 170,270,40);
	
	   
	    ch.setBounds(360, 170,100,40);
	    b3.setBounds(180, 340,90,40);
	    add(l1);
	      add(t1);
	      add(ch);
	    add(b3);
	    b3.addActionListener(this);
	    
	    
	    try{
	    	   Class.forName("com.mysql.jdbc.Driver");
	    	   
	    	   con=DriverManager.getConnection("jdbc:mysql://localhost/voter","root","nsmakkar23");
	      
	    st=con.createStatement();
	    }
	     
	       catch(Exception ex)
	       {
	    	   JOptionPane.showMessageDialog(null,ex.getMessage());
	       }
	       
	       try{
	    	   rs=st.executeQuery("Select * from regis2");
	    	   while(rs.next())
	    	   {ch.addItem(rs.getString(2));
	    	  
	    	   
	    	   }}

	           catch(Exception ex)
	           {
	        	   JOptionPane.showMessageDialog(null,ex.getMessage());
	           }
	}

	
	public static void main(String[] args) {
	    new VOTING();
	 }


	public void actionPerformed(ActionEvent ar)
	{
	if(ar.getSource()==b3)
	{
		
		acc=ch.getSelectedItem();
		/*if(ch.getSelectedItem().equals("Deep Kaur"))
		{
			bal1=bal1+1;
		}
		
		if(ch.getSelectedItem().equals("jp"))
		{
			bal1=bal1+1;
		}
		if(ch.getSelectedItem().equals("mandy"))
		{
			bal1=bal1+1;
		}*/
		try{
	    	rs=st.executeQuery("select * from regis2 where name='"+acc+"'");
	 	   if(rs.next())
	 	   {
	 		   bal1=Integer.parseInt(rs.getString(10))+1;
	 	   }
	    }
	     
	       catch(Exception ex)
	       {
	    	   JOptionPane.showMessageDialog(null,ex.getMessage());
	       }
		try{
	    	st.executeUpdate("update regis2 set balance='"+bal1+"' where name='"+acc+"'");
	 	   JOptionPane.showMessageDialog(null,"vote peroformed ");
	 	   System.exit(0);
	    }
	     
	       catch(Exception ex)
	       {
	    	   JOptionPane.showMessageDialog(null,ex.getMessage());
	       }
	       
	      
	}
	}

}

