package com.example.jee.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.jee.databases.NotesDatabase
import com.example.jee.entities.NotesModel
import com.example.jee.reposiotry.NotesRepository
import com.squareup.okhttp.Dispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class NotesViewModel(application: Application): AndroidViewModel(application) {

   private  val repository:NotesRepository 
    val allNotes:LiveData<List<NotesModel>>
    val highToLow:LiveData<List<NotesModel>>
    val lowTohigh:LiveData<List<NotesModel>>

    init {
        val dao=NotesDatabase.notesDatabase(application).notesDao()
        repository= NotesRepository(dao)
        allNotes=repository.allNOtes
        highToLow=repository.highToLow
        lowTohigh=repository.lowToHigh
        
    }
     fun insertNote(notes: NotesModel)=viewModelScope.launch(Dispatchers.IO){
        repository.insertNotes(notes)
    }
  fun deleteNote(id:Int)=viewModelScope.launch(Dispatchers.IO){
        repository.deleteNotes(id)
    }
     fun updateNote(notes: NotesModel)=viewModelScope.launch(Dispatchers.IO){
        repository.updateNotes(notes)
    }



}