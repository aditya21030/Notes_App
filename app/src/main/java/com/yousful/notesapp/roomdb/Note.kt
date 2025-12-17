package com.yousful.notesapp.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val title : String,
    val description : String,
    val color : Int
)
