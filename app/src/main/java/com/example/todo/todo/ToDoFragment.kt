package com.example.todo.todo

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.isEmpty
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.todo.R
import com.example.todo.databinding.FragmentToDoBinding
import com.example.todo.db.ToDoDataBase


class ToDoFragment : Fragment() {
    lateinit var binding: FragmentToDoBinding
    private lateinit var viewModel: ToDoViewModel
    lateinit var adappter: ToDoAdappter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_to_do, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = ToDoDataBase.getInstance(application).dataDao
        val viewModelFactory = ToDoviewModelFactory(dataSource, application)
         viewModel = ViewModelProvider(this, viewModelFactory)[ToDoViewModel::class.java]



        viewModel.navigateToDetails.observe(viewLifecycleOwner, Observer { todoId ->
            todoId?.let {
            this.findNavController().navigate(ToDoFragmentDirections.actionToDoFragment2ToEditFragment3(todoId))
                viewModel.doneNavigating()
            }

        })

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

         adappter = ToDoAdappter(ToDoListener { todoId ->
            viewModel.onToDoClicked(todoId)
        })

        binding.rcToDoList.adapter = adappter

        viewModel.todoes.observe(viewLifecycleOwner, Observer {

            it?.let {
                adappter.submitList(it)
            }


        })

        return binding.root
    }

}