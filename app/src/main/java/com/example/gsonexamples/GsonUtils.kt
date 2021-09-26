package com.example.gsonexamples

import com.example.gsonexamples.models.User
import com.google.gson.Gson

/**
* Created By : Sanjay Prajapat
* Time : 24/09/2021 on 12:23 AM
*
* */


/**
* convert object to json
* @param object type
* @return String json
* */
fun <T> convertToJson( t:T ): String? = Gson().toJson(t)

/**
 * convert json to object
 * @param String json
 * @param T class type
 * @return String json
 * */
fun <T> convertFromJson(json:String?, t:Class<T>):T? = Gson().fromJson(json,t)


/*
* {"user1":{"address":{"firstAddress":"Green Street","secondAddress":"USA"},"age":23,"firstName":"Justin","lastName":" Bieber","numbers":["2345678","9039023"]},"i1":23}
* */
fun <T> mapToJsonStr(map: Map<String?, T>?): String? =  Gson().toJson(map)
