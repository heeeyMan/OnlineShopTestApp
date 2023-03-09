package com.example.onlineshop.services

import com.example.onlineshop.datamodels.data.FlashSaleListData
import com.example.onlineshop.datamodels.data.HintData
import com.example.onlineshop.datamodels.data.LatestListData
import com.example.onlineshop.datamodels.data.MoreDetailsData
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterfaceUrl {
    @GET("v3/{request}")
    suspend fun getLatestData(@Path("request") request: String): LatestListData

    @GET("v3/{request}")
    suspend fun getFlashSaleData(@Path("request") request: String): FlashSaleListData

    @GET("v3/{request}")
    suspend fun getMoreDetailsData(@Path("request") request: String): MoreDetailsData

    @GET("v3/{request}")
    suspend fun getHintData(@Path("request") request: String): HintData
}