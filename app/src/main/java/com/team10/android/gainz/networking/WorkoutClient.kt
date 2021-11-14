package com.team10.android.gainz.networking

import com.team10.android.gainz.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WorkoutClient {
  companion object {
    private const val BASE_URL = BuildConfig.API_URL
    private var workoutService: WorkoutService? = null

    fun getClient(): WorkoutService {
      if (workoutService === null) {
        return Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build()
          .create(WorkoutService::class.java)
      }
      return workoutService as WorkoutService
    }
  }
}