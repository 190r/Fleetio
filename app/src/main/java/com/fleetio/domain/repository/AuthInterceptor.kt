package com.fleetio.domain.repository

import com.fleetio.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * OkHttp Interceptor to add authentication and account tokens
 */
class AuthInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        requestBuilder.addHeader("Authorization", BuildConfig.AUTH_TOKEN)
        requestBuilder.addHeader("Account-Token", BuildConfig.ACCT_TOKEN)

        return chain.proceed(requestBuilder.build())
    }

}