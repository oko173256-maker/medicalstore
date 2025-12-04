package com.medicalstore.app.utils.extensions

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible

fun View.show() {
    isVisible = true
}

fun View.hide() {
    isVisible = false
}

fun View.gone() {
    visibility = View.GONE
}

fun View.setDebouncedClickListener(debounceTime: Long = 600L, action: () -> Unit) {
    setOnClickListener {
        isClickable = false
        action()
        postDelayed({ isClickable = true }, debounceTime)
    }
}
