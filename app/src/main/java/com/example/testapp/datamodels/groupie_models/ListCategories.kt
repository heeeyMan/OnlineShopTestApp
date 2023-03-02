package com.example.testapp.datamodels.groupie_models

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.R
import com.example.testapp.ui.item_decorations.PaddingBetweenItems
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
        val paddingEnd = when (items.firstOrNull()?.layout) {
            R.layout.latest_item -> 12
            R.layout.flash_sale_item -> 9
            else -> 0
        }
        val marginVertical = 11
        val recyclerView = viewHolder.categories_list
        viewHolder.header.header_name.text = context.getString(headerNameId)
        viewHolder.header.header_view.text = context.getString(viewId)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = GroupAdapter<GroupieViewHolder>().apply { addAll(items) }
        recyclerView.addItemDecoration(PaddingBetweenItems(paddingEnd, marginVertical, context))
    }

    override fun getLayout() = R.layout.list_categories
}