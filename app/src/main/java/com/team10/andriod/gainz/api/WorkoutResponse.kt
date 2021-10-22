package com.team10.andriod.gainz.api

import com.google.gson.annotations.SerializedName

class WorkoutResponse {
  @SerializedName("results")
  var results = ArrayList<Workout>()
}