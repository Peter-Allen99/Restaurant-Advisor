package guiTest;

import java.io.IOException;


public class TestMain {
	static String input;
	public static void main(String[] args) throws IOException {
		String company = "mcdonalds";
		String index = "address";
		String cuisine="Fast Food";
		String venue="Pizza";
	
		SearchTest ST= new SearchTest(cuisine,venue);
		TestUtil TU =new TestUtil(input);
		GetItem GI = new GetItem(TU.getRes(company), "", company);
		RatingWriter RW = new RatingWriter(company);
		// System.out.println(RW.ratingScore());
		RW.addReview();
		//System.out.println(RW.ratingScore());
		//System.out.println(TU.getRes("Pizza Hut"));
		//System.out.println(ST.cuisineSearch(cuisine));
		//System.out.println(ST.venueSearch(venue));
		//System.out.println(ST.compareResults());
		//System.out.println(GI.GetIndex("9"));
	}}

	