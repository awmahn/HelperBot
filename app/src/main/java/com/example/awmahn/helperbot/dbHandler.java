package com.example.awmahn.helperbot;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;


public class dbHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "searchDB.db";
    public static final String TABLE_NAME = "SearchHistory";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "_name";
    public dbHandler(Context context, String name,
                    SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String myQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT " +
                ");";
        db.execSQL(myQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        onCreate(db);
    }

    // Add record to DB
    public void addName (searchDB search) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, search.get_name());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // Delete record from DB
    public void deleteName(String vname){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME
        + "= \"" + vname + "\";");
    }

    //Print DB contents as String
    public String dbToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String myQuery = "SELECT * FROM " + TABLE_NAME;
        // use cursor to navigate through db
        Cursor c = db.rawQuery(myQuery, null);
        c.moveToFirst();
        while  (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("_name")) != null) {
                dbString += c.getString(c.getColumnIndex("_name"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}
