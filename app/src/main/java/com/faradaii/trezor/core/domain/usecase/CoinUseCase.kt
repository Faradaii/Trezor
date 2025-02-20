package com.faradaii.trezor.core.domain.usecase

import com.faradaii.trezor.core.common.utils.ResourceState
import com.faradaii.trezor.core.domain.entities.CoinEntity
import kotlinx.coroutines.flow.Flow

interface CoinUseCase {
    fun getAllCoin(): Flow<ResourceState<List<CoinEntity>>>
    fun getDetailCoin(): Flow<ResourceState<CoinEntity>>
    fun getFavoriteCoin(): Flow<List<CoinEntity>>
    fun getFavoriteCoinById(id: String): Flow<CoinEntity>
    fun setFavoriteCoin(coin: CoinEntity, state: Boolean)
}