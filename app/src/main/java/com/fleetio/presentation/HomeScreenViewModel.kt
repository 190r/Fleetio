package com.fleetio.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.fleetio.domain.model.VehicleDetail
import com.fleetio.domain.repository.VehicleFleetApi
import com.fleetio.domain.repository.paged.FleetPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repo: VehicleFleetApi
): ViewModel() {

    /**
     * Uses Jetpack Paging 3.0
     */
    val vehiclesPagedFlow: Flow<PagingData<VehicleDetail>> = Pager(PagingConfig(
        pageSize = 100,
        prefetchDistance = 1)
    ) {
        FleetPagingSource(repo)
    }.flow.cachedIn(viewModelScope)

}