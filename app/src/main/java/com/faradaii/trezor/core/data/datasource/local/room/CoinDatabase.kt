package com.faradaii.trezor.core.data.datasource.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.faradaii.trezor.core.common.constant.Constant
import com.faradaii.trezor.core.data.datasource.local.model.CoinLocalModel

@Database(
    entities = [CoinLocalModel::class],
    version = Constant.DATABASE_VERSION,
    exportSchema = false
)
abstract class CoinDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao
}