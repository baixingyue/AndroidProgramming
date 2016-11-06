package com.example.androidtext20_sqlite;

/**
 * Created by DELL on 2016/11/5.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public String CREATE_TABLE_SQL = "create table dict_tb(_id integer primary key" + " autoincrement , word , interpret)";

    public MyDatabaseHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("---版本更新-----" + oldVersion + "--->" + newVersion);
    }
}