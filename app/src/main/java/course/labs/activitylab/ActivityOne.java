package course.labs.activitylab;

import android.content.SharedPreferences;
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
		int createCount = 0;
		int startCount = 0;
		int resumeCount = 0;
		int pauseCount = 0;
		int stopCount = 0;
		TextView create, start, resume, pause, stop;
		private SharedPreferences prefs;

		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_one);

			//Log cat print out
			Log.i(TAG, "onCreate called");

			prefs = getPreferences(MODE_PRIVATE);

			createCount = prefs.getInt("createCounter", 0);
			create = (TextView) findViewById(R.id.create);
			String text = getString(R.string.onCreate);
			create.setText(text + " " + createCount);

			startCount = prefs.getInt("startCounter", 0);
			start = (TextView) findViewById(R.id.start);
			String text2 = getString(R.string.onStart);
			start.setText(text + " " + startCount);

			resumeCount = prefs.getInt("resumeCounter", 0);
			resume = (TextView) findViewById(R.id.resume);
			String text3 = getString(R.string.onResume);
			resume.setText(text + " " + resumeCount);

			pauseCount = prefs.getInt("pauseCounter", 0);
			pause = (TextView) findViewById(R.id.pause);
			String text4 = getString(R.string.onPause);
			pause.setText(text + " " + pauseCount);

			stopCount = prefs.getInt("stopCounter", 0);
			stop = (TextView) findViewById(R.id.stop);
			String text5 = getString(R.string.onStop);
			stop.setText(text + " " + stopCount);

			/*if (savedInstanceState != null) {
				Log.d(TAG, "inside the oncreate savedinstancestate");
				createCount = savedInstanceState.getInt("createCounter");
				startCount = savedInstanceState.getInt("startCounter");
				resumeCount = savedInstanceState.getInt("resumeCounter");
					resume = (TextView) findViewById(R.id.resume);
					String text = getString(R.string.onResume);
					resume.setText(text + " " + resumeCount);
				pauseCount = savedInstanceState.getInt("pauseCounter");
					pause = (TextView) findViewById(R.id.pause);
					String text2 = getString(R.string.onPause);
					pause.setText(text2 + " " + pauseCount);
				stopCount = savedInstanceState.getInt("stopCounter");
					stop = (TextView) findViewById(R.id.stop);
					String text3 = getString(R.string.onStop);
					stop.setText(text3 + " " + stopCount);
			}*/

			createCount++;
			create = (TextView) findViewById(R.id.create);
			String text6 = getString(R.string.onCreate);
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

			resumeCount++;
			resume = (TextView) findViewById(R.id.resume);
			String text = getString(R.string.onResume);
			resume.setText(text + " " + resumeCount);
		}

		@Override
		public void onPause(){
			super.onPause();
			//Log cat print out
			Log.i(TAG, "onPause called");

			
			pauseCount++;
			pause = (TextView) findViewById(R.id.pause);
			String text = getString(R.string.onPause);
			pause.setText(text + " " + pauseCount);
		}

		@Override
		public void onStop(){
		super.onStop();
		//Log cat print out
		Log.i(TAG, "onStop called");

		
		stopCount++;
		stop = (TextView) findViewById(R.id.stop);
		String text = getString(R.string.onStop);
		stop.setText(text + " " + stopCount);

			saveCounters();
	}

		@Override
		public void onSaveInstanceState(Bundle savedInstanceState){
			super.onSaveInstanceState(savedInstanceState);
			Log.d(TAG, "onSaveInstanceState()");
			Log.d(TAG, "createCount: " + createCount + " startCount: " + startCount + " pauseCount: " + pauseCount + " resumeCount " +  resumeCount + " stopCount: " + stopCount ) ;
			savedInstanceState.putInt("createCounter", createCount);
			savedInstanceState.putInt("startCounter", startCount);
			savedInstanceState.putInt("pauseCounter", pauseCount);
			savedInstanceState.putInt("resumeCounter", resumeCount);
			savedInstanceState.putInt("stopCounter", stopCount);

		}

		public void saveCounters()
		{
			SharedPreferences.Editor editor = prefs.edit();
			editor.putInt("createCounter", createCount);
			editor.putInt("startCounter", startCount);
			editor.putInt("resumeCounter", resumeCount);
			editor.putInt("pauseCounter", pauseCount);
			editor.putInt("stopCounter", stopCount);
			editor.commit();
		}


		public void launchActivityTwo(View view)
		{
			startActivity(new Intent(this, ActivityTwo.class));
		}
		

}
