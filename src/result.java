



import java.awt.event.*;
import java.sql.*;

import javax.swing.*;



public class result extends JFrame implements ActionListener {
	Connection con;
	Statement st;
	ResultSet rs;
 JLabel l0= new JLabel("select candidate");
 JComboBox ch=new JComboBox();
 
 JLabel l1=new JLabel("Vote");
 JTextField t1 =new JTextField();
 JLabel l2=new JLabel("Name");
 JTextField t2 =new JTextField();
 JLabel l3=new JLabel("Party name");
 JTextField t3 =new JTextField();
 JLabel l4=new JLabel("Symbol");
 JTextField t4 =new JTextField();
 
 
 JButton b2=new JButton("select");

 public result()
 {
     this.setLayout(null);
     this.setVisible(true);
     this.setSize(600,700);
     l0.setBounds(270, 170,70,40);
     ch.setBounds(360, 170,100,40);
     l1.setBounds(90, 170,70,40);
       t1.setBounds(180, 170,50,40);
        l2.setBounds(90, 230,70,40);
       t2.setBounds(180, 230,50,40);
       l3.setBounds(90, 290,70,40);
       t3.setBounds(180, 290,50,40);
        l4.setBounds(90, 350,70,40);
       t4.setBounds(180, 350,50,40);
      add(l0);
      add(ch);
       add(l1);
       add(t1);
       add(l2);
       add(t2);
       add(l3);
       add(t3);
       add(l4);
       add(t4);
       
       b2.setBounds(190,400,80,30);
       add(b2);
       b2.addActionListener(this);
      
      
       
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
       new result();
    }

   
    public void actionPerformed(ActionEvent e) {
       
       
       if(e.getSource()==b2)
       {
    	   try{
        	   rs=st.executeQuery("Select * from regis2 where name='"+ch.getSelectedItem()+"'");
        	   if(rs.next())
        	   {
        		   t1.setText(rs.getString(10));
        		   t2.setText(rs.getString(2));
        		   t3.setText(rs.getString(9));
        		   t4.setText(rs.getString(7));
        	   }
        	   else{
        	   JOptionPane.showMessageDialog(null,"candidate  not exist");
        	   }
        }
         
           catch(Exception ex)
           {
        	   JOptionPane.showMessageDialog(null,ex.getMessage());
           }
       }
      
       
    }
    

}

