package com.faradaii.trezor

import android.app.Application
import com.faradaii.trezor.core.di.databaseModule
import com.faradaii.trezor.core.di.networkModule
import com.faradaii.trezor.core.di.repositoryModule
import com.faradaii.trezor.core.di.useCaseModule
import com.faradaii.trezor.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                )
            )
        }
    }

}