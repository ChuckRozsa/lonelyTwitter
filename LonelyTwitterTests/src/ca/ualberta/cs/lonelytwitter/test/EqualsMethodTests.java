package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import android.test.ActivityInstrumentationTestCase2;

public class EqualsMethodTests extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public EqualsMethodTests() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testEquals() {
		Date date = new Date();
		ImportantTweetModel tweet1 = new ImportantTweetModel("Hello", date);
		NormalTweetModel tweet2 = new NormalTweetModel("Hello", date);
		assertFalse("The tweets are not the same", tweet1.equals(tweet2));
	}
	
	public void testEquals1() {
		Date date = new Date();
		ImportantTweetModel tweet1 = new ImportantTweetModel("Hello", date);
		NormalTweetModel tweet2 = new NormalTweetModel("Hello", date);
		assertFalse("The tweets are not the same", tweet2.equals(tweet1));
	}


}
