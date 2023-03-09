package com.example.onlineshop.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.databinding.HintItemBinding

class HintsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var hintsList: ArrayList<String> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = HintItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HintViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as HintsAdapter.HintViewHolder
        val hint = hintsList[position]
        itemViewHolder.bind(hint)
    }

    override fun getItemCount() = hintsList.size

    inner class HintViewHolder(
        private val binding: HintItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hint: String) {
            binding.hint.text = hint
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setMoreItems(items: List<String>) {
        hintsList.clear()
        hintsList.addAll(items)
        notifyDataSetChanged()
    }
}


