package com.example.onlineshop.models.profile

import android.content.Context
import com.example.onlineshop.R
import com.example.onlineshop.database.Dependencies.accountRepository
import com.example.onlineshop.datamodels.enums.ProfileItemType
import com.example.onlineshop.datamodels.items.ProfileItem
import com.example.onlineshop.ui.adapters.ProfileDataModel
import com.example.onlineshop.utils.OnProfileItemClickListener
import com.xwray.groupie.kotlinandroidextensions.Item

class ProfileModel(
    private val context: Context,
    private val click: OnProfileItemClickListener
) : IProfileModel {

    override suspend fun getFullName(): String {
        val fullName = accountRepository.getFullName()
        return "${fullName.first} ${fullName.second}"
    }

    override fun getProfileList(): List<Item> {
        val tradeStore = ProfileDataModel(
            context,
            ProfileItem(
                iconId = R.drawable.folder,
                fieldNameId = R.string.trade_store,
                price = null,
                imageId = R.drawable.arrow_right,
                typeItem = ProfileItemType.TRADE_STORE
            ),
            click
        )

        val paymentMethod = ProfileDataModel(
            context,
            ProfileItem(
                iconId = R.drawable.folder,
                fieldNameId = R.string.payment_method,
                price = null,
                imageId = R.drawable.arrow_right,
                typeItem = ProfileItemType.PAYMENT_METHOD
            ),
            click
        )

        val balance = ProfileDataModel(
            context,
            ProfileItem(
                iconId = R.drawable.folder,
                fieldNameId = R.string.balance,
                price = "1593",
                imageId = null,
                typeItem = ProfileItemType.BALANCE
            ),
            click
        )

        val tradeHistory = ProfileDataModel(
            context,
            ProfileItem(
                iconId = R.drawable.folder,
                fieldNameId = R.string.trade_history,
                price = null,
                imageId = R.drawable.arrow_right,
                typeItem = ProfileItemType.TRADE_HISTORY
            ),
            click
        )

        val restore = ProfileDataModel(
            context,
            ProfileItem(
                iconId = R.drawable.restore_icon,
                fieldNameId = R.string.restore_purchase,
                price = null,
                imageId = R.drawable.arrow_right,
                typeItem = ProfileItemType.RESTORE_PURCHASE
            ),
            click
        )

        val help = ProfileDataModel(
            context,
            ProfileItem(
                iconId = R.drawable.help,
                fieldNameId = R.string.help,
                price = null,
                imageId = null,
                typeItem = ProfileItemType.HELP
            ),
            click
        )

        val logOut = ProfileDataModel(
            context,
            ProfileItem(
                iconId = R.drawable.log_out,
                fieldNameId = R.string.log_out,
                price = null,
                imageId = null,
                typeItem = ProfileItemType.LOG_OUT
            ),
            click
        )

        return listOf(
            tradeStore, paymentMethod,
            balance, tradeHistory, restore,
            help, logOut
        )
    }
}