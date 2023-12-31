package com.main.myislamiapp.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.main.myislamiapp.databinding.ItemVerseContentBinding

class VersesAdapter (val verses: List<String>) : RecyclerView.Adapter<VersesAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemVerseContentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVerseContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.title.text=verses[position]
    }

    override fun getItemCount(): Int =verses.size

}