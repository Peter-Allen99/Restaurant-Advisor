package guiTest;

import java.awt.GridLayout;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class newWindow {
	
	static String indexString;
	public newWindow(String s){
		indexString=s;
		
}

	public static void test() throws IOException {

		JFrame login; // the login frame

		//creating the login frame

		login = new JFrame("test");

		login.setLayout(new GridLayout(1,1));
		
		login.setSize(200, 200);

		login.setLocationRelativeTo(null);

		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel user; // where to find the username and password
		
		GUItest j = new GUItest();
				
		System.out.println(indexString);
		
		RatingWriter t = new RatingWriter(indexString);
		
		user = new JLabel("");
				
		String listString;
			listString = String.join(", ", t.printAll());
			user.setText(listString);

		
		
		//user.setSize(800,800);

		login.add(user);

		login.setVisible(true);

	}


	
}
