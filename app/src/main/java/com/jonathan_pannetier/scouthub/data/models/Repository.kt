package com.jonathan_pannetier.scouthub.data.models

import com.google.gson.annotations.SerializedName

data class Repository(
    val id: Long,
    val name: String,
    val language: String,
    @SerializedName("watchers_count") val watchers: Int
)