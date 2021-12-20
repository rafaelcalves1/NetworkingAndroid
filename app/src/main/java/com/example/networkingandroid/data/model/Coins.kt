package com.example.networkingandroid.data.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Coins(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String
)