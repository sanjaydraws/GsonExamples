package com.example.gsonexamples.models

import androidx.annotation.Keep
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName


@Keep
data class BaseApiModel (
    @SerializedName("status")
    var status: Int? = 0,

    @SerializedName("message")
    var message: String? = "",

    @SerializedName("data")
    var data : JsonElement? = null
)