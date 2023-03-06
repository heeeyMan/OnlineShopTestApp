package com.example.onlineshop.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import com.example.onlineshop.R
import com.example.onlineshop.datamodels.items.LatestItem
import com.example.onlineshop.utils.OnItemClickedListener
import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.latest_item.*

class LatestDataModel(
    private val context: Context,
    private val data: LatestItem,
    private val click: OnItemClickedListener
) : Item() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        Picasso.get().load(data.imageUrl).into(viewHolder.background_img)
        viewHolder.category_name.text = data.category
        viewHolder.item_name.text = data.name
        viewHolder.price.text = context.getString(R.string.price, data.price)

        viewHolder.latest_item.setOnClickListener {
            click.onItemClick(data.id)
        }
    }

    override fun getLayout() = R.layout.latest_item
}