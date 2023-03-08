package com.example.onlineshop.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.databinding.ColorItemBinding

class ColorAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listColors: ArrayList<String> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = ColorItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MoreViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as ColorAdapter.MoreViewHolder
        val currentUser = listColors[position]
        itemViewHolder.bind(currentUser)
    }

    override fun getItemCount(): Int {
        return listColors.size
    }

    inner class MoreViewHolder(
        private val binding: ColorItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(color: String) {
            binding.color.setBackgroundColor(color.toColorInt())
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setMoreItems(items: List<String>) {
        listColors.clear()
        listColors.addAll(items)
        notifyDataSetChanged()
    }
}


