package com.team10.android.gainz.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class LoginUserResponse(
  @SerializedName("token")
  val token: String?,
  @SerializedName("userId")
  val userId: Int?,
  @SerializedName("message")
  val message: String?
)