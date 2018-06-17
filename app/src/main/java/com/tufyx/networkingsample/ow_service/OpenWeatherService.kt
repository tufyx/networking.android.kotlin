package com.tufyx.networkingsample.ow_service

import android.util.Log

import com.tufyx.networking.service.BaseService
import com.tufyx.networkingsample.models.OWCity

import java.util.HashMap

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class OpenWeatherService(retrofit: Retrofit, retrofitService: IRetrofitOpenWeatherService, private val mAPIKey: String) : BaseService<IRetrofitOpenWeatherService>(retrofit, retrofitService), IOpenWeatherService {

    private var mDelegate: IOWDelegate? = null

    override fun setDelegate(delegate: IOWDelegate) {
        mDelegate = delegate
    }

    override fun getWeatherByCity(city: String) {
        val params = HashMap<String, String>()
        params["q"] = city
        params["appId"] = mAPIKey
        mService.getWeatherForCity(params).enqueue(object : Callback<OWCity> {
            override fun onResponse(call: Call<OWCity>, response: Response<OWCity>) {
                if (response.isSuccessful()) {
                    Log.d("tufyx", "response >> " + response.raw().toString())
                    mDelegate?.didReceiveData(response.body())
                    return
                }

                mDelegate?.didReceiveError()
            }

            override fun onFailure(call: Call<OWCity>, t: Throwable) {
                mDelegate?.didReceiveError()
            }
        })
    }

}
