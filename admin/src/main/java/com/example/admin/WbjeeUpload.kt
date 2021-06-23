package com.example.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class WbjeeUpload : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wbjee_upload)

        val wbjeePreviousYear:CardView=findViewById(R.id.mains_previouse_year)
        val wbjeeNotes:CardView=findViewById(R.id.mains_important_notes)
        val wbjeeQuestions:CardView=findViewById(R.id.mains_important_question)
        val wbjeeDpp:CardView=findViewById(R.id.mains_dpp)
        wbjeePreviousYear.setOnClickListener {
            val intent= Intent(this, PdfUpload::class.java)
            intent.putExtra("type","9")
            startActivity(intent)

//            Toast.makeText(this,"previous year clicked",Toast.LENGTH_SHORT).show()
        }
        wbjeeNotes.setOnClickListener {
            val intent= Intent(this,PdfUpload::class.java)
            intent.putExtra("type","10")
            startActivity(intent)

//            Toast.makeText(this,"important notes  clicked",Toast.LENGTH_SHORT).show()
        }
        wbjeeQuestions.setOnClickListener {
            val intent= Intent(this,PdfUpload::class.java)
            intent.putExtra("type","11")
            startActivity(intent)

//            Toast.makeText(this,"important questions clicked",Toast.LENGTH_SHORT).show()
        }
        wbjeeDpp.setOnClickListener {
            val intent= Intent(this,DppUpload::class.java)
            intent.putExtra("type","12")
            startActivity(intent)

//            Toast.makeText(this,"DPP clicked",Toast.LENGTH_SHORT).show()
        }
    }
}