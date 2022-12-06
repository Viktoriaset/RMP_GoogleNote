package com.example.rmp_googlenote.Note

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rmp_googlenote.R
import com.example.rmp_googlenote.databinding.NoteItemBinding

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.PlantHolder>() {

    var noteList = ArrayList<NoteData>()

    class PlantHolder (item : View) : RecyclerView.ViewHolder(item){

        val binding = NoteItemBinding.bind(item)

        fun bind(note: NoteData) = with(binding){
            header.text = note.header
            body.text = note.body
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addNote(note: NoteData){
        noteList.add(note)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return PlantHolder(view)
    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(noteList[position])
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}