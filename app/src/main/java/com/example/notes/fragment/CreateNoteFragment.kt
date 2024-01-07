package com.example.notes.fragment

import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.notes.R
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.notes.database.NotesEntity
import com.example.notes.databinding.FragmentCreateNoteBinding
import com.example.notes.viewModel.NotesViewModel
import java.util.Date


class CreateNoteFragment : Fragment() {

private lateinit var binding: FragmentCreateNoteBinding
   private var priority:String="1"
    private val viewModel: NotesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateNoteBinding.inflate(layoutInflater,container,false)


         binding.btnSaveNotes.setOnClickListener{
             createNotes(it)
         }
        binding.pGreen.setOnClickListener {
            priority = "1"
             binding.pGreen.setImageResource(R.drawable.done)
            binding.pRed.setImageResource (0)
            binding.pYellow.setImageResource (0)
        }
        binding.pRed.setOnClickListener {
            priority = "2"
            binding.pRed.setImageResource(R.drawable.done)
            binding.pGreen.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }
        binding.pYellow.setOnClickListener {
            priority = "3"
            binding.pYellow.setImageResource(R.drawable.done)
            binding. pRed.setImageResource(0)
            binding.pGreen.setImageResource(0)
        }


        return binding.root

    }
    private fun createNotes(it:View){
        val mNotesTitle = binding.titleEditTv.text.toString()
        val mNotesDescription = binding.descriptionEditTv.text.toString()
        val mNotesSubtitle = binding.subtitleEditTv.text.toString()

        val d = Date()
        val date: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

        val notes = NotesEntity(null,mNotesTitle,mNotesDescription,date.toString(),priority)
        viewModel.addNotes(notes)

        Navigation.findNavController(it!!).navigate(R.id.action_createNoteFragment_to_homeFragment)
    }


}