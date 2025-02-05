package com.example.mobileinay.api.model

data class Jadwal(
    val id_mapel: Long,
    val mapel: String,
    val id_kelas: Long,
    val mulai: String,
    val selesai: String
)
