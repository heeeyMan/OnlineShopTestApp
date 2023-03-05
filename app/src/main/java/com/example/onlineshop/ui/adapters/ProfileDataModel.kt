package com.example.onlineshop.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import com.example.onlineshop.R
import com.example.onlineshop.datamodels.items.ProfileItem
import com.example.onlineshop.utils.OnProfileItemClickListener
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.profile_item.*

class ProfileDataModel(
    private val context: Context,
    private val data: ProfileItem,
    private val click: OnProfileItemClickListener
) : Item() {

    @SuppressLint("UseCompatLoadingForDrawables", "SuspiciousIndentation")
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.icon.setImageDrawable(context.resources.getDrawable(data.iconId, null))
        viewHolder.field_name.text = context.getString(data.fieldNameId)

        viewHolder.arrow.setImageDrawable(data.imageId?.let {
            context.resources.getDrawable(
                it,
                null
            )
        })

        if (!data.price.isNullOrEmpty())
            viewHolder.price.text = context.getString(R.string.price, data.price)

        viewHolder.profile_item.setOnClickListener {
            click.onProfileItemClick(data.typeItem)
        }
    }

    override fun getLayout() = R.layout.profile_item
}