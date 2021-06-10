package com.example.jee.jeeAdvance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jee.Dpp
import com.example.jee.R
import com.example.jee.jeeMains.MainsPdf
import kotlinx.android.synthetic.main.activity_advance_material.*

class AdvanceMaterial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advance_material)

        mains_previouse_year.setOnClickListener {
            val intent= Intent(this, MainsPdf::class.java)
            intent.putExtra("type","5")
            startActivity(intent)

//            Toast.makeText(this,"previous year clicked",Toast.LENGTH_SHORT).show()
        }
        mains_important_notes.setOnClickListener {
//            Toast.makeText(this,"important notes clicked",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,MainsPdf::class.java)
            intent.putExtra("type","6")
            startActivity(intent)

        }
        mains_important_question.setOnClickListener {
//            Toast.makeText(this,"important notes clicked",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,MainsPdf::class.java)
            intent.putExtra("type","7")
            startActivity(intent)

        }
        mains_dpp.setOnClickListener {
          // Toast.makeText(this,"coming soon",Toast.LENGTH_SHORT).show()
           val intent=Intent(this,Dpp::class.java)
           intent.putExtra("type","8")
           startActivity(intent)

        }
    }
}