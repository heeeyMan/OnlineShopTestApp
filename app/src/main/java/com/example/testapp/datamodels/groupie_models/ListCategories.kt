package com.example.testapp.datamodels.groupie_models

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.header_item.view.*
import kotlinx.android.synthetic.main.list_categories.*
import kotlinx.android.synthetic.main.list_categories.categories_list

class ListCategories(
    private val context: Context,
    private val headerNameId: Int,
    private val viewId: Int,
    private val items: List<Item>
) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.header.header_name.text = context.getString(headerNameId)
        viewHolder.header.header_view.text = context.getString(viewId)
        viewHolder.categories_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewHolder.categories_list.adapter = GroupAdapter<GroupieViewHolder>().apply {addAll(items) }
    }

    override fun getLayout() = R.layout.list_categories
}