package com.faradaii.trezor.core.data.datasource.remote.network

import com.faradaii.trezor.core.data.datasource.remote.response.CoinResponse
import com.faradaii.trezor.core.data.datasource.remote.response.ListCoinResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET()
    suspend fun getCoins(): Call<ListCoinResponse>

    @GET()
    suspend fun getCoin(): Call<CoinResponse>
}