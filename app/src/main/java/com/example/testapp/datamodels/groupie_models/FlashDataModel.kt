package com.example.testapp.datamodels.groupie_models

import android.annotation.SuppressLint
import android.content.Context
import com.example.testapp.R
import com.example.testapp.datamodels.FlashItem
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.flash_sale_item.*

class FlashDataModel(
    private val context: Context,
    private val data: FlashItem
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
    }

    override fun getLayout() = R.layout.flash_sale_item
}