package com.example.onlineshop.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import com.example.onlineshop.R
import com.example.onlineshop.datamodels.items.FlashItem
import com.example.onlineshop.utils.OnItemClickedListener
import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.flash_sale_item.*
import kotlinx.android.synthetic.main.flash_sale_item.background_img
import kotlinx.android.synthetic.main.flash_sale_item.category_name
import kotlinx.android.synthetic.main.flash_sale_item.item_name
import kotlinx.android.synthetic.main.flash_sale_item.price

class FlashSaleDataModel(
    private val context: Context,
    private val data: FlashItem,
    private val click: OnItemClickedListener
) : Item() {
    @SuppressLint("UseCompatLoadingForDrawables", "StringFormatMatches")
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        Picasso.get().load(data.imageUrl).into(viewHolder.background_img)
        viewHolder.category_name.text = data.category
        viewHolder.item_name.text = data.name
        viewHolder.price.text = context.getString(R.string.price, data.price)
        viewHolder.discount.text = context.getString(R.string.discount, data.discount)
        viewHolder.flash_sale_item.setOnClickListener{
            click.onItemClick(data.id)
        }
    }

    override fun getLayout() = R.layout.flash_sale_item
}