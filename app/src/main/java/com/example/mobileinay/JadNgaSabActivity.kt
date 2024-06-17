package com.example.mobileinay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.mobileinay.databinding.ActivityJadNgaSabBinding

class JadNgaSabActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJadNgaSabBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJadNgaSabBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        // Find the ImageButton in the layout
        val img_back = findViewById<ImageButton>(R.id.img_back)

        // Set click listener on the ImageButton
        img_back.setOnClickListener{
//             Replace the current fragment with a new fragment
            this.finish()
        }

//        binding.tvSenin.setOnClickListener{
//            startActivity(Intent(   this, JadwalNgajiActivity::class.java))
//        }
//        binding.tvSelasa.setOnClickListener {
//            startActivity(Intent(this, JadNgaSelasaActivity::class.java))
//        }
//        binding.tvRabu.setOnClickListener{
//            startActivity(Intent(   this, JadNgaRabuActivity::class.java))
//        }
//        binding.tvKamis.setOnClickListener {
//            startActivity(Intent(this, JadNgaKamActivity::class.java))
//        }
//        binding.tvJumat.setOnClickListener{
//            startActivity(Intent(   this, JadNgaJumActivity::class.java))
//        }
//        binding.tvSabtu.setOnClickListener {
//            startActivity(Intent(this, JadNgaSabActivity::class.java))
//        }
//        binding.tvMinggu.setOnClickListener{
//            startActivity(Intent(   this, JadNgaMingActivity::class.java))
//        }
    }
}