package com.faradaii.trezor.core.di

import androidx.room.Room
import com.faradaii.trezor.core.common.constant.Constant
import com.faradaii.trezor.core.common.utils.AppExecutors
import com.faradaii.trezor.core.data.datasource.local.LocalDataSource
import com.faradaii.trezor.core.data.datasource.local.room.CoinDao
import com.faradaii.trezor.core.data.datasource.local.room.CoinDatabase
import com.faradaii.trezor.core.data.datasource.remote.RemoteDataSource
import com.faradaii.trezor.core.data.datasource.remote.network.ApiConfig
import com.faradaii.trezor.core.data.datasource.remote.network.ApiInterceptor
import com.faradaii.trezor.core.data.datasource.remote.network.ApiService
import com.faradaii.trezor.core.data.repository.CoinRepositoryImpl
import com.faradaii.trezor.core.domain.repository.CoinRepository
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("faradaii".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            CoinDatabase::class.java, Constant.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
    factory { get<CoinDatabase>().coinDao() }
}

val networkModule = module {
    single {
        ApiInterceptor()
    }
    single {
        ApiConfig.provideOkHttpClient(get<ApiInterceptor>())
    }
    single {
        ApiConfig.provideApiService(get<OkHttpClient>())
    }
}

val repositoryModule = module {
    single { LocalDataSource(get<CoinDao>()) }
    single { RemoteDataSource(get<ApiService>()) }
    single { AppExecutors() }
    single<CoinRepository> { CoinRepositoryImpl(get(), get(), get()) }
}
