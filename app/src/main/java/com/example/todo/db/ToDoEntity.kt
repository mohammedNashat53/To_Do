package com.example.todo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "to_do_table")
data class ToDoEntity (
    @PrimaryKey(autoGenerate = true)
    val todoId: Long = 0L,

    @ColumnInfo(name = "title")
    var title: String = "Go To School",

    @ColumnInfo(name = "priority")
    var priority: String = "Important "
    )

