package com.example.jee

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jee.adapters.NotesAdapter
import com.example.jee.entities.NotesModel
import com.example.jee.viewModels.NotesViewModel
import kotlinx.android.synthetic.main.activity_content.*
import kotlinx.android.synthetic.main.activity_notes.*

class Notes : AppCompatActivity() {

    lateinit var viewModel: NotesViewModel
    lateinit var display:ArrayList<NotesViewModel>
    lateinit var notesAdapter: Adapter
    lateinit var list: ArrayList<NotesModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        noFilter.setBackgroundResource(R.drawable.select_filter)

        viewModel=ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(Application())
        ).get(NotesViewModel(application)::class.java)

        nFilter.setOnClickListener {
            loadData(1)
            noFilter.setBackgroundResource(R.drawable.select_filter)
            high.setBackgroundResource(0)
            low.setBackgroundResource(0)
        }

        hTol.setOnClickListener {
            loadData(2)
            noFilter.setBackgroundResource(0)
            high.setBackgroundResource(R.drawable.select_filter)
            low.setBackgroundResource(0)
        }
        lToh.setOnClickListener {
            loadData(3)
            noFilter.setBackgroundResource(0)
            high.setBackgroundResource(0)
            low.setBackgroundResource(R.drawable.select_filter)
        }

            list= ArrayList()



        addNotes.setOnClickListener {


            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
           val intent =Intent(this,InsertNotes::class.java)
          startActivity(intent)
        }
        viewModel.allNotes.observe(this, Observer {list->

            val  notesAdapter=NotesAdapter(list as ArrayList<NotesModel>,this,Application())
            notesRecyclerView.adapter=notesAdapter
            notesRecyclerView.hasFixedSize()
            notesRecyclerView.layoutManager=GridLayoutManager(this,2)


        })


    }

    private fun loadData(i: Int) {

        if(i==1){
            viewModel.allNotes.observe(this, Observer {list->

                val  notesAdapter=NotesAdapter(list as ArrayList<NotesModel>,this,Application())
                notesRecyclerView.adapter=notesAdapter
                notesRecyclerView.hasFixedSize()
                notesRecyclerView.layoutManager=GridLayoutManager(this,2)


            })
        }
        if(i==2){
            viewModel.highToLow.observe(this, Observer {list->

                val  notesAdapter=NotesAdapter(list as ArrayList<NotesModel>,this,Application())
                notesRecyclerView.adapter=notesAdapter
                notesRecyclerView.hasFixedSize()
                notesRecyclerView.layoutManager=GridLayoutManager(this,2)


            })
        }
        if(i==3){
            viewModel.lowTohigh.observe(this, Observer {list->

                val  notesAdapter=NotesAdapter(list as ArrayList<NotesModel>,this,Application())
                notesRecyclerView.adapter=notesAdapter
                notesRecyclerView.hasFixedSize()
                notesRecyclerView.layoutManager=GridLayoutManager(this,2)


            })

            }

    }


}