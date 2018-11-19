/*This class deals with the adding and displaying of the rating system 
 * 
 * usefull methods
 * ratingScore(); return the average rating
 * printAll();    prints all the reviews
 * addReview();   adds a review to the list
 * 
 */
package clean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ResRating {
	static String company;
	static String companyString;
	String input;
	public ResRating(String name) {
		company = name + "rating";
		companyString = name;
	}

	// creates a new file
	public static void newFile(String s) throws IOException {
		File file = new File(s + ".txt");
		file.createNewFile();
	}

	// adds review to the text file
	public static void appendStrToFile(String str) {
		try {

			// Open given file in append mode.
			BufferedWriter out = new BufferedWriter(new FileWriter(company + ".txt", true));
			out.write(str);
			out.newLine();
			out.close();
		} catch (IOException e) {
			System.out.println("exception occoured" + e);
		}
	}

	// reads the reviews and returns them in an array list
	public static ArrayList<String> readReview() {
		ArrayList<String> array = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(company + ".txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				array.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return array;
	}

	// formats the strings for the output
	public static String reviewSep(String s) {
		String string = s;
		String stringOut = "";
		String[] parts = string.split(";");
		// stringOut = parts[1] + " " + parts[0] + " stars!";
		stringOut = parts[0] + " stars: " + parts[1];
		return stringOut;

	}

	//converts the string into the average rating
	public String ratingScore() {

		String string = seeRating();
		String[] parts = string.split(";");
		double num = Double.parseDouble(parts[0]);
		double total = Double.parseDouble(parts[1]);

		DecimalFormat df = new DecimalFormat("#.#");
		String output = df.format(total / num);
		return output;
	}

	//gets the number of the review
		public static double reviewGetNum(String s) {
		String string = s;
		double output;
		String[] parts = string.split(";");
		output = Double.parseDouble(parts[0]);
		return output;

	}

	// prints the output
	public ArrayList<String> printAll() throws IOException {
		String comTest = company + ".txt";
		ArrayList<String> reviews = new ArrayList<String>();

		if (existCheck(comTest) == false) {
			newFile(company);
			System.out.println("No ratings yet. Feels free to add one if you want.");
			return reviews;
		} else {
			ArrayList<String> array = readReview();
			System.out.println("Ratings:");
			for (int i = 0; i < array.size(); i++) {
				reviews.add(reviewSep(array.get(i)));
				//System.out.println(reviewSep(array.get(i)));
			}
			return reviews;
		}
	}

	// adds review to company text file
	public void addReview() throws IOException {
		String comTest = company + ".txt";

		if (existCheck(comTest) == false) {
			System.out.println("New company");
			newFile(company);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Review for "+(companyString)+": ");
		System.out.println("Enter review");
		String review = sc.nextLine();
		System.out.println("Enter number rating");
		double rating = sc.nextDouble();
		String fullReview = rating + ";" + review;
		appendStrToFile(fullReview);
		reWrite();
		sc.close();
	}
	
	public void addReviewCode(String reviewI, String ratingI) throws IOException {
		String comTest = company + ".txt";
		if (existCheck(comTest) == false) {
			System.out.println("New company");
			newFile(company);
		}
		String review = reviewI;
		String rating = ratingI;
		String fullReview = rating + ";" + review;
		appendStrToFile(fullReview);
		reWrite();
	}

	// checks if the text file exists
	public static boolean existCheck(String s) {

		String comTest = s;
		boolean exists;
		File tempFile = new File(comTest);
		exists = tempFile.exists();
		return exists;
	}

	// returns the string to calculate the rating
	public String seeRating() {
		ArrayList<String> array = readReview();
		int size = array.size();
		double sum = 0;
		int i;
		for (i = 0; i < size; i++) {
			sum += reviewGetNum(array.get(i));
		}
		String output = i + ";" + sum;
		return output;
	}

	//Adds the new rating to the text file
	public void reWrite() {
		String resTxt = companyString + ".txt";

		try {
			BufferedReader file = new BufferedReader(new FileReader(resTxt));
			String line;
			String input = "";
			while ((line = file.readLine()) != null) {
				// System.out.println(line);
				if (line.contains(ratingGet())) {
					line = seeRating();
				}
				input += line + '\n';
			}
			FileOutputStream File = new FileOutputStream(resTxt);
			File.write(input.getBytes());
			file.close();
			File.close();
		} catch (Exception e) {
			System.out.println("");
		}
	}

	//returns the rating string
	public static String ratingGet() {
		String line = null;

		ArrayList<String> res = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(companyString + ".txt");
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

		return bar[10];
	}
}