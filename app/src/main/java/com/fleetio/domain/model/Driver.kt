package com.fleetio.domain.model


import com.google.gson.annotations.SerializedName

data class Driver(
    @SerializedName("default_image_url")
    val defaultImageUrl: Any?,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_name")
    val lastName: String
)