package com.example.weatherfinal.ui

import android.os.Build
import com.example.weatherfinal.BuildConfig
import com.example.weatherfinal.api.OpenWeatherAPI
import com.example.weatherfinal.data.ForecastDetail
import com.example.weatherfinal.data.ForecastItemViewModel
import com.example.weatherfinal.data.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainPresenter(val view: MainView) {
    @Inject
    lateinit var api: OpenWeatherAPI

    fun getForecastForFiveDays(cityName: String) {
        view.showSpinner()
        api.dailyForecast(cityName, 5).enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                response.body()?.let {
                    //This method will be created in the next step.
                    createListForView(it)
                    view.hideSpinner()
                } ?: view.showErrorToast(ErrorTypes.NO_RESULT_FOUND)
            }

            override fun onFailure(call: Call<WeatherResponse>?, t: Throwable) {
                view.showErrorToast(ErrorTypes.CALL_ERROR)
                t.printStackTrace()
            }
        })
    }
    private fun  createListForView(weatherResponse: WeatherResponse) {
        val forecasts = mutableListOf<ForecastItemViewModel>()
        for (forecastDetail : ForecastDetail in weatherResponse.forecast) {
            val dayTemp = forecastDetail.temperature.dayTemperature
            val forecastItem = ForecastItemViewModel(degreeDay = dayTemp.toString(),
                date = forecastDetail.date,
                icon = forecastDetail.description[0].icon,
                description = forecastDetail.description[0].description)
            forecasts.add(forecastItem)
        }
        view.updateForecast(forecasts)
    }
}