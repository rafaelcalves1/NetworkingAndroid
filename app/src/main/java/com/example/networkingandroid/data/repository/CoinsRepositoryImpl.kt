package com.example.networkingandroid.data.repository

import com.example.networkingandroid.data.model.Coins
import com.example.networkingandroid.data.networking.RetrofitService

class CoinsRepositoryImpl(private val retrofitService: RetrofitService) : CoinsRepositoryInterface {

    override suspend fun getList(currency: String): List<Coins>? {
        return try {
            retrofitService.apiService.getListCoins(currency)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}