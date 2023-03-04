package com.example.testapp.datamodels.items

import com.example.testapp.utils.ZERO

data class FlashItem(
    val imageId: Int,
    val category: Int,
    val itemName: String,
    val price: String,
    val discount: String,
    val id: Int = ZERO,
)
