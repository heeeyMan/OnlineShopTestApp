package com.example.onlineshop.datamodels.items

data class ListsItems(
    val latestList: List<LatestData>,
    val flashSaleList: List<FlashSaleData>
)
