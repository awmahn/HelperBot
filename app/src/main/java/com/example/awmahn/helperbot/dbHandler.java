package com.example.awmahn.helperbot;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;


//basis for code is from Android recipe 5
public class dbHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "searchDB.db";
    public static final String TABLE_NAME = "SearchHistory";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "_name";
    public static final String COLUMN_URL = "_url";
    public dbHandler(Context context,
                    SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String myQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME + " TEXT," + COLUMN_URL + " TEXT" +
                ");";
        db.execSQL(myQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        onCreate(db);
    }

    // Add record to DB
    public void addSearch (searchDB search) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, search.get_name());
        values.put(COLUMN_URL, search.get_url());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // Delete record from DB
    public void deleteSearch(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID
        + "= \"" + id + "\";");
        db.close();
    }

    public searchDB findSearch(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String Query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = " + id;

        Cursor c = db.rawQuery(Query, null);

        if (c != null) {
            c.moveToFirst();
        }
        searchDB search = new searchDB();
        search.set_id(c.getInt(c.getColumnIndex(COLUMN_ID)));
        search.set_name(c.getString(c.getColumnIndex(COLUMN_NAME)));
        search.set_url(c.getString(c.getColumnIndex(COLUMN_URL)));

        db.close();

        return search;
    }

    public List<searchDB> findAllSearches() {
        List<searchDB> searches = new ArrayList<searchDB>();
        SQLiteDatabase db  = getReadableDatabase();
        String Query = "SELECT * FROM " + TABLE_NAME;

        Cursor c = db.rawQuery(Query, null);

        c.moveToFirst();
        while (!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex(COLUMN_NAME)) != null && c.getString(c.getColumnIndex(COLUMN_URL)) != null) {
                searchDB search = new searchDB();
                search.set_id(c.getInt(c.getColumnIndex(COLUMN_ID)));
                search.set_name(c.getString(c.getColumnIndex(COLUMN_NAME)));
                search.set_url(c.getString(c.getColumnIndex(COLUMN_URL)));

                searches.add(search);
            }
            c.moveToNext();
        }
        db.close();

        return searches;
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
            if (c.getString(c.getColumnIndex(COLUMN_NAME)) != null && c.getString(c.getColumnIndex(COLUMN_URL)) != null) {
                dbString += c.getInt(c.getColumnIndex(COLUMN_ID));
                dbString += c.getString(c.getColumnIndex(COLUMN_NAME));
                dbString += c.getString(c.getColumnIndex(COLUMN_URL));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}
