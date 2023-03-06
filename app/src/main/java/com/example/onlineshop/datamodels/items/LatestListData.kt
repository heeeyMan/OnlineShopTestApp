package com.example.onlineshop.datamodels.items

import com.google.gson.annotations.SerializedName

data class LatestListData(
    @SerializedName("latest") var latest: List<LatestData> = listOf()
)
