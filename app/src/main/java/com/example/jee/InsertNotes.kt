package com.example.jee

import android.app.Application
import android.os.Bundle
import android.service.autofill.CharSequenceTransformation
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.jee.entities.NotesModel
import com.example.jee.viewModels.NotesViewModel
import kotlinx.android.synthetic.main.activity_insert_notes.*
import kotlinx.android.synthetic.main.activity_insert_notes.doneBtn
import kotlinx.android.synthetic.main.activity_insert_notes.greenPriority
import kotlinx.android.synthetic.main.activity_insert_notes.notesData
import kotlinx.android.synthetic.main.activity_insert_notes.notesSubTitle
import kotlinx.android.synthetic.main.activity_insert_notes.notesTirle
import kotlinx.android.synthetic.main.activity_insert_notes.redPriority
import kotlinx.android.synthetic.main.activity_insert_notes.yellowPriority
import kotlinx.android.synthetic.main.activity_update_notes.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class InsertNotes : AppCompatActivity() {
    lateinit var viewModel:NotesViewModel
   lateinit var date:Date
    var priority:String="1"
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_notes)
        
       viewModel=ViewModelProvider(this,
           ViewModelProvider.AndroidViewModelFactory.getInstance(Application())
       ).get(NotesViewModel(application)::class.java)

        redPriority.setOnClickListener {

            redPriority.setImageResource(R.drawable.ic_baseline_check_24)
            greenPriority.setImageResource(0)
            yellowPriority.setImageResource(0)
            priority="1"

        }
        greenPriority.setOnClickListener {
            redPriority.setImageResource(0)
            greenPriority.setImageResource(R.drawable.ic_baseline_check_24)
            yellowPriority.setImageResource(0)
            priority="2"

        }
        yellowPriority.setOnClickListener {
            redPriority.setImageResource(0)
            greenPriority.setImageResource(0)
            yellowPriority.setImageResource(R.drawable.ic_baseline_check_24)
            priority="3"

        }






//
//
        doneBtn.setOnClickListener{

            val title=notesTirle.text.toString()
            val subTitle=notesSubTitle.text.toString()
            val notesData=notesData.text.toString()

            val currentDate: String = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

            viewModel.insertNote(NotesModel(0,title,subTitle,currentDate,notesData,priority))
            Toast.makeText(this,"Notes Created",Toast.LENGTH_SHORT).show()
            finish()
          // creatNotes(title,subTitle,notesData)

       }
    }

//    private fun creatNotes(title: String, subTitle: String, notesData: String) {
//
//
////
//      notes1.notesTitle=title
//        notes1.notesSubtitle=subTitle
//        notes1.notes=notesData
//           viewModel.insertNote(notes1)
//         Toast.makeText(this,"Notes created",Toast.LENGTH_SHORT).show()
//
//  }
//


}