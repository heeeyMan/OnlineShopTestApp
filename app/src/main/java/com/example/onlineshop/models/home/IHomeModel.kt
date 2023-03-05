package com.example.onlineshop.models.home

import com.example.onlineshop.datamodels.items.FlashSaleListData
import com.example.onlineshop.datamodels.items.LatestListData
import com.example.onlineshop.datamodels.items.ListsItems
import com.xwray.groupie.kotlinandroidextensions.Item

interface IHomeModel {
    suspend fun getLatestData(): LatestListData
    suspend fun getFlashSale(): FlashSaleListData
    fun getTradeData(listItems: ListsItems): List<Item>
}