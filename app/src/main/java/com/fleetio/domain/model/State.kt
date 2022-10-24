package com.fleetio.domain.model


import com.google.gson.annotations.SerializedName

data class State(
    @SerializedName("children")
    val children: List<Children>,
    @SerializedName("type")
    val type: String
)