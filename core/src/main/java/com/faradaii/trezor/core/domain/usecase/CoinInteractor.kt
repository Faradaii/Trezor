package com.faradaii.trezor.core.domain.usecase

import com.faradaii.trezor.core.domain.entities.CoinEntity
import com.faradaii.trezor.core.domain.repository.CoinRepository

class CoinInteractor(private val coinRepository: CoinRepository): CoinUseCase {
    override fun getAllCoin() = coinRepository.getAllCoin()

    override fun getDetailCoin(id: String) = coinRepository.getDetailCoin(id = id)

    override fun getAllFavoriteCoin() = coinRepository.getAllFavoriteCoin()

    override fun getFavoriteCoinById(id: String) = coinRepository.getFavoriteCoinById(id = id)

    override fun setFavoriteCoin(coin: CoinEntity, state: Boolean) = coinRepository.setFavoriteCoin(coin = coin, state = state)
}