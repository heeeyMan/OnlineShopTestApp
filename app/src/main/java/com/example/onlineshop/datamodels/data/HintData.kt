package com.example.onlineshop.datamodels.data

import com.google.gson.annotations.SerializedName

data class HintData(
    @SerializedName("words") var words: ArrayList<String> = arrayListOf()
)
