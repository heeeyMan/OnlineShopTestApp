package com.example.onlineshop.models.more_details

import com.example.onlineshop.datamodels.items.MoreDetailsItem

interface IMoreDetailsModel {
    suspend fun getMoreDetails(): MoreDetailsItem
}