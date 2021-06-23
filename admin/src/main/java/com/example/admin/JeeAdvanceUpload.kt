package com.example.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class JeeAdvanceUpload : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jee_advance_upload)

        val advancePreviousYear:CardView=findViewById(R.id.mains_previouse_year)
        val advanceImportantNotes:CardView=findViewById(R.id.mains_important_notes)
        val advanceImportantQuestions:CardView=findViewById(R.id.mains_important_question)
        val advanceDpp:CardView=findViewById(R.id.mains_dpp)

        advancePreviousYear.setOnClickListener {
            val intent= Intent(this,PdfUpload::class.java)
            intent.putExtra("type","5")
            startActivity(intent)

//            Toast.makeText(this,"previous year clicked",Toast.LENGTH_SHORT).show()
        }
        advanceImportantNotes.setOnClickListener {
//            Toast.makeText(this,"important notes clicked",Toast.LENGTH_SHORT).show()
            val intent= Intent(this,PdfUpload::class.java)
            intent.putExtra("type","6")
            startActivity(intent)

        }
        advanceImportantQuestions.setOnClickListener {
//            Toast.makeText(this,"important notes clicked",Toast.LENGTH_SHORT).show()
            val intent= Intent(this,PdfUpload::class.java)
            intent.putExtra("type","7")
            startActivity(intent)

        }
        advanceDpp.setOnClickListener {
            // Toast.makeText(this,"coming soon",Toast.LENGTH_SHORT).show()
            val intent= Intent(this,DppUpload::class.java)
            intent.putExtra("type","8")
            startActivity(intent)

        }
    }
}