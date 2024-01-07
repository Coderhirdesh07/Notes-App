package com.example.notes.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.database.NotesEntity
import com.example.notes.databinding.ItemNotesBinding
import com.example.notes.fragment.HomeFragment

class NotesAdapter(private val context: Context,private val notesList:List<NotesEntity>):RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    class NotesViewHolder(val binding: ItemNotesBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(ItemNotesBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val data = notesList[position]
        holder.binding.notesTitleTV.text = data.title
        holder.binding.notesSubtitleTV.text = data.description
        holder.binding.notesDateTv.text = data.date

        when (data.priorityQueue) {
            "1"-> {
              holder.binding.viewPriority.setBackgroundResource(R.drawable.redcircle)
            }
            "2"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.custom_shapes)
            }
            "3"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.yellowcircle)

            }
        }
//        holder.binding.root.setOnClickListener {
//            val action = HomeFragmentDirections.actionHomeFragmentToEditNotesFragment(data)
//            Navigation.findNavController(it).navigate(action)
//        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

}