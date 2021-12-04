package com.team10.android.gainz.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class RegisterUserResponse(
  @SerializedName("message")
  val message: String,
  @SerializedName("userId")
  val userId: Int
)