package com.example.networkingandroid.di

import com.example.networkingandroid.ui.viewmodel.CoinViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { CoinViewModel(get()) }
}

