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
        currentPrice = input.currentPrice,
        totalVolume = input.totalVolume,
        totalSupply = input.totalSupply,
        lastUpdated = input.lastUpdated
    )

    fun mapLocalModelToEntity(input: CoinLocalModel) = CoinEntity(
        id = input.id,
        symbol = input.symbol,
        name = input.name,
        image = input.image,
        currentPrice = input.currentPrice,
        totalVolume = input.totalVolume,
        totalSupply = input.totalSupply,
        lastUpdated = input.lastUpdated,
        isFavorite = input.isFavorite
    )

    fun mapEntityToLocalModel(input: CoinEntity) = CoinLocalModel(
        id = input.id,
        symbol = input.symbol,
        name = input.name,
        image = input.image,
        currentPrice = input.currentPrice,
        totalVolume = input.totalVolume,
        totalSupply = input.totalSupply,
        lastUpdated = input.lastUpdated
    )
}