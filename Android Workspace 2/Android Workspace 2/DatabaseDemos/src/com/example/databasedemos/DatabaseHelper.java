package com.example.databasedemos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper {
	private DBHelper helper;
	private SQLiteDatabase sqLiteDatabase;
	public static final String DATABASE_NAME = "student.db";
	private static final int DATABASE_VERSION = 1;
	public static final String TABLE_NAME = "stu";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_AGE = "age";
	public static final String COLUMN_LOCATION = "location";
	private static final String TABLE_CREATION_QUERY = "CREATE TABLE "
			+ TABLE_NAME + " ( " + COLUMN_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME
			+ " TEXT NOT NULL, " + COLUMN_AGE + " TEXT NOT NULL,"
			+ COLUMN_LOCATION + " TEXT NOT NULL );";

	public DatabaseHelper(Context context) {
		helper = new DBHelper(context);
	}

	public DatabaseHelper open() {
		sqLiteDatabase = helper.getWritableDatabase();
		return this;
	}

	public void insertStudent(String name, String age, String location) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(COLUMN_NAME, name);
		contentValues.put(COLUMN_AGE, age);
		contentValues.put(COLUMN_LOCATION, location);

		long rowId = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

		if (rowId != -1) {
			Log.i("vipul", "Insert success with Row Id " + rowId);
		}

	}

	public void displayStudents() {
		Cursor cursor = sqLiteDatabase.query(TABLE_NAME, null, null, null,
				null, null, null);

		if (cursor != null && cursor.moveToFirst()) {
			do {
				String _id = cursor.getString(cursor.getColumnIndex(COLUMN_ID));

				String name = cursor.getString(cursor
						.getColumnIndex(COLUMN_NAME));
				String age = cursor
						.getString(cursor.getColumnIndex(COLUMN_AGE));
				String location = cursor.getString(cursor
						.getColumnIndex(COLUMN_LOCATION));

				Log.i("vipul", _id + " " + name + " " + age + " " + location);
			} while (cursor.moveToNext());
		}
	}

	public void delete(String name) {
		sqLiteDatabase.delete(TABLE_NAME, COLUMN_NAME + " =?",
				new String[] { name });
	}

	public void update(String name) {
		ContentValues values = new ContentValues();
		values.put(COLUMN_AGE, "35");
		sqLiteDatabase.update(TABLE_NAME, values, COLUMN_NAME + " =?",
				new String[] { name });
	}

	private class DBHelper extends SQLiteOpenHelper {

		public DBHelper(Context context) {
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
