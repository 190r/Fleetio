package com.fleetio.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateOf
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.fleetio.common.ApiResponse
import com.fleetio.domain.model.VehicleDetail
import com.fleetio.domain.repository.VehicleFleetApi
import com.fleetio.domain.repository.paged.FleetPagingSource
import com.fleetio.domain.use_case.GetVehicleByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repo: VehicleFleetApi,
    private val vehicleById: GetVehicleByIdUseCase
): ViewModel() {

    private val _vehicle = mutableStateOf(VehicleInfoState())
    val vehicle = _vehicle

    val vehicleFleet: Flow<PagingData<VehicleDetail>> = Pager(PagingConfig(
        pageSize = 100,
        prefetchDistance = 1)
    ) {
        FleetPagingSource(repo)
    }.flow.cachedIn(viewModelScope)

    fun getVehicleById(id: String) {
        vehicleById(id).onEach { vehicle ->
            when(vehicle) {
                is ApiResponse.Success -> {
                    _vehicle.value = VehicleInfoState(vehicle = vehicle.data)
                }
                is ApiResponse.Error -> {
                    _vehicle.value = VehicleInfoState(apiError = vehicle.message ?: "Unexpected error occurred")
                }
                is ApiResponse.Loading -> {
                    _vehicle.value = VehicleInfoState(isLoading = true)
                }
                is ApiResponse.Exception -> {

                }
            }
        }.launchIn(viewModelScope)
    }


}