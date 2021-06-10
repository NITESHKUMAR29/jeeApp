package com.example.jee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_omr_option.*

class OmrOption : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_omr_option)
        start.setOnClickListener {
            val question:String=noOfQuestion.text.toString()
            val cMarks:String=cOption.text.toString()
            val negativeMark=nMark.text.toString()
            if (question.isBlank()){
                Toast.makeText(this,"question no should not be blank",Toast.LENGTH_SHORT).show()

            }

            else if (cMarks.isBlank()){
                Toast.makeText(this,"enter correct option mark",Toast.LENGTH_SHORT).show()
            }
            else if (negativeMark.isBlank()){
                Toast.makeText(this,"enter negative mark",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent=Intent(this,Omr::class.java)
                intent.putExtra("questions",question)
                intent.putExtra("cMark",cMarks)
                intent.putExtra("negativeMark",negativeMark)
                startActivity(intent)
            }

        }

    }
}