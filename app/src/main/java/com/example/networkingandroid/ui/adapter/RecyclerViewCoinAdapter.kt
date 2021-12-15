package com.example.networkingandroid.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.networkingandroid.data.model.Coins
import com.example.networkingandroid.databinding.ItemCoinsBinding

class RecyclerViewCoinAdapter :
    RecyclerView.Adapter<RecyclerViewCoinAdapter.RecyclerViewHolder>() {

    private var coins = mutableListOf<Coins>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RecyclerViewHolder(ItemCoinsBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bindView(coins[position])
    }

    override fun getItemCount(): Int {
        return coins.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun atualizaCoins(coins: List<Coins>){
        this.coins.clear()
        this.coins.addAll(coins)
        notifyDataSetChanged()
    }

    inner class RecyclerViewHolder(private val binding: ItemCoinsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(coins: Coins) {
            binding.itemCoinsTxtNameCoin.text = coins.name
            binding.itemCoinsTxtSymbolCoin.text = coins.symbol
        }

    }
}

