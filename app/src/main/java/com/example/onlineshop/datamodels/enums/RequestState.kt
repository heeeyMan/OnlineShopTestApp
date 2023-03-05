package com.example.onlineshop.datamodels.enums

import com.example.onlineshop.R

enum class RequestState {
    CORRECT,
    UNKNOWN_ERROR;

    fun errorTextVisible(): Boolean {
        return when (this) {
            CORRECT -> false
            UNKNOWN_ERROR -> true
        }
    }

    fun messageErrorText(): Int {
        return when (this) {
            CORRECT -> R.string.text_empty
            UNKNOWN_ERROR -> R.string.unknown_error
        }
    }
}