package clean;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class ResOrder {
	
	static ResUtility TU= new ResUtility();
	
	public ResOrder() {
		
	}

	public static String[] lineSeparator(String s) {
		String input = s;
		String strArray[] = input.split(",");
		return strArray;
	}

	
	public static double cut(String s) {

		String start = s;
		String change = start.replace("$", "");
		Double output = Double.parseDouble(change);
		
		return output;
	}
	
	public String resGetOrder(String res,String num1,String num2, String num3) {
		
		
		String[] food = lineSeparator((TU.getRes(res)).get(8));
		String[] prices = lineSeparator((TU.getRes(res)).get(9));
		String[][] order = new String[food.length][3];
		
		for (int i = 0; i < food.length; i++) {
			order[i][0]=food[i];
		}
		for (int i = 0; i < prices.length; i++) {
			order[i][1]=prices[i];
		}
	
		order[0][2]=num1;
		order[1][2]=num2;
		order[2][2]=num3;
		
		int size=order.length;
		double sum=0;
		String output;
		for(int i=0;i<size;i++) {
			sum+=cut(order[i][1])*Double.parseDouble(order[i][2]);
		}
		double out=round(sum,2);
		output="Your total is: $"+out;
		return output;
		
	}
	private static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	 
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	
}

