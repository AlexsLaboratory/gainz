package com.team10.android.gainz.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class LoginUserRequest(
  @SerializedName("email")
  val email: String,
  @SerializedName("password")
  val password: String
)