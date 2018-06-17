package com.tufyx.networkingsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.tufyx.networkingsample.models.OWCity
import com.tufyx.networking.NetworkingFactory
import com.tufyx.networkingsample.ow_service.IOWDelegate
import com.tufyx.networkingsample.ow_service.IOpenWeatherService
import com.tufyx.networkingsample.ow_service.IRetrofitOpenWeatherService
import com.tufyx.networkingsample.ow_service.OpenWeatherService
import kotlin.jvm.java

class MainActivity : AppCompatActivity(), IOWDelegate {

    private var service: IOpenWeatherService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val builder = NetworkingFactory.getBuilder("http://api.openweathermap.org/data/2.5/")
        val level = NetworkingFactory.provideDebugLevel()
        val httpLoggingInterceptor = NetworkingFactory.getLoggingInterceptor(level)
        val client = NetworkingFactory.getClient(httpLoggingInterceptor, null)
        val retrofit = NetworkingFactory.getRetrofit(builder, client)

        service = OpenWeatherService(
                retrofit,
                retrofit.create(IRetrofitOpenWeatherService::class.java),
                "dc3ab2fad7af61db48b6fa9acaad7369"
        )

        service?.setDelegate(this)
        service?.getWeatherByCity("London")
    }

    override fun didReceiveData(city: OWCity) {
        Log.d("tufyx", "did receive data >> city: " + city.name!!)
    }

    override fun didReceiveError() {
        Log.d("tufyx", "did receive error")
    }
}
