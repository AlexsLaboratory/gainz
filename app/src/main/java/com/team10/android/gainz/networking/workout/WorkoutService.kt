package com.team10.android.gainz.networking.workout

import com.team10.android.gainz.models.WorkoutResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WorkoutService {
  @GET("workout/get-all")
  suspend fun fetchWorkouts(
    @Header("Authorization") token: String,
    @Query("limit") workoutsPerPage: Int,
    @Query("cursor") cursor: Int?,
  ) : WorkoutResponse
}