package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetList {
	private ArrayList<LonelyTweetModel> tweetList;
	
	
	public TweetList() {
		super();
		tweetList = new ArrayList<LonelyTweetModel>();
	}

	public ArrayList<LonelyTweetModel> getTweets() {
		return tweetList;
	}

	public int getCount() {
		return tweetList.size();
	}

	public void addTweet(LonelyTweetModel tweet) throws IllegalArgumentException {
		for (LonelyTweetModel i: tweetList) {
			if(tweet.equals(i)) {
				throw new IllegalArgumentException("The tweet is already in the list!");
			}
		}
		tweetList.add(tweet);
	}

	public boolean hasTweet(NormalTweetModel tweet) {
		for (LonelyTweetModel i: tweetList) {
			if (tweet.equals(i)) {
				return true;
			}
		}
		return false;
	}

	public void removeTweet(NormalTweetModel tweet) {
		// TODO Auto-generated method stub
		tweetList.remove(tweet);
	}
}
