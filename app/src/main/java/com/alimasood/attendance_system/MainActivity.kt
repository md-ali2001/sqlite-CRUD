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
        databaseHandler!!.add("sohaib amir",9)


        val names = databaseHandler!!.get()
        for (i in names.indices) {
            val name = names[i].name
            val e=names[i].attendance



            if (name != null) {
                Log.d("returned", name+" attendance "+ e )
            }

        }

        Log.d("returned", "\n\n")

        //val names = databaseHandler!!.get()
        present("ali masood")




    }

    fun adddata(newitem: String?) {}

    fun present(studentname:String?)
    {
        val names = databaseHandler!!.get()
        for(i in names.indices)

        {
            if(names[i].name==studentname)
            {
                var num=names[i].attendance
               num= num?.plus(1)
                databaseHandler!!.add("inc",num)


            }
        }
        showdata()

    }

    private fun showdata() {
        databaseHandler = DatabaseHandler(this)
        val names = databaseHandler!!.get()
        for (i in names.indices) {
            val name = names[i].name
            val e=names[i].attendance



            if (name != null) {
                Log.d("returned", name+" attendance "+ e )
            }

        }


    }
}