package com.example.onlineshop.models.home

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.onlineshop.R
import com.example.onlineshop.datamodels.data.*
import com.example.onlineshop.datamodels.items.*
import com.example.onlineshop.services.ApiInterfaceUrl
import com.example.onlineshop.services.DataClient
import com.example.onlineshop.services.network.INetworkService
import com.example.onlineshop.ui.adapters.*
import com.example.onlineshop.utils.*
import com.xwray.groupie.kotlinandroidextensions.Item

class HomeModel(
    private val context: Context,
    private val click: OnItemClickedListener,
    private val networkService: INetworkService
) : IHomeModel {
    private val randomId = (ZERO..RANGE).random()

    override fun isConnection() = networkService.checkNetworkConnection()

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getLatestData(): LatestListData {
        val retrofit = DataClient.getInstance()
        val apiInterface = retrofit.create(ApiInterfaceUrl::class.java)
        return apiInterface.getLatestData(LATEST_URL)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getFlashSaleData(): FlashSaleListData {
        val retrofit = DataClient.getInstance()
        val apiInterface = retrofit.create(ApiInterfaceUrl::class.java)
        return apiInterface.getFlashSaleData(FLASH_SALE_URL)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private suspend fun getHintData(): HintData {
        val retrofit = DataClient.getInstance()
        val apiInterface = retrofit.create(ApiInterfaceUrl::class.java)
        return apiInterface.getHintData(HINT_URL)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getHintList(query: String): List<String> {
        val hintList = getHintData().words
        return hintList.filter { it.lowercase().contains(query.lowercase()) }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun getTradeData(listItems: ListsItems): List<Item> {

        val listFlash = getFlashSaleItems(listItems.flashSaleList)
        val listLatest = getLatestItems(listItems.latestList)
        return listOf(
            ListChapters(context, getChapterItems()),
            ListCategories(context, R.string.latest, R.string.view_all, listLatest),
            ListCategories(context, R.string.flash_sale, R.string.view_all, listFlash),
            ListCategories(context, R.string.old_sale, R.string.view_all, listFlash)
        )
    }

    private fun flashSaleToItem(items: List<FlashSaleData>): List<FlashItem> {
        return items.map {
            FlashItem(
                imageUrl = it.imageUrl ?: EMPTY_STRING,
                category = it.category ?: EMPTY_STRING,
                name = it.name ?: EMPTY_STRING,
                price = (it.price ?: -0.0).toString(),
                discount = (it.discount ?: -0).toString(),
                id = randomId
            )
        }
    }

    private fun latestToItem(items: List<LatestData>): List<LatestItem> {
        return items.map {
            LatestItem(
                imageUrl = it.imageUrl ?: EMPTY_STRING,
                category = it.category ?: EMPTY_STRING,
                name = it.name ?: EMPTY_STRING,
                price = (it.price ?: -0.0).toString(),
                id = randomId
            )
        }
    }


    private fun getLatestItems(items: List<LatestData>): List<Item> {
        return latestToItem(items).map {
            LatestDataModel(
                context,
                it,
                click
            )
        }
    }

    private fun getFlashSaleItems(items: List<FlashSaleData>): List<Item> {
        return flashSaleToItem(items).map {
            FlashSaleDataModel(
                context,
                it,
                click
            )
        }
    }

    private fun getChapterItems(): List<Item> {
        return listOf(
            ChapterDataModel(context, ChapterItem(R.drawable.phones, R.string.phones, randomId)),
            ChapterDataModel(
                context,
                ChapterItem(R.drawable.headphones, R.string.headphones, randomId)
            ),
            ChapterDataModel(context, ChapterItem(R.drawable.games, R.string.games, randomId)),
            ChapterDataModel(
                context,
                ChapterItem(R.drawable.furniture, R.string.furniture, randomId)
            ),
            ChapterDataModel(context, ChapterItem(R.drawable.kids, R.string.kids, randomId))
        )
    }
}