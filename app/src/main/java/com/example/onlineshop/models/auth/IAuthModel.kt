package com.example.onlineshop.models.auth

import com.example.onlineshop.datamodels.enums.AccountState
import com.example.onlineshop.datamodels.enums.CurrentPage
import com.example.onlineshop.datamodels.items.AccountData

interface IAuthModel {
    suspend fun getAccountState(account: AccountData, currentPage: CurrentPage): AccountState
    suspend fun addAccount(account: AccountData)
}