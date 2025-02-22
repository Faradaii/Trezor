package com.faradaii.trezor.core.data.datasource.remote

import com.faradaii.trezor.core.data.datasource.remote.network.ApiResponse
import com.faradaii.trezor.core.data.datasource.remote.network.ApiService
import com.faradaii.trezor.core.data.datasource.remote.response.CoinResponse
import com.faradaii.trezor.core.data.datasource.remote.response.CoinResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getAllCoin(): Flow<ApiResponse<List<CoinResponseItem>>> {
        return flow {
            try {
                val response = apiService.getCoins()
                val data = response.listCoinResponse
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(response.listCoinResponse))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getDetailCoin(id: String): Flow<ApiResponse<CoinResponse>> {
        return flow {
            try {
                val response = apiService.getCoin(id = id)
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}