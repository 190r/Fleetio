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

class QueryFleetUseCase @Inject constructor(
    private val repo: VehicleFleetApi
) {

    private val TAG = "QueryFleetUseCase"

    operator fun invoke(queryMap: Map<String, String>): Flow<ApiResponse<List<VehicleDetail>>> = flow {
        try {
            emit(ApiResponse.Loading<List<VehicleDetail>>(null))
            val fleet = repo.queryVehicles(queryMap)
            emit(ApiResponse.Success<List<VehicleDetail>>(fleet))
        } catch (e: HttpException) {
            Log.e(TAG, e.localizedMessage ?: "An unexpected error returned")
            emit(ApiResponse.Error<List<VehicleDetail>>(e.localizedMessage ?: "An unexpected error returned"))
        } catch (e: IOException) {
            Log.e(TAG, "Couldn't reach server. Check your internet connection")
            emit(ApiResponse.Error<List<VehicleDetail>>(e.localizedMessage ?: "Couldn't reach server. Check your internet connection"))
        } catch (e: Exception) {
            Log.e(TAG, e.localizedMessage ?: "unknown error occurred")
            emit(ApiResponse.Exception<List<VehicleDetail>>(e.localizedMessage ?: "unknown error occurred"))
        }
    }

}