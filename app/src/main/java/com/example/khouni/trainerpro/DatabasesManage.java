package com.example.khouni.trainerpro;
import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.Date;
import android.database.Cursor;
/**
 * Created by khouni on 9/25/17.
 */

public class DatabasesManage extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "TrainerPro.db";
    public static final String TABLE_NAME = "client_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FNAME";
    public static final String COL_3 = "LNAME";
    public static final String COL_4 = "ADDRESS";
    public static final String COL_5 = "SEX";
    public static final String COL_6 = "DOB";
    public static final String COL_7 = "PHONE";


    public DatabasesManage(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,FNAME TEXT,LNAME TEXT,ADDRESS TEXT, SEX TEXT, DOB DATE, PHONE INTEGER" +
                ")");
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            onCreate(db);
        }


    public boolean insertData(String fname, String lname, String address, String sex, String dob,String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,fname);
        contentValues.put(COL_3,lname);
        contentValues.put(COL_4,address);
        contentValues.put(COL_5,sex);
        contentValues.put(COL_6,dob);
        contentValues.put(COL_7,phone);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    }

