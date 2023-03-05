package com.example.onlineshop.routers.home

import androidx.navigation.NavController
import com.example.onlineshop.ui.modules.home.HomeFragmentDirections

class HomeRouter(private val navController: NavController): IHomeRouter {
    override fun openMoreDetails(id: Int) {
        navController.navigate(HomeFragmentDirections.actionNavigationHomeToNavigationMore(id))
    }
}