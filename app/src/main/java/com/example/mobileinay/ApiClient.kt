package com.example.mobileinay
import com.example.mobileinay.api.services.ProfileSantriServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://haflah.ponpesinayatullah.com/api/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//    val productServices: ProductServices by lazy {
//        retrofit.create(ProductServices::class.java)
//    }
//    val jadwalServices: JadwalServices by lazy {
//        retrofit.create(JadwalServices::class.java)
//    }
    val profileSantriServices: ProfileSantriServices by lazy {
        retrofit.create(ProfileSantriServices::class.java)
    }
}