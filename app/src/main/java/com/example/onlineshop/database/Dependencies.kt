package com.example.onlineshop.database

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import com.example.onlineshop.database.Base.AppDataBase

@SuppressLint("StaticFieldLeak")
object Dependencies {
    private lateinit var context: Context

    fun init(context: Context) {
        Dependencies.context = context
    }

    private val appDataBase: AppDataBase by lazy {
        Room.databaseBuilder(context, AppDataBase::class.java, "database.db")
            .build()
    }

    val accountRepository: AccountRepository by lazy {
        AccountRepository(appDataBase.getAccountDao())
    }
}