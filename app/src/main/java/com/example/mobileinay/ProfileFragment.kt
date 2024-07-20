package com.example.mobileinay

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class ProfileFragment : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
//      btn  logout
        val btnLogout = view?.findViewById<Button>(R.id.btn_logOut)
        val firebaseAuth = FirebaseAuth.getInstance()

//        Bottom LogOut
        btnLogout?.setOnClickListener{
            firebaseAuth.signOut()
            this.activity?.finish()
        }

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val firebaseAuth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()

        val user = firebaseAuth.currentUser?.email
        if (user != null){
            db.collection("user").document(user!!).get()
                .addOnSuccessListener { document ->
                    if (document != null) {
                        val name = document.data?.get("nama")
                        val kelas = document.data?.get("kelas")
                        if (name != null){
                            view?.findViewById<TextView>(R.id.Tv_NameUser)?.text = "$name"
                            view?.findViewById<TextView>(R.id.Tv_kelas)?.text = "$kelas"
                        }
                    }
                }
                .addOnFailureListener {
                    // Handle error
            }

        }
    }

}