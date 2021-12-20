package com.example.networkingandroid.data.networking

import com.example.networkingandroid.data.model.Coins
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface ApiService {

    @GET("coins/markets")
    suspend fun getListCoins(
        @Query("vs_currency") currency: String
    ): List<Coins>
}