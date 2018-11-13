package guiTest;

import java.util.ArrayList;

public class SearchTest {
	static String input;
	static TestUtil TU = new TestUtil(input);
	String cuisineType;
	String venueType;
	static String[] resArray;

	public SearchTest(String c, String v) {
		cuisineType = c;
		venueType = v;
		resArray = resList();
	}

	//send the two arrays to be compared
	public ArrayList<String> compareResults() {
		ArrayList<String> results = new ArrayList<String>();
		results = compareRes(venueSearch(venueType), cuisineSearch(cuisineType));
		return results;

	}
	
	//checks which restaurant matches the desired cuisine
	public ArrayList<String> cuisineSearch(String type) {
		String[] array = resArray;
		ArrayList<String> hasType = new ArrayList<String>();
		int size = array.length;

		for (int i = 0; i < size; i++) {
			if (TU.getRes(array[i]).contains(type)) {
				hasType.add(array[i]);
			}
		}
		// System.out.println(hasType);
		return hasType;
	}

	//checks which restaurant matches the desired venue
	public ArrayList<String> venueSearch(String type) {
		String[] array = resArray;
		ArrayList<String> hasType = new ArrayList<String>();
		int size = array.length;

		for (int i = 0; i < size; i++) {
			if (TU.getRes(array[i]).contains(type)) {
				hasType.add(array[i]);
			}
		}
		// System.out.println(hasType);
		return hasType;
	}

	//get the restaurant list
	public static String[] resList() {
		String[] resCheck = TU.readList();
		resCheck = arrayShort(resCheck);
		// System.out.println(Arrays.toString(resCheck));
		return resCheck;
	}

	//cuts of string
	public static String[] arrayShort(String[] array) {
		TestUtil TU = new TestUtil(input);
		int size = array.length;
		for (int i = 0; i < size; i++) {
			array[i] = TU.getShortName1(array[i]);
		}
		return array;
	}
	
	//checks if there is any overlap between the cuisine and venue
	public static ArrayList<String> compareRes(ArrayList<String> venueAL, ArrayList<String> cuisineAL) {
		ArrayList<String> result = new ArrayList<String>();
		int venueSize = venueAL.size();
		int cuisineSize = cuisineAL.size();

		for (int i = 0; i < venueSize; i++) {
			for (int j = 0; j < cuisineSize; j++) {
				if ((venueAL.get(i).equals(cuisineAL.get(j))) && (result.contains((cuisineAL.get(j)))) == false) {
					result.add(cuisineAL.get(j));
				}
			}
		}
		//System.out.println(result);
		return result;

	}

}
