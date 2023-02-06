package com.example.composetutorial.stateCodelab.viewModel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.composetutorial.SampleData.WellnessTask

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()

    fun getTasks() = _tasks

    fun removeTask(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
