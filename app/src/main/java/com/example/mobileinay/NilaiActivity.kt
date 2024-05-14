package com.example.mobileinay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast

class NilaiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai)

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
}