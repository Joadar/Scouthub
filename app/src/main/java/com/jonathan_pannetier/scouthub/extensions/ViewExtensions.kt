package com.jonathan_pannetier.scouthub.extensions

import android.view.View

fun View.visible() {
    if (!this.isVisible())
        visibility = View.VISIBLE
}

fun View.invisible() {
    if (!this.isInvisible())
        visibility = View.INVISIBLE
}

fun View.gone() {
    if (!this.isGone())
        visibility = View.GONE
}

fun View.isVisible() = visibility == View.VISIBLE
fun View.isInvisible() = visibility == View.INVISIBLE
fun View.isGone() = visibility == View.GONE
