package com.example.testapp.assemblies.profile

import android.content.Context
import com.example.testapp.models.profile.ProfileModel
import com.example.testapp.routers.profile.ProfileRouter
import com.example.testapp.ui.modules.profile.ProfileViewModel
import com.example.testapp.utils.OnProfileItemClickListener

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