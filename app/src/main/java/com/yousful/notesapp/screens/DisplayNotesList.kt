package com.yousful.notesapp.screens

import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yousful.notesapp.roomdb.Note
import com.yousful.notesapp.viewmodel.NoteViewModel

@Composable
fun DisplayNotesList(
    notes: List<Note>,
    viewModel: NoteViewModel,
    modifier: Modifier = Modifier
) {

    var showDeleteDialog by remember { mutableStateOf(false) }
    var showEditDialog by remember { mutableStateOf(false) }

    var selectedNote by remember { mutableStateOf<Note?>(null) }

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {

        items(notes) { note ->

            NoteListItem(
                note = note,
                modifier = Modifier.combinedClickable(

                    // ✏️ SINGLE TAP → EDIT
                    onClick = {
                        selectedNote = note
                        showEditDialog = true
                    },

                    // 🗑️ LONG PRESS → DELETE
                    onLongClick = {
                        selectedNote = note
                        showDeleteDialog = true
                    }
                )
            )
        }
    }

    // 🔴 DELETE CONFIRMATION DIALOG
    if (showDeleteDialog && selectedNote != null) {

        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },

            title = { Text("Delete Note") },

            text = { Text("Are you sure you want to delete this note?") },

            confirmButton = {
                Button(onClick = {
                    viewModel.delete(selectedNote!!)
                    showDeleteDialog = false
                }) {
                    Text("Delete")
                }
            },

            dismissButton = {
                Button(onClick = { showDeleteDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // ✏️ EDIT NOTE DIALOG (REUSE SAME DIALOG)
    DisplayDialog(
        viewModel = viewModel,
        showDialog = showEditDialog,
        noteToEdit = selectedNote,
        onDismiss = {
            showEditDialog = false
            selectedNote = null
        }
    )
}
