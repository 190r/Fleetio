package com.fleetio.domain.model


import com.google.gson.annotations.SerializedName

data class ExternalIds(
    @SerializedName("clearpathgps")
    val clearpathgps: Any?,
    @SerializedName("external_fuel_id")
    val externalFuelId: Any?,
    @SerializedName("fuel_id")
    val fuelId: Any?,
    @SerializedName("task_code")
    val taskCode: Any?,
    @SerializedName("traxxis_id")
    val traxxisId: Any?
)