package com.example.testapp.datamodels.enums

import com.example.testapp.R

enum class InputTextState {
    EMPTY,
    INCORRECT_EMAIL,
    CORRECT;

    fun fieldBackground() = when (this) {
        EMPTY, INCORRECT_EMAIL -> R.drawable.auth_field_error_background
        CORRECT -> R.drawable.auth_field_background
    }

    fun errorTextId() = when (this) {
        EMPTY -> R.string.empty_text
        INCORRECT_EMAIL -> R.string.email_no_correct
        CORRECT -> R.string.text_empty
    }

    fun isErrorTextVisible() = when (this) {
        EMPTY, INCORRECT_EMAIL -> true
        CORRECT -> false
    }

    fun isCorrect() = when (this) {
        EMPTY, INCORRECT_EMAIL -> false
        CORRECT -> true
    }

}