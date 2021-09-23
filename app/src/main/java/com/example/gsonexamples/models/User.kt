package com.example.gsonexamples.models


data class User(
    val firstName:String?=null,
    val lastName:String? = null,
    val age:Int? = null ,
    val address: Address? = null,
    val numbers:List<String>? = null
)


