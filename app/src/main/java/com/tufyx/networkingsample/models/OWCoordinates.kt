package com.tufyx.networkingsample.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import javax.annotation.Generated

@Generated("org.jsonschema2pojo")
internal class OWCoordinates {

    @SerializedName("lon")
    @Expose
    private val longitude: Float = 0.toFloat()

    @SerializedName("lat")
    @Expose
    private val latitude: Float = 0.toFloat()

}
