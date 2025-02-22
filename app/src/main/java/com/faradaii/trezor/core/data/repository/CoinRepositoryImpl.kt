package com.faradaii.trezor.core.data.repository

import com.faradaii.trezor.core.common.utils.AppExecutors
import com.faradaii.trezor.core.common.utils.DataMapper
import com.faradaii.trezor.core.common.utils.ResourceState
import com.faradaii.trezor.core.data.NetworkBoundResource
import com.faradaii.trezor.core.data.datasource.local.LocalDataSource
import com.faradaii.trezor.core.data.datasource.remote.RemoteDataSource
import com.faradaii.trezor.core.data.datasource.remote.network.ApiResponse
import com.faradaii.trezor.core.data.datasource.remote.response.CoinResponseItem
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
    override fun getAllCoin(): Flow<ResourceState<List<CoinEntity>>> =
        object : NetworkBoundResource<List<CoinEntity>, List<CoinResponseItem>>() {
            override fun loadFromDB(): Flow<List<CoinEntity>> {
                return localDataSource.getAllCoin().map {
                    DataMapper.mapLocalModelToEntityList(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<CoinResponseItem>>> =
                remoteDataSource.getAllCoin()

            override suspend fun saveCallResult(data: List<CoinResponseItem>) {
                localDataSource.insertCoin(DataMapper.mapResponsesToLocalModelList(data))
            }

            override fun shouldFetch(data: List<CoinEntity>?): Boolean =
                true
        }.asFlow()

    override fun getDetailCoin(id: String): Flow<ResourceState<CoinEntity>> {
        return localDataSource.getDetailCoin(id = id)
            .transform { DataMapper.mapLocalModelToEntity(it) }
    }

    override fun getAllFavoriteCoin(): Flow<List<CoinEntity>> {
        return localDataSource.getAllFavoriteCoin().map {
            DataMapper.mapLocalModelToEntityList(it)
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