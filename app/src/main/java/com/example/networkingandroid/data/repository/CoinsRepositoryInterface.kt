package com.example.networkingandroid.data.repository

import com.example.networkingandroid.data.model.Coins

interface CoinsRepositoryInterface {

    suspend fun getList(): List<Coins>?
}