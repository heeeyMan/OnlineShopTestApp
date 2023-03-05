package com.example.onlineshop.utils

import android.content.Context
import android.graphics.Color
import android.text.Annotation
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannedString
import android.text.style.ForegroundColorSpan

fun Int.convertDpToInt(context: Context) =
    (this * context.resources.displayMetrics.density).toInt()

fun SpannableString.colorItem(
    title: SpannedString,
    annotationKey: String,
    annotationValue: String
): SpannableString {
    val spannableTitle = SpannableString(title)
    val annotations = title.getSpans(
        ZERO,
        title.length, Annotation::class.java
    )
    val annotation = annotations.find { it.key == annotationKey }
    if (annotation?.value != null) {
        annotations.find { it.value == annotationValue }
        spannableTitle.setSpan(
            ForegroundColorSpan(Color.BLUE),
            title.getSpanStart(annotation),
            title.getSpanEnd(annotation),
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
    return spannableTitle
}
