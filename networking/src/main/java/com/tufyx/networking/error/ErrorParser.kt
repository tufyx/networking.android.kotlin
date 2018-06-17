package com.tufyx.networking.error

import retrofit2.Response
import retrofit2.Retrofit
import kotlin.jvm.java
import kotlin.reflect.KClass

abstract class ErrorParser<ErrorType>(private val mRetrofit: Retrofit) {

    fun parseAPIError(response: Response<*>, clazz: KClass<*>, defaultError: ErrorType): ErrorType {
        val converter = mRetrofit.responseBodyConverter<ErrorType>(clazz.java, arrayOfNulls(0))

        try {
            return converter.convert(response.errorBody())
        } catch (e: Exception) {
            e.printStackTrace()
            return defaultError
        }

    }

}
