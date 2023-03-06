package com.example.onlineshop.ui.modules.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.datamodels.enums.RequestState
import com.example.onlineshop.datamodels.items.ListsItems
import com.example.onlineshop.models.home.IHomeModel
import com.example.onlineshop.routers.home.IHomeRouter
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.ConnectException

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
                    model.apply {
                        if (!isConnection()) throw ConnectException()
                        val latest = getLatestData().latest
                        val flashSale = getFlashSaleData().flashSale
                        withContext(Dispatchers.Main) {
                            tradeData.postValue(
                                getTradeData(
                                    ListsItems(
                                        latestList = latest,
                                        flashSaleList = flashSale
                                    )
                                )
                            )
                        }
                    }
                }
                requestState.postValue(RequestState.CORRECT)
            } catch (_: ConnectException) {
                requestState.postValue(RequestState.NO_INTERNET)
            } catch (ex: HttpException) {
                when (ex.code()) {
                    400 -> requestState.postValue(RequestState.CLIENT_ERROR)
                    404 -> requestState.postValue(RequestState.NOT_FOUND)
                    in 500..511 -> requestState.postValue(RequestState.SERVER_ERROR)
                    else -> requestState.postValue(RequestState.UNKNOWN_ERROR)
                }
            } catch (_: Throwable) {
                requestState.postValue(RequestState.UNKNOWN_ERROR)
            }
        }
    }

    fun openItem(id: Int) {
        router.openMoreDetails(id)
    }
}