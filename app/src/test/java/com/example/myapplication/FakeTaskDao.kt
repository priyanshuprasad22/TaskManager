package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.dao.TaskDao
import com.example.myapplication.model.Task

class FakeTaskDao : TaskDao {
    private val tasks = mutableListOf<Task>()

    override suspend fun addTask(task: Task) {
        tasks.add(task)
    }

    override suspend fun updateTask(task: Task) {
        val index = tasks.indexOfFirst { it.id == task.id }
        if (index != -1) {
            tasks[index] = task
        }
    }

    override suspend fun deleteTask(task: Task) {
        tasks.remove(task)
    }

    override fun getAllTasks(): LiveData<List<Task>> {
        return MutableLiveData(tasks)
    }
}
