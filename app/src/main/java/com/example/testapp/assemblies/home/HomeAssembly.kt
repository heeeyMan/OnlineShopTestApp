package com.example.testapp.assemblies.home

import android.content.Context
import androidx.navigation.NavController
import com.example.testapp.models.home.HomeModel
import com.example.testapp.routers.home.HomeRouter
import com.example.testapp.ui.modules.home.HomeViewModel
import com.example.testapp.utils.OnItemClickedListener

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