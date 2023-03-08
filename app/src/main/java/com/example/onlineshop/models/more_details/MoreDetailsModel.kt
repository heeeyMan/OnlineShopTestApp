package com.example.onlineshop.models.more_details

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.onlineshop.datamodels.items.MoreDetailsData
import com.example.onlineshop.services.ApiInterfaceUrl
import com.example.onlineshop.services.DataClient
import com.example.onlineshop.utils.MORE_DETAILS_URL

class MoreDetailsModel : IMoreDetailsModel {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getMoreDetailsData(): MoreDetailsData {
        val retrofit = DataClient.getInstance()
        val apiInterface = retrofit.create(ApiInterfaceUrl::class.java)
        return apiInterface.getMoreDetailsData(MORE_DETAILS_URL)
    }
}