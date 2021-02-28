package com.example.sqlitepractice3;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper (Context context) { super(context, "myUserDB.db", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String query = "CREATE TABLE IF NOT EXISTS users (" +
                "userName text,"+
                "password text"+
                ")";
                db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop TABLE IF EXISTS users");
        onCreate(db);
    }
}
