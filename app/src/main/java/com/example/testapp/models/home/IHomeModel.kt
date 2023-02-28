package com.example.testapp.models.home

import com.xwray.groupie.kotlinandroidextensions.Item

interface IHomeModel {
    fun getTradeData(): List<Item>
}