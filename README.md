A modern Notes Application built using Jetpack Compose following MVVM architecture, designed to help users create, edit, organize, and manage notes efficiently with a clean and intuitive UI.

## 📸 Screenshots

<p align="center">
  <img src="https://github.com/user-attachments/assets/49e271c7-8755-4e31-bec8-457d8f05bd7d" width="250"/>
  <img src="https://github.com/user-attachments/assets/b19743b3-1bad-43ce-abb8-c2177124bac9" width="250"/>
  <img src="https://github.com/user-attachments/assets/efed8033-81ed-403e-aadd-9b9e4a7fed11" width="250"/>
  <img src="https://github.com/user-attachments/assets/7bb61640-957b-47d8-8890-66f2205b2cea" width="250"/>
  <img src="https://github.com/user-attachments/assets/68c35d5d-b091-4f56-a046-c10c5e045251" width="250"/>
</p>



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


