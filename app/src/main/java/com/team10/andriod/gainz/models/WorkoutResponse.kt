package com.team10.andriod.gainz.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class WorkoutResponse(
  @SerializedName("page")
  val page: Page
)