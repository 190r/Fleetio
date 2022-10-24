package com.fleetio.domain.model


import com.google.gson.annotations.SerializedName

data class Children(
    @SerializedName("children")
    val children: List<ChildrenX>?,
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("text")
    val text: String?,
    @SerializedName("type")
    val type: String?
)