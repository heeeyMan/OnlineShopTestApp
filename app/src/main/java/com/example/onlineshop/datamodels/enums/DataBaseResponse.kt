package com.example.onlineshop.datamodels.enums

import com.example.onlineshop.R

enum class DataBaseResponse {
    DATA_BASE_ERROR,
    CORRECT;

    fun authErrorTextId() = when (this) {
        DATA_BASE_ERROR -> R.string.database_error
        CORRECT -> R.string.text_empty
    }

    fun isAuthErrorVisible() = when (this) {
        CORRECT -> false
        DATA_BASE_ERROR -> true
    }
}