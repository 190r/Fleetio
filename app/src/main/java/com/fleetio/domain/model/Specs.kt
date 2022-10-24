package com.fleetio.domain.model


import com.google.gson.annotations.SerializedName

data class Specs(
    @SerializedName("account_id")
    val accountId: Int,
    @SerializedName("base_towing_capacity")
    val baseTowingCapacity: Any?,
    @SerializedName("bed_length")
    val bedLength: Any?,
    @SerializedName("body_subtype")
    val bodySubtype: Any?,
    @SerializedName("body_type")
    val bodyType: Any?,
    @SerializedName("brake_system")
    val brakeSystem: Any?,
    @SerializedName("cargo_volume")
    val cargoVolume: Any?,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("curb_weight")
    val curbWeight: Any?,
    @SerializedName("drive_type")
    val driveType: Any?,
    @SerializedName("duty_type")
    val dutyType: Any?,
    @SerializedName("engine_aspiration")
    val engineAspiration: Any?,
    @SerializedName("engine_block_type")
    val engineBlockType: Any?,
    @SerializedName("engine_bore")
    val engineBore: Any?,
    @SerializedName("engine_bore_with_units")
    val engineBoreWithUnits: Any?,
    @SerializedName("engine_brand")
    val engineBrand: String?,
    @SerializedName("engine_cam_type")
    val engineCamType: Any?,
    @SerializedName("engine_compression")
    val engineCompression: Any?,
    @SerializedName("engine_cylinders")
    val engineCylinders: Any?,
    @SerializedName("engine_description")
    val engineDescription: String?,
    @SerializedName("engine_displacement")
    val engineDisplacement: Any?,
    @SerializedName("engine_stroke")
    val engineStroke: Any?,
    @SerializedName("engine_valves")
    val engineValves: Any?,
    @SerializedName("epa_city")
    val epaCity: Any?,
    @SerializedName("epa_combined")
    val epaCombined: Any?,
    @SerializedName("epa_highway")
    val epaHighway: Any?,
    @SerializedName("front_tire_psi")
    val frontTirePsi: Any?,
    @SerializedName("front_tire_type")
    val frontTireType: String,
    @SerializedName("front_track_width")
    val frontTrackWidth: Any?,
    @SerializedName("front_wheel_diameter")
    val frontWheelDiameter: String,
    @SerializedName("fuel_induction")
    val fuelInduction: Any?,
    @SerializedName("fuel_quality")
    val fuelQuality: String?,
    @SerializedName("fuel_tank_2_capacity")
    val fuelTank2Capacity: Double?,
    @SerializedName("fuel_tank_capacity")
    val fuelTankCapacity: Double?,
    @SerializedName("gross_vehicle_weight_rating")
    val grossVehicleWeightRating: Double?,
    @SerializedName("ground_clearance")
    val groundClearance: Any?,
    @SerializedName("height")
    val height: Any?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("interior_volume")
    val interiorVolume: Any?,
    @SerializedName("length")
    val length: Any?,
    @SerializedName("max_hp")
    val maxHp: Any?,
    @SerializedName("max_payload")
    val maxPayload: Any?,
    @SerializedName("max_torque")
    val maxTorque: Any?,
    @SerializedName("msrp")
    val msrp: Double,
    @SerializedName("msrp_cents")
    val msrpCents: Int,
    @SerializedName("oil_capacity")
    val oilCapacity: Any?,
    @SerializedName("passenger_volume")
    val passengerVolume: String?,
    @SerializedName("rear_axle_type")
    val rearAxleType: String,
    @SerializedName("rear_tire_psi")
    val rearTirePsi: Any?,
    @SerializedName("rear_tire_type")
    val rearTireType: String,
    @SerializedName("rear_track_width")
    val rearTrackWidth: Any?,
    @SerializedName("rear_wheel_diameter")
    val rearWheelDiameter: String,
    @SerializedName("redline_rpm")
    val redlineRpm: String,
    @SerializedName("transmission_brand")
    val transmissionBrand: String,
    @SerializedName("transmission_description")
    val transmissionDescription: String,
    @SerializedName("transmission_gears")
    val transmissionGears: Any?,
    @SerializedName("transmission_type")
    val transmissionType: Any?,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("vehicle_id")
    val vehicleId: Int,
    @SerializedName("weight_class")
    val weightClass: Any?,
    @SerializedName("wheelbase")
    val wheelbase: Any?,
    @SerializedName("wheelbase_with_units")
    val wheelbaseWithUnits: Any?,
    @SerializedName("width")
    val width: Any?)