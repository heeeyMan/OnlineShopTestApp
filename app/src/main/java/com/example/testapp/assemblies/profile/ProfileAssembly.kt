package com.example.testapp.assemblies.profile

import android.content.Context
import com.example.testapp.models.profile.ProfileModel
import com.example.testapp.ui.modules.profile.ProfileViewModel

class ProfileAssembly(
    private val context: Context
) : IProfileAssembly {
    override fun build(): ProfileViewModel {
        val model = ProfileModel(context)
        return ProfileViewModel(model)
    }
}