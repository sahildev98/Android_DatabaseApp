package com.example.sqlitepractice3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Database extends DatabaseHelper {
    public Database(Context context) {
        super(context);
    }

    public long addUser(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("users" , null,values);
    }

    public Cursor outputUsersData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String table = "users";
        String [] columns = {"username"};
        String selection = "";
        String [] selectionArgs = {};
        String groupBy = null;
        String having = null;
        String orderBy = "username DESC";
        String limit = "100";

        Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);

        return cursor;
    }
}
