package com.example.testapp.datamodels.enums

import android.text.InputType
import android.view.View
import com.example.testapp.R
import com.example.testapp.utils.ANNOTATION_VALUE_LOGIN
import com.example.testapp.utils.ANNOTATION_VALUE_SIGN_IN
import com.example.testapp.utils.ZERO

enum class CurrentPage {
    LOG_IN,
    SIGN_IN;

    fun headerId() = when (this) {
        LOG_IN -> R.string.welcome_back
        SIGN_IN -> R.string.sign_in
    }

    fun authButtonTextId() = when (this) {
        LOG_IN -> R.string.log_in
        SIGN_IN -> R.string.sign_in
    }

    fun hintId() = when (this) {
        LOG_IN -> R.string.password
        SIGN_IN -> R.string.last_name
    }

    fun emailVisibility() = when (this) {
        LOG_IN -> View.INVISIBLE
        SIGN_IN -> View.VISIBLE
    }

    fun secondFieldType() = when (this) {
        LOG_IN -> InputType.TYPE_CLASS_TEXT + InputType.TYPE_TEXT_VARIATION_PASSWORD
        SIGN_IN -> InputType.TYPE_CLASS_TEXT
    }

    fun isOtherSignInVisible() = when (this) {
        LOG_IN -> false
        SIGN_IN -> true
    }

    fun iconId() = when (this) {
        LOG_IN -> R.drawable.eye_off
        SIGN_IN -> ZERO
    }

    fun hintTextId() = when (this) {
        LOG_IN -> R.string.no_account
        SIGN_IN -> R.string.have_account
    }

    fun annotationValue() = when (this) {
        LOG_IN -> ANNOTATION_VALUE_LOGIN
        SIGN_IN -> ANNOTATION_VALUE_SIGN_IN
    }
}