package com.fleetio.domain.model


import com.google.gson.annotations.SerializedName

data class Geolocation(
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?
)