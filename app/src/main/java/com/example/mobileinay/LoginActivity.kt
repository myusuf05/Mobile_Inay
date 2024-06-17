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
import com.example.mobileinay.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var editTieEmail: EditText
    lateinit var editTiePass: EditText
    lateinit var btnLogin:Button
    lateinit var logReg:TextView
    lateinit var progressDialog: ProgressDialog


    var firebaseAuth = FirebaseAuth.getInstance()

//    override fun onStart(){
//        super.onStart()
//        if(firebaseAuth.currentUser!=null){
//            startActivity(Intent(this, HomeActivity::class.java))
//        }
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        editTieEmail = findViewById(R.id.Tei_email)
        editTiePass = findViewById(R.id.Tei_pass)
        logReg = findViewById(R.id.log_reg)
        btnLogin = findViewById(R.id.btn_login)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Logging")
        progressDialog.setMessage("Silahkan Tunggu..")

        btnLogin.setOnClickListener{
            if (editTieEmail.text.isNotEmpty()&& editTiePass.text.isNotEmpty()){
                prosesLogin()
            }else{
                Toast.makeText(this, "Silahkan Isi Email dan Password terlebih dahulu", LENGTH_SHORT).show()
            }
        }
        logReg.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun prosesLogin() {
        val email = editTieEmail.text.toString()
        val pass = editTiePass.text.toString()

        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email, pass)
            .addOnSuccessListener {
                startActivity(Intent(this, HomeActivity::class.java))
                editTieEmail.text.clear()
                editTiePass.text.clear()
            }
            .addOnFailureListener { error ->
                Toast.makeText(this, error.localizedMessage, LENGTH_SHORT).show()
            }
            .addOnCompleteListener {
                progressDialog.dismiss()
            }
    }
}