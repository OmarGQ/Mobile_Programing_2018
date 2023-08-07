package com.example.omarxv.pract_7_oigq;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table encuesta(codigo int primary key,nombre text,erectil int,dinero int,japo int,calif int)");
        db.execSQL("create table usuarios(nombre text, password text)");
        db.execSQL("Insert into usuarios values ('omar', 'hola')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
