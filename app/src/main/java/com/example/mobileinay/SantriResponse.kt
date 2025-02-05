package com.example.mobileinay

data class SantriResponse(
    val id_santri: Int,
    val name: String,
    val nik: Int,
    val no_hp: String,
    val email: String
)
data class kelas_santri(
    val id_kelas: Int,
    val nama: String
)
data class jadwal_santri(
    val id_jadwal: Int,
    val id_kelas: Int,
    val id_mapel: Int,
    val id_pengajar: Int,
    val hari: Int,
    val mulai: String,
    val selesai: String
)
data class nilai_santri(
    val id_nilai: Int,
    val id_santri: Int,
    val id_mapel: Int,
    val id_pengajar: Int,
    val tugas: String
)
data class keamanan_santri(
    val id_presensi: Int,
    val id_santri: Int,
    val tanggal: Int,
    val waktu: String,
    val status: String
)
data class pengajar(
    val id_pengajar: Int,
    val nama: String,
    val no_hp: String,
    val alamat: String,
    val jenis_kelamin: String
)
