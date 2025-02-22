package com.faradaii.trezor.core.common.utils

import com.faradaii.trezor.core.data.datasource.local.model.CoinLocalModel
import com.faradaii.trezor.core.data.datasource.remote.response.CoinResponseItem
import com.faradaii.trezor.core.domain.entities.CoinEntity

object DataMapper {
    fun mapResponsesToLocalModelList(input: List<CoinResponseItem>): List<CoinLocalModel> =
        input.map {
            mapResponsesToLocalModel(input = it)
        }

    fun mapLocalModelToEntityList(input: List<CoinLocalModel>): List<CoinEntity> =
        input.map {
            mapLocalModelToEntity(input = it)
        }

    private fun mapResponsesToLocalModel(input: CoinResponseItem): CoinLocalModel = CoinLocalModel(
        id = input.id ?: "",
        symbol = input.symbol ?: "",
        name = input.name ?: "",
        image = input.image,
        currentPrice = input.currentPrice?.toDouble(),
        marketCap = input.marketCap,
        marketCapRank = input.marketCapRank,
        fullyDilutedValuation = input.fullyDilutedValuation,
        totalVolume = input.totalVolume,
        high24h = input.high24h?.toDouble(),
        low24h = input.low24h?.toDouble(),
        priceChange24h = input.priceChange24h,
        priceChangePercentage24h = input.priceChangePercentage24h,
        marketCapChange24h = input.marketCapChange24h,
        marketCapChangePercentage24h = input.marketCapChangePercentage24h,
        circulatingSupply = input.circulatingSupply?.toDouble(),
        totalSupply = input.totalSupply?.toDouble(),
        maxSupply = input.maxSupply?.toDouble(),
        ath = input.ath?.toDouble(),
        athChangePercentage = input.athChangePercentage,
        athDate = input.athDate,
        atl = input.atl,
        atlChangePercentage = input.atlChangePercentage,
        atlDate = input.atlDate,
        lastUpdated = input.lastUpdated
    )

    fun mapLocalModelToEntity(input: CoinLocalModel) = CoinEntity(
        id = input.id,
        symbol = input.symbol,
        name = input.name,
        image = input.image,
        currentPrice = input.currentPrice,
        marketCap = input.marketCap,
        marketCapRank = input.marketCapRank,
        fullyDilutedValuation = input.fullyDilutedValuation,
        totalVolume = input.totalVolume,
        high24h = input.high24h,
        low24h = input.low24h,
        priceChange24h = input.priceChange24h,
        priceChangePercentage24h = input.priceChangePercentage24h,
        marketCapChange24h = input.marketCapChange24h,
        marketCapChangePercentage24h = input.marketCapChangePercentage24h,
        circulatingSupply = input.circulatingSupply,
        totalSupply = input.totalSupply,
        maxSupply = input.maxSupply,
        ath = input.ath,
        athChangePercentage = input.athChangePercentage,
        athDate = input.athDate,
        atl = input.atl,
        atlChangePercentage = input.atlChangePercentage,
        atlDate = input.atlDate,
        lastUpdated = input.lastUpdated
    )

    fun mapEntityToLocalModel(input: CoinEntity) = CoinLocalModel(
        id = input.id,
        symbol = input.symbol,
        name = input.name,
        image = input.image,
        currentPrice = input.currentPrice,
        marketCap = input.marketCap,
        marketCapRank = input.marketCapRank,
        fullyDilutedValuation = input.fullyDilutedValuation,
        totalVolume = input.totalVolume,
        high24h = input.high24h,
        low24h = input.low24h,
        priceChange24h = input.priceChange24h,
        priceChangePercentage24h = input.priceChangePercentage24h,
        marketCapChange24h = input.marketCapChange24h,
        marketCapChangePercentage24h = input.marketCapChangePercentage24h,
        circulatingSupply = input.circulatingSupply,
        totalSupply = input.totalSupply,
        maxSupply = input.maxSupply,
        ath = input.ath,
        athChangePercentage = input.athChangePercentage,
        athDate = input.athDate,
        atl = input.atl,
        atlChangePercentage = input.atlChangePercentage,
        atlDate = input.atlDate,
        lastUpdated = input.lastUpdated
    )
}