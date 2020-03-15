package com.codewithparimal.myactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbManager extends SQLiteOpenHelper
{
    private static final String dbname="studentDesc.db";
    public dbManager(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="create table tbl_student (name text,amount text,purpose text)";
        db.execSQL(qry);
        //db.execSQL("ALTER TABLE student ADD COLUMN student_amt INTEGER DEFAULT 0");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_student");
        onCreate(db);
    }



    public String addRecord(String p1,String p2,String p3)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("name",p1);
        cv.put("amount",p2);
        cv.put("purpose",p3);

        long res=db.insert("tbl_student",null,cv);

        if(res==-1)
            return "failed";
        else
            return "Successfully inserted";
        //db.rawQuery("insert into tbl_student values('p1',p2,'p3')");
    }
    public Cursor alldata()
    {
        SQLiteDatabase dbm=this.getWritableDatabase();
        Cursor cursor=dbm.rawQuery("select * from tbl_student",null);
        return cursor;
    }
}
