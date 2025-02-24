package com.faradaii.trezor.core.data.datasource.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coin")
class CoinLocalModel(
    @PrimaryKey val id: String,

    @ColumnInfo(name = "symbol") val symbol: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: String?,
    @ColumnInfo(name = "current_price") val currentPrice: Double?,
    @ColumnInfo(name = "total_volume") val totalVolume: Long?,
    @ColumnInfo(name = "total_supply") val totalSupply: Double?,
    @ColumnInfo(name = "last_updated") val lastUpdated: String?,

    @ColumnInfo(name = "isFavorite") var isFavorite: Boolean = false,
)