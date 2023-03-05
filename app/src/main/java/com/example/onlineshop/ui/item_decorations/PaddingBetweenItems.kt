package com.example.onlineshop.ui.item_decorations

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.utils.ZERO
import com.example.onlineshop.utils.convertDpToInt

class PaddingBetweenItems(
    paddingEnd: Int = ZERO,
    marginVertical: Int = ZERO,
    context: Context
) : RecyclerView.ItemDecoration() {
    private val marginVerticalDp = marginVertical.convertDpToInt(context)
    private val paddingEndDp = paddingEnd.convertDpToInt(context)
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        parent.adapter?.let { adapter ->
            outRect.right = when (parent.getChildAdapterPosition(view)) {
                RecyclerView.NO_POSITION -> ZERO
                adapter.itemCount - 1 -> marginVerticalDp
                else -> paddingEndDp
            }
            outRect.left = when (parent.getChildAdapterPosition(view)) {
                ZERO -> marginVerticalDp
                else -> ZERO
            }
        }
    }
}