package com.team10.andriod.gainz

import android.app.Application
import com.team10.andriod.gainz.networking.WorkoutClient
import com.team10.andriod.gainz.networking.WorkoutService

class MyApplication: Application() {
  lateinit var workoutService: WorkoutService
  override fun onCreate() {
    super.onCreate()
    workoutService = WorkoutClient.getClient()
  }
}