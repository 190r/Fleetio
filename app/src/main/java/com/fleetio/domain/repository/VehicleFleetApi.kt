package com.fleetio.domain.repository

import com.fleetio.domain.model.Comment
import com.fleetio.domain.model.VehicleDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface VehicleFleetApi {

    @GET("api/v1/vehicles")
    suspend fun getFleet(): List<VehicleDetail>

    @GET("api/v1/vehicles/{id}")
    suspend fun getVehicleById(@Path("id") id: String): VehicleDetail

    @GET("api/vi/vehicles")
    suspend fun queryVehicles(@QueryMap queries: Map<String, String>): List<VehicleDetail>

    /**
     * With pagination
     */
    @GET("api/v1/vehicles")
    suspend fun getFleetByPage(@Query("page") pageNumber: Int): Response<List<VehicleDetail>>

    @GET("api/v1/comments")
    suspend fun getVehicleCommentsById(): List<Comment>

    @GET("api/v1/comments")
    suspend fun queryVehicleComments(@Query("q[commentable_id]") id: String): Comment

}