package com.example.datetimepickerdemo;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnDatePicker, btnTimePicker;
	private int currentHour, currentMinutes, currentDate, currentMonth,
			currentYear;
	private Calendar calendar;
	private DatePickerDialog datePickerDialog;
	private TimePickerDialog timePickerDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnDatePicker = (Button) findViewById(R.id.datePickerButton);
		btnTimePicker = (Button) findViewById(R.id.timePickerButton);

		btnDatePicker.setOnClickListener(this);
		btnTimePicker.setOnClickListener(this);

		calendar = Calendar.getInstance();

		currentHour = calendar.get(Calendar.HOUR_OF_DAY);
		currentMinutes = calendar.get(Calendar.MINUTE);

		currentDate = calendar.get(Calendar.DATE);
		currentMonth = calendar.get(Calendar.MONTH);
		currentYear = calendar.get(Calendar.YEAR);

		btnDatePicker.setText(currentDate + "/" + currentMonth + "/"
				+ currentYear);
		btnTimePicker.setText(currentHour + ":" + currentMinutes);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.datePickerButton:
			datePickerDialog = new DatePickerDialog(MainActivity.this,
					new DatePickerDialog.OnDateSetListener() {

						@Override
						public void onDateSet(DatePicker view, int year,
								int monthOfYear, int dayOfMonth) {
							btnDatePicker.setText(dayOfMonth + "/"
									+ (monthOfYear + 1) + "/" + year);

						}
					}, currentYear, currentMonth, currentDate);
			
			datePickerDialog.show();
			
			break;
			
		case R.id.timePickerButton:
			timePickerDialog = new TimePickerDialog(MainActivity.this,
					new TimePickerDialog.OnTimeSetListener() {

						@Override
						public void onTimeSet(TimePicker view, int hourOfDay,
								int minute) {
							btnTimePicker.setText(hourOfDay + ":" + minute);

						}
					}, currentHour, currentMinutes, false);
			timePickerDialog.show();
			break;
		}

	}
}
