package com.example.testapp.datamodels.groupie_models

import android.annotation.SuppressLint
import android.content.Context
import com.example.testapp.R
import com.example.testapp.datamodels.ChapterItem
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.chapter_item.*
import kotlinx.android.synthetic.main.latest_item.*

class ChapterDataModel(
    private val context: Context,
    private val data: ChapterItem
) : Item() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.icon.setImageDrawable(context.resources.getDrawable(data.iconId, null))
        viewHolder.chapter_name.text = context.getString(data.fieldNameId)
    }

    override fun getLayout() = R.layout.chapter_item
}