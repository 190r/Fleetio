package com.fleetio.domain.repository.paged

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fleetio.domain.model.VehicleDetail
import com.fleetio.domain.repository.VehicleFleetApi
import retrofit2.HttpException
import java.io.IOException

class FleetPagingSource(
    private val repo: VehicleFleetApi
): PagingSource<Int, VehicleDetail>() {

    override fun getRefreshKey(state: PagingState<Int, VehicleDetail>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, VehicleDetail> {
        return try {
            val nextPage = params.key ?: 1
            val fleetApiResponse = repo.getFleetByPage(nextPage)
            if (fleetApiResponse.isSuccessful) {
                val data = fleetApiResponse.body()!!
                val headers = fleetApiResponse.headers()
                val currentPage = headers.get("X-Pagination-Current-Page")?.toInt()
                val totalPages = headers.get("X-Pagination-Total-Pages")?.toInt()
                val pageSize = headers.get("X-Pagination-Limit")?.toInt()

                val nextPage = params.key ?: 1

                LoadResult.Page(
                    data = data,
                    prevKey = if (nextPage == 1) null else nextPage - 1,
                    nextKey = if (data.isEmpty()) null else currentPage?.plus(1)
                )
            } else throw Exception("invalid response")
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}