package com.example.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class JeeMainsUpload : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jee_mains_upload)

        val mainsPreviouseYear:CardView=findViewById(R.id.mains_previouse_year)
        val mainsImportantNotes:CardView=findViewById(R.id.mains_important_notes)
        val mainsImportantQuestion:CardView=findViewById(R.id.mains_important_question)
        val mainsDpp:CardView=findViewById(R.id.mains_dpp)

        mainsPreviouseYear.setOnClickListener {

            previousYear()
        }
        mainsImportantNotes.setOnClickListener {
            val intent= Intent(this,PdfUpload::class.java)
            intent.putExtra("type","2")
            startActivity(intent)

        }
        mainsImportantQuestion.setOnClickListener {
            val intent= Intent(this,PdfUpload::class.java)
            intent.putExtra("type","3")
            startActivity(intent)

        }
        mainsDpp.setOnClickListener {
            val intent= Intent(this,DppUpload::class.java)
            intent.putExtra("type","4")
            startActivity(intent)
//            Toast.makeText(this,"Dpp clicked",Toast.LENGTH_SHORT).show()
            // Toast.makeText(this,"coming soon",Toast.LENGTH_SHORT).show()

        }
    }

    private fun previousYear() {
        val intent= Intent(this, PdfUpload::class.java)
        intent.putExtra("type","1")
        startActivity(intent)
    }
}