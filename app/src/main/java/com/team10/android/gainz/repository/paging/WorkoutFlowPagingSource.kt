package com.team10.android.gainz.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.team10.android.gainz.models.WorkoutPaging
import com.team10.android.gainz.models.WorkoutResponse
import com.team10.android.gainz.models.WorkoutResponseMapper
import com.team10.android.gainz.networking.workout.WorkoutService

class WorkoutFlowPagingSource(private val workoutService: WorkoutService) :
  PagingSource<Int, WorkoutPaging.Data>(), WorkoutResponseMapper<WorkoutResponse, WorkoutPaging> {
  var token: String? = null

  override fun getRefreshKey(state: PagingState<Int, WorkoutPaging.Data>): Int? {
    return state.anchorPosition
  }

  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, WorkoutPaging.Data> {
    val cursor = params.key

    return try {
      workoutService.fetchWorkouts(workoutsPerPage = 10, cursor = cursor, token = "Bearer $token").run {
        val data = mapFromResponse(this)
        return LoadResult.Page(
          data = data.workout,
          prevKey = data.prev,
          nextKey = data.next
        )
      }
    } catch (e: Exception) {
      LoadResult.Error(e)
    }
  }

  override fun mapFromResponse(response: WorkoutResponse): WorkoutPaging {
    return with(response) {
      WorkoutPaging(
        next = response.page.next,
        prev = response.page.prev,
        workout = response.page.data.map {
          WorkoutPaging.Data(
            id = it.id,
            title = it.title,
            body = it.body,
            createdAt = it.createdAt,
            updatedAt = it.updatedAt
          )
        }
      )
    }
  }

}