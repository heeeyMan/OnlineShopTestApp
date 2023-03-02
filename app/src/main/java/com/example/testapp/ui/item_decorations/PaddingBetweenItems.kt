package com.example.testapp.ui.item_decorations

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.utils.convertDpToInt

class PaddingBetweenItems(
    paddingEnd: Int,
    marginVertical: Int,
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
                RecyclerView.NO_POSITION -> 0
                adapter.itemCount - 1 -> marginVerticalDp
                else -> paddingEndDp
            }
            outRect.left = when (parent.getChildAdapterPosition(view)) {
                0 -> marginVerticalDp
                else -> 0
            }
        }
    }
}