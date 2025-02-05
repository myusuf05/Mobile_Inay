package com.example.mobileinay.api.services

import com.example.mobileinay.api.model.Jadwal
import retrofit2.Call
import retrofit2.http.GET

interface JadwalServices {
    @GET("jadwal")
//    fun getAll(): Call<Jadwal>
    fun getbyWaktu(waktu: String): Any
}
