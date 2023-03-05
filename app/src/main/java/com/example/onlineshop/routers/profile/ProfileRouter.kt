package com.example.onlineshop.routers.profile

import android.content.Context
import android.content.Intent
import com.example.onlineshop.ui.activities.AuthActivity

class ProfileRouter(private val context: Context) : IProfileRouter {
    override fun backAuthScreen() {
        val intent = Intent(context, AuthActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)
    }
}