package com.main.myislamiapp.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.main.myislamiapp.databinding.ItemVersesBinding

class QuranAdapter(val list: ArrayList<VersesModel>) : RecyclerView.Adapter<QuranAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemVersesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVersesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item=list[position]
        holder.binding.content.text=item.verseName
        holder.binding.ayaNum.text=item.verseNum
        holder.itemView.setOnClickListener {
onItemClickListener?.let {
    it.onItemClick(position,list[position])
}
        }
    }
    override fun getItemCount(): Int = list.size

    //بعمل كدا علشان لو مدوستش
    var onItemClickListener: OnItemClickListener? =null

    interface OnItemClickListener{
        fun onItemClick(pos:Int,item:VersesModel)
    }
}
