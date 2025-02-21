package com.faradaii.trezor.core.common.utils

import com.faradaii.trezor.core.data.datasource.remote.response.CoinResponse
import com.faradaii.trezor.core.domain.entities.CoinEntity

object DataMapper {
    fun mapResponsesToLocalModel(input: List<CoinResponse>): List<CoinLocalModel> =
        input.map {
            CoinLocalModel(
                id = it.id,
                symbol = it.symbol,
                name = it.name,
                image = it.image,
                currentPrice = it.marketData?.currentPrice,
                marketCap = it.marketCap,
                marketCapRank = it.marketCapRank,
                fullyDilutedValuation = it.fullyDilutedValuation,
                totalVolume = it.totalVolume,
                high24h = it.high24h,
                low24h = it.low24h,
                priceChange24h = it.priceChange24h,
                priceChangePercentage24h = it.priceChangePercentage24h,
                marketCapChange24h = it.marketCapChange24h,
                marketCapChangePercentage24h = it.marketCapChangePercentage24h,
                circulatingSupply = it.circulatingSupply,
                totalSupply = it.totalSupply,
                maxSupply = it.maxSupply,
                ath = it.ath,
                athChangePercentage = it.athChangePercentage,
                athDate = it.athDate,
                atl = it.atl,
                atlChangePercentage = it.atlChangePercentage,
                atlDate = it.atlDate,
                roi = it.roi,
                lastUpdated = it.lastUpdated
            )
        }

    fun mapLocalModelToEntity(input: List<CoinLocalModel>): List<CoinEntity> =
        input.map {
            CoinEntity(
                id = it.id,
                symbol = it.symbol,
                name = it.name,
                image = it.image,
                currentPrice = it.currentPrice,
                marketCap = it.marketCap,
                marketCapRank = it.marketCapRank,
                fullyDilutedValuation = it.fullyDilutedValuation,
                totalVolume = it.totalVolume,
                high24h = it.high24h,
                low24h = it.low24h,
                priceChange24h = it.priceChange24h,
                priceChangePercentage24h = it.priceChangePercentage24h,
                marketCapChange24h = it.marketCapChange24h,
                marketCapChangePercentage24h = it.marketCapChangePercentage24h,
                circulatingSupply = it.circulatingSupply,
                totalSupply = it.totalSupply,
                maxSupply = it.maxSupply,
                ath = it.ath,
                athChangePercentage = it.athChangePercentage,
                athDate = it.athDate,
                atl = it.atl,
                atlChangePercentage = it.atlChangePercentage,
                atlDate = it.atlDate,
                roi = it.roi,
                lastUpdated = it.lastUpdated
            )
        }

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
        roi = input.roi,
        lastUpdated = input.lastUpdated
    )
}