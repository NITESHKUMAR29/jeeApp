package com.example.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class AdminContent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_content)
        val jeeMains=findViewById<CardView>(R.id.jeeMainss)
        val jeeAdvance=findViewById<CardView>(R.id.jeeAdvance)
        val wbjee=findViewById<CardView>(R.id.wbJee)
        jeeMains.setOnClickListener {
        val intent=Intent(this,JeeMainsUpload::class.java)
            startActivity(intent)
        }
        jeeAdvance.setOnClickListener {
            val intent=Intent(this,JeeAdvanceUpload::class.java)
            startActivity(intent)
        }
        wbjee.setOnClickListener {
            val intent=Intent(this,WbjeeUpload::class.java)
            startActivity(intent)
        }

    }
}