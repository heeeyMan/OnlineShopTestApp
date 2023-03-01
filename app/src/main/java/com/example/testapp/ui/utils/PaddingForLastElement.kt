package com.example.testapp.ui.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class PaddingForLastElement(private val padding: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        parent.adapter?.let { adapter ->
            outRect.bottom =
                when (parent.getChildAdapterPosition(view)) {
                    adapter.itemCount - 1 -> padding
                    else -> 0
                }
        }
    }
}