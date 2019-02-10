package com.example.weatherfinal.ui

import com.example.weatherfinal.api.OpenWeatherAPI
import com.example.weatherfinal.data.ForecastItemViewModel
import com.example.weatherfinal.data.WeatherResponse
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenterTest {
    @Mock
    lateinit var view: MainView

    @InjectMocks
    lateinit var api:OpenWeatherAPI

    @Mock
    lateinit var response: WeatherResponse
    @Mock
    val forecasts = mutableListOf<ForecastItemViewModel>()

    lateinit var presenter: MainPresenter


    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter(view)


    }

    @Test
    fun `get daily forecast test`(){
        presenter.getForecastForFiveDays("London")
    }
}