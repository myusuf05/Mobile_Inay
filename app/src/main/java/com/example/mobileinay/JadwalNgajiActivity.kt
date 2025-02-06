package com.example.mobileinay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileinay.databinding.ActivityJadwalNgajiBinding

class JadwalNgajiActivity : AppCompatActivity() {

    private val dbName = "jadwal"
//
//    private lateinit var db:FirebaseFirestore
//    private var firebaseAuth = FirebaseAuth.getInstance()
    private lateinit var binding: ActivityJadwalNgajiBinding
//    private lateinit var jadwalAdapter: JadwalAdapter


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityJadwalNgajiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        // Inisialisasi Firestore
//        db = FirebaseFirestore.getInstance()

        // Menyiapkan view selain recycler view
        prepareView()
        // Menyiapkan recycler view
        binding.rvCard.setHasFixedSize(true)
        binding.rvCard.layoutManager = LinearLayoutManager(this)

//        ApiClient.instance.get_jadwal().enqueue(object : Callback<List<jadwal_santri>> {
//            override fun onResponse(
//                call: Call<List<jadwal_santri>>,
//                response: Response<List<jadwal_santri>>
//            ) {
//                if (response.isSuccessful){
//                    val jadwalList = response.body()
//                }
//            }
//
//            override fun onFailure(call: Call<List<jadwal_santri>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
//        ApiClient.instance.get_pengajar().enqueue(object :Callback<List<pengajar>>{
//            override fun onResponse(
//                call: Call<List<pengajar>>,
//                response: Response<List<pengajar>>
//            ) {
//                if (response.isSuccessful){
//                    val pengajarList = response.body()
//                }
//            }
//
//            override fun onFailure(call: Call<List<pengajar>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
        fetchData("senin")
    }

    private fun prepareView() {
        binding.imgBack.setOnClickListener{
//             Replace the current fragment with a new fragment
            this.finish()
        }
        binding.tvSenin.setOnClickListener{
            fetchData("senin")
        }
        binding.tvSelasa.setOnClickListener {
            fetchData("selasa")
        }
        binding.tvRabu.setOnClickListener{
            fetchData("rabu")
        }
        binding.tvKamis.setOnClickListener {
            fetchData("kamis")
        }
        binding.tvJumat.setOnClickListener{
            fetchData("jum'at")
        }
        binding.tvSabtu.setOnClickListener {
            fetchData("sabtu")
        }
        binding.tvMinggu.setOnClickListener{
            fetchData( "minggu")
        }
    }

    private fun fetchData( hari: String) {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val kelascolletion = db.collection("user").document(firebaseAuth.currentUser?.email.toString())
//                    .get().await()
//                val jadwal = db.collection(dbName).document(kelascolletion.getString("kelas").toString())
//                    .collection(hari)
//                    .get().await()
//                val listKegiatan = ArrayList<CardMapel>()
//                for (documentjadwal in jadwal.documents) {
//                    listKegiatan.add(
//                        CardMapel(
//                            documentjadwal.id,
//                            documentjadwal.getString("kegiatan"),
//                            documentjadwal.getString("kitab"),
//                            documentjadwal.getString("lokasi")
//                        )
//                    )
//                }
//                withContext(Dispatchers.Main) {
////                    jadwalAdapter = JadwalAdapter(listKegiatan)
////                    binding.rvCard.adapter = jadwalAdapter
//                }
//            } catch (e: Exception) {
//                Toast.makeText(this@JadwalNgajiActivity, "Error saat mengambil data", Toast.LENGTH_SHORT).show()
//            }
//        }
    }

}