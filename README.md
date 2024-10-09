# Task Manager Application

This is an Android Task Manager Application built using **Kotlin** that allows users to manage their tasks effectively. It leverages the **Room Database** for local data storage and supports full CRUD (Create, Read, Update, Delete) operations for tasks.

## Features

- **Add Tasks:** Users can create new tasks with fields such as title, description, and due date.
- **View Tasks:** Display a list of all tasks stored in the Room database.
- **Update Tasks:** Modify task details, such as the task name, description, and status.
- **Delete Tasks:** Remove tasks that are no longer required.
- **Task Status:** Users can update the status of tasks (e.g., pending, in-progress, or completed).
- **Data Persistance** Since it uses Room Database, tasks are available even without internet access.
- **Simple UI:** User-friendly interface with a focus on task management efficiency.

## Tech Stack

### Frontend (UI)
- **Kotlin:** The language used for building the Android application.
- **XML:** Used for defining the layout of the application.

### Backend (Local Storage)
- **Room Database:** For local persistence of tasks. It allows smooth and efficient data handling with an SQLite-based database.
- **LiveData & ViewModel:** For observing changes in the task data and ensuring that the UI stays up-to-date with the database.

### Architecture
- **MVVM (Model-View-ViewModel):** The app follows the MVVM architecture pattern to ensure separation of concerns and scalability.

## Setup & Installation

1. **Clone the repository:**
   ```bash
   https://github.com/priyanshuprasad22/TaskManager
