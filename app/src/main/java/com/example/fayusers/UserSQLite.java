package com.example.fayusers;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserSQLite extends SQLiteOpenHelper {
    public UserSQLite( Context context,  String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BasedeDatos) {
        BasedeDatos.execSQL("create table users(id int primary key, name text, lastname text, email text, password text, gender text, birthday text )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
