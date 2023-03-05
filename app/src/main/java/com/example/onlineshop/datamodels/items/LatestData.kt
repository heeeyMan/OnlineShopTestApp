package com.example.onlineshop.datamodels.items

import com.google.gson.annotations.SerializedName


data class LatestData(
    @SerializedName("category") var category: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("image_url") var imageUrl: String? = null
)
