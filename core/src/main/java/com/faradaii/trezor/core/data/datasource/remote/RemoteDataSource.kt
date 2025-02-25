package com.faradaii.trezor.core.data.datasource.remote

import com.faradaii.trezor.core.data.datasource.remote.network.ApiResponse
import com.faradaii.trezor.core.data.datasource.remote.network.ApiService
import com.faradaii.trezor.core.data.datasource.remote.response.CoinResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {
    fun getAllCoin(): Flow<ApiResponse<List<CoinResponseItem>>> {
        return flow {
            try {
                val response = apiService.getCoins()
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

}