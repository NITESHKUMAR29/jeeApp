package com.example.jee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        textView27.alpha=0f
        textView26.alpha=0f
        textView26.animate().setDuration(2000).alpha(1f).withEndAction(){
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }
        textView27.animate().setDuration(2000).alpha(1f).withEndAction(){
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()

        }

    }
}