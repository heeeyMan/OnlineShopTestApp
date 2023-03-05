package com.example.onlineshop.services

import com.example.onlineshop.datamodels.items.FlashSaleListData
import com.example.onlineshop.datamodels.items.LatestListData
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterfaceUrl {
    @GET("/{request}")
    suspend fun getLatestData(@Path("request") request: String): LatestListData

    @GET("/{request}")
    suspend fun getFlashSaleData(@Path("request") request: String): FlashSaleListData
}