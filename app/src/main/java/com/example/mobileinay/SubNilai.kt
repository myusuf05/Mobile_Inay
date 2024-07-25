package com.example.mobileinay

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

data class SubNilai(
    val nama: String? = null,
    val nilai: Number? = null
)

data class Semester(
    val semester: String = "",
    val tahun: String = "",
    val mapel: List<SubNilai> = listOf()
)

private var firebaseAuth = FirebaseAuth.getInstance()

fun addNilai( semester: Semester){
    val firestore = FirebaseFirestore.getInstance()
    firestore.collection("user").document(firebaseAuth.currentUser?.email.toString())
        .collection("nilai")
        .add(semester)
        .addOnSuccessListener {
//
        }
        .addOnFailureListener {
//
        }

}


