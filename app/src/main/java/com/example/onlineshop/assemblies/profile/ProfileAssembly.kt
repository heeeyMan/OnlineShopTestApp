package com.example.onlineshop.assemblies.profile

import android.content.Context
import com.example.onlineshop.models.profile.ProfileModel
import com.example.onlineshop.routers.profile.ProfileRouter
import com.example.onlineshop.ui.modules.profile.ProfileViewModel
import com.example.onlineshop.utils.OnProfileItemClickListener

class ProfileAssembly(
    private val context: Context,
    private val click: OnProfileItemClickListener
) : IProfileAssembly {
    override fun build(): ProfileViewModel {
        val router = ProfileRouter(context)
        val model = ProfileModel(context, click)
        return ProfileViewModel(model, router)
    }
}