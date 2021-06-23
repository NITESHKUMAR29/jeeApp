package com.example.jee.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jee.daos.NotesDao
import com.example.jee.entities.NotesModel


@Database(entities = [NotesModel::class],version = 1)
abstract  class NotesDatabase:RoomDatabase() {

    abstract fun notesDao(): NotesDao

    companion object {
        @Volatile
        private var INSTANCE: NotesDatabase? = null
        fun notesDatabase(context: Context): NotesDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {

                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NotesDatabase::class.java,
                        "Notes_Database"
                    ).build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }


//
//    companion object {
//
//        @Volatile
//        private var INSTANCE: NotesDatabase? = null
//
//        fun notesDatabase(context: Context): NotesDatabase {
//            synchronized(this) {
//                var instance = INSTANCE
//
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        NotesDatabase::class.java,
//                        "Notes_Database"
//                    )
//
//                        .build()
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
//    }
}



