package com.yousful.notesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yousful.notesapp.repository.NotesRepository

class NoteViewModelFactory(private val repository: NotesRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(NoteViewModel::class.java)){

            @Suppress
            return NoteViewModel(repository) as T

        }
        throw IllegalArgumentException("Unknown View Model Classs")

    }

}