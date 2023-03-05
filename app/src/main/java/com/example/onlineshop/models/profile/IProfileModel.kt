package com.example.onlineshop.models.profile

import com.xwray.groupie.kotlinandroidextensions.Item

interface IProfileModel {
    fun getProfileList(): List<Item>
}