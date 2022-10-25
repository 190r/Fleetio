package com.fleetio.presentation

import com.fleetio.domain.model.CommentItem
import com.fleetio.domain.model.VehicleDetail

/**
 * A state holder of properties for composable state
 */
data class VehicleInfoState(
    val isLoading: Boolean = false,
    val vehicle: VehicleDetail? = null,
    val apiError: String = ""
)

data class VehicleCommentState(
    val isLoading: Boolean = false,
    val userComments: List<CommentItem> = emptyList(),
    val apiError: String = ""
)
