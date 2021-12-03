package com.example.networkingandroid.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.networkingandroid.databinding.ActivityMainBinding
import com.example.networkingandroid.ui.adapter.RecyclerViewCoinAdapter
import com.example.networkingandroid.ui.viewmodel.CoinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mViewModel: CoinViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
        configClick()
    }


    private fun configClick() {
        binding.mainActivityButton.setOnClickListener {
            mViewModel.getCoins()
            binding.mainActivityButton.visibility = View.GONE
            binding.mainActivityLayoutRecycler.visibility = View.VISIBLE
        }
    }

    private fun initRecycler() {
        mViewModel.mCoinsLiveData.observe(this, Observer {
            it?.let { coins ->
                binding.mainActivityRecyclerViewCoins.adapter = RecyclerViewCoinAdapter(coins)
            }
        })
    }


}