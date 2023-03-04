package com.example.testapp.assemblies.signin

import android.content.Context
import androidx.navigation.NavController
import com.example.testapp.models.signin.SignInModel
import com.example.testapp.routers.signin.SignInRouter
import com.example.testapp.ui.modules.signin.SignInViewModel

class SignInAssembly(
    private val context: Context,
): ISignInAssembly {
    override fun build(): SignInViewModel {
        val router = SignInRouter()
        val model = SignInModel()
        return SignInViewModel(model, router)
    }
}