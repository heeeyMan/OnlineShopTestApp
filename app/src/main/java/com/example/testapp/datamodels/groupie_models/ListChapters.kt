package com.example.testapp.datamodels.groupie_models

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.R
import com.example.testapp.ui.utils.PaddingBetweenItems
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.list_chapters.*

class ListChapters(
    private val context: Context,
    private val items: List<Item>
) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val padding = 21
        val recyclerView = viewHolder.categories_list
        recyclerView.addItemDecoration(PaddingBetweenItems(padding))
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = GroupAdapter<GroupieViewHolder>().apply { addAll(items) }
    }

    override fun getLayout() = R.layout.list_chapters
}