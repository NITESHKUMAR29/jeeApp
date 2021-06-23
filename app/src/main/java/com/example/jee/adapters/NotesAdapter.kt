package com.example.jee.adapters

import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.jee.NotesDetail
import com.example.jee.R
import com.example.jee.UpdateNotes
import com.example.jee.entities.NotesModel
import com.example.jee.viewModels.NotesViewModel

class NotesAdapter(val list:ArrayList<NotesModel>,val context: Context,
                   private val application: Application

):
    RecyclerView.Adapter<NotesAdapter.Notes>() {

    inner class Notes(itemView:View):RecyclerView.ViewHolder(itemView){




        val notesTitle:TextView=itemView.findViewById(R.id.mNotesTitle)
        val notesSubTitle:TextView=itemView.findViewById(R.id.mSubtitle)
        //val notesData:TextView=itemView.findViewById(R.id.mNotesData)
        val notesDate:TextView=itemView.findViewById(R.id.mDate)
        val priority:View=itemView.findViewById(R.id.mPriority)
        val notesMenu:ImageView=itemView.findViewById(R.id.notesMenu)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Notes {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view=layoutInflater.inflate(R.layout.notes_sample,parent,false)
        return Notes(view)
    }

    override fun getItemCount() =list.size

    override fun onBindViewHolder(holder: Notes, position: Int) {
        val currentItem=list[position]

        if (currentItem.notesPriority == "1"){
            holder.priority.setBackgroundResource(R.drawable.red_priority)

        }
       else if (currentItem.notesPriority == "2"){
            holder.priority.setBackgroundResource(R.drawable.yellow_priority)
        }
       else if  (currentItem.notesPriority == "3"){
            holder.priority.setBackgroundResource(R.drawable.green_priority)
        }

        holder.notesTitle.text=currentItem.notesTitle
        holder.notesSubTitle.text=currentItem.notesSubtitle
        //holder.notesData.text=currentItem.notes
        holder.notesDate.text=currentItem.notesDate

        holder.itemView.setOnClickListener {

         val intent= Intent(context,NotesDetail::class.java)
            intent.putExtra("dTitle",currentItem.notesTitle)
            intent.putExtra("dSubTitle",currentItem.notesSubtitle)
            intent.putExtra("dData",currentItem.notes)
          context.startActivity(intent)
        }
        holder.notesMenu.setOnClickListener {
            val popUpMenu=PopupMenu(context,it)
           popUpMenu.setOnMenuItemClickListener { item ->
                when(item.itemId){
                    R.id.notesEdit ->{
                        val intent=Intent(context,UpdateNotes::class.java)
                        intent.putExtra("id",currentItem.id)
                        intent.putExtra("title",currentItem.notesTitle)
                        intent.putExtra("subTitle",currentItem.notesSubtitle)
                        intent.putExtra("priority",currentItem.notesPriority)
                        intent.putExtra("data",currentItem.notes)
                        context.startActivity(intent)
                        return@setOnMenuItemClickListener  true
                    }

                    R.id.notesDelete ->{

                       NotesViewModel(application).deleteNote(currentItem.id)
                        notifyItemRemoved(position)

                        Toast.makeText(context,"deleted",Toast.LENGTH_SHORT).show()
                        return@setOnMenuItemClickListener true
                    }

                    else -> false
                }
            }
            popUpMenu.inflate(R.menu.notes_menu )
            popUpMenu.show()
        }












    }



}