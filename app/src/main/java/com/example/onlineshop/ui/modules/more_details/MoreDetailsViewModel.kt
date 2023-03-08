package com.example.onlineshop.ui.modules.more_details

import android.graphics.Bitmap
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.datamodels.enums.BottomBarButtonType
import com.example.onlineshop.datamodels.items.MoreDetailsItem
import com.example.onlineshop.models.more_details.IMoreDetailsModel
import com.example.onlineshop.routers.more_details.IMoreDetailsRouter
import com.example.onlineshop.utils.ZERO
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoreDetailsViewModel(
    private val model: IMoreDetailsModel,
    private val router: IMoreDetailsRouter
) : ViewModel() {
    val moreDetailsData = MutableLiveData<MoreDetailsItem>()
    val price = MutableLiveData<String>()
    val largeImage = MutableLiveData<Bitmap>()
    private var currentPrice = ZERO.toDouble()
    private var priceOneProduct = ZERO.toDouble()
    private var quantity = 1
    fun initMoreDetails() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = model.getMoreDetails()
                withContext(Dispatchers.Main) {
                    priceOneProduct = data.price.toDouble()
                    currentPrice = priceOneProduct
                    moreDetailsData.postValue(data)
                }
            }
        }
    }
    fun bottomBarClickHandle(type: BottomBarButtonType) {
        when(type) {
            BottomBarButtonType.ADD_CARD -> {

            }
            BottomBarButtonType.POSITIVE -> {
                currentPrice += priceOneProduct
                price.postValue(currentPrice.toString())
            }
            BottomBarButtonType.NEGATIVE -> {
                currentPrice -= priceOneProduct
                price.postValue(currentPrice.toString())
            }
        }
    }

    fun updateImage(uri: Uri) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val image = Picasso.get().load(uri).get()
                withContext(Dispatchers.Main) {
                    largeImage.postValue(image)
                }
            }
        }
    }
}