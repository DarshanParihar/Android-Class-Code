package com.example.databaseexample;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {

	private DatabaseHelper databaseHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.row);

		databaseHelper = new DatabaseHelper(this);
		databaseHelper.open();

		databaseHelper.createStudent("Bhavik", "24", "Thane");
		databaseHelper.createStudent("Balvir", "24", "Belapur");
		databaseHelper.createStudent("Bhavesh", "24", "Dadar");

		Cursor cursor = databaseHelper.fetchStudents();
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				R.layout.row, cursor, new String[] {
						DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_AGE,
						DatabaseHelper.COLUMN_LOCATION }, new int[] {
						R.id.txtName, R.id.txtAge, R.id.txtLocation }, 0);
		setListAdapter(adapter);

		// databaseHelper.showStudents();
		// databaseHelper.deleteStudent("Bhavesh");
		// databaseHelper.updateStudent("Bhavik", "26");
		// databaseHelper.showStudents();

	}
}
