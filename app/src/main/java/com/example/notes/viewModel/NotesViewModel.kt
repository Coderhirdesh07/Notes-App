package com.example.notes.viewModel

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.database.NotesDataBase
import com.example.notes.database.NotesEntity
import com.example.notes.repository.NotesRepository
import kotlinx.coroutines.launch

class NotesViewModel(application: Application):AndroidViewModel(application) {

    private val mNotesRepository :NotesRepository
    init {
        val mDao = NotesDataBase.getDatabaseInstance(application).notesDao()
        mNotesRepository = NotesRepository(mDao)
    }


    fun addNotes(notes:NotesEntity) = viewModelScope.launch {
        mNotesRepository.insertNote(notes)
    }


    fun removeNotes(id:Int) = viewModelScope.launch {
        mNotesRepository.deleteNote(id)
    }


    fun editNotes(notes: NotesEntity)=viewModelScope.launch {
        mNotesRepository.updateNotes(notes)
    }


    fun getNotes():LiveData<List<NotesEntity>>{
        return mNotesRepository.getListOfNotes()
    }
}