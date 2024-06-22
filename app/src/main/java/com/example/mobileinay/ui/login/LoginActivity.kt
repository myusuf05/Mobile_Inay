package com.example.mobileinay.ui.login

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.mobileinay.DatadiriActivity
import com.example.mobileinay.ui.home.HomeActivity
import com.example.mobileinay.R
import com.example.mobileinay.databinding.ActivityLoginBinding
import com.example.mobileinay.ui.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var progressDialog: ProgressDialog
    private lateinit var loginBinding: ActivityLoginBinding
    private var firebaseAuth = FirebaseAuth.getInstance()

    override fun onStart(){
        super.onStart()
        if(firebaseAuth.currentUser!=null){
            startActivity(Intent(this, DatadiriActivity::class.java))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        supportActionBar?.hide()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Logging")
        progressDialog.setMessage("Silahkan Tunggu..")

        loginBinding.btnLogin.setOnClickListener{
            if (loginBinding.TeiEmail.text.isNotEmpty() && loginBinding.TeiPass.text.isNotEmpty()){
                prosesLogin()
            }else{
                Toast.makeText(this, "Silahkan Isi Email dan Password terlebih dahulu", LENGTH_SHORT).show()
            }
        }
        loginBinding.logReg.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun prosesLogin() {
        val email = loginBinding.TeiEmail.text.toString()
        val pass = loginBinding.TeiPass.text.toString()

        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email, pass)
            .addOnSuccessListener {
                startActivity(Intent(this, DatadiriActivity::class.java))
                loginBinding.TeiEmail.text.clear()
                loginBinding.TeiPass.text.clear()
            }
            .addOnFailureListener { error ->
                Toast.makeText(this, error.localizedMessage, LENGTH_SHORT).show()
            }
            .addOnCompleteListener {
                progressDialog.dismiss()
            }
    }
}