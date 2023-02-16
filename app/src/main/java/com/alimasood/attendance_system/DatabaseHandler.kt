package com.alimasood.attendance_system

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.*

class DatabaseHandler(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    var DB: SQLiteDatabase
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE ${TABLE_NAME} ($pk INTEGER PRIMARY KEY, $COLUMN_ID TEXT,$COLUMN_ID2 TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldversion: Int, newversion: Int) {
        onCreate(db)



    }

    fun update(id : Int? , newattendance : Int) {
        val st= "UPDATE $TABLE_NAME SET $COLUMN_ID2 = $newattendance WHERE $pk = $id";
        DB.execSQL(st)
    }

    fun add(primarykey:Int,item: String?,attendance: Int?): Boolean {
        val contentValues = ContentValues()
        contentValues.put(pk, primarykey)
        contentValues.put(COLUMN_ID, item)
        contentValues.put(COLUMN_ID2, attendance)

        val result = DB.insert(TABLE_NAME, null, contentValues)
        return if (result == -1L) {
            false
        } else true
    }

    fun get(): ArrayList<readdata> {
        val DBR = this.readableDatabase
        val cursor = DBR.rawQuery("SELECT * FROM " + TABLE_NAME, null)
        val names = ArrayList<readdata>()
        while (cursor.moveToNext()) {
            val r = readdata()
            r.primarykey = cursor.getInt(0)
            r.name = cursor.getString(1)
            r.attendance=cursor.getInt(2)

            names.add(r)
        }
        return names
    }

    companion object {
        private const val DB_VERSION = 1
        private const val DB_NAME = "attendance8.db"
        private const val TABLE_NAME = "attendancetable"
        private const val pk = "pk"
        private const val COLUMN_ID = "students"
        private const val COLUMN_ID2 = "attendance"
    }

    init {
        DB = writableDatabase
    }
}