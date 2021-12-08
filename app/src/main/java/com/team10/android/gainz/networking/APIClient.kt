package com.team10.android.gainz.networking

import com.team10.android.gainz.BuildConfig
import com.team10.android.gainz.networking.auth.AuthService
import com.team10.android.gainz.networking.workout.WorkoutService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
  private val _url = BuildConfig.API_URL

  private fun getRetrofit(): Retrofit {
    val logging = HttpLoggingInterceptor()

    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    val client: OkHttpClient = OkHttpClient.Builder()
      .addInterceptor(logging)
      .build()

    return Retrofit.Builder()
      .baseUrl(_url)
      .addConverterFactory(GsonConverterFactory.create())
      .client(client)
      .build()
  }

  fun getWorkoutService(): WorkoutService {
    return APIClient().getRetrofit().create(WorkoutService::class.java)
  }

  fun getAuthService(): AuthService {
    return APIClient().getRetrofit().create(AuthService::class.java)
  }
}