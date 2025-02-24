package com.faradaii.trezor.core.data

import com.faradaii.trezor.core.common.utils.ResourceState
import com.faradaii.trezor.core.data.datasource.remote.network.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class NetworkBoundResource<ResultType, RequestType> {
    private var result: Flow<ResourceState<ResultType>> = flow {
        emit(ResourceState.Loading())

        val dbSource = loadFromDB().first()
        if (shouldFetch(dbSource)) {
            emit(ResourceState.Loading())

            when (val apiResponse = createCall().first()) {
                is ApiResponse.Success -> {
                    print("SAVE CALL API SUCCESS")
                    saveCallResult(apiResponse.data)
                    emitAll(loadFromDB().map { ResourceState.Success(it) })
                }

                is ApiResponse.Empty -> {
                    print("LOAD DB API EMPTY")
                    emitAll(loadFromDB().map { ResourceState.Success(it) })
                }

                is ApiResponse.Error -> {
                    print("ERROR API ERROR, ${apiResponse.errorMessage}")
                    emit(ResourceState.Error(apiResponse.errorMessage))
                }
            }
        } else {
            emitAll(loadFromDB().map { ResourceState.Success(it) })
        }
    }

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<ResourceState<ResultType>> = result
}