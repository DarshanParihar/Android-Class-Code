package com.example.databasedemo;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHelper {
	private Context context;
	private MyDatabaseClass myDatabaseClass;
	private SQLiteDatabase sqLiteDatabase;
	public static final String DATABASE_NAME = "student.db";
	public static final int DATABASE_VERSION = 1;
	public static final String TABLE_NAME = "Student";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_STUDENT_NAME = "name";
	public static final String COLUMN_STUDENT_AGE = "age";
	public static final String COLUMN_STUDENT_LOCATION = "location";
	public static final String TABLE_CREATION_QUERY = "CREATE TABLE "
			+ TABLE_NAME + " ( " + COLUMN_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_STUDENT_NAME
			+ " TEXT, " + COLUMN_STUDENT_AGE + " TEXT, "
			+ COLUMN_STUDENT_LOCATION + " TEXT);";

	public DatabaseHelper(Context context) {
		this.context = context;
		myDatabaseClass = new MyDatabaseClass(context);
	}

	public DatabaseHelper open() {
		sqLiteDatabase = myDatabaseClass.getWritableDatabase();
		return this;
	}

	public void insertStudent(String name, String age, String location) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(COLUMN_STUDENT_NAME, name);
		contentValues.put(COLUMN_STUDENT_AGE, age);
		contentValues.put(COLUMN_STUDENT_LOCATION, location);
		long rowID = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

		if (rowID == -1) {
			Toast.makeText(context, "Insertion Failed!", Toast.LENGTH_SHORT)
					.show();
		} else {
			Toast.makeText(context, "Insertion Success!", Toast.LENGTH_SHORT)
					.show();
		}
	}

	public void viewStudents() {
		Cursor cursor = sqLiteDatabase.query(TABLE_NAME, null, null, null,
				null, null, COLUMN_STUDENT_NAME + " ASC ");

		if (cursor != null && cursor.moveToFirst()) {
			do {
				String name = cursor.getString(0);
				String age = cursor.getString(1);
				String location = cursor.getString(2);

				Log.i("vipul", name + " " + age + " " + location);
			} while (cursor.moveToNext());
		}
	}

	public ArrayList<String> viewStudentNames() {
		ArrayList<String> studentNames = new ArrayList<String>();
		Cursor cursor = sqLiteDatabase.query(TABLE_NAME, null, null, null,
				null, null, COLUMN_STUDENT_NAME + " ASC ");

		if (cursor != null && cursor.moveToFirst()) {
			do {
				String name = cursor.getString(cursor
						.getColumnIndex(COLUMN_STUDENT_NAME));
				studentNames.add(name);
			} while (cursor.moveToNext());
		}

		return studentNames;
	}

	public void updateStudent(String name, String age) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(COLUMN_STUDENT_AGE, age);

		/**
		 * SQLite prepared statements
		 */
		int rowsUpdated = sqLiteDatabase.update(TABLE_NAME, contentValues,
				COLUMN_STUDENT_NAME + " =?", new String[] { name });
		Toast.makeText(context, rowsUpdated + " updated", Toast.LENGTH_SHORT)
				.show();
	}

	public void deleteStudent(String name) {
		int rowsDeleted = sqLiteDatabase.delete(TABLE_NAME, COLUMN_STUDENT_NAME
				+ " =?", new String[] { name });
		Toast.makeText(context, rowsDeleted + " deleted", Toast.LENGTH_SHORT)
				.show();

	}

	private class MyDatabaseClass extends SQLiteOpenHelper {

		public MyDatabaseClass(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(TABLE_CREATION_QUERY);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		}

	}

}
