package com.example.onlineshop.models.home

import com.example.onlineshop.datamodels.data.FlashSaleListData
import com.example.onlineshop.datamodels.data.LatestListData
import com.example.onlineshop.datamodels.items.ListsItems
import com.xwray.groupie.kotlinandroidextensions.Item

interface IHomeModel {
    suspend fun getLatestData(): LatestListData
    suspend fun getFlashSaleData(): FlashSaleListData
    suspend fun getHintList(query: String): List<String>
    fun getTradeData(listItems: ListsItems): List<Item>
    fun isConnection(): Boolean
}