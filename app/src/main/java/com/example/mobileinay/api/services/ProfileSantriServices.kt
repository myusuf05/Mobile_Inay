package com.example.mobileinay.api.services

import com.example.mobileinay.api.model.ProfileSantri
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileSantriServices {
    @GET("profile/{id_user}")

    fun getProfile(@Path("id_user")idUser:Int): Call<ProfileSantri>
}