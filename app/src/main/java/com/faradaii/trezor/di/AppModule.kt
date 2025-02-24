package com.faradaii.trezor.di

import com.faradaii.trezor.core.domain.usecase.CoinInteractor
import com.faradaii.trezor.core.domain.usecase.CoinUseCase
import com.faradaii.trezor.detail.DetailViewModel
import com.faradaii.trezor.home.HomeViewModel
import org.koin.dsl.module


val useCaseModule = module {
    single<CoinUseCase> { CoinInteractor(get()) }
}

val viewModelModule = module {
    single { DetailViewModel(get()) }
    single { HomeViewModel(get()) }
}