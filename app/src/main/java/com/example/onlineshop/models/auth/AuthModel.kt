package com.example.onlineshop.models.auth

import com.example.onlineshop.database.Dependencies.accountRepository
import com.example.onlineshop.datamodels.enums.AccountState
import com.example.onlineshop.datamodels.enums.CurrentPage
import com.example.onlineshop.datamodels.data.AccountData

class AuthModel : IAuthModel {
    override suspend fun getAccountState(
        account: AccountData,
        currentPage: CurrentPage
    ): AccountState {
        val isAvailable = when (currentPage) {
            CurrentPage.LOGIN -> accountRepository.isAccountExist(account)
            CurrentPage.SIGN_IN -> accountRepository.isAccountBusy(account)
        }
        return when {
            isAvailable && currentPage == CurrentPage.LOGIN -> AccountState.ACCOUNT_EXIST
            !isAvailable && currentPage == CurrentPage.SIGN_IN -> AccountState.ACCOUNT_NOT_BUSY
            isAvailable && currentPage == CurrentPage.SIGN_IN -> AccountState.USER_ALREADY_REGISTERED
            else -> AccountState.NO_EXIST
        }
    }

    override suspend fun addAccount(account: AccountData) {
        accountRepository.insertAccount(account)
    }
}