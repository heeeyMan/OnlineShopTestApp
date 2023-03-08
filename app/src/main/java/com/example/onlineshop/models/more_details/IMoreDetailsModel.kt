package com.example.onlineshop.models.more_details

import com.example.onlineshop.datamodels.items.MoreDetailsData

interface IMoreDetailsModel {
    suspend fun getMoreDetailsData(): MoreDetailsData
}