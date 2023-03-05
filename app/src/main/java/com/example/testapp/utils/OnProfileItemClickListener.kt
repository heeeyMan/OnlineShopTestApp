package com.example.testapp.utils

import com.example.testapp.datamodels.enums.ProfileItemType

interface OnProfileItemClickListener {
    fun onProfileItemClick(item: ProfileItemType)
}