package com.example.mobileinay

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.mobileinay.databinding.ActivityDatadiriBinding
import com.example.mobileinay.ui.home.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class DatadiriActivity : AppCompatActivity() {
    lateinit var progressDialog: ProgressDialog
    private var firebaseAuth = FirebaseAuth.getInstance()
    private var firestore = FirebaseFirestore.getInstance()
    private lateinit var datadiriBinding: ActivityDatadiriBinding
    private lateinit var userEmail: String

    override fun onStart() {
        super.onStart()
        firestore.collection("user").document(userEmail).get()
            .addOnSuccessListener { document ->
                if (document.data != null) goToHome()
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        datadiriBinding = ActivityDatadiriBinding.inflate(layoutInflater)
        setContentView(datadiriBinding.root)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Proses")
        progressDialog.setMessage("Silahkan Tunggu..")

        val loggedInEmail = firebaseAuth.currentUser?.email
        if (loggedInEmail != null) {
            userEmail = loggedInEmail
        } else {
            finish()
        }

        datadiriBinding.btnRegister.setOnClickListener{
            val sName = datadiriBinding.etName.text.toString().trim()
            val sKelas = datadiriBinding.etKelas.text.toString().trim()
            val sAlamat = datadiriBinding.etAlamat.text.toString().trim()
            if (sName.isEmpty() || sKelas.isEmpty() || sAlamat.isEmpty()) {

                Toast.makeText(this, "Silahkan isi data diri dulu", Toast.LENGTH_SHORT).show()
            }else{
                goToHome()
                insertUser(sName, sKelas, sAlamat)
            }

        }
    }

    private fun goToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    private fun insertUser(nama: String, kelas: String, alamat: String) {
        val userMap = hashMapOf(
            "nama" to nama,
            "kelas" to kelas,
            "alamat" to alamat
        )
        firestore.collection("user").document(userEmail).set(userMap)
            .addOnSuccessListener {
                goToHome()
            }
            .addOnFailureListener {
                Toast.makeText(this,"Gagal menyimpan data", Toast.LENGTH_SHORT).show()
            }
    }

}