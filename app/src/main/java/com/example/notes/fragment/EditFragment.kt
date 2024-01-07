package com.example.notes.fragment

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.notes.R
import com.example.notes.database.NotesEntity
import com.example.notes.databinding.FragmentEditBinding
import com.example.notes.viewModel.NotesViewModel
import java.util.Date


class EditFragment : Fragment() {
    val notes by navArgs<EditNotesFragmentByArgs>()
    lateinit var binding:FragmentEditBinding
    private val viewModel: NotesViewModel by viewModels()
    private var priority:String="1"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentEditBinding.inflate(layoutInflater,container,false)





        when (notes.data.priority) {
            "1" -> {
                priority = "1"
                binding.pGreen.setImageResource(R.drawable.done)
                binding.pRed.setImageResource (0)
                binding.pYellow.setImageResource (0)
            }

            "2" -> {
                priority = "2"
                binding.pRed.setImageResource(R.drawable.done)
                binding.pGreen.setImageResource(0)
                binding.pYellow.setImageResource(0)
            }

            "3" -> {
                priority="3"
                binding.pYellow.setImageResource(R.drawable.done)
                binding. pRed.setImageResource(0)
                binding.pGreen.setImageResource(0)


            }

        }

        binding.btnEditNotes.setOnClickListener {
            updateNotes(it)
        }






        return binding.root
    }
   private fun updateNotes(it:View){
        val mNotesTitle = binding.titleEditTv.text.toString()
        val mNotesDescription = binding.descriptionEditTv.text.toString()
        val mNotesSubtitle = binding.subtitleEditTv.text.toString()

        val d = Date()
        val date: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

        val notes = NotesEntity(null,mNotesTitle,mNotesDescription,date.toString(),priority)
        viewModel.editNotes(notes)

        Navigation.findNavController(it!!).navigate(R.id.action_createNoteFragment_to_homeFragment)
    }


}