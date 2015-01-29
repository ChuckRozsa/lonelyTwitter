package ca.ualberta.cs.lonelytwitter.test;

import java.util.ArrayList;

import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TweetList;
import android.test.ActivityInstrumentationTestCase2;

public class TweetListTests extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public TweetListTests() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testTweetList() {
		TweetList tweetlist = new TweetList();
		ArrayList<LonelyTweetModel> tweets = tweetlist.getTweets();
		assertNotNull("Tweet List not Initialized", tweets);	
	}
	
	public void testCounts() {
		TweetList tweetList = new TweetList();
		NormalTweetModel tweet = new NormalTweetModel("Hello"); 
		tweetList.addTweet(tweet);
		assertEquals("This should be zero", 1, tweetList.getCount());
	}
	
	public void testAdd() {
		TweetList tweetList = new TweetList();
		NormalTweetModel tweet = new NormalTweetModel("Hello");
		tweetList.addTweet(tweet);
		
		//From http://stackoverflow.com/questions/3083161/junit-exception-testing Jan 29, 2014
		Throwable caught = null;
		try {
		   tweetList.addTweet(tweet);
		} catch (Throwable t) {
		   caught = t;
		}
		assertNotNull(caught);
		
	}
	
	public void testHas() {
		TweetList tweetList = new TweetList();
		NormalTweetModel tweet = new NormalTweetModel("Hello");
		tweetList.addTweet(tweet);
		assertTrue("The tweet should be in the list", tweetList.hasTweet(tweet));
		NormalTweetModel tweet1 = new NormalTweetModel("Bye");
		assertFalse("The tweet should not be in the list", tweetList.hasTweet(tweet1));
	}
	
	public void testRemove() {
		TweetList tweetList = new TweetList();
		NormalTweetModel tweet = new NormalTweetModel("Hello");
		tweetList.addTweet(tweet);
		tweetList.removeTweet(tweet);
		assertFalse("The tweet should not be in the list", tweetList.hasTweet(tweet));
		assertEquals("There shouldn't be any tweets in the list", 0, tweetList.getCount());
		
	}
	public void testGetTweets() {
		TweetList tweetList = new TweetList();
		NormalTweetModel tweet = new NormalTweetModel("Hello");
		NormalTweetModel tweet1 = new NormalTweetModel("Bye");
		tweetList.addTweet(tweet);
		tweetList.addTweet(tweet1);
		ArrayList<LonelyTweetModel> newtweetList = tweetList.getTweets();
		assertEquals("The tweets should be the same", tweet, newtweetList.get(0));
		assertEquals("The tweets should be the same", tweet1, newtweetList.get(1));
		
		
	}
}
