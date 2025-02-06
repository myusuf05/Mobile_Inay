package com.example.mobileinay


//import com.example.mobileinay.retrofit.ApiClient
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class NilaiActivity : AppCompatActivity() {

    private var dbName = "kelas"
//    private lateinit var db:FirebaseFirestore
//    private var auth = FirebaseAuth.getInstance()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserNilai
    private lateinit var spinnerSemester: Spinner
    private lateinit var spinnerTahun: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai)

//        db = FirebaseFirestore.getInstance()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        spinnerSemester = findViewById(R.id.SpinnerSemester)
        spinnerTahun = findViewById(R.id.SpinnerTahun)

//        ApiClient.instance.get_nilai().enqueue(object : Callback<List<nilai_santri>> {
//            override fun onResponse(
//                call: Call<List<nilai_santri>>,
//                response: Response<List<nilai_santri>>
//            ) {
//                if (response.isSuccessful){
//                    val nilaiList = response.body()
//                }
//            }
//
//            override fun onFailure(call: Call<List<nilai_santri>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })

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
//        val userEmail = auth.currentUser
//
//        if (userEmail != null){
//            val emailUser = userEmail.email
//
////            mengambil kelas pengguna berdasarkan email
//            db.collection("user").document(auth.currentUser?.email.toString())
//                .get()
//                .addOnSuccessListener { documents ->
//                    if (documents.exists()){
//                        val kelas = documents.getString("kelas") ?: ""
//
////                        list untuk menyimpan data nilai
//                        val nilaiList = mutableListOf<NilaiItem>()
//
////                        Setelah mendapatkan kelas pengguna, ambil nilai dari sub nilai
//                        db.collection("kelas").document(kelas)
//                            .collection("nilai")
//                            .get()
//                            .addOnSuccessListener { querySnapshot ->
//                                for (document in querySnapshot){
//                                    val mapel = document.getString("mapel") ?: ""
//                                    val nilai = document.getLong("nilai") ?.toInt() ?:0
//                                    val semester = document.getString("semester") ?:""
//                                    val tahunAjaran = document.getString("tahunAjaran") ?: ""
//
////                                    menambahkan data ke list
//                                    nilaiList.add(NilaiItem(mapel, nilai, semester, tahunAjaran))
//
////                                    menampilkan nilai ini ke recyclerView atau logcat
//                                    Log.d("Firestore", "Mata pelajaran: $mapel, Nilai: $nilai")
//                                }
////                                Setelah data lengkap, set adapter ke recyclerView
//                                val adapter = UserNilai(nilaiList)
//                                recyclerView.adapter = adapter
//                            }
//                            .addOnFailureListener { e ->
//                                Log.w("Firebase", "Error mengambil data nilai", e)
//                            }
//                    }
//                }
//                .addOnFailureListener { e ->
//                    Log.w("Firebase", "Eror mengambil data kelas User", e)
//                }
//        }else{
////            jika user belum Login
//            Log.w("Auth", "User Belum Login")
//        }

    }

}
