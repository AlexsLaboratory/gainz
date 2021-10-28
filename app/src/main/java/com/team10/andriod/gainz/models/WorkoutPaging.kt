package com.team10.andriod.gainz.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

data class WorkoutPaging(
  val next: Int? = null,
  val prev: Int? = null,
  val workout: List<Data>
) {
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
}
