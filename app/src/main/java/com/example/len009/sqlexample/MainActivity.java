package com.example.len009.sqlexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MySqlHelper sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqLiteDatabase = new MySqlHelper(this);
        sqLiteDatabase.insert("Irakli Managadze", "558394171");
        sqLiteDatabase.insert("Alexander Pataridze", "558389876");
    }

    public void onQueryClick(View view) {
        Cursor cursor = sqLiteDatabase.query();
        cursor.moveToFirst();
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(MyContracts.Contacts.NAME));

        }
    }

//    package com.example.len009.sqlexample;
//
//    import android.database.Cursor;
//    import android.database.sqlite.SQLiteDatabase;
//    import android.support.v7.app.AppCompatActivity;
//    import android.os.Bundle;
//    import android.view.View;
//
//    import java.util.List;

//    public class MainActivity extends AppCompatActivity {
//
//        MySqlHelper sqLiteDatabase;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//            Contact contact = new Contact();
//            contact.setName("Irakli");
//            contact.setNumber("558394171");
//            contact.save();
//
//            contact = new Contact();
//            contact.setName("Irakli");
//            contact.setNumber("558394171");
//            contact.save();
//
//            contact = new Contact();
//            contact.setName("Irakli");
//            contact.setNumber("558394171");
//            contact.save();
//
//            contact = new Contact();
//            contact.setName("Irakli");
//            contact.setNumber("558394171");
//            contact.save();
//
//        }
//
//        public void onQueryClick(View view) {
//            List<Contact> books = Contact.find(Contact.class, null, null);
//            books.get(0);
//        }
//    }
}