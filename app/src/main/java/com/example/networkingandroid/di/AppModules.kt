package com.example.networkingandroid.di

import com.example.networkingandroid.data.networking.RetrofitService
import com.example.networkingandroid.data.repository.CoinsRepositoryImpl
import com.example.networkingandroid.data.repository.CoinsRepositoryInterface
import org.koin.dsl.module

val service = module {
    factory { RetrofitService() }
    factory<CoinsRepositoryInterface> { CoinsRepositoryImpl(get()) }
}


val appModules = listOf(
    service,
    uiModule
)