package com.team10.android.gainz.networking.auth

import com.team10.android.gainz.models.LoginRequest
import com.team10.android.gainz.models.LoginResponse
import com.team10.android.gainz.models.RegisterUserRequest
import com.team10.android.gainz.models.RegisterUserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface AuthService {
    @POST("auth/login")
    fun loginUser(@Body loginRequest: LoginRequest?): Call<LoginResponse>

    @PUT("auth/signup")
    fun signupUser(@Body registerUserRequest: RegisterUserRequest?): Call<RegisterUserResponse>
}