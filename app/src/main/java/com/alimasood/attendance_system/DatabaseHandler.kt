package com.alimasood.attendance_system

import android.database.sqlite.SQLiteOpenHelper
import com.alimasood.attendance_system.DatabaseHandler
import android.database.sqlite.SQLiteDatabase
import android.content.ContentValues
import android.content.Context
import android.os.FileObserver.CREATE
import com.alimasood.attendance_system.readdata
import java.util.*

class DatabaseHandler(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    var DB: SQLiteDatabase
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE ${TABLE_NAME} ($COLUMN_ID TEXT,$COLUMN_ID2 TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldversion: Int, newversion: Int) {
        onCreate(db)



    }

    fun add(item: String?,age: String?): Boolean {
        val contentValues = ContentValues()
        contentValues.put(COLUMN_ID, item)
        contentValues.put(COLUMN_ID2, age)

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
            r.age=cursor.getString(1)

            names.add(r)
        }
        return names
    }

    companion object {
        private const val DB_VERSION = 1
        private const val DB_NAME = "attendance4.db"
        private const val TABLE_NAME = "attendancetable2"
        private const val COLUMN_ID = "students"
        private const val COLUMN_ID2 = "AGE"
    }

    init {
        DB = writableDatabase
    }
}