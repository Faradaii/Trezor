package com.faradaii.trezor.core.data.repository

import com.faradaii.trezor.core.common.utils.AppExecutors
import com.faradaii.trezor.core.common.utils.DataMapper
import com.faradaii.trezor.core.common.utils.ResourceState
import com.faradaii.trezor.core.data.datasource.local.LocalDataSource
import com.faradaii.trezor.core.data.datasource.remote.RemoteDataSource
import com.faradaii.trezor.core.domain.entities.CoinEntity
import com.faradaii.trezor.core.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform

class CoinRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val appExecutors: AppExecutors,
) : CoinRepository {
    override fun getAllCoin(): Flow<ResourceState<List<CoinEntity>>> {

    }

    override fun getDetailCoin(): Flow<ResourceState<CoinEntity>> {
        TODO("Not yet implemented")
    }

    override fun getAllFavoriteCoin(): Flow<List<CoinEntity>> {
        return localDataSource.getAllFavoriteCoin().map {
            DataMapper.mapLocalModelToEntity(it)
        }
    }

    override fun getFavoriteCoinById(id: String): Flow<CoinEntity> {
        return localDataSource.getFavoriteCoinById(id = id)
            .transform { DataMapper.mapLocalModelToEntity(it) }
    }

    override fun setFavoriteCoin(coin: CoinEntity, state: Boolean) {
        val newCoin = DataMapper.mapEntityToLocalModel(coin)
        appExecutors.diskIO().execute { localDataSource.setFavoriteCoin(newCoin, state) }
    }
}