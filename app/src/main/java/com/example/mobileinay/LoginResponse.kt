package com.example.mobileinay

data class LoginResponse(
    val message: String,
    val access_token: String?,
    val token_type: String,
    val expires_in: Int
)

data class JadwalResponse(
    val message: String,
    val data: DataKelas?
)

data class LoginRequest(
    val id_santri: String,
    val password: String
)

data class Profile(
    val message: String,
    val data: UserData?
)
data class UserData(
    val id_santri: String,
    val nama: String,
    val email: String,
    val kelas: Kelas?,
    val password: String,
)
data class DataKelas(
    val id_kelas: Int,
    val kelas: Kelas?
)

data class Kelas(
    val id_kelas: Int,
    val kelas: String,
    val jadwal: List<DataJadwal>,
    val created_at: String,
    val updated_at: String
)
data class DataJadwal(
    val id_jadwal: Int,
    val id_kelas: Int,
    val id_mapel: Int,
    val id_pengajar: Int,
    val hari: Int,
    val mulai: String,
    val selesai: String

)

data class Pendidikan(
    val id_pendidikan: Int,
    val pendidikan: String,
    val is_aktif: Int,
    val created_at: String,
    val updated_at: String
)




