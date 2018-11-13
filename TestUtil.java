/* This class contains some methods that are used by many other classes.
 * 
 * 
 */

package guiTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestUtil {
	public static String string;
	public TestUtil(String s) {
		string=s;
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
	public String getShortName1(String input) {
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
		// System.out.println(Arrays.toString(array));

		int size = array.length;
		for (int i = 0; i < size; i++) {

			if (array[i].contains(check)) {
				output = getShortName1(array[i]);
			}

		}

		return output;
	}

	public String shortToLong(String input) {
		String temp=getShortName2(input);
		String output=getFullName(temp);
		return output;
	}
}
