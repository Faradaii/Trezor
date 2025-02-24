package com.faradaii.trezor.core.data.datasource.remote.network

import com.faradaii.trezor.core.common.constant.Constant
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiConfig {
    fun provideOkHttpClient(apiInterceptor: ApiInterceptor): OkHttpClient {
        val certificatePinner = CertificatePinner.Builder()
            .add(
                Constant.API_BASE_URL_CERTIFICATE,
                "sha256/mjn+Ebun2uqk7tsbSp60Eu72RNDbXJCTsUj+bZs2tWs="
            )
            .add(
                Constant.API_BASE_URL_CERTIFICATE,
                "sha256/bdrBhpj38ffhxpubzkINl0rG+UyossdhcBYj+Zx2fcc="
            )
            .add(
                Constant.API_BASE_URL_CERTIFICATE,
                "sha256/rN8Nekvur6PlgOlNuzfCZxCXFGY/7nubD2emYw0kIW4="
            )
            .build()
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(apiInterceptor)
            .certificatePinner(certificatePinner)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(200, TimeUnit.SECONDS)
            .build()
    }

    fun provideApiService(okHttpClient: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit.create(ApiService::class.java)
    }
}