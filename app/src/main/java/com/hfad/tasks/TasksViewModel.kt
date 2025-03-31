
package com.hfad.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TasksViewModel(private val dao: TaskDao) : ViewModel() {
    var newTaskName = ""

    val tasks: LiveData<List<Task>> = dao.getAll()

    fun addTask() {
        viewModelScope.launch {
            val task = Task(taskName = newTaskName)
            dao.insert(task)
        }
    }
}