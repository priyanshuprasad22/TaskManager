package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.TaskAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewmodel.TaskViewModel
import com.example.myapplication.model.Task

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val taskViewModel: TaskViewModel by viewModels()
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        setContentView(binding.root)


        taskAdapter = TaskAdapter(mutableListOf(),taskViewModel) { task -> onTaskClicked(task) }
        binding.recyclerViewTasks.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = taskAdapter
        }


        taskViewModel.allTasks.observe(this) { tasks ->
            taskAdapter.updateTasks(tasks)
        }


        binding.fabAddTask.setOnClickListener {
            val intent = Intent(this, AddEditTaskActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onTaskClicked(task: Task) {
        
        val intent = Intent(this, AddEditTaskActivity::class.java)
        intent.putExtra("task", task)
        startActivity(intent)
    }
}
