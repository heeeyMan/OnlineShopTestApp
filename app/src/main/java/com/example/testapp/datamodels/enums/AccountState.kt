package com.example.testapp.datamodels.enums

import com.example.testapp.R

enum class AccountState {
    USER_ALREADY_REGISTERED,
    NO_USER,
    CORRECT;

    fun authErrorTextId() = when (this) {
        USER_ALREADY_REGISTERED -> R.string.user_already_registered
        NO_USER -> R.string.no_user
        CORRECT -> R.string.text_empty
    }

    fun isAuthErrorVisible() = when (this) {
        CORRECT -> false
        USER_ALREADY_REGISTERED, NO_USER -> true
    }
}