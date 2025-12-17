# Notes-App
A modern Notes Application built using Jetpack Compose following MVVM architecture, designed to help users create, edit, organize, and manage notes efficiently with a clean and intuitive UI.

## 📸 Screenshots

<div style="display:flex; gap:10px; flex-wrap:wrap;">

<img src="https://github.com/user-attachments/assets/c193a2bb-c564-4b5d-9aaf-b1c0702c3c18" width="200"/>
<img src="https://github.com/user-attachments/assets/a743bbeb-2d88-46d8-81a1-85a4f69c83d5" width="200"/>
<img src="https://github.com/user-attachments/assets/94341899-db75-4b3b-bddf-a8a857a984f3" width="200"/>
<img src="https://github.com/user-attachments/assets/f7013eaa-c741-4fd0-878f-4afae4d06293" width="200"/>
<img src="https://github.com/user-attachments/assets/c9e725cb-d22d-4b35-8bc4-05824819b8df" width="200"/>

</div>


# 🚀 Features

✍️ Create Notes with title, description, and color selection

✏️ Edit Notes using the same dialog (no extra screen)

🗑️ Delete Notes with confirmation dialog (long press)

🎨 Color Picker for visually organizing notes

📱 Responsive UI using LazyVerticalStaggeredGrid

⚡ Real-time UI updates using LiveData & ViewModel

💾 Offline storage using Room Database

🧩 Material 3 Components for modern UI design

# 🛠️ Tech Stack

Language: Kotlin

UI: Jetpack Compose (Material 3)

Architecture: MVVM

Database: Room

State Management: LiveData

Asynchronous: Kotlin Coroutines

Dependency Injection: Manual (ViewModelFactory)

# 🧱 Architecture Overview

This project follows MVVM (Model–View–ViewModel) architecture:

Model: Room Entity & DAO (Note, NoteDao)

View: Jetpack Compose UI (DisplayNotesList, NoteListItem, DisplayDialog)

ViewModel: Handles business logic & state (NoteViewModel)

Repository: Acts as a single source of truth (NotesRepository)


# 🧠 Key Learnings

Implemented Jetpack Compose UI from scratch

Understood state management in Compose

Applied Room Database CRUD operations

Designed clean architecture using MVVM

Managed dialogs, long-press actions, and UI state effectively


