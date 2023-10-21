package com.main.myislamiapp.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.main.myislamiapp.databinding.ItemHadethTitleBinding
import com.main.myislamiapp.databinding.ItemVerseContentBinding

class HadethAdapter (val ahadeth: List<HadethModel>) : RecyclerView.Adapter<HadethAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemHadethTitleBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHadethTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = ahadeth[position]
        holder.binding.title.text = item.title
        holder.binding.title.setOnClickListener {
        onItemClick?.let {
            it.onHadethclick(position, item)
        }
    }
    }
var onItemClick:OnHadethClickListener?=null
    override fun getItemCount(): Int =ahadeth.size
interface OnHadethClickListener{
    fun onHadethclick(position: Int,item:HadethModel)
}
}