package com.example.testapp.assemblies.home

import android.content.Context
import androidx.navigation.NavController
import com.example.testapp.models.home.HomeModel
import com.example.testapp.routers.HomeRouter
import com.example.testapp.ui.home.HomeViewModel

class HomeAssembly(
    private val context: Context,
    private val navController: NavController
): IHomeAssembly {
    override fun build(): HomeViewModel {
        val model = HomeModel(context)
        val router = HomeRouter(navController)
        return HomeViewModel(model, router)
    }
}