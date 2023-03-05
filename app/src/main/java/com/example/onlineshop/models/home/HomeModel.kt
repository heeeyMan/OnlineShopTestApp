package com.example.onlineshop.models.home

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.onlineshop.R
import com.example.onlineshop.datamodels.items.*
import com.example.onlineshop.services.ApiInterfaceUrl
import com.example.onlineshop.services.DataClient
import com.example.onlineshop.ui.adapters.*
import com.example.onlineshop.utils.*
import com.xwray.groupie.kotlinandroidextensions.Item

class HomeModel(
    private val context: Context,
    private val click: OnItemClickedListener
) : IHomeModel {
    private val randomId = (0..100000).random()

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getLatestData(): LatestListData {
        val retrofit = DataClient.getInstance()
        val apiInterface = retrofit.create(ApiInterfaceUrl::class.java)
        return apiInterface.getLatestData(LATEST_URL)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getFlashSale(): FlashSaleListData {
        val retrofit = DataClient.getInstance()
        val apiInterface = retrofit.create(ApiInterfaceUrl::class.java)
        return apiInterface.getFlashSaleData(FLASH_SALE_URL)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun getTradeData(listItems: ListsItems): List<Item> {

        val listFlash = getFlashSaleItems(listItems.flashSaleList)
        val listLatest = getLatestItems(listItems.latestList)
        return listOf(
            ListChapters(context, getChapterItems()),
            ListCategories(context, R.string.latest, R.string.view_all, listLatest),
            ListCategories(context, R.string.flash_sale, R.string.view_all, listFlash),
            ListCategories(context, R.string.flash_sale, R.string.view_all, listFlash)
        )
    }

    private fun flashSaleToItem(items: ArrayList<FlashSaleData>): List<FlashItem> {
        return items.map {
            FlashItem(
                imageUrl = it.imageUrl ?: "",
                category = it.category ?: EMPTY_STRING,
                name = it.name ?: EMPTY_STRING,
                price = (it.price ?: -0.0).toString(),
                discount = (it.discount ?: -0).toString(),
                id = randomId
            )
        }
    }

    private fun latestToItem(items: ArrayList<LatestData>): List<LatestItem> {
        return items.map {
            LatestItem(
                imageUrl = it.imageUrl ?: "",
                category = it.category?.toInt() ?: 0,
                name = it.name ?: "",
                price = (it.price ?: -0.0).toString(),
                id = randomId
            )
        }
    }


    private fun getLatestItems(items: ArrayList<LatestData>): List<Item> {
        return latestToItem(items).map {
            LatestDataModel(
                context,
                it,
                click
            )
        }
    }

    private fun getFlashSaleItems(items: ArrayList<FlashSaleData>): List<Item> {
        return flashSaleToItem(items).map {
            FlashSaleDataModel(
                context,
                it,
                click
            )
        }
    }

    private fun getChapterItems(): List<Item> {
        val phones = ChapterItem(R.drawable.phones, R.string.phones, randomId)
        val headphones = ChapterItem(R.drawable.headphones, R.string.headphones, randomId)
        val games = ChapterItem(R.drawable.games, R.string.games, THREE)
        val furniture = ChapterItem(R.drawable.furniture, R.string.furniture, randomId)
        val kids = ChapterItem(R.drawable.kids, R.string.kids, randomId)
        return listOf(
            ChapterDataModel(context, phones),
            ChapterDataModel(context, headphones),
            ChapterDataModel(context, games),
            ChapterDataModel(context, furniture),
            ChapterDataModel(context, kids)
        )
    }
}