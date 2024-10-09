package com.example.myapplication.dao


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.model.Task


@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM task_table ORDER BY dueDate ASC")
    fun getAllTasks(): LiveData<List<Task>>
}
