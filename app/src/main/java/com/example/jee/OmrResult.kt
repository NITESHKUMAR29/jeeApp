package com.example.jee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_omr_result.*

class OmrResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_omr_result)
         val obtainMark:String=intent.getStringExtra("totalRightMark").toString()
        val totalMark:String=intent.getStringExtra("totalMark").toString()
        val correctAnswer:String=intent.getStringExtra("rightAnswer").toString()
        val wrongAnswer:String=intent.getStringExtra("wrongAnswer").toString()
         val totalQuestion:String=intent.getStringExtra("totalQuestion").toString()
        val notAttempt=totalQuestion.toInt()-(correctAnswer.toInt()+wrongAnswer.toInt())
                obtainMarkss.text=obtainMark
        fMark.text=totalMark
        cAnswer.text=correctAnswer
        wAnswers.text=wrongAnswer
       tQuestion.text=totalQuestion
       nAttempt.text=notAttempt.toString()
        mScore.text=totalMark
    }
}