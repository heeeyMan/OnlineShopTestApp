package com.example.onlineshop.datamodels.data

import com.google.gson.annotations.SerializedName

data class FlashSaleListData(
    @SerializedName("flash_sale") var flashSale: List<FlashSaleData> = listOf()
)
