package com.example.testapp.datamodels.items

import com.example.testapp.utils.ZERO

data class LatestItem(
    val imageId: Int,
    val category: Int,
    val name: String,
    val price: String,
    val id: Int = ZERO
)
