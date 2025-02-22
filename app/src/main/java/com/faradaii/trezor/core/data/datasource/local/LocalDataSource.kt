package com.faradaii.trezor.core.data.datasource.local

import com.faradaii.trezor.core.data.datasource.local.model.CoinLocalModel
import com.faradaii.trezor.core.data.datasource.local.room.CoinDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val coinDao: CoinDao) {
    fun getAllCoin(): Flow<List<CoinLocalModel>> = coinDao.getAllCoin()

    fun getDetailCoin(id: String): Flow<CoinLocalModel> = coinDao.getDetailCoin(id = id)

    fun getAllFavoriteCoin(): Flow<List<CoinLocalModel>> = coinDao.getAllFavoriteCoin()

    fun getFavoriteCoinById(id: String): Flow<CoinLocalModel> = coinDao.getFavoriteCoinById(id = id)

    fun setFavoriteCoin(coin: CoinLocalModel, newState: Boolean) {
        coin.isFavorite = newState
        coinDao.updateCoin(coin = coin)
    }

    suspend fun insertCoin(coins: List<CoinLocalModel>) = coinDao.insertCoin(coins = coins)
}