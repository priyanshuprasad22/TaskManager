package com.example.myapplication

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityAddEditTaskBinding
import com.example.myapplication.model.Task
import com.example.myapplication.viewmodel.TaskViewModel
import java.text.SimpleDateFormat
import java.util.*

class AddEditTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddEditTaskBinding
    private val taskViewModel: TaskViewModel by viewModels()


    private val priorities = listOf("Low", "Medium", "High")


    private var selectedPriority: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val prioritySpinner = binding.spinnerPriority


        val priorityAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            priorities
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }


        prioritySpinner.adapter = priorityAdapter


        prioritySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View, position: Int, id: Long) {
                selectedPriority = when (priorities[position]) {
                    "Low" -> 1
                    "Medium" -> 2
                    "High" -> 3
                    else -> 1
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        val task = intent.getParcelableExtra<Task>("task")

        task?.let {
            binding.editTextTitle.setText(it.title)
            binding.editTextDescription.setText(it.description)
            binding.editTextDueDate.setText(SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(it.dueDate))


            prioritySpinner.setSelection(priorities.indexOfFirst { it == task.priority.toString() })
        }

        binding.editTextDueDate.setOnClickListener{
            val calendar = Calendar.getInstance()
            val year= calendar.get(Calendar.YEAR)
            val month=calendar.get(Calendar.MONTH)
            val day=calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                {_,selectedYear,selectedMonth, selectedDay->
                    val formattedDate= "$selectedYear-${String.format("%02d",selectedMonth+1)}-${String.format("%02d",selectedDay)}"
                    binding.editTextDueDate.setText(formattedDate)
                },
                year,
                month,
                day
            )

            datePickerDialog.show();

        }


        binding.buttonSaveTask.setOnClickListener {
            val title = binding.editTextTitle.text.toString()
            val description = binding.editTextDescription.text.toString()
            val dueDateString = binding.editTextDueDate.text.toString()

            val dueDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(dueDateString) ?: Date()

            val newTask = Task(
                title = title,
                description = description,
                dueDate = dueDate,
                priority = selectedPriority
            )

            if (task == null) {
                taskViewModel.addTask(newTask)
            } else {
                newTask.id = task.id
                taskViewModel.updateTask(newTask)
            }

            finish()
        }
    }
}
