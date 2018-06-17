package com.tufyx.networkingsample.ow_service

import com.tufyx.networkingsample.models.OWCity

interface IOWDelegate {

    fun didReceiveData(city: OWCity)

    fun didReceiveError()

}
