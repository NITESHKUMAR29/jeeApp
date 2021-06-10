package com.example.jee.jeeMains

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jee.Dpp
import com.example.jee.R
import kotlinx.android.synthetic.main.activity_choose_pdf.*

class ChoosePdf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_pdf)

        mains_previouse_year.setOnClickListener {

            previousYear()
        }
      mains_important_notes.setOnClickListener {
          val intent=Intent(this,MainsPdf::class.java)
          intent.putExtra("type","2")
          startActivity(intent)

      }
    mains_important_question.setOnClickListener {
        val intent=Intent(this,MainsPdf::class.java)
        intent.putExtra("type","3")
        startActivity(intent)

    }
        mains_dpp.setOnClickListener {
            val intent=Intent(this,Dpp::class.java)
            intent.putExtra("type","4")
            startActivity(intent)
//            Toast.makeText(this,"Dpp clicked",Toast.LENGTH_SHORT).show()
           // Toast.makeText(this,"coming soon",Toast.LENGTH_SHORT).show()

        }
    }

    private fun previousYear() {
        val intent=Intent(this, MainsPdf::class.java)
        intent.putExtra("type","1")
        startActivity(intent)
    }
}