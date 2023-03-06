package com.example.onlineshop.datamodels.enums

import com.example.onlineshop.R

enum class RequestState {
    CORRECT,
    NOT_FOUND,
    NO_INTERNET,
    SERVER_ERROR,
    CLIENT_ERROR,
    UNKNOWN_ERROR;

    fun errorTextVisible(): Boolean {
        return when (this) {
            CORRECT -> false
            NOT_FOUND, NO_INTERNET, SERVER_ERROR,
            UNKNOWN_ERROR, CLIENT_ERROR -> true
        }
    }

    fun messageErrorText(): Int {
        return when (this) {
            CORRECT -> R.string.text_empty
            NOT_FOUND -> R.string.not_found
            NO_INTERNET -> R.string.no_internet
            SERVER_ERROR -> R.string.server_error
            CLIENT_ERROR -> R.string.client_error
            UNKNOWN_ERROR -> R.string.unknown_error
        }
    }

    fun tryAgainButtonVisible(): Boolean {
        return when (this) {
            CORRECT, NOT_FOUND, SERVER_ERROR, UNKNOWN_ERROR, CLIENT_ERROR -> false
            NO_INTERNET -> true
        }
    }
}