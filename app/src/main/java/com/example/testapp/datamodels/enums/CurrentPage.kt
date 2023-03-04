package com.example.testapp.datamodels.enums

import com.example.testapp.R

enum class CurrentPage {
    LOG_IN,
    SIGN_IN;

    fun headerId(): Int {
        return when(this) {
            LOG_IN -> R.string.welcome_back
            SIGN_IN -> R.string.sign_in
        }
    }

    fun authButtonTextId(): Int {
        return when(this) {
            LOG_IN -> R.string.log_in
            SIGN_IN -> R.string.sign_in
        }
    }

    fun isEmailVisible(): Boolean {
        return when(this) {
            LOG_IN -> false
            SIGN_IN -> true
        }
    }

    fun isOtherSignInVisible(): Boolean {
        return when(this) {
            LOG_IN -> false
            SIGN_IN -> true
        }
    }

    fun iconId(): Int? {
        return when(this) {
            LOG_IN -> R.drawable.eye_off
            SIGN_IN -> null
        }
    }

    fun hintTextId(): Int {
        return when(this) {
            LOG_IN -> R.string.no_account
            SIGN_IN -> R.string.have_account
        }
    }
}