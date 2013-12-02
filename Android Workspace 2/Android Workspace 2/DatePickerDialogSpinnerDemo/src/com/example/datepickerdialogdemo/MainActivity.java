package com.example.datepickerdialogdemo;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity implements OnClickListener,
		OnDateSetListener, OnTimeSetListener, OnItemSelectedListener {

	private Button btnSelectDate, btnSelectTime;
	private int day, month, year, hours, minutes, seconds;
	private Calendar calendar;
	private DatePickerDialog datePickerDialog;
	private TimePickerDialog timePickerDialog;
	private Spinner spinnerSelectTimeFormat;
	private ArrayAdapter<String> adapterTimeFormat;
	private boolean is24HoursView = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnSelectDate = (Button) findViewById(R.id.btnSelectDate);
		btnSelectTime = (Button) findViewById(R.id.btnSelectTime);

		btnSelectDate.setOnClickListener(MainActivity.this);
		btnSelectTime.setOnClickListener(MainActivity.this);

		calendar = Calendar.getInstance();

		day = calendar.get(Calendar.DAY_OF_MONTH);
		month = calendar.get(Calendar.MONTH);
		year = calendar.get(Calendar.YEAR);

		hours = calendar.get(Calendar.HOUR_OF_DAY);
		minutes = calendar.get(Calendar.MINUTE);
		seconds = calendar.get(Calendar.SECOND);

		btnSelectDate.setText(day + "/" + month + "/" + year);
		btnSelectTime.setText(hours + ":" + minutes + ":" + seconds);

		spinnerSelectTimeFormat = (Spinner) findViewById(R.id.spinnerTimeFormat);
		spinnerSelectTimeFormat.setOnItemSelectedListener(MainActivity.this);
		adapterTimeFormat = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_spinner_item);
		adapterTimeFormat
				.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		adapterTimeFormat.add("24 Hours View");
		adapterTimeFormat.add("12 Hours View");
		spinnerSelectTimeFormat.setAdapter(adapterTimeFormat);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnSelectDate:
			datePickerDialog = new DatePickerDialog(MainActivity.this,
					MainActivity.this, year, month, day);
			datePickerDialog.show();
			break;

		case R.id.btnSelectTime:
			timePickerDialog = new TimePickerDialog(MainActivity.this,
					MainActivity.this, hours, minutes, is24HoursView);
			timePickerDialog.show();
			break;
		}

	}

	@Override
	public void onDateSet(DatePicker view, int myear, int monthOfYear,
			int dayOfMonth) {
		btnSelectDate.setText(dayOfMonth + "/" + monthOfYear + "/" + myear);

	}

	@Override
	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		btnSelectTime.setText(hourOfDay + ":" + minute);
	}

	@Override
	public void onItemSelected(AdapterView<?> adapterView, View view, int pos,
			long id) {
		if (pos == 0)
			is24HoursView = true;
		else
			is24HoursView = false;
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}
