package com.tufyx.networkingsample.ow_service

import com.tufyx.networking.service.IBaseService

interface IOpenWeatherService : IBaseService {

    fun getWeatherByCity(city: String)

    fun setDelegate(delegate: IOWDelegate)

}
