package com.example.weatherfinal.ui

import com.example.weatherfinal.data.ForecastItemViewModel

interface MainView {
    fun showSpinner()
    fun hideSpinner()
    fun updateForecast(forecasts: List<ForecastItemViewModel>)
    fun showErrorToast(errorType: ErrorTypes)
}