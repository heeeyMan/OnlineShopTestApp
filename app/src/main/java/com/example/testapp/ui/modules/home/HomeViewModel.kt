package com.example.testapp.ui.modules.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.models.home.IHomeModel
import com.example.testapp.routers.home.IHomeRouter
import com.xwray.groupie.kotlinandroidextensions.Item

class HomeViewModel(
    private val model: IHomeModel,
    private val router: IHomeRouter
) : ViewModel() {
    val tradeData = MutableLiveData<List<Item>>()
    fun initProfileList() {
        tradeData.postValue(model.getTradeData())
    }

    fun openItem(id: Int) {
        router.openMoreDetails(id)
    }
}