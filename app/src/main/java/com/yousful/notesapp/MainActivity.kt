package com.yousful.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import com.yousful.notesapp.repository.NotesRepository
import com.yousful.notesapp.roomdb.NotesDB
import com.yousful.notesapp.screens.DisplayDialog
import com.yousful.notesapp.screens.DisplayNotesList
import com.yousful.notesapp.ui.theme.NotesAppTheme
import com.yousful.notesapp.viewmodel.NoteViewModel
import com.yousful.notesapp.viewmodel.NoteViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = NotesDB.getInstance(applicationContext)
        val repository = NotesRepository(database.notesDao)
        val viewModelFactory = NoteViewModelFactory(repository)
        val noteViewModel =
            ViewModelProvider(this, viewModelFactory)[NoteViewModel::class.java]

        setContent {
            NotesAppTheme {

                Scaffold(
                    floatingActionButton = {
                        MyFAB(viewModel = noteViewModel)
                    }
                ) { paddingValues ->

                    val notes by noteViewModel.allNotes.observeAsState(emptyList())

                    DisplayNotesList(
                        notes = notes,
                        viewModel = noteViewModel,
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }
}

@Composable
fun MyFAB(viewModel: NoteViewModel) {

    var showDialog by remember { mutableStateOf(false) }

    DisplayDialog(
        viewModel = viewModel,
        showDialog = showDialog,
        onDismiss = { showDialog = false }
    )

    FloatingActionButton(
        onClick = { showDialog = true },
        containerColor = Color.Blue,
        contentColor = Color.White
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add Note"
        )
    }
}
