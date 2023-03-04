package com.example.testapp.datamodels.items

import com.example.testapp.utils.ZERO

data class ChapterItem(
    val iconId: Int,
    val fieldNameId: Int,
    val id: Int = ZERO,
)