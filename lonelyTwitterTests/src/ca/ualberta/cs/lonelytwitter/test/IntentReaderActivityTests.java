package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.test.ViewAsserts;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.R;

public class IntentReaderActivityTests extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {

	public IntentReaderActivityTests() {
		super(IntentReaderActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testSendText() {
		String text = "Hello world!";
		IntentReaderActivity activity = startWithText(text,
				IntentReaderActivity.NORMAL);
		
		assertEquals("got the text?", text, activity.getText());
	}
	
	public void testDoubleText(){
		String text = "Hello world!";
		IntentReaderActivity activity = startWithText(text,
				IntentReaderActivity.DOUBLE);
		
		assertEquals("double text?", text+text, activity.getText());
	}
	
	public void testDisplayText() {
		String text = "Hello";
		IntentReaderActivity activity = startWithText(text,
				IntentReaderActivity.NORMAL);
		TextView view = (TextView) activity.findViewById(R.id.intentText);
		assertEquals("corect test?", text, view.getText());
		
	}
	
	public void testDisplayEmptyText(){
		String text = "";
		IntentReaderActivity activity = startWithText(text,
				IntentReaderActivity.NORMAL);
		TextView view = (TextView) activity.findViewById(R.id.intentText);
		assertEquals("empty?", "There was no input", view.getText());
	}
	
	public void testTextVisibility() {
		IntentReaderActivity activity = startWithText("Hello",
				IntentReaderActivity.NORMAL);
		View view = activity.getWindow().getDecorView();
		TextView tv = (TextView) activity.findViewById(R.id.intentText);
		android.test.ViewAsserts.assertOnScreen(view, tv);
		
	}
	
	public void testReverseText() {
		String text = "Hello";
		String reverse = "olleH";
		IntentReaderActivity activity = startWithText(text,
				IntentReaderActivity.REVERSE);
		
		assertEquals("reverse text?" , reverse, activity.getText());
	}
	
	
	private IntentReaderActivity startWithText(String text, int mode) {
		
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text );
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, mode);
		setActivityIntent(intent);
		
		return (IntentReaderActivity) getActivity();
		
	}

}
