package com.example.mobileinay

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.mobileinay.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.userProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    lateinit var editTeiUser: EditText
    lateinit var editTeiKelas: EditText
    lateinit var editTeiAlamat: EditText
    lateinit var editTieEmail:EditText
    lateinit var editTiePass:EditText
    lateinit var editTieConfPass:EditText
    lateinit var logReg:TextView
    lateinit var btnReg:Button
    lateinit var progressDialog: ProgressDialog

    var firebaseAuth = FirebaseAuth.getInstance()
    private lateinit var db: FirebaseFirestore

    override fun onStart(){
        super.onStart()
//        if(firebaseAuth.currentUser!=null){
//            startActivity(Intent(this, HomeActivity::class.java))
//        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()


        editTieEmail = findViewById(R.id.Tei_email)
        editTiePass = findViewById(R.id.Tei_pass)
        editTieConfPass = findViewById(R.id.Tei_ConfPass)
        btnReg = findViewById(R.id.btn_Reg)
        logReg = findViewById(R.id.log_reg)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Proses")
        progressDialog.setMessage("Silahkan Tunggu..")

        logReg.setOnClickListener {
            startActivity(Intent(this, DatadiriActivity::class.java))
        }

        btnReg.setOnClickListener{
            if (editTeiUser.text.isNotEmpty() && editTeiKelas.text.isNotEmpty()
                && editTieEmail.text.isNotEmpty() && editTiePass.text.isNotEmpty()){
                if (editTiePass.text.toString() == editTieConfPass.text.toString()){
                    //Menampilkan Register
                    processRegister()
                }else{
                    Toast.makeText(this, "Konfirmasi kata sandi harus sama" ,LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Silahkan Isi dulu Semua datanya" , LENGTH_SHORT).show()
            }
        }
    }
    private fun processRegister(){
        val userName = editTeiUser.text.toString()
        val kelas = editTeiKelas.text.toString()
        val email = editTieEmail.text.toString()
        val pass = editTiePass.text.toString()

        progressDialog.show()
        firebaseAuth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    val userUpdateProfile = userProfileChangeRequest {
                        displayName = userName
                        val kelas = hashMapOf(
                            "kelas" to kelas,
                            "email" to email
                        )
                    }
                    val user = task.result.user
                    user!!.updateProfile(userUpdateProfile)
                        .addOnCompleteListener {
                            progressDialog.dismiss()
                            startActivity(Intent(this, DatadiriActivity::class.java))
                        }
                        .addOnFailureListener { error2 ->
                            Toast.makeText(this, error2.localizedMessage, LENGTH_SHORT).show()
                        }
                }else{
                    progressDialog.dismiss()
                }
            }
            .addOnFailureListener { error ->
                Toast.makeText(this, error.localizedMessage, LENGTH_SHORT).show()
            }
    }
}