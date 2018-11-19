package clean;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.*;

public class newWindow {
	
	static String indexString;
	public newWindow(String s){
		indexString=s;
		
}

	public void test() throws IOException {

		JFrame login; // the login frame

		//creating the login frame

		login = new JFrame(indexString+" reviews");
		login.setLayout(new GridLayout(1,1));
		login.setSize(400, 200);
		login.setLocationRelativeTo(null);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel user; // where to find the username and password
		//GUItest2 j = new GUItest2();
		System.out.println(indexString);
		ResRating RW = new ResRating(indexString);
		
		user = new JLabel("");
				
		String listString;
			listString = String.join(", ", RW.printAll());
			user.setText(listString);

		//user.setSize(800,800);

		login.add(user);
		login.setVisible(true);

	}


	
}