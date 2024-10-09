# Task Manager Application

This is an Android Task Manager Application built using **Kotlin** that allows users to manage their tasks effectively. It leverages the **Room Database** for local data storage and supports full CRUD (Create, Read, Update, Delete) operations for tasks.

## Features

- **Add Tasks:** Users can create new tasks with fields such as title, description, and due date.
- **View Tasks:** Display a list of all tasks stored in the Room database.
- **Update Tasks:** Modify task details, such as the task name, description, and status.
- **Delete Tasks:** Remove tasks that are no longer required.
- **Task Status:** Users can update the status of tasks.
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
2. **Open the project** in **Android Studio**:
    - Launch Android Studio and select **Open an existing project**.
    - Navigate to the directory where you cloned the project and select it.

3. **Sync the project** to install dependencies:
    - After opening the project, Android Studio will prompt you to sync the project. Make sure to sync to install all dependencies.

4. **Run the app**:
    - Connect your Android device or start an emulator.
    - Click on the **Run** button in Android Studio or use the shortcut `Shift + F10`.

## Screenshots
![ea41c98b-635a-47fa-b8bd-ef4b9763bb72](https://github.com/user-attachments/assets/ccfcf904-db23-40b4-9456-a385a836331d)
![a673254a-6cca-43f2-a96c-fca9373081d4](https://github.com/user-attachments/assets/06c29afe-c334-4290-9f09-5e50807d6a73)
![fbffc18c-cdc7-49f9-930a-6374f59c0e0d](https://github.com/user-attachments/assets/45229648-17d5-48da-9eb9-ce7b1451a35a)
![2b85090e-671c-4d51-aacb-8584c0773478](https://github.com/user-attachments/assets/276c2b27-5a87-4036-8540-0fdd2a7a1826)
![0836e617-296d-40c2-b603-c47e3ca950a4](https://github.com/user-attachments/assets/7d01586e-d93a-4f3f-a14d-1549cfda89dc)

