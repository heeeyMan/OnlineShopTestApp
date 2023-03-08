package com.example.onlineshop.ui.modules.more_details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.datamodels.enums.BottomBarButtonType
import com.example.onlineshop.datamodels.items.MoreDetailsItem
import com.example.onlineshop.models.more_details.IMoreDetailsModel
import com.example.onlineshop.routers.more_details.IMoreDetailsRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoreDetailsViewModel(
    private val model: IMoreDetailsModel,
    private val router: IMoreDetailsRouter
) : ViewModel() {
    val moreDetailsData = MutableLiveData<MoreDetailsItem>()
    fun initMoreDetails() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = model.getMoreDetails()
                withContext(Dispatchers.Main) {
                    moreDetailsData.postValue(data)
                }
            }
        }
    }
    fun bottomBarClickHandle(type: BottomBarButtonType) {

    }
}