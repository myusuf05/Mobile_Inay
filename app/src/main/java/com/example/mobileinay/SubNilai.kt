package com.example.mobileinay

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

data class Nilai(
    var nama: String?,
    var nilai: Int = 0,
    var semester: String?,
    var studentEmail: String?,
    var tahun: String?,
)



