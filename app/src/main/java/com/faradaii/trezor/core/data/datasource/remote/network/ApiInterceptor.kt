package com.faradaii.trezor.core.data.datasource.remote.network

import com.faradaii.trezor.core.common.constant.Constant
import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val currentUrl = chain.request().url
        val newUrl =
            currentUrl.newBuilder().addQueryParameter("x-cg-demo-api-key", Constant.API_KEY).build()
        val req = chain.request().newBuilder().url(newUrl).build()
        return chain.proceed(req)
    }
}
