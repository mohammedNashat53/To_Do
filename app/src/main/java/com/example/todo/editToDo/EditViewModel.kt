package com.example.todo.editToDo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo.db.ToDoDao
import com.example.todo.db.ToDoEntity
import kotlinx.coroutines.*

class EditViewModel(
    private val dataSource: ToDoDao,
    private val todoId: Long
) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    private val _onEdit = MutableLiveData<Boolean>()
    val onEdit: LiveData<Boolean>
        get() = _onEdit

    private val _hideBtSave = MutableLiveData<Boolean>()
    val hideBtSave: LiveData<Boolean>
        get() = _hideBtSave


    private val _currentToDo = MutableLiveData<ToDoEntity>()
    val currentToDo: LiveData<ToDoEntity>
        get() = _currentToDo

    private val _navigateToMainScreen = MutableLiveData<Boolean>()
    val navigateToMainScreen : LiveData <Boolean>
    get () = _navigateToMainScreen


    init {
        if (todoId > 0L) {
            initializeToDo()
            _hideBtSave.value = true
        }
    }

    private fun initializeToDo() {
        uiScope.launch {
            _currentToDo.value = getToDoFromDataBase()
        }
    }

    fun onEdit() {
        _onEdit.value = true
    }

    fun doneNavigating() {
        _navigateToMainScreen.value = false
    }

    fun onDelete() {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                _currentToDo.value?.let { dataSource.delete(it) }
            }
            _navigateToMainScreen.value = true
        }
    }

    private suspend fun getToDoFromDataBase(): ToDoEntity? {
        return withContext(Dispatchers.IO) {
            val todo = dataSource.get(todoId)
            todo
        }
    }

    fun getDetailesToEdit(title: String, priority: String) {
        if (todoId > 0) update(title, priority)
        else insert(title, priority)
    }

    private fun insert(title: String, priority: String) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                val todo = ToDoEntity()
                todo.title = title
                todo.priority = priority
                dataSource.insert(todo)
            }
            _navigateToMainScreen.value = true
        }
    }

    private fun update(title: String, priority: String) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                val oldToDo = _currentToDo.value ?: return@withContext
                oldToDo.title = title
                oldToDo.priority = priority
                dataSource.update(oldToDo)
            }
            _navigateToMainScreen.value = true

        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}