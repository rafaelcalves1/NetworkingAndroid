package com.example.networkingandroid.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.networkingandroid.databinding.ActivityMainBinding
import com.example.networkingandroid.ui.adapter.RecyclerViewCoinAdapter
import com.example.networkingandroid.ui.viewmodel.CoinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: CoinViewModel by viewModel()

    private val adapter = RecyclerViewCoinAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainActivityRecyclerViewCoins.adapter = adapter
        initRecycler()
        configClick()
        showLoading()
        showError()
    }


    private fun configClick() {
        binding.mainActivityButton.setOnClickListener {
            viewModel.getCoins()
            binding.mainActivityButton.visibility = View.GONE
            binding.mainActivityLayoutRecycler.visibility = View.VISIBLE
        }
    }

    private fun initRecycler() {
        viewModel.mCoinsLiveData.observe(this, Observer {
            it?.let { coins ->
                adapter.atualizaCoins(coins)
            }
        })
    }

    private fun showLoading() {
        viewModel.isLoading.observe(this, Observer {
            binding.mainActivityError.root.isVisible = it
        })
    }

    private fun showError() {
        viewModel.mErrorGetCoin.observe(this, Observer {
            binding.mainActivityError.root.isVisible = it
        })
    }
}