package com.example.mobileinay

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity_jad_Nga_Selasa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_jad_nga_selasa)

//        getJadwal("pagi", R.id.JdlKegiatan)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.JdlKegiatan)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val id = "123" // Ganti dengan email user yang sedang login
////        getUserProfile(id, view)
//        getProduct(view)
//    }

//    private fun getJadwal(waktu: String, textView: Long){
//        ApiClient.jadwalServices.getbyWaktu(waktu).enqueue(object : Callback<List<Jadwal>> {
//            override fun onResponse(call: Call<List<Jadwal>>, response: Response<List<Jadwal>>) {
//                if (response.isSuccessful) {
//                    val data = response.body()
//                    if (!data.isNullOrEmpty()) {
//                        val jadwalText = StringBuilder()
//                        for (jadwal in data) {
//                            jadwalText.append("${jadwal.id_mapel} (${jadwal.mulai} - ${jadwal.selesai})\n")
//                        }
//                        findViewById<TextView>(textView).text = jadwalText.toString()
//                    } else {
//                        Log.e("Activity_jad_Nga_Selasa", "Jadwal kosong untuk $waktu")
//                    }
//                } else {
//                    Log.e("Activity_jad_Nga_Selasa", "Gagal mengambil jadwal: ${response.errorBody()}")
//                }
//            }
//
//            override fun onFailure(call: Call<List<Jadwal>>, t: Throwable) {
//                Log.e("Activity_jad_Nga_Selasa", "Error fetching jadwal data", t)
//            }
//        })
//        val call = com.example.mobileinay.ApiClient.jadwalServices.getAll()
//
//        call.enqueue(object: Callback<Jadwal> {
//            override fun onResponse(call: Call<Jadwal>, response: Response<Jadwal>) {
//
//                val data = response.body()
//                waktu.findViewById<TextView>(R.id.Tv_NameUser)?.text = data?.title
//            }
//
//            override fun onFailure(call: Call<Product>, t: Throwable) {
//                Log.e("ProfileFragment", "Error fetching user data", t)
//            }
//
//        })
    }
//}