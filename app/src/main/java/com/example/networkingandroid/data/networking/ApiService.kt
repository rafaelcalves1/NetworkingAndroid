package com.example.networkingandroid.data.networking

import com.example.networkingandroid.data.model.Coins
import retrofit2.http.GET

interface ApiService {

    @GET("/events")
    suspend fun getListCoins(): List<Coins>
}