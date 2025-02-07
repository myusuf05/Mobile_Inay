package com.example.mobileinay.api.services


import com.example.mobileinay.JadwalNew
import com.example.mobileinay.LoginRequest
import com.example.mobileinay.LoginResponse
import com.example.mobileinay.Profile
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface LoginServices {
    @POST("login")
    fun cekLogin(
       @Body request: LoginRequest
    ):Call<LoginResponse>

    @GET ("profiles")
    fun getProfile(
        @Header("Authorization") token: String,
        @Query("id_user") id_user:String
    ):Call<Profile>

    @GET ("jadwals")
    fun getJadwal(
        @Header("Authorization") token: String,
        @Path("id_kelas") idKelas: Int
    ):Call<JadwalNew>

//    @GET ("jadwals")
//    fun getJadwal(
//        @Header("Authorization") token: String,
////        @Query("id_user") id_user:String
//    ):Call<JadwalResponse>

}