package ca.ualberta.cs.lonelytwitter.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

/*
 * generate this class with new.. JUnit Test Case
 * set superclass to ActivityInstrumentationTestCase2
 */
public class LonelyTwitterActivityUITest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	Instrumentation instrumentation;
	Activity activity;
	EditText textInput;
	
	public LonelyTwitterActivityUITest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = getActivity();

		textInput = ((EditText) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.body));
	}
	
	public void testSetText() {
		
		instrumentation.runOnMainSync(new Runnable() {

			@Override
			public void run() {
				String text = "tweet";
				textInput.setText(text);
			}
			
		});
		
		instrumentation.waitForIdleSync();
		
		assertEquals("correct text?", "tweet",
				textInput.getText().toString());
	}
	
	public void testAdapterChanged() {
		ListView lv = (ListView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.oldTweetsList);
		
		@SuppressWarnings("unchecked")
		ArrayAdapter<NormalTweetModel> adapter = (ArrayAdapter<NormalTweetModel>) lv.getAdapter();
		int old_count = adapter.getCount();
		instrumentation.runOnMainSync(new Runnable() {

			@Override
			public void run() {
				makeTweet("Hello");
			}
			
		});
		Class<? extends NormalTweetModel> tweet1 = adapter.getItem(old_count).getClass();
		Class<? extends NormalTweetModel> tweet2 = adapter.getItem(old_count-1).getClass();
		instrumentation.waitForIdleSync();
		int new_count = adapter.getCount();
		assertEquals("Adapter changed?", old_count + 1, new_count);
		assertEquals("Same class?", tweet1, tweet2);
		assertEquals("Right text?", "Hello",  adapter.getItem(old_count).getText());
		
		
	}
	
	/*
	 * fills in the input text field and clicks the 'save'
	 * button for the activity under test
	 */
	private void makeTweet(String text) {
		assertNotNull(activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
		textInput.setText(text);
		((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save)).performClick();
	}
}
