package com.example.jee.neet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jee.R
import kotlinx.android.synthetic.main.activity_neet_material.*

class NeetMaterial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_neet_material)

            neet_previouse_year.setOnClickListener {
                Toast.makeText(this,"previous year clicked",Toast.LENGTH_SHORT).show()
            }
        neet_important_notes.setOnClickListener {
            Toast.makeText(this,"important notes clicked",Toast.LENGTH_SHORT).show()
        }
        neet_important_question.setOnClickListener {
            Toast.makeText(this,"important question clicked",Toast.LENGTH_SHORT).show()
        }
        neet_dpp.setOnClickListener {
            Toast.makeText(this,"DPP clicked",Toast.LENGTH_SHORT).show()
        }
    }
}