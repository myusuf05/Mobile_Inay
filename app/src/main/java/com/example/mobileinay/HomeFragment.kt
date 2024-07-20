package com.example.mobileinay

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class HomeFragment : Fragment() {

    val Auth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        //find the ImageButton in the layout
        val imgNilai = view?.findViewById<ImageButton>(R.id.imgNilai)
        val imgNgaji = view?.findViewById<ImageButton>(R.id.imgJadwal_ngaji)
        val imgAman = view?.findViewById<ImageButton>(R.id.imgkeamanan)
        val imgLaporan = view?.findViewById<ImageButton>(R.id.imgraport)
        val imgBuku = view?.findViewById<ImageButton>(R.id.majmu)

        // Set click listener on the ImageButton
        imgNilai?.setOnClickListener {
            val intent = Intent(activity, NilaiActivity::class.java)
            startActivity(intent)
        }
        imgNgaji?.setOnClickListener{

            val intent = Intent(activity, JadwalNgajiActivity::class.java)
            startActivity(intent)
        }
        imgAman?.setOnClickListener{
            val intent = Intent(activity, KeamananActivity::class.java)
            startActivity(intent)
        }
        imgLaporan?.setOnClickListener {
            val intent = Intent(activity, RaportActivity::class.java)
            startActivity(intent)
        }
        imgBuku?.setOnClickListener {
            val intent = Intent(activity, MajmuActivity::class.java)
            startActivity(intent)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val Auth = FirebaseAuth.getInstance()

        val user = Auth.currentUser
        if (user != null){
            UserData (view)
        }
    }

    private fun UserData(view: View) {
        val userId = Auth.currentUser?.email
        if (userId !=null){
            db.collection("user").document(userId!!).get()
                .addOnSuccessListener { document ->
                    if (document != null){
                        val name = document.data?.get("nama")
                        if (name != null){
                            view?.findViewById<TextView>(R.id.NamaUser)?.text = "Halo, $name"
                        }
                    }
                }

        }
    }

}