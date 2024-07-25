package com.example.mobileinay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileinay.databinding.ActivityNilaiBinding
import com.google.firebase.auth.FirebaseAuth

class NilaiActivity : AppCompatActivity() {


    private lateinit var binding: ActivityNilaiBinding
    private val nilaiView: penilain_user by viewModels()
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNilaiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
//        val adap = nilaiAdapter()
//        binding.nilaiMapel.layoutManager = LinearLayoutManager(this)
//        binding.nilaiMapel.adapter = adap

//        nilaiView.semesterNilai.observe(this, Observer{ listNilai ->
//            adap.submitList(listNilai)
//        })
        
//        penilain_user.nam

        prepareView()

        val items = listOf("Semester 1", "Semester 2")

        val autoComplete : AutoCompleteTextView = findViewById(R.id.auto_complete)

        val adapter = ArrayAdapter(this,R.layout.list_semester,items)

        autoComplete.setAdapter(adapter)

        val tahun = listOf("2022/2023", "2023/2024")

        val otomatis :AutoCompleteTextView = findViewById(R.id.auto_complete2)

        val ketahun = ArrayAdapter(this,R.layout.list_semester,tahun)

        otomatis.setAdapter(ketahun)


        autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
            adapterView, view, i, l ->

            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this,"Item: $itemSelected", Toast.LENGTH_SHORT).show()
        }
    }

//    private fun nilaiAdapter(): Any {
//
//    }

    private fun prepareView() {
        val btnKembali: ImageButton = findViewById(R.id.img_kembali)
        btnKembali.setOnClickListener {
            val intent = Intent(this, HomeFragment::class.java)
            startActivity(intent)
            finish()
        }
    }


}