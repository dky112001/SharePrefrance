package com.example.shareprefrance

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val sharedPreferences: SharedPreferences =
            getSharedPreferences("user", Context.MODE_PRIVATE)
        val auth = sharedPreferences.getBoolean("log", false)

        Handler().postDelayed(
            Runnable {
                if (
                    auth == true) {
                    val intent = Intent(this, LoginSucess_activity::class.java)

                    startActivity(intent)
                } else {
                    val intent = Intent(this, MainActivity::class.java)

                    startActivity(intent)
                }

            },1000
        )
    }
}