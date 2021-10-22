package com.team10.andriod.gainz

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.team10.andriod.gainz.api.WorkoutResponse
import com.team10.andriod.gainz.api.WorkoutService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val retrofit = Retrofit.Builder()
      .baseUrl(BuildConfig.BASE_API)
      .addConverterFactory(GsonConverterFactory.create())
      .build()

    val service = retrofit.create(WorkoutService::class.java)
    val call = service.getAll(3, null)
    call.enqueue(object : Callback<WorkoutResponse> {
      override fun onResponse(call: Call<WorkoutResponse>?, response: Response<WorkoutResponse>?) {
        if (response?.code() == 200) {
          val workoutResponse = response.body()!!
          for (workout in workoutResponse.results) {
            Log.d("MainActivity", workout.toString())
          }
        }
      }

      override fun onFailure(call: Call<WorkoutResponse>?, t: Throwable?) {
        TODO("Not yet implemented")
      }

    })
  }
}