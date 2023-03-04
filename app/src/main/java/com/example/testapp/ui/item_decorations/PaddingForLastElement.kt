package com.example.testapp.ui.item_decorations

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.utils.ZERO
import com.example.testapp.utils.convertDpToInt

class PaddingForLastElement(
    private val padding: Int,
    private val context: Context
) : RecyclerView.ItemDecoration() {
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
                    adapter.itemCount - 1 -> padding.convertDpToInt(context)
                    else -> ZERO
                }
        }
    }
}