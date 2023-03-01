package com.example.testapp.ui.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class PaddingBetweenItems(private val padding: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        parent.adapter?.let { adapter ->
            outRect.right =
                when(parent.getChildAdapterPosition(view)) {
                    RecyclerView.NO_POSITION, adapter.itemCount - 1 -> 0
                    else -> padding
                }
        }
    }
}