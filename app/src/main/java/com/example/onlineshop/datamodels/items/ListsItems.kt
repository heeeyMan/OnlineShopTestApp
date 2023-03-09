package com.example.onlineshop.datamodels.items

import com.example.onlineshop.datamodels.data.FlashSaleData
import com.example.onlineshop.datamodels.data.LatestData

data class ListsItems(
    val latestList: List<LatestData>,
    val flashSaleList: List<FlashSaleData>
)
