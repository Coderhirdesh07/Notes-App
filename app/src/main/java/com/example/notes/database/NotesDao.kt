package com.example.notes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertNotes(notes:NotesEntity)


    @Query("DELETE FROM notesDb WHERE id=:id")
    suspend fun deleteNotes(id:Int)

    @Query("Select * from notesDb")
    fun getAllNotes() : LiveData<List<NotesEntity>>

    @Update
    suspend fun updateNotes(notes: NotesEntity)

}