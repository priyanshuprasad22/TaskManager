package com.example.myapplication.adapter

import com.example.myapplication.model.Task
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.viewmodel.TaskViewModel
import java.text.SimpleDateFormat
import java.util.*

class TaskAdapter(
    private val taskList: MutableList<Task>,
    private val taskViewModel: TaskViewModel,
    private val onTaskClick: (Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val taskTitle: TextView = view.findViewById(R.id.taskTitle)
        val taskDescription: TextView = view.findViewById(R.id.taskDescription)
        val taskComplete: CheckBox = view.findViewById(R.id.taskComplete)
        val taskDate:TextView = view.findViewById(R.id.taskDate)
        val taskPriority:TextView = view.findViewById(R.id.priority)
        val deleteIcon:ImageView = view.findViewById(R.id.deleteIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_layout, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]


        holder.taskTitle.text = task.title
        holder.taskDescription.text = task.description
        holder.taskComplete.isChecked = task.isCompleted
        holder.taskDate.text= SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(task.dueDate)
        holder.taskPriority.text = when(task.priority){
            1->"Priority: Low"
            2->"Priority: Medium"
            3->"Priority: High"
            else->"Priority: Low"
        }
        holder.deleteIcon.setOnClickListener{
            removeTask(task)
            taskViewModel.deleteTask(task)
        }


        holder.itemView.setOnClickListener {
            onTaskClick(task)
        }

        holder.taskComplete.setOnCheckedChangeListener { _, isChecked ->
            task.isCompleted = isChecked
            taskViewModel.updateTask(task);
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun addTask(task: Task) {
        taskList.add(task)
        notifyItemInserted(taskList.size - 1)
    }

    fun removeTask(task: Task) {
        val index = taskList.indexOf(task)
        if (index != -1) {
            taskList.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    fun updateTasks(newTasks: List<Task>) {
        taskList.clear()
        taskList.addAll(newTasks)
        notifyDataSetChanged()
    }
}
