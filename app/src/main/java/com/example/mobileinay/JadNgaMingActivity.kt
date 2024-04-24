package com.example.mobileinay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileinay.databinding.ActivityJadNgaMingBinding

class JadNgaMingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJadNgaMingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJadNgaMingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.tvSenin.setOnClickListener{
            startActivity(Intent(   this, JadwalNgajiActivity::class.java))
        }
        binding.tvSelasa.setOnClickListener {
            startActivity(Intent(this, JadNgaSelasaActivity::class.java))
        }
        binding.tvRabu.setOnClickListener{
            startActivity(Intent(   this, JadNgaRabuActivity::class.java))
        }
        binding.tvKamis.setOnClickListener {
            startActivity(Intent(this, JadNgaKamActivity::class.java))
        }
        binding.tvJumat.setOnClickListener{
            startActivity(Intent(   this, JadNgaJumActivity::class.java))
        }
        binding.tvSabtu.setOnClickListener {
            startActivity(Intent(this, JadNgaSabActivity::class.java))
        }
        binding.tvMinggu.setOnClickListener{
            startActivity(Intent(   this, JadNgaMingActivity::class.java))
        }
    }
}