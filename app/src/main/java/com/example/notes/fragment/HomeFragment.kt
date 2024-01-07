package com.example.notes.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notes.R
import com.example.notes.adapters.NotesAdapter
import com.example.notes.databinding.FragmentHomeBinding
import com.example.notes.viewModel.NotesViewModel


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
     private val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)

//        viewModel.getNotes().observe(viewLifecycleOwner,{notesList->
//            binding.recyclerViewAllNotes.layoutManager = GridLayoutManager(this,2)
//            binding.recyclerViewAllNotes.adapter=NotesAdapter(requireContext(),notesList)
//
//        })



        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNoteFragment)
        }

        return binding.root
    }


}