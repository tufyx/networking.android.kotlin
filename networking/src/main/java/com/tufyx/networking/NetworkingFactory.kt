package com.tufyx.networking

import okhttp3.Call
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkingFactory {

    fun getClient(loggingInterceptor: HttpLoggingInterceptor, interceptor: Interceptor?): Call.Factory {
        val builder = OkHttpClient.Builder()
        if (interceptor != null) {
            builder.addInterceptor(interceptor)
        }

        return builder
                .addInterceptor(loggingInterceptor)
                .readTimeout(Config.Timeouts.READ.toLong(), TimeUnit.MILLISECONDS)
                .writeTimeout(Config.Timeouts.WRITE.toLong(), TimeUnit.MILLISECONDS)
                .connectTimeout(Config.Timeouts.CONNECT.toLong(), TimeUnit.MILLISECONDS)
                .build()
    }

    fun getLoggingInterceptor(level: HttpLoggingInterceptor.Level): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(level)
        return loggingInterceptor
    }

    fun provideDebugLevel(): HttpLoggingInterceptor.Level {
        when (BuildConfig.DEBUG_LEVEL) {
            0 -> return HttpLoggingInterceptor.Level.NONE
            1 -> return HttpLoggingInterceptor.Level.BASIC
            2 -> return HttpLoggingInterceptor.Level.HEADERS
            else -> return HttpLoggingInterceptor.Level.BODY
        }
    }

    fun getRetrofit(builder: Retrofit.Builder, client: Call.Factory): Retrofit {
        return builder.client(client as OkHttpClient).build()
    }

    fun getBuilder(url: String): Retrofit.Builder {
        return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
    }

}
