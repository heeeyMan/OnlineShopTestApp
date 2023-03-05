package com.example.onlineshop.datamodels.items

import com.example.onlineshop.utils.ZERO

data class FlashItem(
    val imageId: Int,
    val category: Int,
    val name: String,
    val price: String,
    val discount: String,
    val id: Int = ZERO,
)
