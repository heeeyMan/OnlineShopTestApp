package com.example.onlineshop.datamodels.items

data class ListsItems(
    val latestList: ArrayList<LatestData>,
    val flashSaleList: ArrayList<FlashSaleData>
)
