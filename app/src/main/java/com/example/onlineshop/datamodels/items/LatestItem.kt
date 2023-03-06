package com.example.onlineshop.datamodels.items

import com.example.onlineshop.utils.ZERO

data class LatestItem(
    val imageUrl: String,
    val category: String,
    val name: String,
    val price: String,
    val id: Int = ZERO
)
