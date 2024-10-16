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
- **Room Database**: Utilizes Room, a robust persistence library that provides an abstraction layer over SQLite, ensuring smooth and efficient data handling. Room simplifies database operations, manages database versioning, and integrates seamlessly with LiveData and ViewModel for reactive programming.

- **Data Access Object (DAO)**: Defines the methods for accessing and manipulating task data within the Room database. DAOs are responsible for managing database operations, ensuring that data interactions are performed asynchronously to maintain UI responsiveness. They provide a clean API for performing operations such as inserting, updating, deleting, and querying tasks.

- **Repository Pattern**: The repository acts as a mediator between the data sources (Room database, network, etc.) and the ViewModel. It encapsulates data operations, ensuring a single source of truth for the data. The repository abstracts the complexities of data management, allowing the ViewModel to focus solely on preparing data for the UI.

## Task Structure

The `Task` entity represents a task in the application and includes the following fields:

- **id**: A unique identifier for each task, which is automatically generated by the database.
- **title**: A brief title for the task, providing a summary of what needs to be done.
- **description**: A more detailed explanation of the task, outlining the specifics or requirements.
- **dueDate**: The date by which the task should be completed, helping users prioritize their workload.
- **status**: The current state of the task, which can indicate whether the task is "Not Completed." or "Completed."
- **priority**: An integer representing the task's priority level, with possible values:
  - **0**: Low priority
  - **1**: Medium priority
  - **2**: High priority



## Architecture
- **MVVM (Model-View-ViewModel)**: The app adheres to the MVVM architecture pattern, which promotes separation of concerns and enhances scalability. In this architecture:
  - **Model**: Represents the data and business logic. It communicates with the Room database through the DAO.
  - **View**: Represents the UI components that display data to the user. It observes data changes through LiveData, ensuring the UI is always updated with the latest data.
  - **ViewModel**: Acts as a bridge between the Model and the View, managing UI-related data and handling user interactions. The ViewModel retrieves data from the repository and prepares it for display, ensuring that the View remains decoupled from the data source.



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

