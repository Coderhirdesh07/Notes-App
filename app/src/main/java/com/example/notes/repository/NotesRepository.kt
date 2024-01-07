package com.example.notes.repository

import androidx.lifecycle.LiveData
import androidx.room.RoomDatabase
import com.example.notes.database.NotesDao
import com.example.notes.database.NotesEntity

class NotesRepository(private val dao: NotesDao) {

    fun getListOfNotes():LiveData<List<NotesEntity>>{
        return dao.getAllNotes()
    }

    suspend fun insertNote(notes:NotesEntity){
        dao.insertNotes(notes)
    }

    suspend fun deleteNote(id:Int){
        dao.deleteNotes(id)
    }

    suspend fun updateNotes(notes: NotesEntity){
        dao.updateNotes(notes)
    }


}