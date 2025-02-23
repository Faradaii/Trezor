package com.faradaii.trezor.detail

import androidx.lifecycle.ViewModel
import com.faradaii.trezor.core.domain.entities.CoinEntity
import com.faradaii.trezor.core.domain.usecase.CoinUseCase

class DetailViewModel(private val coinUseCase: CoinUseCase) : ViewModel() {
    fun setFavoriteCoin(coin: CoinEntity, state: Boolean) = coinUseCase.setFavoriteCoin(coin, state)
}