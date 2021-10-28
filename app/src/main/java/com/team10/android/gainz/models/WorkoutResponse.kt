package com.team10.android.gainz.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class WorkoutResponse(
  @SerializedName("page")
  val page: Page
)