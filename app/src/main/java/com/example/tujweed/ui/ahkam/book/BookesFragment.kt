package com.example.tujweed.ui.ahkam.book

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tujweed.databinding.FragmentBookesBinding

class BookesFragment : Fragment() {
    lateinit var binding: FragmentBookesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookesBinding.inflate(inflater,container,false)
        binding.idPDFView.fromAsset("tujweed_book2.pdf").load()
        return binding.root
    }

}