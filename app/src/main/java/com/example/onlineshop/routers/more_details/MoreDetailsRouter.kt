package com.example.onlineshop.routers.more_details

import android.content.Context
import android.content.Intent
import androidx.navigation.NavController
import com.example.onlineshop.R
import com.example.onlineshop.ui.modules.more_details.MoreDetailsFragmentDirections
import com.example.onlineshop.utils.SHARE_INTENT_TYPE

class MoreDetailsRouter(
    private val navController: NavController,
    private val context: Context
) : IMoreDetailsRouter {
    override fun openMarket() {
        navController.navigate(MoreDetailsFragmentDirections.actionNavigationMoreToNavigationMarket())
    }

    override fun shareFriends(url: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = SHARE_INTENT_TYPE
        intent.putExtra(Intent.EXTRA_TEXT, url)
        context.startActivity(
            Intent.createChooser(
                intent,
                context.getString(R.string.share_friends)
            )
        )
    }
}