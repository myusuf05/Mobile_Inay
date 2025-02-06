package com.example.mobileinay


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobileinay.api.adapter.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

//    private lateinit var SharesPrefs : SharedPreferences
    private lateinit var namaUser: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        namaUser = view.findViewById(R.id.NamaUser)
        val sharesPrefs = SessionManager(requireContext())
        val accssToken = sharesPrefs.getTokenAcces()

        Log.d("HomeFragment", "Token yang digunakan: $accssToken")

        if (!accssToken.isNullOrEmpty() ){
            getUserProfil(accssToken)
        }else{
            Log.d("HomeFragment", "Token yang dikirim: Bearer $accssToken")
            Toast.makeText(requireContext(), "Token tidak ditemukan", Toast.LENGTH_SHORT).show()
        }

        val imgNilai = view?.findViewById<ImageButton>(R.id.imgNilai)
        val imgNgaji = view?.findViewById<ImageButton>(R.id.imgJadwal_ngaji)
        val imgAman = view?.findViewById<ImageButton>(R.id.imgkeamanan)
        val imgLaporan = view?.findViewById<ImageButton>(R.id.imgraport)
        val imgBuku = view?.findViewById<ImageButton>(R.id.majmu)

        // Set click listener on the ImageButton
        imgNilai?.setOnClickListener {
            val intent = Intent(activity, NilaiActivity::class.java)
            startActivity(intent)
        }
        imgNgaji?.setOnClickListener{

            val intent = Intent(activity, JadwalNgajiActivity::class.java)
            startActivity(intent)
        }
        imgAman?.setOnClickListener{
            val intent = Intent(activity, KeamananActivity::class.java)
            startActivity(intent)
        }
        imgLaporan?.setOnClickListener {
            val intent = Intent(activity, RaportActivity::class.java)
            startActivity(intent)
        }
        imgBuku?.setOnClickListener {
            val intent = Intent(activity, MajmuActivity::class.java)
            startActivity(intent)
        }
        return view
    }

    private fun getUserProfil(accssToken: String) {
        val authHeader = "Bearer $accssToken"
        val idUser = "25021000"
//        Log.d("HomeFragment", "Menggunakan Token: $authHeader")

        ApiClient.loginServices.getProfile(authHeader, idUser)
            .enqueue(object : Callback<Profile> {
                override fun onResponse(
                    call: Call<Profile>,
                    response: Response<Profile>
                ) {
                    Log.d("HomeFragment", "Response Code: ${response.code()}") // Log response code
                    Log.d("HomeFragment", "Response Body: ${response.body()}") // Log response body
                    if (response.isSuccessful){
                        val UserProtected = response.body()
                        if (UserProtected?.data != null) {
                            namaUser.text = "${UserProtected.data.nama}"
                        } else {
                            namaUser.text = "Data user tidak ditemukan"
                            Log.e("HomeFragment", "Data user kosong: ${response.body()}")
                        }
                    }else{
                        namaUser.text = "Gagal memuat nama user"
                        Log.e("HomeFragment", "Error Response: ${response.errorBody()?.string()}")
                    }
                }

                override fun onFailure(call: Call<Profile>, t: Throwable) {
                    Log.e("HomeFragment", "Request gagal: ${t.message}", t)
                    namaUser.text = "Hubungan bermasalah"
                }

            })
    }

}