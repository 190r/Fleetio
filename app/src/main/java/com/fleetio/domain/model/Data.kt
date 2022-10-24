package com.fleetio.domain.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("can_watch")
    val canWatch: Boolean,
    @SerializedName("contact")
    val contact: Contact,
    @SerializedName("label")
    val label: String,
    @SerializedName("record_id")
    val recordId: Int,
    @SerializedName("record_type")
    val recordType: String
)