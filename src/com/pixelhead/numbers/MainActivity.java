package com.pixelhead.numbers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.text.format.DateFormat;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("cccc, MMMM d");
	private static final SimpleDateFormat DATE_NUMERIC_FORMAT = new SimpleDateFormat("yyyy MM dd");
	
	private TextView time;
	private TextView dateText;
	private TextView dateNumeric;
	
	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		time = (TextView) findViewById(R.id.time);
		dateText = (TextView) findViewById(R.id.date_text);
		dateNumeric = (TextView) findViewById(R.id.date_numeric);
		if (Build.VERSION.SDK_INT < 11){
		    getSupportActionBar().hide(); 
		}
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		updateTask.run();
		handler.postDelayed(updateTask, 900);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		handler.removeCallbacks(updateTask);
	}
	
	private Runnable updateTask = new Runnable() {
		
		@Override
		public void run() {
			Date date = Calendar.getInstance().getTime();
			time.setText(DateFormat.getTimeFormat(MainActivity.this).format(date));
			dateText.setText(DATE_FORMAT.format(date));
			dateNumeric.setText(DATE_NUMERIC_FORMAT.format(date));
			long now = SystemClock.uptimeMillis();
			long next = now + (1000 - now % 1000);
			handler.postAtTime(updateTask, next);
		}
	};
}