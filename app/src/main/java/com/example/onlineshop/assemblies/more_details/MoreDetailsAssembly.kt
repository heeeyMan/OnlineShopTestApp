package com.example.onlineshop.assemblies.more_details

import android.content.Context
import androidx.navigation.NavController
import com.example.onlineshop.models.more_details.MoreDetailsModel
import com.example.onlineshop.routers.more_details.MoreDetailsRouter
import com.example.onlineshop.ui.modules.more_details.MoreDetailsViewModel

class MoreDetailsAssembly(
    private val navController: NavController,
    private val context: Context
) : IMoreDetailsAssembly {
    override fun build(): MoreDetailsViewModel {
        val router = MoreDetailsRouter(navController, context)
        val model = MoreDetailsModel()
        return MoreDetailsViewModel(model, router)
    }
}