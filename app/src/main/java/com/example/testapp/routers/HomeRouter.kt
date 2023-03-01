package com.example.testapp.routers

import androidx.navigation.NavController
import com.example.testapp.ui.home.HomeFragmentDirections

class HomeRouter(private val navController: NavController): IHomeRouter {
    override fun openMoreDetails() {
        navController.navigate(HomeFragmentDirections.actionNavigationHomeToNavigationMore())
    }
}