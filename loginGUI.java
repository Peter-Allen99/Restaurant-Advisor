package clean;

import java.awt.event.*; 
import javax.swing.*;

/* There are 2 important methods in this class
 * 
 * The loginGUI method/class 
 * -creates the simple GUI that the user can log into
 * -includes
 * 		~Jframe
 * 		~textfields
 * 		~Jlabels
 * 
 * The validator method 
 * -takes the user input from the textfields
 * -compares the input to a set username and password strings
 * -if true, the window disposes and opens the main GUI window
 * -if false, opens an optionPane and displays and incorrect username and password message
 * 		~once the message window is closed, the previous strings in the text fields are cleared
 * 
 * 	Creator: Matt Stark
 */

//The username is "restaurant" and the password is "login"


public class loginGUI extends JPanel {
	
	private static final long serialVersionUID = 1L;
	String u; // the user inputed username
	String p; // the user inputed password
	JTextField username; // the username field
	JTextField password; // the password field
	JLabel user; // the "Enter username" text on the screen
	JLabel pass; // the "Enter password" text on the screen
	JLabel info; // where to find the username and password
	JButton enter; // the enter button

	loginGUI() {
		//initializing the login frame
		JFrame login; 
		
		//creating the login frame
		login = new JFrame("Login");
		login.setSize(350, 200);
		login.setLocationRelativeTo(null);
		login.setLayout(null);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//creating the "Enter Username: " text
		user = new JLabel("Enter Username:");
		user.setSize(user.getPreferredSize());
		user.setLocation(30, 10);
		login.add(user);
		
		//creating the "Enter Password: " text
		pass = new JLabel("Enter Password:");
		pass.setSize(pass.getPreferredSize());
		pass.setLocation(30, 60);
		login.add(pass);
		
		//creating the username textfield
		username = new JTextField();
		username.setColumns(25);
		username.setSize(username.getPreferredSize());

		username.setLocation(30, 30);
		username.setToolTipText("Enter Username");
		login.add(username);
		
		//creating the password text field
		password = new JTextField();
		password.setColumns(25);
		password.setSize(password.getPreferredSize());

		password.setLocation(30, 80);
		password.setToolTipText("Enter Password");
		login.add(password);
		p = password.getText();
		
		//creating the enter button
		enter = new JButton("Enter");
		enter.setSize(enter.getPreferredSize());
		enter.setLocation(30,110);
		login.add(enter);
		
		//making the window visible and passing onto the validator method
		login.setVisible(true);
		validator();
	}

	public void validator() {
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				
				//obtaining the user input strings
				u = username.getText();
				p = password.getText();
				
				//if the username and the password are correct move to the main GUItest class
				if (u.equals("restaurant") && p.equals("login")) {
					RestaurantGUI correct = new RestaurantGUI();
					correct.setVisible(true);
					//dispose();
				}
				
				//if the username and password are incorrect display an incorrect message
				else {
					JOptionPane.showMessageDialog(null,"Wrong	Password	/	Username");
					username.setText("");
					password.setText("");
					username.requestFocus();
				}
			}
		});
	}
}