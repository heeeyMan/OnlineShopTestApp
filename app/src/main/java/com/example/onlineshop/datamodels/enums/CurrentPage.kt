package com.example.onlineshop.datamodels.enums

import android.text.InputType
import android.view.View
import com.example.onlineshop.R
import com.example.onlineshop.utils.ANNOTATION_VALUE_LOGIN
import com.example.onlineshop.utils.ANNOTATION_VALUE_SIGN_IN
import com.example.onlineshop.utils.ZERO

enum class CurrentPage {
    LOGIN,
    SIGN_IN;

    fun headerId() = when (this) {
        LOGIN -> R.string.welcome_back
        SIGN_IN -> R.string.sign_in
    }

    fun authButtonTextId() = when (this) {
        LOGIN -> R.string.log_in
        SIGN_IN -> R.string.sign_in
    }

    fun hintId() = when (this) {
        LOGIN -> R.string.password
        SIGN_IN -> R.string.last_name
    }

    fun emailVisibility() = when (this) {
        LOGIN -> View.INVISIBLE
        SIGN_IN -> View.VISIBLE
    }

    fun inputType() = when (this) {
        LOGIN -> InputType.TYPE_CLASS_TEXT + InputType.TYPE_TEXT_VARIATION_PASSWORD
        SIGN_IN -> InputType.TYPE_CLASS_TEXT
    }

    fun isOtherSignInVisible() = when (this) {
        LOGIN -> false
        SIGN_IN -> true
    }

    fun iconId() = when (this) {
        LOGIN -> R.drawable.eye_off
        SIGN_IN -> ZERO
    }

    fun hintTextId() = when (this) {
        LOGIN -> R.string.no_account
        SIGN_IN -> R.string.have_account
    }

    fun annotationValue() = when (this) {
        LOGIN -> ANNOTATION_VALUE_LOGIN
        SIGN_IN -> ANNOTATION_VALUE_SIGN_IN
    }
}