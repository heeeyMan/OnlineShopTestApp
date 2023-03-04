package com.example.testapp.datamodels.items

import com.example.testapp.utils.ZERO

data class ProfileItem(
    val iconId: Int,
    val fieldNameId: Int,
    val price: String? = null,
    val imageId: Int? = null,
    val id: Int = ZERO,
)