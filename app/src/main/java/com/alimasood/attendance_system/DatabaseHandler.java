package com.alimasood.attendance_system;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION=1;
    private static final String DB_NAME="attendance.db";
    private static final String TABLE_NAME="attendancetable";
    private static final String COLUMN_ID="students";
    SQLiteDatabase DB;


    public DatabaseHandler(Context context) {
        super(context, DB_NAME,null,DB_VERSION);
        DB=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ("+COLUMN_ID+" TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
onCreate(db);
    }

    public boolean add(String item)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_ID,item);
        long result=DB.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
        {
            return false;
        }
        else
            return true;

}


public ArrayList<readdata> get()
{
    SQLiteDatabase DBR=this.getReadableDatabase();
    Cursor cursor=DBR.rawQuery("SELECT * FROM " + TABLE_NAME,null);
    ArrayList<readdata> names=new ArrayList<>();
    while(cursor.moveToNext())
    {
        readdata r=new readdata();
        r.name=cursor.getString(0);
        names.add(r);

    }
    return names;

}


}
