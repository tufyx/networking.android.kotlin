package com.tufyx.networkingsample.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import javax.annotation.Generated

@Generated("org.jsonschema2pojo")
internal class OWMain {

    @SerializedName("temp")
    @Expose
    private val temperature: Float = 0.toFloat()

    @SerializedName("pressure")
    @Expose
    private val pressure: Float = 0.toFloat()

    @SerializedName("humidity")
    @Expose
    private val humidity: Float = 0.toFloat()

    @SerializedName("temp_min")
    @Expose
    private val minTemperature: Float = 0.toFloat()

    @SerializedName("temp_max")
    @Expose
    private val maxTemperature: Float = 0.toFloat()

}
