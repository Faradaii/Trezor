package com.faradaii.trezor.core.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CoinEntity(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String?,
    val currentPrice: Double?,
    val marketCap: Long?,
    val marketCapRank: Int?,
    val fullyDilutedValuation: Long?,
    val totalVolume: Long?,
    val high24h: Double?,
    val low24h: Double?,
    val priceChange24h: Double?,
    val priceChangePercentage24h: Double?,
    val marketCapChange24h: Long?,
    val marketCapChangePercentage24h: Double?,
    val circulatingSupply: Double?,
    val totalSupply: Double?,
    val maxSupply: Double?,
    val ath: Double?,
    val athChangePercentage: Double?,
    val athDate: String?,
    val atl: Double?,
    val atlChangePercentage: Double?,
    val atlDate: String?,
    val roi: Roi?,
    val lastUpdated: String?,
) : Parcelable

@Parcelize
data class Roi(
    val currency: String?,
    val times: Double?,
    val percentage: Double?,
) : Parcelable