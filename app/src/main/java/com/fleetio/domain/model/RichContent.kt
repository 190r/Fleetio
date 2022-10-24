package com.fleetio.domain.model


import com.google.gson.annotations.SerializedName

data class RichContent(
    @SerializedName("state")
    val state: List<State>
)