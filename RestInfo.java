package cleanGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class RestInfo extends JFrame implements ActionListener {

	static ResUtility RU = new ResUtility();
	String[] messageStrings = arrayFull(RU.readList());
	String[] Descriptors = { "Name", "Address", "Phone Number", "Email", "Hours of Operation", "Type of cuisine",
			"Type of dining", "Price Range", "Rating" };

	public String indexString = "";
	public String output = "";

	JLabel L = new JLabel("");
	
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox cmbMessageList = new JComboBox(messageStrings);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox cmbMessageList4 = new JComboBox(Descriptors);
	JButton on;

	RestInfo() {
		super("Restaurant Info");
		setSize(325, 350);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(Color.gray);
		dispose();

		cmbMessageList.setLocation(50, 60);
		cmbMessageList.addActionListener(this);
		cmbMessageList.setSize(200, 30);
		add(cmbMessageList);

		// get item index (help)
		cmbMessageList4.setLocation(50, 120);
		cmbMessageList4.setSize(200, 30);
		cmbMessageList4.addActionListener(this);
		add(cmbMessageList4);

		JLabel options = new JLabel();
		options = new JLabel("Restaurants:");
		options.setLocation(50, 40);
		options.setSize(options.getPreferredSize());
		add(options);

		options = new JLabel("Types Information:");
		options.setLocation(50, 100);
		options.setSize(options.getPreferredSize());
		add(options);

		options = new JLabel("Restaurant Information:");
		options.setLocation(50, 20);
		options.setSize(600, 20);
		options.setFont(new Font("Serif", Font.BOLD, 20));
		add(options);
		
		JLabel out = new JLabel("output");
		out.setLocation(50, 240);
		out.setSize(out.getPreferredSize());
		add(out);

		// The Enter Button
		on = new JButton("Search");
		on.setFont(new Font("Serif", Font.BOLD, 20));
		on.setLocation(50, 180);
		on.setSize(200, 30);
		on.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// JButton cb = (JButton) e.getSource();
				String resString = (String) cmbMessageList.getSelectedItem();
				indexString = (String) cmbMessageList4.getSelectedItem();
				ResInfo RI = new ResInfo("", RU.getShortName2(resString));
				output = RI.GetIndex(indexString);
				out.setText(output);
				out.setSize(out.getPreferredSize());
				L.setText(output);
			}
		});
		add(on);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

	public static String[] arrayFull(String[] array) {
		// ResUtility RU = new ResUtility();
		int size = array.length;
		for (int i = 0; i < size; i++) {
			array[i] = RU.getFullName(array[i]);
		}
		return array;
	}
}