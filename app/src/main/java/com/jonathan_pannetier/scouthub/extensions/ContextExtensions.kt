package com.jonathan_pannetier.scouthub.extensions

import android.content.Context
import android.widget.Toast


fun Context.toast(message: CharSequence, length: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, length).show()