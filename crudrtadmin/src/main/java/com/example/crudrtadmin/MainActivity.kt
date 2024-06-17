package com.example.crudrtadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var pagiList: ArrayList<Pagi>
    private lateinit var pagiAdapter: PagiAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recylerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        pagiList = ArrayList()

        pagiList.add(Pagi("Musyawaroh", "Fathul Mu'in", "Masjid Utara", "05.30"))
        pagiList.add(Pagi("Bandongan", "Iqlil", "Aula", "05.30"))
        pagiList.add(Pagi("Ngaji", "Fathul Mu'in", "Dalem", "05.30"))
        pagiList.add(Pagi("Hafalan", "Alfiyah Ibnu Malik", "Masjid Utara", "05.30"))
        pagiList.add(Pagi("Sorogan", "Fathul Mu'in", "Dalem", "05.30"))
        pagiList.add(Pagi("Ngaji", "Fathul Mu'in", "Masjid Utara", "05.30"))
        pagiList.add(Pagi("", "", "", ""))

        pagiAdapter = PagiAdapter(pagiList)
    }
}