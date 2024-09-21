package com.example.mobileinay


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class NilaiActivity : AppCompatActivity() {

    private var dbName = "kelas"

    private lateinit var db:FirebaseFirestore
    private lateinit var auth: FirebaseAuth
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserNilai
    private lateinit var spinnerSemester: Spinner
    private lateinit var spinnerTahun: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai)

        db = FirebaseFirestore.getInstance()
        auth = FirebaseAuth.getInstance()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        spinnerSemester = findViewById(R.id.SpinnerSemester)
        spinnerTahun = findViewById(R.id.SpinnerTahun)

//        SetUp pilihan semester
        val semesterList = listOf("Semester 1", "Semester 2")
        val semesters = ArrayAdapter.createFromResource(
            this,
            R.array.semester_array,
            android.R.layout.simple_spinner_item
        )
        semesters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSemester.adapter = semesters

//        setUp pilihan tahun ajaran
        val tahunAjaranList = listOf("2023/2024", "2022/2023")
        val tahuns = ArrayAdapter.createFromResource(
            this,
            R.array.tahun_array,
            android.R.layout.simple_spinner_item
        )
        tahuns.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTahun.adapter = tahuns

//      ambil email pengguna yang sedang login
        val userEmail = auth.currentUser?.email

//        Jika pengguna ada, amnil data dari firestore
        if (userEmail !=null){
            getUserData(userEmail)
        }
    }

//    private fun fetchData( hari: String) {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val kelascolletion = db.collection("user").document(auth.currentUser?.email.toString())
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
//                    UserNilai = JadwalAdapter(listKegiatan)
//                    binding.rvCard.adapter = UserNilai
//                }
//            } catch (e: Exception) {
//                Toast.makeText(this@NilaiActivity, "Error saat mengambil data", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
    private fun getUserData(){
//        Referensi ke dokumen user di koleksi firestore berdasarkan email
        db.collection("user").document(auth.currentUser?.email.toString())
            .get()
            .addOnSuccessListener { documents->
                if (documents !=null) {
//                    Ambil kelas pengguna
                    val kelas = documents.getString("kelas")
                    if (kelas != null){
                        fetchNilaiFromFirestore(kelas)
                    }
                }else{
                    Log.d("Firestore", "No such Dosucment")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("Firestore", "Get Failed with ", exception)
            }
    }

    private fun fetchNilaiFromFirestore(kelas: String) {
//        Ambil nilai dari sub  koleksi "nilai" di dalam dokumen kelas
        db.collection("kelas").document(kelas)
            .collection("nilai")
            .get()
            .addOnSuccessListener { result ->
                val nilaiList = ArrayList<NilaiItem>()

//                loop melalui dokumen di sub koleksi "nilai"
                for (document in result){
                    val mapel = document.getString("nama")?:""
                    val nilai = document.getLong("nilai")?.toInt()?: 0

//                    Tambahkan ke dalam list
                    nilaiList.add(NilaiItem(mapel, nilai))
                }

//                Atur adapter untuk recyclerView
                adapter = UserNilai(nilaiList)
                recyclerView.adapter = adapter
            }
            .addOnFailureListener { exception ->
                Log.d("Firestore", "Error getting documents: ", exception)
            }
    }
}
