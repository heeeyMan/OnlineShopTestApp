package com.example.onlineshop.models.more_details

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.onlineshop.datamodels.items.MoreDetailsData
import com.example.onlineshop.datamodels.items.MoreDetailsItem
import com.example.onlineshop.services.ApiInterfaceUrl
import com.example.onlineshop.services.DataClient
import com.example.onlineshop.utils.EMPTY_STRING
import com.example.onlineshop.utils.MORE_DETAILS_URL

class MoreDetailsModel : IMoreDetailsModel {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getMoreDetails(): MoreDetailsItem {
        val data = getMoreDetailsData()
        return MoreDetailsItem(
            name = data.name ?: EMPTY_STRING,
            description = data.description?: EMPTY_STRING,
            rating = data.rating.toString(),
            numberOfReviews = data.numberOfReviews.toString(),
            price = data.price.toString(),
            colors = data.colors,
            imageUrls = data.imageUrls
        )
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private suspend fun getMoreDetailsData(): MoreDetailsData {
        val retrofit = DataClient.getInstance()
        val apiInterface = retrofit.create(ApiInterfaceUrl::class.java)
        return apiInterface.getMoreDetailsData(MORE_DETAILS_URL)
    }
}