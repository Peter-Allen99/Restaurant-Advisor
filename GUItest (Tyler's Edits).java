
package guiTest;



import java.awt.Color;

import java.awt.Font;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.File;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import javax.swing.JComboBox;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JTextField;



public class GUItest extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	static String input;

	TestUtil TU =new TestUtil(input);

	String[] messageStrings = arrayFull(TU.readList());
	
	ArrayList<String> list1 = new ArrayList<String>();
	ArrayList<String> list2 = new ArrayList<String>();
	ArrayList<String> list3 = new ArrayList<String>();

	
	//String[] list = arrayFull(SearchTest.venueSearch());
	String[] venue = { "Fast Food", "Family Style"};
	String[] cuisine = { "Burger", "Pasta", "Coffee", "Pizza"};
	String[] options = { "Venue Check", "Cuisine Check", "Compare Both"};
	String[] reviewOptions = { "Get Score", "Print All Reviews", "Add Review"};
	String[] smallNames = {"mcdonalds","olivegarden","starbucks", "pizzahut"};

	String[] Descriptors = { "Name", "Address", "Phone Number", "Email", "Hours of Operation", "Type of cuisine",
			"Type of dining", "Price Range", "Food Items", "Price of Food", "Rating" };
	
	@SuppressWarnings({ "unchecked", "rawtypes" })

	JComboBox cmbMessageList = new JComboBox(messageStrings);
	
	JComboBox cmbMessageList2 = new JComboBox(smallNames);
	
	JComboBox cmbMessageList3 = new JComboBox(venue);
	
	JComboBox cmbMessageList4 = new JComboBox(Descriptors);

	JComboBox cmbMessageList5 = new JComboBox(cuisine);
	
	JComboBox cmbMessageList6 = new JComboBox(options);

	JComboBox cmbMessageList7 = new JComboBox(reviewOptions);

	
	@SuppressWarnings({ "unchecked", "rawtypes" })

	JComboBox descriptors = new JComboBox(Descriptors);



	JTextField res;

	JTextField index;
	
	JTextField Rating;
	
	JTextField thing;


	JButton on;

	JLabel answer;
    JLabel L = new JLabel(""); 
    JLabel J = new JLabel(""); 

	public String resString = "";

	public String indexString = "";

	public String output = "";



	public static void main(String[] args) throws IOException {

		new GUItest().setVisible(true);

		//newFile("olivegarden");

	}



	// sets up the main gui

	GUItest() {

		super("Restaurant checker");

		setSize(900, 600);

		setResizable(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLocationRelativeTo(null);

		setLayout(new GridLayout(5,3));

		getContentPane().setBackground(Color.gray);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//get item company name
		
		cmbMessageList.setSelectedIndex(1);

		cmbMessageList.addActionListener(this);

		add(cmbMessageList);
		
		//review company name

		cmbMessageList2.setSelectedIndex(1);

		cmbMessageList2.addActionListener(this);

		add(cmbMessageList2);
				
		//search test venue
		
		cmbMessageList3.setSelectedIndex(1);

		cmbMessageList3.addActionListener(this);

		add(cmbMessageList3);
		
		//get item index (help)
		
		cmbMessageList4.setSelectedIndex(1);

		cmbMessageList4.addActionListener(this);

		add(cmbMessageList4);
		// ========================================== Text input 1



		// ========================================== Text input 2

		index = new JTextField("Please Write A Review");

		add(index);
		
		cmbMessageList5.setSelectedIndex(1);

		cmbMessageList5.addActionListener(this);

		add(cmbMessageList5);
		
        add(L);
		
		Rating = new JTextField("Enter the Amount of Stars (0-5)");
		add(Rating);
		
		cmbMessageList6.setSelectedIndex(1);

		cmbMessageList6.addActionListener(this);

		add(cmbMessageList6);
		
		on = new JButton("Check");

		on.setFont(new Font("Serif", Font.BOLD, 40));

		on.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//JButton cb = (JButton) e.getSource();

				String resString = (String) cmbMessageList.getSelectedItem();
				
				ArrayList<String> rest = TU.getRes(resString);
								
				indexString = (String) cmbMessageList4.getSelectedItem();
								
				GetItem GI = new GetItem(rest, "", TU.getShortName2(resString));

				output = GI.GetIndex(indexString);

				L.setText(output);
				}
			
		});
		
		add(on);
		
        add(J);
		
		thing = new JTextField("");
		add(thing);
		
		thing = new JTextField("");
		add(thing);
		
		cmbMessageList7.setSelectedIndex(1);

		cmbMessageList7.addActionListener(this);

		add(cmbMessageList7);
		
		thing = new JTextField("");
		add(thing);

		// ========================================== Button that checks

		// ========================================== Label for answer
		
	}



	// what happens when button is pushed

	@Override

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == cmbMessageList6) {

			@SuppressWarnings("rawtypes")

			JComboBox cb = (JComboBox) e.getSource();

			String resString = (String) cb.getSelectedItem();
			
			SearchTest t = new SearchTest((String)cmbMessageList3.getSelectedItem(),(String)cmbMessageList5.getSelectedItem());
			
			if(resString.equals("Venue Check")){
				list1 = t.venueSearch((String)cmbMessageList3.getSelectedItem());
				System.out.println(list1);
			}

			if(resString.equals("Cuisine Check")){
				list2 = t.cuisineSearch((String)cmbMessageList5.getSelectedItem());
				System.out.println(list2);
			}
			if(resString.equals("Compare Both")){
				list1 = t.venueSearch((String)cmbMessageList3.getSelectedItem());
				list2 = t.cuisineSearch((String)cmbMessageList5.getSelectedItem());
				list3 = SearchTest.compareRes(list1, list2);
				System.out.println(list3);
			}
			//ArrayList<String> rest = TU.getRes(resString);

			//System.out.println(rest);

			//GetItem GI = new GetItem(rest, "", TU.getShortName2(resString));

			//indexString = index.getText();

			//output = GI.GetIndex(indexString);

			//answer.setText(list1);
		}
		
		if (e.getSource() == cmbMessageList7) {

			@SuppressWarnings("rawtypes")

			JComboBox cb = (JComboBox) e.getSource();
			indexString = (String) cmbMessageList2.getSelectedItem();
			RatingWriter t = new RatingWriter(indexString);
			String resString = (String) cb.getSelectedItem();
			String review = index.getText();
			String rating = Rating.getText();
			
			if(resString.equals("Get Score")){
				String a = t.ratingScore();
				J.setText(a);
			}
			
			if(resString.equals("Print All Reviews")){
				try {
					//potentially open a new window to display
					newWindow correct = new newWindow(indexString);
					correct.test();

					//correct.setVisible(true);

					dispose();
					t.printAll();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//J.setText(a);
			}
			
			if(resString.equals("Add Review")){
				try {
					t.addReviewCode(review,rating);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		
		}

	}



	// creates a new file

	public static void newFile(String s) throws IOException {

		File file = new File(s + ".txt");

		file.createNewFile();

	}

	

	//changes the format of the input string

	public static String[] arrayFull(String[] array) {

		TestUtil TU =new TestUtil(input);

		int size = array.length;

		for (int i = 0; i < size; i++) {

			array[i] = TU.getFullName(array[i]);

		}

		return array;

	}

	

}