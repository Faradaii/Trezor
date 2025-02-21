package com.faradaii.trezor.core.data.repository

import com.faradaii.trezor.core.common.utils.ResourceState
import com.faradaii.trezor.core.domain.entities.CoinEntity
import com.faradaii.trezor.core.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class CoinRepositoryImpl : CoinRepository {
    override fun getAllCoin(): Flow<ResourceState<List<CoinEntity>>> {
        TODO("Not yet implemented")
    }

    override fun getDetailCoin(): Flow<ResourceState<CoinEntity>> {
        TODO("Not yet implemented")
    }

    override fun getFavoriteCoin(): Flow<List<CoinEntity>> {
        TODO("Not yet implemented")
    }

    override fun getFavoriteCoinById(id: String): Flow<CoinEntity> {
        TODO("Not yet implemented")
    }

    override fun setFavoriteCoin(coin: CoinEntity, state: Boolean) {
        TODO("Not yet implemented")
    }
}