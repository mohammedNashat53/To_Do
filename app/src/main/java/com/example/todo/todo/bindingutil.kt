package com.example.todo.todo

import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.todo.R
import com.example.todo.db.ToDoEntity


@BindingAdapter("todoTitel")
fun TextView.setTitle(item: ToDoEntity?) {
    item?.let {
        text = item.title
    }
}

@BindingAdapter("todoPriority")
fun TextView.setPriority(item: ToDoEntity?) {
    item?.let {
        text =item.priority
    }
}

