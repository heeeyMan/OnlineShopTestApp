package com.example.onlineshop.models.profile

import android.graphics.drawable.Drawable
import com.xwray.groupie.kotlinandroidextensions.Item

interface IProfileModel {
    fun getProfileList(): List<Item>
    suspend fun getFullName(): String
}