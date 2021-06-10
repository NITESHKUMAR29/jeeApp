package com.example.jee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_right_answer.*
import maes.tech.intentanim.CustomIntent

class RightAnswer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_right_answer)
        mOk.setOnClickListener {
//            val intent= Intent(this,Dpp::class.java)
//            startActivity(intent)

            onBackPressed()

        }

    }

    override fun finish() {
        super.finish()
        CustomIntent.customType(this,"fadein-to-fadeout")
        
    }
}