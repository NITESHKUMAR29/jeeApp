package com.example.jee.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.jee.entities.NotesModel


@Dao
interface NotesDao {

    @Query("SELECT * FROM Notes_Database")
  fun  getAllNotes(): LiveData<List<NotesModel>>

    @Query("SELECT * FROM Notes_Database ORDER BY notesPriority ASC")
    fun  highToLow(): LiveData<List<NotesModel>>

    @Query("SELECT * FROM Notes_Database ORDER BY notesPriority DESC")
    fun  lowToHigh(): LiveData<List<NotesModel>>
    @Insert
   fun insertNotes(notes: NotesModel)
    @Query("DELETE FROM Notes_Database WHERE id=:id")
    fun deleteNotes(id:Int)

    @Update
  fun updateNotes(notesUpdate: NotesModel)
}