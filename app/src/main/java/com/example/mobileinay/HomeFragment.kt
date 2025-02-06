package com.example.mobileinay

//import com.google.firebase.auth.FirebaseAuth
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
        ApiClient.loginServices.getProtected(authHeader)
            .enqueue(object : Callback<ProtectedResponse> {
                override fun onResponse(
                    call: Call<ProtectedResponse>,
                    response: Response<ProtectedResponse>
                ) {
                    if (response.isSuccessful){
                        val UserProtected = response.body()
                        UserProtected?.data?.let {
                            namaUser.text = ", ${it.nama}"
                        }
                    }else{
                        namaUser.text = "Gagal memuat nama user"
                    }
                }

                override fun onFailure(call: Call<ProtectedResponse>, t: Throwable) {
                    namaUser.text = "Hubungan bermasalah"
                }

            })
    }

}