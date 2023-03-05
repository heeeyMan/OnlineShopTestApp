package com.example.onlineshop.ui.adapters

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlineshop.R
import com.example.onlineshop.ui.item_decorations.PaddingBetweenItems
import com.example.onlineshop.utils.CATEGORIES_MARGIN_VERTICAL
import com.example.onlineshop.utils.FLASH_PADDING_END
import com.example.onlineshop.utils.LATEST_PADDING_END
import com.example.onlineshop.utils.ZERO
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
            R.layout.latest_item -> LATEST_PADDING_END
            R.layout.flash_sale_item -> FLASH_PADDING_END
            else -> ZERO
        }
        val recyclerView = viewHolder.categories_list
        viewHolder.header.header_name.text = context.getString(headerNameId)
        viewHolder.header.header_view.text = context.getString(viewId)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = GroupAdapter<GroupieViewHolder>().apply { addAll(items) }
        recyclerView.addItemDecoration(PaddingBetweenItems(paddingEnd, CATEGORIES_MARGIN_VERTICAL, context))
    }

    override fun getLayout() = R.layout.list_categories
}