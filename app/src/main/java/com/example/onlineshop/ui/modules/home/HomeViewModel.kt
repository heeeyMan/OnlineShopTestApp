package com.example.onlineshop.ui.modules.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.datamodels.enums.RequestState
import com.example.onlineshop.models.home.IHomeModel
import com.example.onlineshop.routers.home.IHomeRouter
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val model: IHomeModel,
    private val router: IHomeRouter
) : ViewModel() {
    val tradeData = MutableLiveData<List<Item>>()
    val requestState = MutableLiveData<RequestState>()
    fun initProfileList() {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    model.getFlashSale()
                }
                requestState.postValue(RequestState.CORRECT)
            } catch (_: Throwable) {
                requestState.postValue(RequestState.UNKNOWN_ERROR)
            }
        }
    }

    fun openItem(id: Int) {
        router.openMoreDetails(id)
    }
}