package com.team10.andriod.gainz.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WorkoutService {
  @GET("/workout/get-all")
  fun getAll(
    @Query("limit") limit: Int?,
    @Query("cursor") cursor: Int?
  ): Call<WorkoutResponse>
}