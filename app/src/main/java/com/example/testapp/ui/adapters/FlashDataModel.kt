package com.example.testapp.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import com.example.testapp.R
import com.example.testapp.datamodels.items.FlashItem
import com.example.testapp.utils.OnItemClickedListener
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.flash_sale_item.*
import kotlinx.android.synthetic.main.flash_sale_item.background_img
import kotlinx.android.synthetic.main.flash_sale_item.category_name
import kotlinx.android.synthetic.main.flash_sale_item.item_name
import kotlinx.android.synthetic.main.flash_sale_item.price

class FlashDataModel(
    private val context: Context,
    private val data: FlashItem,
    private val click: OnItemClickedListener
) : Item() {
    @SuppressLint("UseCompatLoadingForDrawables", "StringFormatMatches")
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
        viewHolder.discount.text = context.getString(R.string.discount, data.discount)
        viewHolder.flash_sale_item.setOnClickListener{
            click.onItemClick(data.id)
        }
    }

    override fun getLayout() = R.layout.flash_sale_item
}