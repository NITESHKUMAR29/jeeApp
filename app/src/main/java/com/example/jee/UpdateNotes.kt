package com.example.jee

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.jee.entities.NotesModel
import com.example.jee.viewModels.NotesViewModel
import kotlinx.android.synthetic.main.activity_insert_notes.*
import kotlinx.android.synthetic.main.activity_update_notes.*
import kotlinx.android.synthetic.main.activity_update_notes.doneBtn
import kotlinx.android.synthetic.main.activity_update_notes.greenPriority
import kotlinx.android.synthetic.main.activity_update_notes.notesData
import kotlinx.android.synthetic.main.activity_update_notes.notesSubTitle
import kotlinx.android.synthetic.main.activity_update_notes.notesTirle
import kotlinx.android.synthetic.main.activity_update_notes.redPriority
import kotlinx.android.synthetic.main.activity_update_notes.yellowPriority
import java.text.SimpleDateFormat
import java.util.*

class UpdateNotes : AppCompatActivity() {
    lateinit var mPriority:String
    override fun onCreate(savedInstanceState: Bundle?) {
        var priority:String="1"

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_notes)

        var viewModel: NotesViewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(Application())
        ).get(NotesViewModel(application)::class.java)

        val id:Int=intent.getIntExtra("id",0)
        val title:String=intent.getStringExtra("title").toString()
        val subTitle:String=intent.getStringExtra("subTitle").toString()
          mPriority=intent.getStringExtra("priority").toString()
        val data:String=intent.getStringExtra("data").toString()


        if (mPriority=="1"){
            redPriority.setImageResource(R.drawable.ic_baseline_check_24)
        }
       else if (mPriority=="3"){
            yellowPriority.setImageResource(R.drawable.ic_baseline_check_24)
        }
       else if (mPriority=="2"){
            greenPriority.setImageResource(R.drawable.ic_baseline_check_24)
        }

        notesData.setSelection(notesData.text.length);
       notesTirle.setText(title)
        notesSubTitle.setText(subTitle)
        notesData.setText(data)
       redPriority.setOnClickListener {
           redPriority.setImageResource(R.drawable.ic_baseline_check_24)
           yellowPriority.setImageResource(0)
           greenPriority.setImageResource(0)
           priority="1"
       }
        yellowPriority.setOnClickListener {
            redPriority.setImageResource(0)
            yellowPriority.setImageResource(R.drawable.ic_baseline_check_24)
            greenPriority.setImageResource(0)
            priority="3"

        }

        greenPriority.setOnClickListener {
            redPriority.setImageResource(0)
            yellowPriority.setImageResource(0)
            greenPriority.setImageResource(R.drawable.ic_baseline_check_24)
            priority="2"

        }

        doneBtn.setOnClickListener {
            val title=notesTirle.text.toString()
            val subTitle=notesSubTitle.text.toString()
            val notesData=notesData.text.toString()


            val currentDate: String = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(
                Date()
            )

            viewModel.updateNote(NotesModel(id,title,subTitle,currentDate,notesData,priority))
            Toast.makeText(this,"Notes Updated", Toast.LENGTH_SHORT).show()
            finish()
        }



    }
}