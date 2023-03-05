package com.example.onlineshop.utils

import com.example.onlineshop.datamodels.enums.ProfileItemType

interface OnProfileItemClickListener {
    fun onProfileItemClick(item: ProfileItemType)
}