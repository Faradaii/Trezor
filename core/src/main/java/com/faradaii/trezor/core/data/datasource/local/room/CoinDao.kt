package com.faradaii.trezor.core.data.datasource.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.faradaii.trezor.core.data.datasource.local.model.CoinLocalModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinDao {

    @Query("SELECT * FROM coin")
    fun getAllCoin(): Flow<List<CoinLocalModel>>

    @Query("SELECT * FROM coin WHERE id = :id")
    fun getDetailCoin(id: String): Flow<CoinLocalModel>

    @Query("SELECT * FROM coin WHERE isFavorite = 1")
    fun getAllFavoriteCoin(): Flow<List<CoinLocalModel>>

    @Query("SELECT * FROM coin WHERE id = :id")
    fun getFavoriteCoinById(id: String): Flow<CoinLocalModel>

    @Update
    fun updateCoin(coin: CoinLocalModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoin(coins: List<CoinLocalModel>)
}