package com.example.testapp.models.profile

import com.xwray.groupie.kotlinandroidextensions.Item

interface IProfileModel {
    fun getProfileList(): List<Item>
}