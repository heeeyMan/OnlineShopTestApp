package com.example.testapp.models.home

import android.annotation.SuppressLint
import android.content.Context
import com.example.testapp.R
import com.example.testapp.datamodels.items.ChapterItem
import com.example.testapp.datamodels.items.FlashItem
import com.example.testapp.datamodels.items.LatestItem
import com.example.testapp.ui.adapters.*
import com.example.testapp.utils.OnItemClickedListener
import com.xwray.groupie.kotlinandroidextensions.Item

class HomeModel(
    private val context: Context,
    private val click: OnItemClickedListener
) : IHomeModel {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun getTradeData(): List<Item> {
        val phones = ChapterItem(R.drawable.phones, R.string.phones, 6)
        val headphones = ChapterItem(R.drawable.headphones, R.string.headphones, 7)
        val games = ChapterItem(R.drawable.games, R.string.games, 7)
        val furniture = ChapterItem(R.drawable.furniture, R.string.furniture, 8)
        val kids = ChapterItem(R.drawable.kids, R.string.kids, 9)
        val listChapters = listOf(
            ChapterDataModel(context, phones),
            ChapterDataModel(context, headphones),
            ChapterDataModel(context, games),
            ChapterDataModel(context, furniture),
            ChapterDataModel(context, kids)
        )
        val phoneSamsung = LatestItem(
            R.drawable.latest_phone,
            R.string.phones,
            "Samsung S10",
            "180,000",
            1
        )
        val gamesPlayStation = LatestItem(
            R.drawable.latest_play_station,
            R.string.games,
            "Play Station 5 console",
            "90,000",
            2
        )
        val gamesPlayStationRed = LatestItem(
            R.drawable.latest_play_station_red,
            R.string.games,
            "Play Station 5 console",
            "95,000",
            3
        )
        val listLatest = listOf(
            LatestDataModel(context, phoneSamsung, click),
            LatestDataModel(context, gamesPlayStation, click),
            LatestDataModel(context, gamesPlayStationRed, click)
        )

        val sneakersBlack = FlashItem(
            R.drawable.flash_black_sneakers, R.string.kids,
            "New balance sneakers",
            "33,00",
            "30",
            4
        )
        val sneakersWhite = FlashItem(
            R.drawable.flash_sneaker_white, R.string.kids,
            "New balance sneakers",
            "22,50",
            "30",
            5
        )

        val listFlash =
            listOf(
                FlashDataModel(context, sneakersBlack, click),
                FlashDataModel(context, sneakersWhite, click),
                FlashDataModel(context, sneakersWhite, click),
                FlashDataModel(context, sneakersWhite, click),
                FlashDataModel(context, sneakersWhite, click)
            )

        return listOf(
            ListChapters(context, listChapters),
            ListCategories(context, R.string.latest, R.string.view_all, listLatest),
            ListCategories(context, R.string.flash_sale, R.string.view_all, listFlash),
            ListCategories(context, R.string.flash_sale, R.string.view_all, listFlash)
        )
    }
}