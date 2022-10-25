package com.fleetio.domain.use_case

import android.util.Log
import com.fleetio.common.ApiResponse
import com.fleetio.domain.model.CommentItem
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

    operator fun invoke(vehicleId: String): Flow<ApiResponse<List<CommentItem>>> = flow {
        try {
            emit(ApiResponse.Loading<List<CommentItem>>(null))
            val commentList = repo.queryVehicleComments(vehicleId)
            emit(ApiResponse.Success<List<CommentItem>>(commentList))
        } catch (e: HttpException) {
            Log.e(TAG, e.localizedMessage ?: "An unexpected error returned")
            emit(ApiResponse.Error<List<CommentItem>>(e.localizedMessage ?: "An unexpected error returned"))
        } catch (e: IOException) {
            Log.e(TAG, "Couldn't reach server. Check your internet connection")
            emit(ApiResponse.Error<List<CommentItem>>(e.localizedMessage ?: "Couldn't reach server. Check your internet connection"))
        } catch (e: Exception) {
            Log.e(TAG, e.localizedMessage ?: "unknown error occurred")
            emit(ApiResponse.Exception<List<CommentItem>>(e.localizedMessage ?: "unknown error occurred"))
        }
    }

}