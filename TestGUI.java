package guiTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

class TestGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JLabel status;
	@SuppressWarnings("rawtypes")
	JComboBox fromLocations;
	@SuppressWarnings("rawtypes")
	JComboBox destinations;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	TestGUI() {
		super("Book a Flight!");
		JLabel fromLabel = new JLabel("Current Location:");
		String[] from = { "Paris" };
		fromLocations = new JComboBox(from);

		// fromLocations.addItem(someLocation);
		// ...
		JLabel toLabel = new JLabel("Destination:");
		String[] to = { "Belfast" };
		destinations = new JComboBox(to);
		// destinations.addItem("Belfast");
		// destinations.addItem(someLocation);
		// ...
		JButton okButton = new JButton("OK");
		status = new JLabel("");
		setSize(900, 600);
		add(fromLabel);
		add(fromLocations);
		add(toLabel);
		add(destinations);
		okButton.addActionListener(this);
		add(okButton);
		add(status);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	public void actionPerformed(ActionEvent e) {
		Object from = fromLocations.getSelectedItem();
		String FROM = from.toString();
		Object to = destinations.getSelectedItem();
		String TO = to.toString();
		status.setText("You're flying from " + FROM + "to " + TO + ".");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TestGUI().setVisible(true);
			}
		});
	}
}