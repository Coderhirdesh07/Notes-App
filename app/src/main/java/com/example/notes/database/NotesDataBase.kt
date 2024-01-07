package com.example.notes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NotesEntity::class], version = 1)
abstract class NotesDataBase:RoomDatabase() {

    abstract fun notesDao():NotesDao

    companion object{
        @Volatile
        var INSTANCE :NotesDataBase?=null

        fun getDatabaseInstance(context: Context):NotesDataBase{
            val mTempInstance=INSTANCE
            if(mTempInstance!=null){
                return mTempInstance
            }
            synchronized(this){
                val roomDatabaseInstance= Room.databaseBuilder(context,NotesDataBase::class.java,"notesDb").build()

                INSTANCE = roomDatabaseInstance
                return roomDatabaseInstance
            }
        }
    }

}