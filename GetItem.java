/* This class allows for access of the restaurant info by typing a string
 */

package guiTest;

import java.util.ArrayList;

public class GetItem {
	protected String index;
	protected ArrayList<String> resArray;
	protected String resString;
	public GetItem(ArrayList<String> array,String s,String resS) {
		index=s;
		resArray=array;
		resString=resS;
	}
	//displays the output for the desired input
	public String GetIndex(String s) {
		ArrayList<String> array=resArray;
		RatingWriter RW =new RatingWriter(resString);
		
		//System.out.println(resString);
		s=s.toLowerCase();
		String output=""; 
		
		 switch (s) { 
	        case "name":
	        case "0":
	        	output=(array.get(0));
	            break; 
	        case "address":
	        case "1":
	        	output=(array.get(1));
	            break; 
	        case "phone number":
	        case "2":
	        	output=(array.get(2));
	            break; 
	        case "email":
	        case "3":
	        	output=(array.get(3));
	            break; 
	        case "hours":
	        case "4":
	        	output=(array.get(4));
	            break; 
	        case "type of cuisine":
	        case "5":
	        	output=(array.get(5));
	            break; 
	        case "type of dining":
	        case "6":
	        	output=(array.get(6));
	            break; 
	        case "price range":
	        case "7":
	        	output=(array.get(7));
	            break;  
	        case "food items":
	        case "8":
	        	output=(array.get(8));
	            break; 
	        case "price":
	        case "9":
	        	output=(array.get(9));
	            break; 
	        case "rating":
	        case "10":
	        	output=RW.ratingScore();
	            break; 
	            
	        default: 
	        	output="error"; 
	            break; 
	        } 
		 return output;
	}
}
