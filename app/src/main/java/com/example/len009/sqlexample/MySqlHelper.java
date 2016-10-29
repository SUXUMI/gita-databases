package com.example.len009.sqlexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

/**
 * Created by len009 on 10/29/2016
 */
public class MySqlHelper extends SQLiteOpenHelper {

    private static final String CONTACTS_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + MyContracts.Contacts.TABLE_NAME
            + "(" + MyContracts.Contacts.ID + " INTEGER PRIMARY KEY, " + MyContracts.Contacts.NAME + " TEXT, " + MyContracts.Contacts.NUMBER + " TEXT); ";

    public MySqlHelper(Context context) {
        super(context, MyContracts.DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CONTACTS_TABLE_CREATE);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + MyContracts.Contacts.TABLE_NAME);
        onCreate(db);
    }

    public void insert(String name, String number) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MyContracts.Contacts.NAME, name);
        values.put(MyContracts.Contacts.NUMBER, number);
        values.put(MyContracts.Contacts.ID, 1);
        db.insert(MyContracts.Contacts.TABLE_NAME, null, values);
        db.close();
    }

    public void update(int id, String name, String number) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MyContracts.Contacts.NAME, name);
        if (number != null)
            values.put(MyContracts.Contacts.NUMBER, number);
        db.update(MyContracts.Contacts.TABLE_NAME, values,
                MyContracts.Contacts.ID + " = ?", new String[]{id + ""});
        db.close();
    }

    public Cursor query() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(MyContracts.Contacts.TABLE_NAME,
                new String[]{MyContracts.Contacts.NAME, MyContracts.Contacts.NUMBER},
                null, null, null, null, null);
        return cursor;
    }

    public void delete(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(MyContracts.Contacts.TABLE_NAME,
                MyContracts.Contacts.ID + " = ?", new String[]{id + ""});
        db.close();
    }
}