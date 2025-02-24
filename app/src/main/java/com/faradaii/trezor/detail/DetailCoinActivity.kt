package com.faradaii.trezor.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat.getParcelableExtra
import com.faradaii.trezor.R
import com.faradaii.trezor.core.common.utils.DateFormatter
import com.faradaii.trezor.core.common.utils.loadImage
import com.faradaii.trezor.core.domain.entities.CoinEntity
import com.faradaii.trezor.databinding.ActivityDetailCoinBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.faradaii.trezor.core.R as coreR

class DetailCoinActivity : AppCompatActivity() {

    private val detailCoinViewModel: DetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailCoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailCoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailCoin = getParcelableExtra(intent, EXTRA_DATA, CoinEntity::class.java)
        showDetail(detailCoin)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
    }

    private fun showDetail(detailCoin: CoinEntity?) {
        detailCoin?.let {
            supportActionBar?.title = detailCoin.name

            var statusFavorite = detailCoin.isFavorite
            setStatusFavorite(statusFavorite)

            binding.apply {
                content.tvDetailName?.text = detailCoin.name
                content.tvDetailSymbol?.text = detailCoin.symbol
                content.tvDetailCurrentPrice?.text =
                    getString(coreR.string.currency, detailCoin.currentPrice.toString())
                content.tvDetailTotalSupply?.text = detailCoin.totalSupply.toString()
                content.tvDetailLastUpdate?.text =
                    DateFormatter.formatIsoDate(detailCoin.lastUpdated ?: "")
                content.tvDetailTotalVolume?.text = detailCoin.totalVolume.toString()
                ivCoinLogo.loadImage(url = detailCoin.image)

                fab.setOnClickListener {
                    statusFavorite = !statusFavorite
                    detailCoinViewModel.setFavoriteCoin(detailCoin, statusFavorite)
                    setStatusFavorite(statusFavorite)
                }
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        binding.fab.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                if (statusFavorite) R.drawable.ic_bookmark_white else R.drawable.ic_not_bookmark_white
            )
        )
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}