package com.example.networkingandroid.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkingandroid.data.model.Coins
import com.example.networkingandroid.data.repository.CoinsRepositoryInterface
import kotlinx.coroutines.launch

class CoinViewModel(private val repository: CoinsRepositoryInterface) : ViewModel() {

    val mCoinsLiveData: MutableLiveData<List<Coins>> = MutableLiveData()
    val mErrorGetCoin: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun getCoins(currency: String) {
        isLoading.value = true
        mErrorGetCoin.value = false
        viewModelScope.launch {
            try {
                mCoinsLiveData.value = repository.getList(currency)
            } catch (e: Exception) {
                e.printStackTrace()
                mErrorGetCoin.value = true
            }
            isLoading.value = false
        }
    }
}