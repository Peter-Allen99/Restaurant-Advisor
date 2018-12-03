package cleanGUI;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import java.util.ArrayList;

public class RestReview extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	static ResUtility RU = new ResUtility();
	String[] messageStrings = arrayFull(RU.readList());
	String[] reviewOptions = { "Print All Reviews", "Add Review" };

	ArrayList<String> list1 = new ArrayList<String>();
	ArrayList<String> list2 = new ArrayList<String>();
	ArrayList<String> list3 = new ArrayList<String>();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox cmbMessageList7 = new JComboBox(reviewOptions);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox cmbMessageList2 = new JComboBox(messageStrings);

	JTextField index;
	JTextField Rating;
	public String indexString = "";
	public String resString = "";
	JLabel J = new JLabel("");

	RestReview() {
		super("Restaurant Reviews");
		setSize(325, 400);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(Color.gray);
		dispose();

		cmbMessageList2.setLocation(50, 120);
		cmbMessageList2.setSize(200, 30);
		cmbMessageList2.addActionListener(this);
		add(cmbMessageList2);

		cmbMessageList7.setLocation(50, 60);
		cmbMessageList7.setSize(200, 30);
		cmbMessageList7.addActionListener(this);
		add(cmbMessageList7);

		// The Review JTextField
		index = new JTextField("");
		index.setLocation(50, 240);
		index.setSize(200, 100);
		add(index);

		// The Rating JTextField
		Rating = new JTextField("");
		Rating.setLocation(50, 180);
		Rating.setSize(200, 30);
		add(Rating);

		JLabel ratings = new JLabel("Leave a Rating (Out of 5.0):");
		ratings.setLocation(50, 160);
		ratings.setSize(ratings.getPreferredSize());
		add(ratings);

		JLabel options = new JLabel("Reviews:");
		options.setLocation(50, 20);
		options.setSize(ratings.getPreferredSize());
		options.setFont(new Font("Serif", Font.BOLD, 20));
		add(options);

		options = new JLabel("Review Options:");
		options.setLocation(50, 40);
		options.setSize(ratings.getPreferredSize());
		add(options);

		// the Review Label
		JLabel reviews = new JLabel("Leave a Review:");
		reviews.setLocation(600, 220);
		reviews.setSize(reviews.getPreferredSize());
		add(reviews);

		// review company name
		JLabel company = new JLabel("Restaurants:");
		company.setLocation(50, 100);
		company.setSize(company.getPreferredSize());
		add(company);

		// the Review Label
		JLabel reviews1 = new JLabel("Leave a Review:");
		reviews1.setLocation(600, 220);
		reviews1.setSize(reviews1.getPreferredSize());
		add(reviews1);

		setVisible(true);
	}

	// changes the format of the input string
	public static String[] arrayFull(String[] array) {
		// ResUtility RU = new ResUtility();
		int size = array.length;
		for (int i = 0; i < size; i++) {
			array[i] = RU.getFullName(array[i]);
		}
		return array;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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

			if (resString.equals("Print All Reviews")) {
				try {
					newWindow.test();
					// correct.setVisible(true);

					dispose();
					RR.printAll();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				// J.setText(a);
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
}