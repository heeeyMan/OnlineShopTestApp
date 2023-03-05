package com.example.onlineshop.assemblies.auth

import android.content.Context
import com.example.onlineshop.models.auth.AuthModel
import com.example.onlineshop.routers.auth.AuthRouter
import com.example.onlineshop.ui.modules.auth.AuthViewModel

class AuthAssembly(
    private val context: Context
): IAuthAssembly {
    override fun build(): AuthViewModel {
        val router = AuthRouter(context)
        val model = AuthModel()
        return AuthViewModel(model, router)
    }
}