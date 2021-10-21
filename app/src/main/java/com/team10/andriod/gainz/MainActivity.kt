package com.team10.andriod.gainz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    loadWorkouts()
  }

  private fun loadWorkouts() {
    val queue = Volley.newRequestQueue(this)
    val url = BuildConfig.BASE_API + "workout/get-all?limit=3"

    val jsonObjectRequest = JsonObjectRequest(
      Request.Method.GET, url, null,
      { response ->
        val result = response.toString()
        Log.d("data", result)
      },
      { error ->
        Log.e("error", error.toString())
      }
    )
    queue.add(jsonObjectRequest)
  }
}