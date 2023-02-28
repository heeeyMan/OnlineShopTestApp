package com.example.testapp.datamodels.groupie_models

import android.annotation.SuppressLint
import android.content.Context
import com.example.testapp.R
import com.example.testapp.datamodels.ProfileItem
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.profile_item.*

class ProfileDataModel(
    private val context: Context,
    private val data: ProfileItem
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
        if(!data.price.isNullOrEmpty())
        viewHolder.price.text = context.getString(R.string.price, data.price)
    }

    override fun getLayout() = R.layout.profile_item
}