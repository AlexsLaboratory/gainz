package com.team10.andriod.gainz.api

import com.google.gson.annotations.SerializedName

class Workout {
  @SerializedName("id")
  var id = 0

  @SerializedName("title")
  var title = ""

  @SerializedName("body")
  var body = ""

  @SerializedName("createdAt")
  var createdAt = ""

  @SerializedName("updatedAt")
  var updatedAt = ""

  override fun toString(): String {
    return "[${this.id}, ${this.title}, ${this.body}, ${this.createdAt}, ${this.updatedAt}]"
  }
}