package com.example.testapp.datamodels.items

import com.google.gson.annotations.SerializedName

data class FlashSaleListData(
    @SerializedName("flash_sale") var flashSale: ArrayList<FlashSaleData> = arrayListOf()
)
