package com.example.onlineshop.datamodels.data

import com.google.gson.annotations.SerializedName

data class LatestListData(
    @SerializedName("latest") var latest: List<LatestData> = listOf()
)
