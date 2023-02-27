package com.example.testapp.ui.home

import androidx.lifecycle.ViewModel
import com.example.testapp.models.home.IHomeModel
import com.example.testapp.routers.IHomeRouter

class HomeViewModel(
    val model: IHomeModel,
    val router: IHomeRouter
) : ViewModel()