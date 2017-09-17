package course.labs.activitylab;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityOne extends Activity {

		// string for logcat documentation
		private final static String TAG = "Lab-ActivityOne";

		// lifecycle counts
		//TODO: Create 7 counter variables, each corresponding to a different one of the lifecycle callback methods.
		int createCount = 0;
		int startCount = 0;
		int resumeCount = 0;
		int pauseCount = 0;
		int stopCount = 0;
		int restartCount = 0;
		int destroyCount = 0;
		TextView create, start, resume, pause;

		//TODO:  increment the variables' values when their corresponding lifecycle methods get called.
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_one);

			//Log cat print out
			Log.i(TAG, "onCreate called");
			
			//TODO: update the appropriate count variable & update the view
			createCount++;
			create = (TextView) findViewById(R.id.create);
			String text = getString(R.string.onCreate);
			create.setText(text + " " + createCount);
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_one, menu);
			return true;
		}
		
		// lifecycle callback overrides
		
		@Override
		public void onStart(){
			super.onStart();
			//Log cat print out
			Log.i(TAG, "onStart called");
			
			//TODO:  update the appropriate count variable & update the view
			startCount++;
			start = (TextView) findViewById(R.id.start);
			String text = getString(R.string.onStart);
			start.setText(text + " " + startCount);
		}

		@Override
		public void onResume(){
			super.onResume();
			//Log cat print out
			Log.i(TAG, "onResume called");

			//TODO:  update the appropriate count variable & update the view
			resumeCount++;
			resume = (TextView) findViewById(R.id.resume);
			String text = getString(R.string.onResume);
			resume.setText(text + " " + restartCount);
		}

		@Override
		public void onPause(){
			super.onPause();
			//Log cat print out
			Log.i(TAG, "onPause called");

			//TODO:  update the appropriate count variable & update the view
			pauseCount++;
			pause = (TextView) findViewById(R.id.pause);
			String text = getString(R.string.onPause);
			pause.setText(text + " " + pauseCount);
		}

		@Override
		public void onStop(){
		super.onStop();
		//Log cat print out
		Log.i(TAG, "onPause called");

		//TODO:  update the appropriate count variable & update the view
		pauseCount++;
		pause = (TextView) findViewById(R.id.pause);
		String text = getString(R.string.onPause);
		pause.setText(text + " " + pauseCount);
	}


	// TODO: implement 5 missing lifecycle callback methods

		@Override
		public void onSaveInstanceState(Bundle savedInstanceState){
			//TODO:  save state information with a collection of key-value pairs & save all  count variables
		}


		public void launchActivityTwo(View view) {
			startActivity(new Intent(this, ActivityTwo.class));
		}
		

}
