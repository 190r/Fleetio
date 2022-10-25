package com.fleetio.domain.model


import com.google.gson.annotations.SerializedName

data class DefaultImage(
    @SerializedName("secure_file_url")
    val secureFileUrl: String,
    @SerializedName("small_square_url")
    val smallSquareUrl: String
)