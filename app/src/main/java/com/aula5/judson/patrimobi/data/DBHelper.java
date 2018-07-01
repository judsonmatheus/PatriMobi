package com.aula5.judson.patrimobi.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Judson on 28/06/2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "patrimobi";
    private static  final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS 'patrimobi'(id integer primary key autoincrement, nome text, localizacao text, valor double, situacaa text,dataAquisicao text, descrica text";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXIST patrimobi";
        db.execSQL(sql);
        onCreate(db);
    }
}
