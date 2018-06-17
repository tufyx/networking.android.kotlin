package com.tufyx.networkingsample.ow_service

import com.tufyx.networkingsample.models.OWCity

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface IRetrofitOpenWeatherService {

    @GET(OWEndpoints.Weather)
    fun getWeatherForCity(@QueryMap params: Map<String, String>): Call<OWCity>

}
