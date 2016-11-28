package com.example.administrator.myapplication.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xiaojay on 2016/11/25.
 */
public class DBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME="Test";
    private static final String TABLE_NAME = "user_base_infor";
    private static final String KEY_ID = "userId";
    private static final String KEY_NAME = "userName";
    private static final String KEY_PASSWD = "passWd";
    private static final int VERSION = 1;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String createTable = ( "CREATE TABLE IF NOT EXISTS TABLE_NAME"  +
                 "( KEY_ID integer primary key autoincrement KEY_NAME text not null KEY_PASSWD text not null)");
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion ,int newVersion){
        sqLiteDatabase.execSQL("DROP TABLE IF exists TABLE_NAME");
        onCreate(sqLiteDatabase);
    }


}
