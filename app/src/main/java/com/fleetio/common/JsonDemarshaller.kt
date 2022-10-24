package com.fleetio.common

import android.content.Context
import com.fleetio.R
import com.fleetio.domain.model.VehicleDetail
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

fun getVehicles(context: Context): List<VehicleDetail> {
    var fleet: List<VehicleDetail> = mutableListOf()
    try {
        val inputStream = context.resources.openRawResource(R.raw.vehicles)
        val reader = InputStreamReader(inputStream)
        val gson = GsonBuilder().create()
        val listType = object: TypeToken<List<VehicleDetail>>() {}.type
        fleet = gson.fromJson(reader, listType)
    } catch (e: Exception) {}

    return fleet
}