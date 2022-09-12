package com.example.todo.editToDo

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todo.db.ToDoDao
import com.example.todo.todo.ToDoViewModel

class EditViewModelFactory (
    private val dataSource: ToDoDao,
    private val todoId : Long

): ViewModelProvider.Factory{
        @Suppress("unchecked_cast")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(EditViewModel::class.java)) {
                return EditViewModel(dataSource,todoId) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }