package com.example.mobileinay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileinay.databinding.ActivityJadwalNgajiBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class JadwalNgajiActivity : AppCompatActivity() {

    private val dbName = "pendidikaninay"

    private lateinit var db:FirebaseFirestore

    private lateinit var binding: ActivityJadwalNgajiBinding

    private lateinit var jadwalList: ArrayList<CardMapel>
    private lateinit var jadwalAdapter: JadwalAdapter



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityJadwalNgajiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        // Inisialisasi Firestore
        db = FirebaseFirestore.getInstance()

        // Menyiapkan view selain recycler view
        prepareView()
        // Menyiapkan recycler view
        binding.rvCard.setHasFixedSize(true)
        binding.rvCard.layoutManager = LinearLayoutManager(this)
        fetchData(0)
    }
    private fun prepareView() {
        binding.imgBack.setOnClickListener{
//             Replace the current fragment with a new fragment
            this.finish()
        }
        binding.tvSenin.setOnClickListener{
//            startActivity(Intent(   this, JadwalNgajiActivity::class.java))
            fetchData(0)
        }
        binding.tvSelasa.setOnClickListener {
//            startActivity(Intent(this, JadNgaSelasaActivity::class.java))
            fetchData(1)
        }
        binding.tvRabu.setOnClickListener{
//            startActivity(Intent(   this, JadNgaRabuActivity::class.java))
        }
        binding.tvKamis.setOnClickListener {
//            startActivity(Intent(this, JadNgaKamActivity::class.java))
        }
        binding.tvJumat.setOnClickListener{
//            startActivity(Intent(   this, JadNgaJumActivity::class.java))
        }
        binding.tvSabtu.setOnClickListener {
//            startActivity(Intent(this, JadNgaSabActivity::class.java))
        }
        binding.tvMinggu.setOnClickListener{
//            startActivity(Intent(   this, JadNgaMingActivity::class.java))
        }
    }
    private fun fetchData(hari: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val kelasSnapshot = db.collection(dbName).document(hari.toString())
                    .collection("kelas")
                    .get().await()
                val listKegiatan = ArrayList<CardMapel>()
                for (documentKelas in kelasSnapshot.documents) {
                    val kelasId = documentKelas.id
                    val kegiatanSnapshot = db.collection(dbName).document(hari.toString())
                        .collection("kelas").document(kelasId).collection("kegiatan").get()
                        .await()
                    for(documentKegiatan in kegiatanSnapshot.documents) {
                        listKegiatan.add(
                            CardMapel(
                                documentKegiatan.getString("namae_kegiatan"),
                                documentKegiatan.getString("kitab"),
                                documentKegiatan.getString("lokasi"),
                                documentKegiatan.getString("jam"))
                        )
                    }
                }
                withContext(Dispatchers.Main) {
                    jadwalAdapter = JadwalAdapter(listKegiatan)
                    binding.rvCard.adapter = jadwalAdapter
                }
            } catch (e: Exception) {
                Toast.makeText(this@JadwalNgajiActivity, "Error saat mengambil data", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun getJadwalData():ArrayList<CardMapel> {
        val jadwalList = ArrayList<CardMapel>()
        jadwalList.add(CardMapel("Musyawarah", "Fathul Qorib", "Masjid Utara", "05:30"));
        jadwalList.add(CardMapel("Bandongan", "Fathul Muin", "Masjid Utara", "05:30"));
        jadwalList.add(CardMapel("Musyawarah", "Fathul Muin", "Masjid Utara", "05:30"));
        jadwalList.add(CardMapel("Madrasah", "Fathul Muin", "Masjid Utara", "05:30"));
        return jadwalList
    }
}