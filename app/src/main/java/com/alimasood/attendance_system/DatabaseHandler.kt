package com.alimasood.attendance_system

import android.database.sqlite.SQLiteOpenHelper
import com.alimasood.attendance_system.DatabaseHandler
import android.database.sqlite.SQLiteDatabase
import android.content.ContentValues
import android.content.Context
import com.alimasood.attendance_system.readdata
import java.util.*

class DatabaseHandler(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    var DB: SQLiteDatabase
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " TEXT )")
    }

    override fun onUpgrade(db: SQLiteDatabase, i: Int, i1: Int) {
        onCreate(db)
    }

    fun add(item: String?): Boolean {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_ID, item)
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
            r.name = cursor.getString(0)
            names.add(r)
        }
        return names
    }

    companion object {
        private const val DB_VERSION = 1
        private const val DB_NAME = "attendance.db"
        private const val TABLE_NAME = "attendancetable"
        private const val COLUMN_ID = "students"
    }

    init {
        DB = writableDatabase
    }
}