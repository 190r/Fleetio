package com.fleetio.domain.model


import com.google.gson.annotations.SerializedName

data class CurrentLocationEntry(
    @SerializedName("address")
    val address: String?,
    @SerializedName("address_components")
    val addressComponents: AddressComponents,
    @SerializedName("contact_id")
    val contactId: Any?,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("geolocation")
    val geolocation: Geolocation?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_current")
    val isCurrent: Boolean,
    @SerializedName("item_id")
    val itemId: Int,
    @SerializedName("item_type")
    val itemType: String,
    @SerializedName("locatable_id")
    val locatableId: Int,
    @SerializedName("locatable_type")
    val locatableType: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("vehicle_id")
    val vehicleId: Int
)