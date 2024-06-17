package com.example.mobileinay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DatadiriActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etKelas: EditText
    private lateinit var etAlamat: EditText
    private lateinit var btnSave: Button

    private lateinit var progressBar: ProgressBar

    private var db= Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datadiri)

        etName = findViewById(R.id.etName)
        etKelas = findViewById(R.id.etKelas)
        etAlamat = findViewById(R.id.etAlamat)
        btnSave = findViewById(R.id.btnRegister)
        //progressBar = findViewById()

        btnSave.setOnClickListener{

            val sName = etName.text.toString().trim()
            val sKelas = etKelas.text.toString().trim()
            val sAlamat = etAlamat.text.toString().trim()

            val userMap = hashMapOf(
                "nama" to sName,
                "kelas" to sKelas,
                "alamat" to sAlamat
            )

            val userId = FirebaseAuth.getInstance().currentUser!!.uid
            db.collection("user").document(userId).set(userMap)
                .addOnSuccessListener {
                    Toast.makeText(this, "sucess", Toast.LENGTH_SHORT).show()
                    etName.text.clear()
                    etKelas.text.clear()
                    etAlamat.text.clear()
                }
                .addOnFailureListener {
                    Toast.makeText(this,"Gagal", Toast.LENGTH_SHORT).show()
                }
        }
    }
}