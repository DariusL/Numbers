package com.pixelhead.numbers;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private TextView year;
	private TextView month;
	private TextView day;
	
	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		year = (TextView) findViewById(R.id.year);
		month = (TextView) findViewById(R.id.month);
		day = (TextView) findViewById(R.id.day);
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
			Calendar calendar = Calendar.getInstance();
			year.setText(String.valueOf(calendar.get(Calendar.YEAR)));
			month.setText(String.valueOf(calendar.get(Calendar.MONTH) + 1));
			day.setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
			handler.postDelayed(updateTask, 900);
		}
	};
}