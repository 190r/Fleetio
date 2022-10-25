package com.fleetio.domain.model


import com.google.gson.annotations.SerializedName

data class CommentItem(
    @SerializedName("comment")
    val comment: String,
    @SerializedName("commentable_id")
    val commentableId: Int,
    @SerializedName("commentable_type")
    val commentableType: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("rich_content")
    val richContent: RichContent?,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user_full_name")
    val userFullName: String,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("user_image_url")
    val userImageUrl: String?,
    @SerializedName("with_mentions")
    val withMentions: Boolean
)