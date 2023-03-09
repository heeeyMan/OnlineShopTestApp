package com.example.onlineshop.ui.adapters

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.databinding.SmallImageItemBinding
import com.example.onlineshop.utils.OnSmallImageClickedListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.latest_item.*

class ImageAdapter(
    private val click: OnSmallImageClickedListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var imagesList: ArrayList<String> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = SmallImageItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ImageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as ImageAdapter.ImageViewHolder
        val image = imagesList[position]
        itemViewHolder.bind(image)
    }

    override fun getItemCount() = imagesList.size

    inner class ImageViewHolder(
        private val binding: SmallImageItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(imageUri: String) {
            val uri = Uri.parse(imageUri)
            binding.image.apply {
                Picasso.get().load(imageUri).into(this)
                setOnClickListener {
                    click.onItemClick(uri)
                }
            }

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setMoreItems(items: List<String>) {
        imagesList.clear()
        imagesList.addAll(items)
        notifyDataSetChanged()
    }
}


