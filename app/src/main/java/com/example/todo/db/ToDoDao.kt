package com.example.todo.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ToDoDao {

    @Insert
    fun insert(entity: ToDoEntity)

    @Update
    fun update(entity: ToDoEntity)

    @Query("DELETE from to_do_table")
    fun clear()

    @Delete
    fun delete(entity: ToDoEntity)

    @Query("SELECT * FROM to_do_table WHERE todoId = :key ")
    fun get(key: Long): ToDoEntity?

    @Query("SELECT * FROM to_do_table ORDER By todoId DESC ")
    fun getAllToDo(): LiveData<List<ToDoEntity>>

    @Query("SELECT * FROM to_do_table ORDER BY todoId DESC LIMIT 1")
    fun getToDo(): ToDoEntity?
}