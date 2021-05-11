package com.example.sharedpref

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.checkbox as checkbox1

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences:SharedPreferences
    var isRemembered=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences=getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        isRemembered =sharedPreferences.getBoolean("CHECKBOX" ,false)
        if(isRemembered)
        {
            val intent= Intent(this,AnotherActivity::class.java)
            startActivity(intent)
            finish()
        }
      login.setOnClickListener{

          val name:String=nameEt.text.toString()
          val age:Int=ageEt.text.toString().toInt()
          val checked:Boolean = checkbox1.isChecked

          val editor:SharedPreferences.Editor=sharedPreferences.edit()
          editor.putString("NAME",name)
          editor.putInt("AGE",age)
          editor.putBoolean("CHECKBOX",checked)
          editor.apply()

          Toast.makeText(this,"Information Saved!",Toast.LENGTH_LONG).show()
          val intent=Intent(this,AnotherActivity::class.java)
          startActivity(intent)
          finish()



      }
    }
}