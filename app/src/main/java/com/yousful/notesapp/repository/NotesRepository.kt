package com.yousful.notesapp.repository

import androidx.lifecycle.LiveData
import com.yousful.notesapp.roomdb.Note
import com.yousful.notesapp.roomdb.NoteDao

class NotesRepository(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insertNote(note: Note) {
        noteDao.insert(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.delete(note)
    }

    suspend fun updateNote(note: Note){
        noteDao.update(note)
    }


}
