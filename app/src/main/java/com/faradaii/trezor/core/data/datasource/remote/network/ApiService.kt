package com.faradaii.trezor.core.data.datasource.remote.network

import com.faradaii.trezor.core.data.datasource.remote.response.CoinResponse
import com.faradaii.trezor.core.data.datasource.remote.response.ListCoinResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("coins/markets")
    suspend fun getCoins(): ListCoinResponse

    @GET("coins/{id}")
    suspend fun getCoin(@Path("id") id: String): CoinResponse
}