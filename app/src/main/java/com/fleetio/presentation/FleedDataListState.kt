package com.fleetio.presentation

import com.fleetio.domain.model.Comment
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
    val userComment: Comment? = null,
    val apiError: String = ""
)
