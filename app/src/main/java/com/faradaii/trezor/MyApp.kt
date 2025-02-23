package com.faradaii.trezor

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager
import com.faradaii.trezor.core.common.utils.DarkMode
import com.faradaii.trezor.core.di.databaseModule
import com.faradaii.trezor.core.di.networkModule
import com.faradaii.trezor.core.di.repositoryModule
import com.faradaii.trezor.di.useCaseModule
import com.faradaii.trezor.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.util.Locale

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

        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        preferences.getString(
            getString(R.string.pref_key_dark),
            getString(R.string.pref_dark_follow_system)
        )?.apply {
            val mode = DarkMode.valueOf(this.uppercase(Locale.US))
            AppCompatDelegate.setDefaultNightMode(mode.value)
        }
    }

}