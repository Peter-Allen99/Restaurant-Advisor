package guiTest;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class fancyGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	String[] messageStrings = readList();
	JComboBox cmbMessageList = new JComboBox(messageStrings);
	JLabel lblText = new JLabel();
	public static void main(String[] args) {
		System.out.println(Arrays.toString(readList()));
		fancyGUI fr = new fancyGUI();

		fr.setVisible(true);

	}

	public fancyGUI() {
		setLayout(new FlowLayout());
		setSize(400, 300);
		setTitle("yolo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cmbMessageList.setSelectedIndex(1);
		cmbMessageList.addActionListener(this);
		add(cmbMessageList);
		add(lblText);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmbMessageList) {
			JComboBox cb = (JComboBox) e.getSource();
			String msg = (String) cb.getSelectedItem();
			
			System.out.println(msg);
			System.out.println(readRes(msg));

		}

	}
	
	public static String[] readList() {
		String line = null;

		ArrayList<String> res = new ArrayList<String>();
		try {
			FileReader fr = new FileReader("RestaurantList.txt");
			BufferedReader br = new BufferedReader(fr);
			for (int i = 0; i < 11; i++) {
				if ((line = br.readLine()) != null) {
					res.add(line);
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println("File not found");
		}
		
		String[] bar = res.toArray(new String[res.size()]);
		
		return bar;
	}
	
	public static ArrayList<String> readRes(String s) {
		String line = null;

		ArrayList<String> res = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(s+".txt");
			BufferedReader br = new BufferedReader(fr);
			for (int i = 0; i < 11; i++) {
				if ((line = br.readLine()) != null) {
					res.add(line);
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println("File not found");
		}
		
		
		
		return res;
	}
}
