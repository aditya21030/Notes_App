package com.yousful.notesapp.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.yousful.notesapp.roomdb.Note
import com.yousful.notesapp.viewmodel.NoteViewModel

@Composable
fun DisplayDialog(
    viewModel: NoteViewModel,
    showDialog: Boolean,
    onDismiss: () -> Unit,
    noteToEdit: Note? = null
) {

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var selectedColor by remember { mutableStateOf(Color.Blue) }

    // 🔑 RESET / PREFILL LOGIC
    LaunchedEffect(noteToEdit, showDialog) {
        if (noteToEdit != null) {
            // ✏️ Editing existing note
            title = noteToEdit.title
            description = noteToEdit.description
            selectedColor = Color(noteToEdit.color)
        } else {
            // ➕ Creating new note
            title = ""
            description = ""
            selectedColor = Color.Blue
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,

            title = {
                Text(text = if (noteToEdit == null) "Add Note" else "Edit Note")
            },

            text = {
                Column {

                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Note Title") }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text("Note Description") }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    MyColorPicker(
                        selectedColor = selectedColor,
                        onColorSelected = { selectedColor = it }
                    )
                }
            },

            confirmButton = {
                Button(
                    onClick = {
                        val note = Note(
                            id = noteToEdit?.id ?: 0,
                            title = title,
                            description = description,
                            color = selectedColor.toArgb()
                        )

                        if (noteToEdit == null) {
                            viewModel.insert(note)
                        } else {
                            viewModel.update(note)
                        }

                        onDismiss()
                    }
                ) {
                    Text(text = if (noteToEdit == null) "Save" else "Update")
                }
            },

            dismissButton = {
                Button(onClick = onDismiss) {
                    Text("Cancel")
                }
            }
        )
    }
}

