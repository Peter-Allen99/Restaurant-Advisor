/* Output methods:
 * getRes(String); returns all the info about the input restaurant in an array list
 * readList(); returns the list of restaurants in an array list
 * getFullName(String); returns the full name of the restaurant when given the string line from readList();
 * getShortName1(String); returns the short name of the restaurant when given the string line from readList();
 * getShortName2(String); returns the shot name of the restaurant when given the full name 
 * 
 * 
*/



package clean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ResUtility {
	public ResUtility() {
	}
	
	//get the info about the restaurant in an array list
	public ArrayList<String> getRes(String input) {
		String line = null;
		String stringTemp = getShortName2(input);
		ArrayList<String> res = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(stringTemp + ".txt");
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

	//gets the info from the restaurant list
	public String[] readList() {
		String line = null;

		ArrayList<String> res = new ArrayList<String>();
		try {
			FileReader fr = new FileReader("RestaurantList.txt");
			BufferedReader br = new BufferedReader(fr);
			for (int i = 0; i < 11; i++) {
				if ((line = br.readLine()) != null) {
					res.add((line));
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println("File not found");
		}

		String[] bar = res.toArray(new String[res.size()]);

		return bar;
	}
	
	//gets the full name of the restaurant
	public String getFullName(String input) {
		String stringF = input;
		String[] parts = stringF.split(";");
		String output = parts[1];
		return output;
	}

	//gets the short name of the restaurant
	public static String getShortName1(String input) {
		String stringN1 = input;

		String[] parts = stringN1.split(";");
		String output = parts[0];

		return output;
	}

	//gives the full string from the partial string
	public String getShortName2(String input) {
		String check = input;
		String output = "";
		String[] array = readList();

		int size = array.length;
		for (int i = 0; i < size; i++) {

			if (array[i].contains(check)) {
				output = getShortName1(array[i]);
			}

		}

		return output;
	}
	public String[] resList() {
		String[] resCheck = readList();
		resCheck = arrayShort(resCheck);
		// System.out.println(Arrays.toString(resCheck));
		return resCheck;
	}

	//cuts of string
	public static String[] arrayShort(String[] array) {
		
		int size = array.length;
		for (int i = 0; i < size; i++) {
			array[i] = getShortName1(array[i]);
		}
		return array;
	}

}

