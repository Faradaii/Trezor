package com.faradaii.trezor.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.faradaii.trezor.core.domain.usecase.CoinUseCase

class HomeViewModel(coinUseCase: CoinUseCase) : ViewModel() {
    val coin = coinUseCase.getAllCoin().asLiveData().also {
        it.observeForever { result ->
            println("HomeViewModel: Data received -> $result")
        }
    }
}