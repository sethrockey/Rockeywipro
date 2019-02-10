package com.example.weatherfinal.api

import android.os.Build
import com.example.weatherfinal.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response


class OpenWeatherInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url: HttpUrl = chain.request().url().newBuilder()
            .addQueryParameter("APPID", OpenWeatherAPI.API_KEY)
            .addQueryParameter("mode", "json")
            .addQueryParameter("units", "metric").build()
        return chain.proceed(chain.request().newBuilder().addHeader("Accept", "application/json").url(url).build())

    }


}