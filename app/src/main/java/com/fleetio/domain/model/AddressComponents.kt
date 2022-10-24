package com.fleetio.domain.model


import com.google.gson.annotations.SerializedName

data class AddressComponents(
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("country_short")
    val countryShort: String,
    @SerializedName("postal_code")
    val postalCode: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("region_short")
    val regionShort: String,
    @SerializedName("street")
    val street: String,
    @SerializedName("street_number")
    val streetNumber: String
)