package com.example.networkingandroid.data.repository

import com.example.networkingandroid.data.model.Coins
import com.example.networkingandroid.data.networking.RetrofitService

class CoinsRepositoryImpl(private val retrofitService: RetrofitService) : CoinsRepositoryInterface {

    override suspend fun getList(): List<Coins>? {
        return try {
            retrofitService.service.getListCoins()
        } catch (e: Exception) {
            null
        }
    }
}