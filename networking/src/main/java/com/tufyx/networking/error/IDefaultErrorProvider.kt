package com.tufyx.networking.error

interface IDefaultErrorProvider<T> {

    fun provideDefaultError(): T

}