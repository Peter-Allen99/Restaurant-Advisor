package clean;

import java.util.ArrayList;

import guiTest.TestUtil;
import guiTest.TimeTest;

public class ResInfo {
	
	protected String index;
	protected ArrayList<String> resArray;
	protected String resString;
	TestUtil TU=new TestUtil();
	
	public ResInfo(String s,String resS) {
		index=s;
		resArray=TU.getRes(resS);
		resString=resS;
	}
	//displays the output for the desired input
	public String GetIndex(String s) {
		ArrayList<String> array=resArray;
		ResRating RR =new ResRating(resString);
		TimeTest RT=new TimeTest();
		
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
	        case "hours of operation":
	        case "4":
	        	output=(RT.lineTime(array.get(4)));
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
	        	output=RR.ratingScore();
	            break; 
	            
	        default: 
	        	output="error"; 
	            break; 
	        } 
		 return output;
	}
}

