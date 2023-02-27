package com.example.testapp.models.profile

import android.content.Context
import com.example.testapp.R
import com.example.testapp.datamodels.ProfileItem
import com.example.testapp.datamodels.groupie_models.ProfileDataModel
import com.xwray.groupie.kotlinandroidextensions.Item

class ProfileModel(private val context: Context) : IProfileModel {
    override fun getProfileList(): List<Item> {
        val tradeStore = ProfileDataModel(
            context,
            ProfileItem(
                iconId = R.drawable.folder,
                fieldNameId = R.string.trade_store,
                price = null,
                imageId = R.drawable.arrow_right
            )
        )
        val paymentMethod = ProfileDataModel(
            context,
            ProfileItem(
                iconId = R.drawable.folder,
                fieldNameId = R.string.payment_method,
                price = null,
                imageId = R.drawable.arrow_right
            )
        )
        val balance = ProfileDataModel(
            context,
            ProfileItem(
                iconId = R.drawable.folder,
                fieldNameId = R.string.trade_store,
                price = "1593",
                imageId = null
            )
        )
        val tradeHistory = ProfileDataModel(
            context,
            ProfileItem(
                iconId = R.drawable.folder,
                fieldNameId = R.string.trade_history,
                price = null,
                imageId = R.drawable.arrow_right
            )
        )
        val restore = ProfileDataModel(
            context,
            ProfileItem(
                iconId = R.drawable.restore_icon,
                fieldNameId = R.string.restore_purchase,
                price = null,
                imageId = R.drawable.arrow_right
            )
        )
        val help = ProfileDataModel(
            context,
            ProfileItem(
                iconId = R.drawable.help,
                fieldNameId = R.string.help,
                price = null,
                imageId = null
            )
        )
        val logOut = ProfileDataModel(
            context,
            ProfileItem(
                iconId = R.drawable.log_out,
                fieldNameId = R.string.log_out,
                price = null,
                imageId = null
            )
        )
        return listOf(
            tradeStore, paymentMethod, balance, tradeHistory, restore, help, logOut
        )
    }
}