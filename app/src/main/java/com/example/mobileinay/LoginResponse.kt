package com.example.mobileinay

data class LoginResponse(
    val message: String,
    val data: UserData?,
    val access_token: String?,
    val token_type: String,
    val expires_in: Int
)

data class LoginRequest(
    val id_santri: String,
    val password: String

)
data class ProtectedResponse(
    val message: String,
    val data: UserData?
)

data class UserData(
    val id_santri: String,
    val nama: String,
    val email: String,
    val kelas: String,
    val password: String,

)

data class Kelas(
    val id_kelas: Int,
    val kelas: String,
    val created_at: String,
    val updated_at: String
)

data class Pendidikan(
    val id_pendidikan: Int,
    val pendidikan: String,
    val is_aktif: Int,
    val created_at: String,
    val updated_at: String
)

data class Profile(
    val message: String,
    val data: com.example.mobileinay.UserData
)


