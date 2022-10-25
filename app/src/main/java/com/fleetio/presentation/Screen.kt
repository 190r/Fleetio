package com.fleetio.presentation

sealed class Screen(val route: String) {
    object FleetViewScreen: Screen("home_screen")
    object VehicleInfoDisplay: Screen("vehicle_info_display")
}
