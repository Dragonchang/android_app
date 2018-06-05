package com.example.testfl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
	public static String TABLE_DEBUG = "debug_table";
	public static final String ACCOUNTS_ID = "_id";
	public static final String INSERT_VALUE = "insert_value";
	public static final String mValue = "123456789;";
	public MyDBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		arg0.execSQL("CREATE TABLE " + TABLE_DEBUG + " ( "
                + ACCOUNTS_ID + " INTEGER,"
                + INSERT_VALUE + " TEXT NOT NULL)");

	}
    public void onOpen(SQLiteDatabase db) {

    }
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
