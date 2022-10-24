package com.fleetio.domain.use_case

import android.util.Log
import com.fleetio.common.ApiResponse
import com.fleetio.domain.model.VehicleDetail
import com.fleetio.domain.repository.VehicleFleetApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetVehicleByIdUseCase @Inject constructor(
    private val repo: VehicleFleetApi
) {
    private val TAG = "GetVehicleByIdUseCase"

    operator fun invoke(id: String): Flow<ApiResponse<VehicleDetail>> = flow {
        try {
            emit(ApiResponse.Loading<VehicleDetail>(null))
            val vehicleDetail = repo.getVehicleById(id)
            emit(ApiResponse.Success<VehicleDetail>(vehicleDetail))
        } catch (e: HttpException) {
            Log.e(TAG, e.localizedMessage ?: "An unexpected error returned")
            emit(ApiResponse.Error<VehicleDetail>(e.localizedMessage ?: "An unexpected error returned"))
        } catch (e: IOException) {
            Log.e(TAG, "Couldn't reach server. Check your internet connection")
            emit(ApiResponse.Error<VehicleDetail>(e.localizedMessage ?: "Couldn't reach server. Check your internet connection"))
        } catch (e: Exception) {
            Log.e(TAG, e.localizedMessage ?: "unknown error occurred")
            emit(ApiResponse.Exception<VehicleDetail>(e.localizedMessage ?: "unknown error occurred"))
        }
    }

}