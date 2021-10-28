package com.team10.andriod.gainz.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Data(
  @SerializedName("body")
  val body: String,
  @SerializedName("createdAt")
  val createdAt: String,
  @SerializedName("id")
  val id: Int,
  @SerializedName("title")
  val title: String,
  @SerializedName("updatedAt")
  val updatedAt: String
)