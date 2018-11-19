/*Output Methods
 * compareResults(); checks if there are any restaurants with both of the inputs
 * cuisineSearch(String); returns restaurants with the input cuisine
 * venueSearch(String); returns restaurants with the input venue
 */


package clean;

import java.util.ArrayList;

public class ResSearch {
	static String input;
	static ResUtility RU = new ResUtility();
	String cuisineType;
	String venueType;
	static String[] resArray;

	public ResSearch(String c, String v) {
		cuisineType = c;
		venueType = v;
		resArray = RU.resList();
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
			if (RU.getRes(array[i]).contains(type)) {
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
			if (RU.getRes(array[i]).contains(type)) {
				hasType.add(array[i]);
			}
		}
		return hasType;
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
		if(result.isEmpty()) {
			result.add("No such restaurant");
			return result;
		}
	
		return result;

	}

}

