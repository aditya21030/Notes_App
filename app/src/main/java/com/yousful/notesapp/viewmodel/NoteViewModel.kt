package com.yousful.notesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yousful.notesapp.repository.NotesRepository
import com.yousful.notesapp.roomdb.Note
import kotlinx.coroutines.launch

class NoteViewModel(private val repository: NotesRepository) : ViewModel () {

    val allNotes : LiveData<List<Note>> = repository.allNotes

    fun insert(note: Note) = viewModelScope.launch { repository.insertNote(note) }

    fun delete(note: Note) = viewModelScope.launch { repository.deleteNote(note) }

    fun update(note: Note) = viewModelScope.launch { repository.updateNote(note) }

}