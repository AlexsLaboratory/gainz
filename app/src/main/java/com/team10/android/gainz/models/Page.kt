package com.team10.android.gainz.models


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Page(
  @SerializedName("data")
  val `data`: List<Data>,
  @SerializedName("direction")
  val direction: String,
  @SerializedName("next")
  val next: Int?,
  @SerializedName("prev")
  val prev: Int?
)