package guiTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox cmbMessageList = new JComboBox(messageStrings);

	String[] Descriptors = { "Name", "Address", "Phone Number", "Email", "Hours of Operation", "Type of cuisine",
			"Type of dining", "Price Range", "Food Items", "Price of Food", "Rating" };
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox descriptors = new JComboBox(Descriptors);

	JTextField res;
	JTextField index;
	JButton on;
	JLabel answer;
	public String resString = "";
	public String indexString = "";
	public String output = "";

	public static void main(String[] args) throws IOException {
		new GUItest().setVisible(true);
		//newFile("olivegarden");
	}

	// sets up the main gui
	private GUItest() {
		super("Restaurant checker");
		setSize(900, 600);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3, 1));
		getContentPane().setBackground(Color.MAGENTA);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cmbMessageList.setSelectedIndex(1);
		cmbMessageList.addActionListener(this);
		add(cmbMessageList);
		// ========================================== Text input 1

		// ========================================== Text input 2
		index = new JTextField("name");
		add(index);
		// ========================================== Button that checks
		on = new JButton("Check");
		on.setFont(new Font("Serif", Font.BOLD, 80));
		on.addActionListener(this);
		// add(on);
		// ========================================== Label for answer
		answer = new JLabel(" ", JLabel.CENTER);
		answer.setFont(new Font("Serif", Font.BOLD, 75));
		add(answer);
	}


	// what happens when button is pushed
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmbMessageList) {
			@SuppressWarnings("rawtypes")
			JComboBox cb = (JComboBox) e.getSource();
			String resString = (String) cb.getSelectedItem();

			ArrayList<String> rest = TU.getRes(resString);
			//System.out.println(rest);
			GetItem GI = new GetItem(rest, "", TU.getShortName2(resString));

			indexString = index.getText();
			output = GI.GetIndex(indexString);
			answer.setText(output);
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
