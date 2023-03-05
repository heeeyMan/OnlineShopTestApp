package com.example.onlineshop.datamodels.items

import com.example.onlineshop.datamodels.enums.ProfileItemType
import com.example.onlineshop.utils.ZERO

data class ProfileItem(
    val iconId: Int,
    val fieldNameId: Int,
    val price: String? = null,
    val imageId: Int? = null,
    val id: Int = ZERO,
    val typeItem: ProfileItemType
)