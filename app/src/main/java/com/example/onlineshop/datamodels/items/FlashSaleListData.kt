package com.example.onlineshop.datamodels.items

import com.google.gson.annotations.SerializedName

data class FlashSaleListData(
    @SerializedName("flash_sale") var flashSale: List<FlashSaleData> = listOf()
)
