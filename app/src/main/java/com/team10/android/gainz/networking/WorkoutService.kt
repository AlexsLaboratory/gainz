package com.team10.android.gainz.networking

import com.team10.android.gainz.models.WorkoutResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WorkoutService {
  @GET("workout/get-all")
  suspend fun fetchWorkouts(
    @Query("limit") workoutsPerPage: Int,
    @Query("cursor") cursor: Int?,
  ) : WorkoutResponse
}