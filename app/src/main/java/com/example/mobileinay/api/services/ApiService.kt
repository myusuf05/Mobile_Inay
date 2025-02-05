package com.example.mobileinay.api.services

import com.example.mobileinay.LoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun loginUser(@Body request: LoginRequest): Call<LoginRequest>
}