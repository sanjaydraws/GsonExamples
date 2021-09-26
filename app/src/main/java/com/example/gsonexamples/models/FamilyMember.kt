package com.example.gsonexamples.models

import com.google.gson.annotations.SerializedName


data class FamilyMember (
    @SerializedName("role")
    val mRole:String?=null,
    @SerializedName("age")
    val mAge:Int?=null
    )