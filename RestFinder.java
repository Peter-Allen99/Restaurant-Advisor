package cleanGUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

@SuppressWarnings("serial")
public class RestFinder extends JFrame implements ActionListener {

	ArrayList<String> list1 = new ArrayList<String>();
	ArrayList<String> list2 = new ArrayList<String>();
	ArrayList<String> list3 = new ArrayList<String>();

	String[] venue = { "Fast Food", "Family Style" };
	String[] cuisine = { "American", "Italian", "Coffee", "Mexican", "Belgian", "Pub", "German", "Chili" };
	String[] options = { "Venue Check", "Cuisine Check", "Compare Both" };

	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox cmbMessageList3 = new JComboBox(venue);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox cmbMessageList5 = new JComboBox(cuisine);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox cmbMessageList6 = new JComboBox(options);

	RestFinder() {
		super("Restaurant Finder");
		setSize(325, 350);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(Color.gray);
		dispose();

		// search test venue
		cmbMessageList3.setLocation(50, 60);
		cmbMessageList3.setSize(200, 30);
		cmbMessageList3.addActionListener(this);
		add(cmbMessageList3);

		cmbMessageList5.setLocation(50, 120);
		cmbMessageList5.setSize(200, 30);
		cmbMessageList5.addActionListener(this);
		add(cmbMessageList5);

		cmbMessageList6.setLocation(50, 180);
		cmbMessageList6.setSize(200, 30);
		cmbMessageList6.addActionListener(this);
		add(cmbMessageList6);

		JLabel options = new JLabel();
		options = new JLabel("Restaurant Finder:");
		options.setLocation(50, 20);
		options.setSize(600, 20);
		options.setFont(new Font("Serif", Font.BOLD, 20));
		add(options);

		options = new JLabel("Type of Food:");
		options.setLocation(50, 100);
		options.setSize(options.getPreferredSize());
		add(options);

		options = new JLabel("Type of Restaurant:");
		options.setLocation(50, 40);
		options.setSize(options.getPreferredSize());
		add(options);

		options = new JLabel("Search Options:");
		options.setLocation(50, 160);
		options.setSize(options.getPreferredSize());
		add(options);

		setVisible(true);
	}

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
	}
}