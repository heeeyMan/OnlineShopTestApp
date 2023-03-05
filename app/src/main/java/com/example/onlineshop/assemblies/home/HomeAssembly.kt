package com.example.onlineshop.assemblies.home

import android.content.Context
import androidx.navigation.NavController
import com.example.onlineshop.models.home.HomeModel
import com.example.onlineshop.routers.home.HomeRouter
import com.example.onlineshop.ui.modules.home.HomeViewModel
import com.example.onlineshop.utils.OnItemClickedListener

class HomeAssembly(
    private val context: Context,
    private val navController: NavController,
    private val click: OnItemClickedListener
): IHomeAssembly {
    override fun build(): HomeViewModel {
        val model = HomeModel(context, click)
        val router = HomeRouter(navController)
        return HomeViewModel(model, router)
    }
}