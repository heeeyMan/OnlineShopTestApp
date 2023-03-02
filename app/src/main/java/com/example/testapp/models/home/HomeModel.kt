package com.example.testapp.models.home

import android.annotation.SuppressLint
import android.content.Context
import com.example.testapp.R
import com.example.testapp.datamodels.ChapterItem
import com.example.testapp.datamodels.FlashItem
import com.example.testapp.datamodels.LatestItem
import com.example.testapp.datamodels.groupie_models.*
import com.xwray.groupie.kotlinandroidextensions.Item

class HomeModel(private val context: Context) : IHomeModel {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun getTradeData(): List<Item> {
        val phones = ChapterItem(R.drawable.phones, R.string.phones)
        val headphones = ChapterItem(R.drawable.headphones, R.string.headphones)
        val games = ChapterItem(R.drawable.games, R.string.games)
        val furniture = ChapterItem(R.drawable.furniture, R.string.furniture)
        val kids = ChapterItem(R.drawable.kids, R.string.kids)
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
            "180,000"
        )
        val gamesPlayStation = LatestItem(
            R.drawable.latest_play_station,
            R.string.games,
            "Play Station 5 console",
            "90,000"
        )
        val gamesPlayStationRed = LatestItem(
            R.drawable.latest_play_station_red,
            R.string.games,
            "Play Station 5 console",
            "95,000"
        )
        val listLatest = listOf(
            LatestDataModel(context, phoneSamsung),
            LatestDataModel(context, gamesPlayStation),
            LatestDataModel(context, gamesPlayStationRed)
        )

        val sneakersBlack = FlashItem(
            R.drawable.flash_black_sneakers, R.string.kids,
            "New balance sneakers",
            "33,00",
            "30"
        )
        val sneakersWhite = FlashItem(
            R.drawable.flash_sneaker_white, R.string.kids,
            "New balance sneakers",
            "22,50",
            "30"
        )

        val listFlash =
            listOf(
                FlashDataModel(context, sneakersBlack),
                FlashDataModel(context, sneakersWhite),
                FlashDataModel(context, sneakersWhite),
                FlashDataModel(context, sneakersWhite),
                FlashDataModel(context, sneakersWhite)
            )

        return listOf(
            ListChapters(context, listChapters),
            ListCategories(context, R.string.latest, R.string.view_all, listLatest),
            ListCategories(context, R.string.flash_sale, R.string.view_all, listFlash),
            ListCategories(context, R.string.flash_sale, R.string.view_all, listFlash)
        )
    }
}