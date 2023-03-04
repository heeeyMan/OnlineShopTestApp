package com.example.testapp.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import com.example.testapp.R
import com.example.testapp.datamodels.items.LatestItem
import com.example.testapp.utils.OnItemClickedListener
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
        viewHolder.background_img.setImageDrawable(
            context.resources.getDrawable(
                data.imageId,
                null
            )
        )
        viewHolder.category_name.text = context.getString(data.category)
        viewHolder.item_name.text = data.itemName
        viewHolder.price.text = context.getString(R.string.price, data.price)
        viewHolder.latest_item.setOnClickListener{
            click.onItemClick(data.id)
        }
    }

    override fun getLayout() = R.layout.latest_item
}