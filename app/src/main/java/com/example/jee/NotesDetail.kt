package com.example.jee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notes_detail.*

class NotesDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_detail)

        val mDTitle:String=intent.getStringExtra("dTitle").toString()
        val mDSubTitle:String=intent.getStringExtra("dSubTitle").toString()
        val mDData:String=intent.getStringExtra("dData").toString()

        dTitle.text=mDTitle
        dSubtitle.text=mDSubTitle
        dData.text=mDData
    }
}