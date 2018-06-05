package com.example.testfl;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
public class MydbActivity extends Activity {
    private Button mButtoninsert;
    private Button mButtondelete;
    private Button mButtonupdate;
    private Button mButtonQuery;
    private MyDBHelper mDBHelper;
    private SQLiteDatabase mDB;
    private static final String DATABASE_NAME = "Test.db";
   
    private static final String EXTRAS_VALUE = MyDBHelper.INSERT_VALUE;
    private static final String[] COLUMNS_EXTRAS_KEY_AND_VALUE = {EXTRAS_VALUE};
    private static final String SELECTION_USERDATA_BY_ACCOUNT ="(select insert_value FROM debug_table )";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mydb);
		mDBHelper = new MyDBHelper(this, DATABASE_NAME, null,1);
		mDB = mDBHelper.getWritableDatabase();
		mButtoninsert = (Button)findViewById(R.id.button1);
		mButtoninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	int i =0;
            	//mDB.beginTransaction();
            	for(i =0;i <10;i++) {
	              ContentValues values = new ContentValues();
	              values.put(MyDBHelper.ACCOUNTS_ID, i);
	              values.put(MyDBHelper.INSERT_VALUE, MyDBHelper.mValue);
	              mDB.insert(MyDBHelper.TABLE_DEBUG, null, values);
            	}
            }
        });
		mButtondelete = (Button)findViewById(R.id.button2);
		mButtondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = mDB.query(MyDBHelper.TABLE_DEBUG,
                        COLUMNS_EXTRAS_KEY_AND_VALUE,
                        null,
                        null,
                        null, null, null);
                String tmpkey = null;
                   int i =0;
                try {
                	   Log.i("testzfl","MydbActivity cursor.getString*****************begin");
                    while (cursor.moveToNext()) {
                	   //cursor.moveToNext();
                    	if (0 == i){
                    		cursor.getColumnIndexOrThrow("_id");
                    		Log.i("testzfl","MydbActivity cursor.fillwindows end!!!!!!! count = "+cursor.getCount());
                    	} else {
                    		Log.i("testzfl","MydbActivity cursor.moveToNext !!!!!!! moveToNext  i = "+i);
                    		if(784 == i) {
                    			Log.i("testzfl","MydbActivity cursor.moveToNext stop!!!!  i = "+i);
                    			//break;
                    		}
                    	}
                    	tmpkey = cursor.getString(0);
                    	i++;
                    	//Log.i("testzfl","MydbActivity cursor.moveToNext end!!!!!!!  i = "+i);
                    	//cursor.moveToNext();
                    	//tmpkey = cursor.getString(0);
                    	
                    	//Log.i("testzfl","MydbActivity cursor.getString = "+tmpkey);
                      }
                    Log.i("testzfl","MydbActivity cursor.getString***************** end");
                } finally {
                    cursor.close();
                }
            }
        });
		mButtonupdate = (Button)findViewById(R.id.button3);
		mButtonupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            }
        });
		mButtonQuery = (Button)findViewById(R.id.button4);
		mButtonQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            }
        });
	}
}
