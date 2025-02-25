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
    val totalVolume: Long?,
    val totalSupply: Double?,
    val lastUpdated: String?,
    val isFavorite: Boolean,
) : Parcelable