package com.example.mobileinay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject

class penilain_user: ViewModel() {
    private lateinit var db: FirebaseFirestore
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var listSemester: MutableLiveData<List<Semester>>
            val semesterNilai: LiveData<List<Semester>> get() = listSemester

    fun nambahSemester(semester: penilaian){
        db = FirebaseFirestore.getInstance()
        db.collection("user").document(firebaseAuth.currentUser?.email.toString())
            .collection("nilai")
            .get()
            .addOnSuccessListener { documents ->
                val listNilai = mutableListOf<Semester>()
                for (document in documents){
                    val semester = document.toObject(Semester::class.java)
                    listNilai.add(semester)
                }
                listSemester.value = listNilai
            }
            .addOnFailureListener { e ->
//
            }
    }
}

