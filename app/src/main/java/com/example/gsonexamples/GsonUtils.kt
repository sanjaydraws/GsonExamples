package com.example.gsonexamples

import com.example.gsonexamples.models.User
import com.google.gson.Gson

/**
* Created By : Sanjay Prajapat
 * Time : 24/09/2021 on 12:23 AM
 *
* */


fun <T> convertToJson( t:T ): String? {
    return Gson().toJson(t)
}
