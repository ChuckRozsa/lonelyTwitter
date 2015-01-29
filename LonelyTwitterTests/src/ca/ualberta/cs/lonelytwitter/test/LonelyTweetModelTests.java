package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import android.test.ActivityInstrumentationTestCase2;

public class LonelyTweetModelTests extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public LonelyTweetModelTests() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testSample() {
		//fail("This fails yo.");
		assertEquals("5 is equal to 5", 5,5);
	}
	
	public void testEquals() {
		Date date = new Date();
		NormalTweetModel tweet1 = new NormalTweetModel("Hello", date);
		NormalTweetModel tweet2 = new NormalTweetModel("Hello", date);
		assertTrue("Different tweets", tweet1.equals(tweet2));
	}

}
