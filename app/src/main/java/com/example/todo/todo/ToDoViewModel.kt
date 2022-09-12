package com.example.todo.todo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.todo.db.ToDoDao
import com.example.todo.db.ToDoEntity
import kotlinx.coroutines.*

class ToDoViewModel(
    val dataSource: ToDoDao,
    application: Application
) : AndroidViewModel(application) {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    private val _navigateToDetails = MutableLiveData<Long?>()
    val navigateToDetails : LiveData<Long?>
        get() = _navigateToDetails


     val currentToDo = MutableLiveData<ToDoEntity?>()
     val todoes = dataSource.getAllToDo()

    init {
        initialixzeToDo()

    }


    private  fun initialixzeToDo() {
        uiScope.launch {
            currentToDo.value = getToDoFromDataBase()
        }

    }


    private suspend fun getToDoFromDataBase(): ToDoEntity? {
     return withContext(Dispatchers.IO){
         val todo = dataSource.getToDo()
         todo
     }
    }

    fun onToDoClicked(id: Long ){
        _navigateToDetails.value = id
    }

    fun doneNavigating() {
        _navigateToDetails.value = null
    }

    fun onClear(){
        uiScope.launch {
            withContext(Dispatchers.IO){
                dataSource.clear()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}