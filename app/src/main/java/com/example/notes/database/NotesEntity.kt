package com.example.notes.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.PriorityQueue

@Entity(tableName = "notesDb")
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    var title:String,
    var description:String,
    var date:String,
    var priorityQueue:String
)
