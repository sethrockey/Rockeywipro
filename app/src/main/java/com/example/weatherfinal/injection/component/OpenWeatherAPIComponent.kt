package com.example.weatherfinal.injection.component

import com.example.weatherfinal.injection.module.OpenWeatherAPIModule
import com.example.weatherfinal.ui.MainPresenter
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(OpenWeatherAPIModule::class))
interface OpenWeatherAPIComponent {
    fun inject(presenter: MainPresenter);
}