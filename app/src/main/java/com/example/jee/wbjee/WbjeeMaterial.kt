package com.example.jee.wbjee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jee.Dpp
import com.example.jee.R
import com.example.jee.jeeMains.MainsPdf
import kotlinx.android.synthetic.main.activity_wbjee_material.*

class WbjeeMaterial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wbjee_material)

        mains_previouse_year.setOnClickListener {
            val intent= Intent(this, MainsPdf::class.java)
            intent.putExtra("type","9")
            startActivity(intent)

//            Toast.makeText(this,"previous year clicked",Toast.LENGTH_SHORT).show()
        }
        mains_important_notes.setOnClickListener {
            val intent=Intent(this,MainsPdf::class.java)
            intent.putExtra("type","10")
            startActivity(intent)

//            Toast.makeText(this,"important notes  clicked",Toast.LENGTH_SHORT).show()
        }
        mains_important_question.setOnClickListener {
            val intent=Intent(this,MainsPdf::class.java)
            intent.putExtra("type","11")
            startActivity(intent)

//            Toast.makeText(this,"important questions clicked",Toast.LENGTH_SHORT).show()
        }
        mains_dpp.setOnClickListener {
            val intent=Intent(this,Dpp::class.java)
            intent.putExtra("type","12")
            startActivity(intent)

//            Toast.makeText(this,"DPP clicked",Toast.LENGTH_SHORT).show()
        }
    }
}