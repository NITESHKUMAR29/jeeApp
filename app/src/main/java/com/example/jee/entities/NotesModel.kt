package com.example.jee.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Notes_Database")
data class NotesModel(
    @PrimaryKey(autoGenerate = true)

    var id: Int,
    @ColumnInfo(name = "notesTitle")
    var notesTitle: String,
    @ColumnInfo(name = "notesSubtitle")

    var notesSubtitle: String,
    @ColumnInfo(name = "notesDate")
    var notesDate: String,
    @ColumnInfo(name = "notes")
    var notes: String,
    @ColumnInfo(name = "notesPriority")
    var notesPriority: String


)



