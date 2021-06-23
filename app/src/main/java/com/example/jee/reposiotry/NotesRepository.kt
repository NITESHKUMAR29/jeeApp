package com.example.jee.reposiotry

import androidx.lifecycle.LiveData
import com.example.jee.daos.NotesDao
import com.example.jee.entities.NotesModel

class NotesRepository(private val noteDao: NotesDao){

    val allNOtes:LiveData<List<NotesModel>> =noteDao.getAllNotes()
    val highToLow:LiveData<List<NotesModel>> =noteDao.highToLow()
    val lowToHigh:LiveData<List<NotesModel>> =noteDao.lowToHigh()
     suspend fun insertNotes(notes: NotesModel){
        noteDao.insertNotes(notes)
    }
    suspend fun deleteNotes(id: Int){
        noteDao.deleteNotes(id)

    }
     suspend fun updateNotes(notes: NotesModel){
        noteDao.updateNotes(notes)
    }
}