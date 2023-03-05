package com.example.testapp.assemblies.auth

import android.content.Context
import com.example.testapp.models.auth.AuthModel
import com.example.testapp.routers.auth.AuthRouter
import com.example.testapp.ui.modules.auth.AuthViewModel
import com.example.testapp.utils.OnProfileItemClickListener

class AuthAssembly(
    private val context: Context
): IAuthAssembly {
    override fun build(): AuthViewModel {
        val router = AuthRouter(context)
        val model = AuthModel()
        return AuthViewModel(model, router)
    }
}