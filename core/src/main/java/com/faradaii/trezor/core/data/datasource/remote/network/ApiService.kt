package com.faradaii.trezor.core.data.datasource.remote.network

import com.faradaii.trezor.core.common.constant.Constant
import com.faradaii.trezor.core.data.datasource.remote.response.CoinResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("coins/markets")
    suspend fun getCoins(@Query("vs_currency") vsCurrency: String = Constant.CURRENCY_DEFAULT): List<CoinResponseItem>
}