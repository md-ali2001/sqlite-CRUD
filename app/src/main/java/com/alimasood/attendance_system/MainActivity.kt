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
      // databaseHandler!!.add(18, "ohaib amir",0)


        val names = databaseHandler!!.get()
        for (i in names.indices) {
            val id=names[i].primarykey
            val name = names[i].name
            val e=names[i].attendance



            if (name != null) {
                Log.d("data", "id:" +id+ "  name:"+name+" attendance :"+ e )
            }

        }

        Log.d("data", "\n\n")

        //val names = databaseHandler!!.get()
        present(1)




    }

    fun adddata(newitem: String?) {}

    fun present(studentid:Int?)
    {
        val names = databaseHandler!!.get()
        for(i in names.indices)

        {
            if(names[i].primarykey==studentid)
            {
                var num=names[i].attendance
               num= num?.plus(1)
                if (num != null) {
                    databaseHandler!!.update(names[i].primarykey,num)
                }



            }
        }
        showdata()

    }

    private fun showdata() {
        databaseHandler = DatabaseHandler(this)
        val names = databaseHandler!!.get()
        for (i in names.indices) {
            val id=names[i].primarykey
            val name = names[i].name
            val e=names[i].attendance



            if (name != null) {
                Log.d("data", "id :" +id+ "name : "+name+" attendance "+ e )
            }

        }


    }
}