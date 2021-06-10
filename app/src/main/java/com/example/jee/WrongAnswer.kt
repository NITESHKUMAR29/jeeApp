package com.example.jee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_wrong_answer.*
import maes.tech.intentanim.CustomIntent

class WrongAnswer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wrong_answer)

        val myAns:String=intent.getStringExtra("rightAnswer").toString()

        rAnswer.text=myAns

        mOk.setOnClickListener {
            onBackPressed()
        }
    }

    override fun finish() {
        super.finish()
        CustomIntent.customType(this,"fadein-to-fadeout")
    }
}