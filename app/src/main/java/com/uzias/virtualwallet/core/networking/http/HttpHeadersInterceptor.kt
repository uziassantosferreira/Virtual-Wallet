package com.uzias.virtualwallet.core.http

import okhttp3.Interceptor
import okhttp3.Response

class HttpHeadersInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        return chain!!.proceed(HttpRequestBuilder(chain.request()).build())
    }
}