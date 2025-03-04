package qnmc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class MenuBar extends JMenuBar {
	//CONSTANTS
	public static int bits;
	private String d1 = "Jane Smith";
	private String d2 = "John Doe";
	private String d3 = "Ashok Kumar";
	private String summary = "The Quine McCluskey algorithm (or the method of prime implicants) "
			+ "\nis a method used for minimization of boolean functions which was developed by W.V. "
			+ "\nQuine and Edward J. McCluskey. It is functionally identical to Karnaugh mapping, "
			+ "\nbut the tabular form makes it more efficient for use in computer algorithms, and"
			+ "\nit also gives a deterministic way to check that the minimal form of a Boolean "
			+ "\nfunction has been reached. It is sometimes referred to as the tabulation method.";

	//not used yet
	public void createMenuItem(String itemname, Integer EventKey){
		JMenuItem item = new JMenuItem(itemname, EventKey);
		//method for inside adding action listener
	}

	public void Actionlistener (JMenuItem item){
		item.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			System.out.println("Something"); //method
		}});
	}

	//DEVELOPERSMENU
	public void adddeveloper(String developername){
		JMenuItem developer = new JMenuItem("Developer ", KeyEvent.VK_N);
		developer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showdeveloperinfo(developername);
			}
		});
	}

	public void showdeveloperinfo(String developername){
		JOptionPane.showMessageDialog(null, developername,
				"Quine McCluskey Prime Implicant Generator",
				JOptionPane.INFORMATION_MESSAGE);
	}

	//ABOUT ITEM
	public void about(){
		JMenuItem objective = new JMenuItem("About Quine McCluskey Algorithm",
				KeyEvent.VK_N);

		objective.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showsummary();
			}
		});
	}

	public void showsummary(){
		JOptionPane.showMessageDialog(null, MenuBar.this.summary,
				"Quine McCluskey Prime Implicant Generator",
				JOptionPane.INFORMATION_MESSAGE);
	}

	//FILE MENU
	public JMenuItem Exit(){
		JMenuItem exit = new JMenuItem("Exit  Alt+F4", KeyEvent.VK_N);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		return exit;
	}

	public JMenuItem ctrln(){
		JMenuItem ctrln = new JMenuItem("New  Ctrl+N", KeyEvent.VK_N);
		ctrln.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				enterbits();
			}
		});
		return ctrln;
	};

	public void enterbits(){
		if(GUI.set!=null)GUI.set.clear();

		String booleanbits = JOptionPane
				.showInputDialog("Enter the boolean bits(3 to 5): ");
		try {

			bits = Integer.parseInt(booleanbits);

		} catch (NumberFormatException e) {

			bits=2;
		}
		if(bits<3||bits>5){
			JOptionPane.showMessageDialog(null,
					"Wrong input. Press File and then NEW", "Error",
					JOptionPane.ERROR_MESSAGE, null);

		}
	}

	public MenuBar() {
		filemenu();
		helpmenu();
		developersmenu();
	}

	public void helpmenu(){
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_F);
		add(help);

		help.add(summary);//string
	}

	public void developersmenu(){
		JMenu developers = new JMenu("About...");
		developers.setMnemonic(KeyEvent.VK_F);
		add(developers);

		adddeveloper(d1); //item
		//text, keyevent, objectname, method for action listener
	}

	public void filemenu(){
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F); //f key constant
		add(fileMenu);

		fileMenu.add(Exit()); //item
		fileMenu.add(ctrln());//item
	}
}
