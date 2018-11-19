package clean;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class RestaurantGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	static String input;

	static ResUtility RU = new ResUtility();
	String[] messageStrings = arrayFull(RU.readList());

	ArrayList<String> list1 = new ArrayList<String>();
	ArrayList<String> list2 = new ArrayList<String>();
	ArrayList<String> list3 = new ArrayList<String>();

	// String[] list = arrayFull(SearchTest.venueSearch());
	String[] venue = { "Fast Food", "Family Style" };
	String[] cuisine = { "Burger", "Pasta", "Coffee", "Pizza" };
	String[] options = { "Venue Check", "Cuisine Check", "Compare Both" };
	String[] reviewOptions = { "Get Score", "Print All Reviews", "Add Review" };
	String[] smallNames = { "mcdonalds", "olivegarden", "starbucks", "pizzahut" };
	String[] Descriptors = { "Name", "Address", "Phone Number", "Email", "Hours of Operation", "Type of cuisine",
			"Type of dining", "Price Range", "Food Items", "Price of Food", "Rating" };
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox cmbMessageList = new JComboBox(messageStrings);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox cmbMessageList2 = new JComboBox(smallNames);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox cmbMessageList3 = new JComboBox(venue);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox cmbMessageList4 = new JComboBox(Descriptors);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox cmbMessageList5 = new JComboBox(cuisine);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox cmbMessageList6 = new JComboBox(options);
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	//public static void main(String[] args) throws IOException {
		//new GUItest().setVisible(true);
		// newFile("olivegarden");
	//}
	// sets up the main gui
	RestaurantGUI() {
		super("Restaurant checker");
		setSize(900, 450);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(Color.gray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// get item company name
		cmbMessageList.setLocation(50,60);
		cmbMessageList.addActionListener(this);
		cmbMessageList.setSize(200,30);
		add(cmbMessageList);
		
		// review company name
		JLabel company = new JLabel("Restaurants:");
		company.setLocation(600,100);
		company.setSize(company.getPreferredSize());
		add(company);
		
		cmbMessageList2.setLocation(600,120);
		cmbMessageList2.setSize(200,30);
		cmbMessageList2.addActionListener(this);
		add(cmbMessageList2);
		
		// search test venue
		cmbMessageList3.setLocation(320,60);
		cmbMessageList3.setSize(200,30);
		cmbMessageList3.addActionListener(this);
		add(cmbMessageList3);
		
		// get item index (help)
		cmbMessageList4.setLocation(50,120);
		cmbMessageList4.setSize(200,30);
		cmbMessageList4.addActionListener(this);
		add(cmbMessageList4);
		// ========================================== Text input 1
		// ========================================== Text input 2
		
		//The Review JTextField
		index = new JTextField("Review");
		index.setLocation(600,240);
		index.setSize(200,100);
		add(index);
		
		cmbMessageList5.setLocation(320,120);
		cmbMessageList5.setSize(200,30);
		cmbMessageList5.addActionListener(this);
		add(cmbMessageList5);
		add(L);
		
		//The Rating JTextField
		Rating = new JTextField("Rating");
		Rating.setLocation(600,180);
		Rating.setSize(200,30);
		add(Rating);
		
		cmbMessageList6.setLocation(320,180);
		cmbMessageList6.setSize(200,30);
		cmbMessageList6.addActionListener(this);
		add(cmbMessageList6);
		
		//The Enter Button
		on = new JButton("Search");
		on.setFont(new Font("Serif", Font.BOLD, 20));
		on.setLocation(50,180);
		on.setSize(200,30);
		on.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// JButton cb = (JButton) e.getSource();
				String resString = (String) cmbMessageList.getSelectedItem();
				indexString = (String) cmbMessageList4.getSelectedItem();
				ResInfo RI = new ResInfo("", RU.getShortName2(resString));
				output = RI.GetIndex(indexString);
				System.out.println(output);
				L.setText(output);
			}
		});
		
		add(on);
		add(J);
		
		//============= These are nearly all the labels in the GUI=========
		
		//The Rating Label
		JLabel ratings = new JLabel("Leave a Rating (Out of 5.0):");
		ratings.setLocation(600,160);
		ratings.setSize(ratings.getPreferredSize());
		add(ratings);
		
		JLabel options = new JLabel("Reviews:");
		options.setLocation(600,20);
		options.setSize(ratings.getPreferredSize());
		options.setFont(new Font("Serif", Font.BOLD, 20));
		add(options);
		
		options = new JLabel("Review Options:");
		options.setLocation(600,40);
		options.setSize(ratings.getPreferredSize());
		add(options);
		
		options = new JLabel("Restaurant Finder:");
		options.setLocation(320,20);
		options.setSize(600,20);
		options.setFont(new Font("Serif", Font.BOLD, 20));
		add(options);
		
		options = new JLabel("Restaurant Information:");
		options.setLocation(50,20);
		options.setSize(600,20);
		options.setFont(new Font("Serif", Font.BOLD, 20));
		add(options);
		
		options = new JLabel("Restaurants:");
		options.setLocation(50,40);
		options.setSize(ratings.getPreferredSize());
		add(options);
		
		options = new JLabel("Types Information:");
		options.setLocation(50,100);
		options.setSize(ratings.getPreferredSize());
		add(options);
		
		options = new JLabel("Type of Food:");
		options.setLocation(320,100);
		options.setSize(ratings.getPreferredSize());
		add(options);
		
		options = new JLabel("Type of Restaurant:");
		options.setLocation(320,40);
		options.setSize(ratings.getPreferredSize());
		add(options);
		
		options = new JLabel("Search Options:");
		options.setLocation(320,160);
		options.setSize(ratings.getPreferredSize());
		add(options);
		
		
		cmbMessageList7.setLocation(600,60);
		cmbMessageList7.setSize(200,30);
		cmbMessageList7.addActionListener(this);
		add(cmbMessageList7);
		
		//the Review Label
		JLabel reviews = new JLabel("Leave a Review:");
		reviews.setLocation(600,220);
		reviews.setSize(reviews.getPreferredSize());
		add(reviews);
		
		options = new JLabel("The Restaurant Checker");
		options.setLocation(50,260);
		options.setSize(600,50);
		options.setFont(new Font("Serif", Font.BOLD, 45));
		add(options);
		

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
			ResSearch RS = new ResSearch((String) cmbMessageList3.getSelectedItem(),
					(String) cmbMessageList5.getSelectedItem());

			if (resString.equals("Venue Check")) {
				list1 = RS.venueSearch((String) cmbMessageList3.getSelectedItem());
				System.out.println(list1);
			}

			if (resString.equals("Cuisine Check")) {
				list2 = RS.cuisineSearch((String) cmbMessageList5.getSelectedItem());
				System.out.println(list2);
			}
			if (resString.equals("Compare Both")) {
				list1 = RS.venueSearch((String) cmbMessageList3.getSelectedItem());
				list2 = RS.cuisineSearch((String) cmbMessageList5.getSelectedItem());
				list3 = ResSearch.compareRes(list1, list2);
				System.out.println(list3);
			}
			// ArrayList<String> rest = TU.getRes(resString);
			// System.out.println(rest);
			// GetItem GI = new GetItem(rest, "", TU.getShortName2(resString));
			// indexString = index.getText();
			// output = GI.GetIndex(indexString);
			// answer.setText(list1);
		}

		if (e.getSource() == cmbMessageList7) {
			@SuppressWarnings("rawtypes")
			JComboBox cb = (JComboBox) e.getSource();
			indexString = (String) cmbMessageList2.getSelectedItem();
			ResRating RR = new ResRating(indexString);
			String resString = (String) cb.getSelectedItem();
			String review = index.getText();
			String rating = Rating.getText();

			if (resString.equals("Get Score")) {
				String a = RR.ratingScore();
				J.setText(a);
				System.out.println(a);
			}

			if(resString.equals("Print All Reviews")){
				try {
					//potentially open a new window to display
					newWindow correct = new newWindow(indexString);
					correct.test();

					//correct.setVisible(true);

					dispose();
					RR.printAll();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//J.setText(a);
			}

			if (resString.equals("Add Review")) {
				try {
					RR.addReviewCode(review, rating);
					System.out.println("Review added");
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

	// changes the format of the input string
	public static String[] arrayFull(String[] array) {
		//ResUtility RU = new ResUtility();
		int size = array.length;
		for (int i = 0; i < size; i++) {
			array[i] = RU.getFullName(array[i]);
		}
		return array;
	}
}