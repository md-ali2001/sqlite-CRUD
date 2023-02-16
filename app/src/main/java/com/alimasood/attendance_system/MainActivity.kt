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
        databaseHandler!!.add("ali masood","e")
        databaseHandler!!.add("sohaib bin amir","w")
        databaseHandler!!.add("ayan hussain","s")
        databaseHandler!!.add("ammar abid","d")
        val names = databaseHandler!!.get()
        for (i in names.indices)
        {
            val name=names[i].name
            val e=names[i].age


            if (name != null) {
                Log.d("returned",name+" age:"+e )
            }

        }


    }

    fun adddata(newitem: String?) {}
}