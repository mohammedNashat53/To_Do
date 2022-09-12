package com.example.todo.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.ItemViewBinding
import com.example.todo.db.ToDoEntity

class ToDoAdappter(val clickListener: ToDoListener) :
    ListAdapter<ToDoEntity, ToDoAdappter.ToDoViewHolder>(ToDoDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item,clickListener)
    }


    class ToDoViewHolder private constructor(val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: ToDoEntity,
            clickListener: ToDoListener
        ) {
            binding.todo = item
            binding.clicklistener = clickListener
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): ToDoViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemViewBinding.inflate(layoutInflater, parent, false)

                return ToDoViewHolder(binding)
            }
        }
    }
}

class ToDoDiffUtil() : DiffUtil.ItemCallback<ToDoEntity>() {
    override fun areItemsTheSame(oldItem: ToDoEntity, newItem: ToDoEntity): Boolean {
        return oldItem.todoId == oldItem.todoId
    }

    override fun areContentsTheSame(oldItem: ToDoEntity, newItem: ToDoEntity): Boolean {
        return oldItem == oldItem
    }

}


class ToDoListener(val clickListener: (todoId: Long) -> Unit) {
    fun onClick(todo: ToDoEntity) = clickListener(todo.todoId)
}