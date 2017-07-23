import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
public class main extends JFrame implements ActionListener
{
MenuBar mb=new MenuBar();
Menu h=new Menu("Registervoters");
MenuItem Home=new MenuItem("Registervoters");
Menu About=new Menu("RegisterCandidate");
MenuItem a=new MenuItem("RegisterCandidate");
Menu Contact=new Menu("Vote");
Menu Branches=new Menu("Result");

public main()
{
	this.setVisible(true);
	this.setLayout(null);
	this.setSize(500,600);
	mb.add(h);
	h.add(Home);
	mb.add(About);
	About.add(a);
	mb.add(Contact);
	mb.add(Branches);
	
	this.setMenuBar(mb);
	Home.addActionListener(this);
	a.addActionListener(this);
	Contact.addActionListener(this);
	Branches.addActionListener(this);
}
	public static void main(String[] args) 
	{
		new main();
		
}

	public void actionPerformed(ActionEvent arg0) {
	if(arg0.getSource()==Home)
	{
		new register();
		
	}if(arg0.getSource()==a)
	{
		new regcan();
		
	}
	if(arg0.getSource()==Contact)
	{
		new log();
		this.hide();
	}
	if(arg0.getSource()==Branches)
	{
		new result();
		this.hide();
	}
		
	}

}

