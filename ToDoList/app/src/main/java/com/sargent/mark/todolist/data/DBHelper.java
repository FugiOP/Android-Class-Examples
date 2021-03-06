package com.sargent.mark.todolist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mark on 7/4/17.
 */

public class DBHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "items.db";
    private static final String TAG = "dbhelper";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Added column status and category to CREATE queryString
        String queryString = "CREATE TABLE " + Contract.TABLE_TODO.TABLE_NAME + " ("+
                Contract.TABLE_TODO._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Contract.TABLE_TODO.COLUMN_NAME_DESCRIPTION + " TEXT NOT NULL, " +
                Contract.TABLE_TODO.COLUMN_NAME_DUE_DATE + " DATE, " +
                Contract.TABLE_TODO.COLUMN_NAME_CATEGORY + " TEXT NOT NULL, " +
                Contract.TABLE_TODO.COLUMN_NAME_STATUS + " TEXT NOT NULL " +
                "); ";

        Log.d(TAG, "Create table SQL: " + queryString);
        db.execSQL(queryString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //When database version is updated, drop table and recreate it
        if(oldVersion<newVersion){
            db.execSQL("DROP TABLE "+ Contract.TABLE_TODO.TABLE_NAME+" ");
            String queryString = "CREATE TABLE " + Contract.TABLE_TODO.TABLE_NAME + " ("+
                    Contract.TABLE_TODO._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    Contract.TABLE_TODO.COLUMN_NAME_DESCRIPTION + " TEXT NOT NULL, " +
                    Contract.TABLE_TODO.COLUMN_NAME_DUE_DATE + " DATE, " +
                    Contract.TABLE_TODO.COLUMN_NAME_CATEGORY + " TEXT, " +
                    Contract.TABLE_TODO.COLUMN_NAME_STATUS + " TEXT NOT NULL " +
                    "); ";
            db.execSQL(queryString);
        }
    }
}
