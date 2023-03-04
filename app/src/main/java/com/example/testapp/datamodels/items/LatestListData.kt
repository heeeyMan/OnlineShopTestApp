package com.example.testapp.datamodels.items

import com.google.gson.annotations.SerializedName

data class LatestListData(
    @SerializedName("latest") var latest: ArrayList<LatestData> = arrayListOf()
)
