package com.example.weatherfinal.api

import com.example.weatherfinal.data.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherAPI {
    @GET("forecast/daily/")

    fun dailyForecast(
        @Query("q") cityName: String,
        @Query("cnt") dayCount: Int
    ): Call<WeatherResponse>

    companion object {
        val BASE_URL = "http://api.openweathermap.org/data/2.5/"
        val API_KEY ="c0ba07ab8e2ef9fbc73b1660685734a9"
    }
}