package com.fleetio.domain.model


import com.google.gson.annotations.SerializedName

data class CustomFields(
    @SerializedName("checkbox_filter_test")
    val checkboxFilterTest: String,
    @SerializedName("extra_rextra_read_all_about_it_this_is_a_super_long_field_name_my_guyyy")
    val extraRextraReadAllAboutItThisIsASuperLongFieldNameMyGuyyy: String,
    @SerializedName("manufacturer_model")
    val manufacturerModel: String,
    @SerializedName("rear_camera_enabled")
    val rearCameraEnabled: String,
    @SerializedName("restrict")
    val restrict: String,
    @SerializedName("telematics_subscription")
    val telematicsSubscription: String,
    @SerializedName("test")
    val test: String,
    @SerializedName("toll_pass_number")
    val tollPassNumber: String,
    @SerializedName("vehicle_cleanliness")
    val vehicleCleanliness: String,
    @SerializedName("warranty_expiration")
    val warrantyExpiration: String,
    @SerializedName("warranty_type")
    val warrantyType: String
)