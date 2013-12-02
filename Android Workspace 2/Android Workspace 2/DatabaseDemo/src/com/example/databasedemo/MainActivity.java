package com.example.databasedemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

	private DatabaseHelper databaseHelper;
	private ArrayAdapter<String> studentNameAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);

		databaseHelper = new DatabaseHelper(this);
		databaseHelper.open();

//		databaseHelper.insertStudent("Vipul", "27", "Thane");
//		databaseHelper.insertStudent("Sanket", "24", "Mulund");
//		databaseHelper.insertStudent("Akshay", "29", "Ghatkopar");
//		databaseHelper.insertStudent("Anil", "31", "Nahur");
//		databaseHelper.insertStudent("Vijay", "33", "Bhandup");
//		databaseHelper.insertStudent("Vishal", "36", "Dadar");

		// databaseHelper.viewStudents();
		// databaseHelper.updateStudent("Vipul", "30");
		// databaseHelper.viewStudents();
		// databaseHelper.deleteStudent("Vipul");
		// databaseHelper.viewStudents();

		studentNameAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				databaseHelper.viewStudentNames());
		studentNameAdapter.notifyDataSetChanged();
		getListView().setAdapter(studentNameAdapter);
	}
}
