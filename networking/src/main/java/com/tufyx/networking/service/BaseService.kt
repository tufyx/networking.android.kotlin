package com.tufyx.networking.service

import retrofit2.Retrofit

abstract class BaseService<T>(override val retrofit: Retrofit, protected var mService: T) : IBaseService