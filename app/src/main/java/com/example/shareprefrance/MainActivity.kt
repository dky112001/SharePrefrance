package com.example.shareprefrance

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {


    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userName : EditText= findViewById(R.id.username)
        var password : EditText= findViewById(R.id.password)
        var login : Button = findViewById(R.id.logbtn)
        var sharedPreferences: SharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE)

        login.setOnClickListener {
            val intent = Intent(this,LoginSucess_activity::class.java)
                val edit : SharedPreferences.Editor= sharedPreferences.edit()
                edit.putString("name",userName.text.toString())
                edit.putString("password",password.text.toString())
                edit.putBoolean("log",true)
                edit.apply()
                edit.commit()
            startActivity(intent)


        }

    }
}