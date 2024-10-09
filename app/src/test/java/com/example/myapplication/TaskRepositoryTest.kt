import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.FakeTaskDao
import com.example.myapplication.model.Task
import com.example.myapplication.repository.TaskRepository
import com.example.myapplication.dao.TaskDao
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.*

class TaskRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var taskDao: FakeTaskDao
    private lateinit var taskRepository: TaskRepository

    @Before
    fun setUp() {
        taskDao = FakeTaskDao()
        taskRepository = TaskRepository(taskDao)
    }

    @Test
    fun addTask() = runBlocking {
        val task = Task(title = "New Task", description = "Description", dueDate = Date(), priority = 1)
        taskRepository.addTask(task)

        val tasks: LiveData<List<Task>> = taskRepository.allTasks
        tasks.observeForever { }

        assertEquals(1, tasks.value?.size)
        assertEquals("New Task", tasks.value?.get(0)?.title)
    }

    @Test
    fun updateTask() = runBlocking {
        val task = Task(title = "Task to Update", description = "Description", dueDate = Date(), priority = 1)
        taskRepository.addTask(task)

        val updatedTask = task.copy(title = "Updated Task")
        taskRepository.updateTask(updatedTask)

        val tasks: LiveData<List<Task>> = taskRepository.allTasks
        tasks.observeForever { }

        assertEquals("Updated Task", tasks.value?.get(0)?.title)
    }

    @Test
    fun deleteTask() = runBlocking {
        val task = Task(title = "Task to Delete", description = "Description", dueDate = Date(), priority = 1)
        taskRepository.addTask(task)

        taskRepository.deleteTask(task)

        val tasks: LiveData<List<Task>> = taskRepository.allTasks
        tasks.observeForever { }

        assertEquals(0, tasks.value?.size)
    }
}
