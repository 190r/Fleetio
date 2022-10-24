package com.fleetio.domain.model


import com.google.gson.annotations.SerializedName

data class Contact(
    @SerializedName("default_image")
    val defaultImage: Any?,
    @SerializedName("email")
    val email: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("id")
    val id: Int
)