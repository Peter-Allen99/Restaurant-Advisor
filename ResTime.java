package clean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ResTime {
	static ResUtility RU = new ResUtility();
	static String[] resArray;

	public ResTime() {
	}

	//public static void main(String[] args) {
		//System.out.println(areOpen());
	//}

	// gets the current time
	public static String time() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String time = sdf.format(cal.getTime());

		return time;
	}

	// gets rid of : in input
	public static String shorten(String s) {
		String start = s;
		String output = start.replace(":", "");
		return output;
	}

	// returns current time in proper format
	public String currentTime() {
		String start = time();
		String[] parts = start.split(":");
		String time = "";
		String half = "";
		String hours = parts[0];
		String minutes = parts[1];
		int halfTest = Integer.parseInt(hours);
		if (halfTest < 12) {
			half = " A.M";
		} else {
			half = " P.M";
		}
		if (Integer.parseInt(hours) > 12) {
			hours = Integer.toString((Integer.parseInt(hours) - 12));
		}
		if (hours.contains("00")) {
			hours = "12";
		} else {
			hours = Integer.toString((Integer.parseInt(hours)));
		}

		time = hours + ":" + minutes + half;
		// System.out.println(time);
		return time;

	}

	// returns the given time in proper format
	public String formatTime(String s) {

		String start = s;
		String[] parts = start.split(":");
		String time = "";
		String half = "";
		String hours = parts[0];
		String minutes = parts[1];
		int halfTest = Integer.parseInt(hours);
		if (halfTest < 12) {
			half = " A.M";
		} else {
			half = " P.M";
		}
		if (Integer.parseInt(hours) > 12) {
			hours = Integer.toString((Integer.parseInt(hours) - 12));
		}
		if (hours.contains("00")) {
			hours = "12";
		} else {
			hours = Integer.toString((Integer.parseInt(hours)));
		}

		time = hours + ":" + minutes + half;
		// System.out.println(time);
		return time;

	}

	// returns time in proper format from military time
	public String milToReg(String s) {
		String time = "";
		String start = s;
		int mid = start.length() / 2;
		String[] parts = { start.substring(0, mid), start.substring(mid) };
		time = parts[0] + ":" + parts[1];
		String timeFull = formatTime(time);
		// System.out.println(timeFull);
		return timeFull;
	}

	// returns the hours of operation from the string
	public String lineTime(String s) {
		String start = s;
		String output;
		String[] parts = start.split("-");
		String open = parts[0];
		String close = parts[1];
		output = milToReg(open) + " to " + milToReg(close);
		return output;
	}

	// checks if open based on the hours and current time
	public String openCheck(String s) {
		String start = s;
		int time = Integer.parseInt(shorten(time()));
		// System.out.println(time);

		String[] parts = start.split("-");
		int open = Integer.parseInt(parts[0]);
		int close = Integer.parseInt(parts[1]);

		if (time > open && time < close) {
			return "Open";
		} else {
			return "Closed";
		}

	}
	
	//puts all open restaurants into an array list
	public ArrayList<String> areOpen() {
		resArray = RU.resList();
		// System.out.println(Arrays.toString(resArray));
		ArrayList<String> isOpen = new ArrayList<String>();
		int size = resArray.length;
		for (int i = 0; i < size; i++) {
			String check = openCheck((RU.getRes(resArray[i])).get(4));
			// System.out.println(resArray[i]+": "+check);
			if (check == "Open") {
				isOpen.add(resArray[i]);
			}
		}
		//System.out.println(isOpen);
		if (isOpen.isEmpty()) {
			isOpen.add("No open restaurants");
			return isOpen;
		}
		return isOpen;

	}
}
