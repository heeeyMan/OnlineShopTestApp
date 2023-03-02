package com.example.testapp.utils

import android.content.Context

fun Int.convertDpToInt(context: Context) =
    (this * context.resources.displayMetrics.density).toInt()
