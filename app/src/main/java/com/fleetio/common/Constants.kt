package com.fleetio.common

import com.fleetio.BuildConfig

const val BASE_URL = "https://secure.fleetio.com/"

enum class VehicleType(type: String) {
    V_TYPE_CAR("Car"),
    V_TYPE_GENERATOR("Generator"),
    V_TYPE_SUV("SUV"),
    V_TYPE_TRUCK("Truck"),
    V_TYPE_VAN("Van"),
    V_TYPE_TRACTOR("Tractor"),
    V_TYPE_TRAILER("Trailer"),
    V_TYPE_BOAT("Boat"),
    V_TYPE_FORKLIFT("Forklift"),
    V_TYPE_SEMI_TRUCK("Semi-Trailer Truck")
}

enum class VehicleStatus() {
    V_STATUS_ACTIVE,
    V_STATUS_INACTIVE,
    V_STATUS_SOLD,
    V_STATUS_RENTED,
    V_STATUS_IN_SHOP,
    V_STATUS_SERVICE_DONE
}