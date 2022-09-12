package com.example.todo.editToDo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.todo.R
import com.example.todo.databinding.FragmentEditBinding
import com.example.todo.db.ToDoDataBase


class EditFragment : Fragment() {
    lateinit var binding: FragmentEditBinding
    lateinit var priority: String
    lateinit var title: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit, container, false)

        val arguments = EditFragmentArgs.fromBundle(requireArguments())

        val application = requireNotNull(this.activity).application

        val datasource = ToDoDataBase.getInstance(application).dataDao

        val viewModelFactory = EditViewModelFactory(datasource, arguments.todoId)

        val viewModel = ViewModelProvider(this, viewModelFactory).get(EditViewModel::class.java)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        viewModel.currentToDo.observe(viewLifecycleOwner, Observer { todo ->
            binding.edTitle.setText(todo?.title)
            binding.edPriority.setText(todo?.priority)
        })

        viewModel.navigateToMainScreen.observe(viewLifecycleOwner, Observer {
            if (it){
                findNavController().navigate(EditFragmentDirections.actionEditFragment3ToToDoFragment2())
            }
        })

        viewModel.hideBtSave.observe(viewLifecycleOwner, Observer {
         if (it){
             binding.btSave.visibility = View.GONE
             binding.btDelete.visibility = View.VISIBLE
             binding.btUpdat.visibility = View.VISIBLE
         }
        })

        viewModel.onEdit.observe(viewLifecycleOwner, Observer {

            if (it) {
                getDetailes()
                if (title.isEmpty() || priority.isEmpty()){
                  Toast.makeText(context,"Set all Details",Toast.LENGTH_SHORT).show()
                }else {
                    viewModel.getDetailesToEdit(title, priority)
                }
            }
        })


        return binding.root
    }


    private fun getDetailes() {
        title = binding.edTitle.text.toString()
        priority = binding.edPriority.text.toString()
    }

}