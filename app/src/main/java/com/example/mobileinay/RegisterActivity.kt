package com.example.mobileinay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileinay.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnReg.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding.logReg.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}