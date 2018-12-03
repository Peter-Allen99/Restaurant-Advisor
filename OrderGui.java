package clean;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class OrderGui extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	String resString;
	static String[] Res = { "mcdonalds", "olivegarden", "starbucks", "pizzahut" };
	static ResUtility TU = new ResUtility();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox resCB = new JComboBox(Res);

	JLabel item1M, item2M, item3M, title, result;
	JButton button;
	JTextField t1, t2, t3;

	OrderGui() {

		setSize(325, 350);
		//setResizable(false);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		setLayout(null);
		//getContentPane().setBackground(Color.gray);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// get item company name
		resCB.setLocation(50, 60);
		resCB.addActionListener(this);
		resCB.setSize(220, 30);
		add(resCB);

		title = new JLabel("Order Food");
		title.setLocation(50, 30);
		title.setSize(600, 20);
		title.setFont(new Font("Serif", Font.BOLD, 23));
		add(title);

		item1M = new JLabel();
		item1M.setLocation(50, 110);
		item1M.setSize(item1M.getPreferredSize());
		add(item1M);

		item2M = new JLabel();
		item2M.setLocation(50, 150);
		item2M.setSize(item2M.getPreferredSize());
		add(item2M);

		item3M = new JLabel();
		item3M.setLocation(50, 190);
		item3M.setSize(item3M.getPreferredSize());
		add(item3M);

		result = new JLabel();
		result.setLocation(50, 270);
		result.setSize(result.getPreferredSize());
		add(result);

		button = new JButton("Order");
		button.setFont(new Font("Serif", Font.BOLD, 20));
		button.setLocation(110, 220);
		button.setSize(button.getPreferredSize());
		add(button);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == resCB) {
			@SuppressWarnings("rawtypes")
			JComboBox cb = (JComboBox) e.getSource();
			resString = (String) cb.getSelectedItem();

			getMenu(resString);
			ArrayList<String> menu = getMenu(resString);
			System.out.println(menu);

			item1M.setText(menu.get(0));
			item1M.setSize(item1M.getPreferredSize());

			item2M.setText(menu.get(1));
			item2M.setSize(item2M.getPreferredSize());

			item3M.setText(menu.get(2));
			item3M.setSize(item3M.getPreferredSize());

			t1 = new JTextField();
			t1.setBounds(230, 105, 30, 23);
			add(t1);
			t2 = new JTextField();
			t2.setBounds(230, 145, 30, 23);
			add(t2);
			t3 = new JTextField();
			t3.setBounds(230, 185, 30, 23);
			add(t3);

		}
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResOrder OT = new ResOrder();
				String answer = OT.resGetOrder(resString, t1.getText(), t2.getText(), t3.getText());
				result.setText(answer);

				result.setSize(item3M.getPreferredSize());
				System.out.println(answer);

			}
		});

	}

	public static ArrayList<String> getMenu(String s) {

		String input = s;
		String check1 = TU.getRes(input).get(8);
		String check2 = TU.getRes(input).get(9);
		ArrayList<String> output = new ArrayList<String>();
		String[] parts1 = check1.split(",");
		String[] parts2 = check2.split(",");

		String item1 = parts1[0] + "   " + parts2[0] + "   x  ";
		String item2 = parts1[1] + "   " + parts2[1] + "   x  ";
		String item3 = parts1[2] + "   " + parts2[2] + "   x  ";

		output.add(item1);
		output.add(item2);
		output.add(item3);
		
		return output;

	}

}