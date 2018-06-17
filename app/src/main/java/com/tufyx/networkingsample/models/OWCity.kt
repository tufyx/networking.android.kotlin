package com.tufyx.networkingsample.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.ArrayList

import javax.annotation.Generated

@Generated("org.jsonschema2pojo")
class OWCity {

    @SerializedName("id")
    @Expose
    private val id: String? = null

    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("coord")
    @Expose
    private val coordinates: OWCoordinates? = null

    @SerializedName("weather")
    @Expose
    private val weather: ArrayList<OWWeather>? = null

    @SerializedName("main")
    @Expose
    private val main: OWMain? = null
}
