package com.tufyx.networking.delegate

interface IBaseDelegate<ErrorType> {

    fun didReceiveError(error: ErrorType)

    fun didReceiveFailure(t: Throwable)

}
