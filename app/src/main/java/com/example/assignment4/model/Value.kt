package com.example.assignment4.model


import com.google.gson.annotations.SerializedName

//joke
data class Value(
    @SerializedName("categories")//
    val categories: List<String>,
    @SerializedName("id")//id
    val id: Int,
    @SerializedName("joke")//joke
    val joke: String
)