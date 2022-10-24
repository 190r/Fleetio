package com.fleetio.domain.use_case

import android.util.Log
import com.fleetio.common.ApiResponse
import com.fleetio.domain.model.Comment
import com.fleetio.domain.repository.VehicleFleetApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class QueryCommentsUseCase @Inject constructor(
    private val repo: VehicleFleetApi
) {

    private val TAG = "QueryFleetUseCase"

    operator fun invoke(vehicleId: String): Flow<ApiResponse<Comment>> = flow {
        try {
            emit(ApiResponse.Loading<Comment>(null))
            val comment = repo.queryVehicleComments(vehicleId)
            emit(ApiResponse.Success<Comment>(comment))
        } catch (e: HttpException) {
            Log.e(TAG, e.localizedMessage ?: "An unexpected error returned")
            emit(ApiResponse.Error<Comment>(e.localizedMessage ?: "An unexpected error returned"))
        } catch (e: IOException) {
            Log.e(TAG, "Couldn't reach server. Check your internet connection")
            emit(ApiResponse.Error<Comment>(e.localizedMessage ?: "Couldn't reach server. Check your internet connection"))
        } catch (e: Exception) {
            Log.e(TAG, e.localizedMessage ?: "unknown error occurred")
            emit(ApiResponse.Exception<Comment>(e.localizedMessage ?: "unknown error occurred"))
        }
    }

}