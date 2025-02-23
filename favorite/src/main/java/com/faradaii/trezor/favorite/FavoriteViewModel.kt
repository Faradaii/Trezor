package com.faradaii.trezor.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.faradaii.trezor.core.domain.usecase.CoinUseCase

class FavoriteViewModel(coinUseCase: CoinUseCase) : ViewModel() {
    val favoriteCoin = coinUseCase.getAllFavoriteCoin().asLiveData()
}