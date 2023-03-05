package com.example.testapp.routers.auth

import android.content.Context
import android.content.Intent
import com.example.testapp.ui.activities.MainActivity

class AuthRouter(private val context: Context) : IAuthRouter {

    override fun openMainActivity() {
        val intent = Intent(context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)
    }

}