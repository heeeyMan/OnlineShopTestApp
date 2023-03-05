package com.example.onlineshop.datamodels.enums

import com.example.onlineshop.R

enum class AccountState {
    USER_ALREADY_REGISTERED,
    NO_EXIST,
    ACCOUNT_EXIST,
    ACCOUNT_NOT_BUSY;

    fun authErrorTextId() = when (this) {
        USER_ALREADY_REGISTERED -> R.string.user_already_registered
        NO_EXIST -> R.string.no_user
        ACCOUNT_NOT_BUSY, ACCOUNT_EXIST -> R.string.text_empty
    }

    fun isAuthErrorVisible(): Boolean = when (this) {
        ACCOUNT_NOT_BUSY, ACCOUNT_EXIST -> false
        NO_EXIST -> true
        USER_ALREADY_REGISTERED -> true
    }
}