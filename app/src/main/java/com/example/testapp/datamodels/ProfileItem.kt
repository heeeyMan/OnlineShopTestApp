package com.example.testapp.datamodels

data class ProfileItem(
    val iconId: Int,
    val fieldNameId: Int,
    val price: String? = null,
    val imageId: Int? = null
)