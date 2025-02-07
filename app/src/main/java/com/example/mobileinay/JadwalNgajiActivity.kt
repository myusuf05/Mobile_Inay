package com.example.mobileinay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileinay.api.adapter.SessionManager

class JadwalNgajiActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager
    private lateinit var hariAdapter: HariAdapter
    private lateinit var jadwalAdapter: JadwalAdapter
//    private lateinit var recyclerView: RecyclerView
    private val  jadwalList = mutableListOf<DataJadwal>()
    private var selectDay = "1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jadwal_ngaji)
        supportActionBar?.hide()

        recyclerView = findViewById(R.id.rv_card)

        val jadwalList = listOf(
            DataJadwal("Musyawarah", "Kitab: Fathul Qorib", "05:30 WIB", "06:30 WIB"),
            DataJadwal("Kajian Tafsir", "Kitab: Tafsir Jalalin", "05:30 WIB", "06:30 WIB"),
            DataJadwal("Fiqih Pagi", "Kitab: Safinatun Najah", "05:30 WIB", "06:30 WIB")
        )

        jadwalAdapter = JadwalAdapter(jadwalList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = jadwalAdapter

//        val token = " Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2hhZmxhaC5wb25wZXNpbmF5YXR1bGxhaC5jb20vYXBpL2xvZ2luIiwiaWF0IjoxNzM4ODQ4NTQ4LCJleHAiOjE3Mzg4NTIxNDgsIm5iZiI6MTczODg0ODU0OCwianRpIjoiRHZEVElnYzdkVFg0c2k5ViIsInN1YiI6IiIsInBydiI6IjNmYmRkYmY3ODM3MTIwYjUzZWNjMGI0YTg0MGUzMDczNWFjMWVhYjMifQ.3csmAG90Yr_cmxh8OmVH1Y3VkwMz5HoDi49tZ-qPKDw"


//        sessionManager = SessionManager(this)

//        val accssToken = sessionManager.getTokenAcces()
        val idKelas = 1

//       if (!accssToken.isNullOrEmpty()){
//           getListJadwal(accssToken, idKelas)
//       }else{
//           Toast.makeText(this, "token tidak ditemukan", Toast.LENGTH_SHORT).show()
//       }

//        findViewById<TextView>(R.id.tvSenin).setOnClickListener { filterJadwal("1") }
//        findViewById<TextView>(R.id.tvSelasa).setOnClickListener { filterJadwal("2") }
//        findViewById<TextView>(R.id.tvRabu).setOnClickListener { filterJadwal("3") }
//        findViewById<TextView>(R.id.tvKamis).setOnClickListener { filterJadwal("4") }
//        findViewById<TextView>(R.id.tvJumat).setOnClickListener { filterJadwal("5") }
//        findViewById<TextView>(R.id.tvSabtu).setOnClickListener { filterJadwal("6") }
//        findViewById<TextView>(R.id.tvMinggu).setOnClickListener { filterJadwal("7") }
    }

    private fun getListJadwal(accssToken: String, idKelas: Int) {
//        val authHeader = "Bearer $accssToken"
//        val idUser = "25021000"
//        ApiClient.loginServices.getJadwal(accssToken, idKelas)
//            .enqueue(object : Callback<JadwalNew>{
//                override fun onResponse(call: Call<JadwalNew>, response: Response<JadwalNew>) {
//                    if (response.isSuccessful && response.body() !=null){
//                        val jadwals = response.body()?.data?.kelas?.jadwal ?: emptyList()
//                        jadwalList.clear()
//                        jadwalList.addAll(jadwals)
//                        filterJadwal(selectDay)

//                        jadwalAdapter = JadwalAdapter(jadwalList)
//                        recyclerView.adapter = jadwalAdapter
//                    }else{
//                        Log.e("JadwalActivity", "Error : ${response.errorBody()?.string()}")
//                        Toast.makeText(this@JadwalNgajiActivity, "Gagal Memuat Jadwal", Toast.LENGTH_SHORT).show()
//                    }
//                }

//                override fun onFailure(call: Call<JadwalNew>, t: Throwable) {
//                    Log.e("Jadwal Activity", "Request gagal: ${t.message}", t)
//                    Toast.makeText(this@JadwalNgajiActivity, "Hubungan bermasalah", Toast.LENGTH_SHORT).show()
//                }
//
//            })
      }

//    private fun filterJadwal(day: String) {
//        selectDay = day
//        val filterList = jadwalList.filter { it.hari == day }
//        jadwalAdapter.updateData(filterList)
//    }

}