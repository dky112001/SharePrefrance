package com.example.shareprefrance

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginSucess_activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_sucess)

        val nameGet: TextView = findViewById(R.id.nameget)
        val passwordget: TextView = findViewById(R.id.passwordget)
        val logout: Button = findViewById(R.id.logoutbutton)

        val sharedPreferences: SharedPreferences =
            getSharedPreferences("user", Context.MODE_PRIVATE)

        val nameshow = sharedPreferences.getString("name", "")
        val password = sharedPreferences.getString("password", "")

        nameGet.text = nameshow
        passwordget.text = password

        logout.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}