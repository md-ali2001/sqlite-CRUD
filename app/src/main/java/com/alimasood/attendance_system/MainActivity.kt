package com.alimasood.attendance_system

import androidx.appcompat.app.AppCompatActivity
import com.alimasood.attendance_system.DatabaseHandler
import android.os.Bundle
import android.util.Log
import com.alimasood.attendance_system.R
import com.alimasood.attendance_system.readdata

class MainActivity : AppCompatActivity() {
    var databaseHandler: DatabaseHandler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        databaseHandler = DatabaseHandler(this)
        databaseHandler!!.add("lllll")
        val names = databaseHandler!!.get()
        //for (i in names.indices) Log.d("returned", names[i].name)
    }

    fun adddata(newitem: String?) {}
}