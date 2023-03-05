package com.example.onlineshop.datamodels.items

import com.example.onlineshop.utils.ZERO

data class ChapterItem(
    val iconId: Int,
    val fieldNameId: Int,
    val id: Int = ZERO,
)