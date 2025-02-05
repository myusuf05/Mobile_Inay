package com.example.mobileinay.ui.login

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresExtension
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileinay.R
//import com.example.mobileinay.api.adapter.SessionManager
import com.example.mobileinay.ui.home.HomeActivity

class LoginActivity : AppCompatActivity() {
//    private lateinit var sessionManager: SessionManager

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

//        sessionManager = SessionManager(this)

        // Hubungkan elemen-elemen dari XML
        val nisEditText = findViewById<EditText>(R.id.Tei_email)
        val passwordEditText = findViewById<EditText>(R.id.Tei_pass)
        val loginButton = findViewById<Button>(R.id.btn_login)

        loginButton.setOnClickListener {
            goToHome();

//            val idSantri = nisEditText.text.toString().trim()
//            val password = passwordEditText.text.toString().trim()
//
//            if (idSantri.isEmpty()){
//                Toast.makeText(this, "Nis Tidak Boleh Kososng", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//            if (password.isEmpty()){
//                Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//            loginUser(idSantri, password)
        }
    }

//    private fun loginUser(idSantri: String, password: String) {
//        val loginRequest = LoginRequest(idSantri, password)
//
//        ApiClient.apiService
//    }

    private fun goToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }



//Firebase

//            if (email.isNotEmpty() && password.isNotEmpty()) {
//                Toast.makeText(this, "Isi semua kolom!", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//            loginUser(email, password)


//    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
//    private fun loginUser(email: String, password: String) {
//        val loginRequest = LoginRequest(email, password)
//        ApiClient.instance.loginUser(loginRequest)
//            .enqueue(object : Callback<LoginResponse> {
//                override fun onResponse(
//                    call: Call<LoginResponse>,
//                    response: Response<LoginResponse>
//                ) {
//                    if (response.isSuccessful){
//                        val loginResponse = response.body()
//                        if (loginResponse != null && loginResponse.success){
//                            Toast.makeText(this@LoginActivity, "Login Berhasil: ${loginResponse.user.name}", Toast.LENGTH_SHORT).show()
//                        }else{
//                            Toast.makeText(this@LoginActivity, loginResponse?.message ?: "Login Gagal", Toast.LENGTH_SHORT).show()
//                        }
//                    }else{
//                        Toast.makeText(this@LoginActivity, "Error: ${response.code()}", Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                    Toast.makeText(this@LoginActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
//                }
//            })
//
//    }
}


//    private lateinit var progressDialog: ProgressDialog
//    private lateinit var loginBinding: ActivityLoginBinding
//    private var firebaseAuth = FirebaseAuth.getInstance()
//    private lateinit var tvLupaSandi: TextView
//
//    override fun onStart(){
//        super.onStart()
//        if(firebaseAuth.currentUser!=null){
//            startActivity(Intent(this, DatadiriActivity::class.java))
//        }
//    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(loginBinding.root)
//        supportActionBar?.hide()
//
//        tvLupaSandi = findViewById(R.id.lupaSandi)
//
//        progressDialog = ProgressDialog(this)
//        progressDialog.setTitle("Login")
//        progressDialog.setMessage("Silahkan Tunggu..")
//
//        loginBinding.btnLogin.setOnClickListener{
//            if (loginBinding.TeiEmail.text.isNotEmpty() && loginBinding.TeiPass.text.isNotEmpty()){
//                prosesLogin()
//            }else{
//                Toast.makeText(this, "Silahkan Isi Email dan Password terlebih dahulu", LENGTH_SHORT).show()
//            }
//        }
//
//        tvLupaSandi.setOnClickListener {
//            startActivity(Intent(this, LupaSandiActivity::class.java))
//        }
//        loginBinding.logReg.setOnClickListener {
//            startActivity(Intent(this, RegisterActivity::class.java))
//        }
//    }
//
//    private fun prosesLogin() {
//        val email = loginBinding.TeiEmail.text.toString()
//        val pass = loginBinding.TeiPass.text.toString()
//
//        progressDialog.show()
//        firebaseAuth.signInWithEmailAndPassword(email, pass)
//            .addOnSuccessListener {
//                startActivity(Intent(this, DatadiriActivity::class.java))
//                loginBinding.TeiEmail.text.clear()
//                loginBinding.TeiPass.text.clear()
//            }
//            .addOnFailureListener { error ->
//                Toast.makeText(this, error.localizedMessage, LENGTH_SHORT).show()
//            }
//            .addOnCompleteListener {
//                progressDialog.dismiss()
//            }
//    }
