//package com.example.mobileinay.api.adapter
//import android.content.Context
//import android.content.SharedPreferences
//
//class SessionManager(context: Context) {
//    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
//    private val editor: SharedPreferences.Editor = sharedPreferences.edit()
//
//    companion object {
//        private const val PREF_NAME = "UserSession"
//        private const val KEY_TOKEN = "user_token"
//        private const val KEY_USER_ID = "user_id"
//    }
//
//    // Simpan token
//    fun saveAuthToken(token: String) {
//        editor.putString(KEY_TOKEN, token)
//        editor.apply()
//    }
//
//    // Ambil token
//    fun getAuthToken(): String? {
//        return sharedPreferences.getString(KEY_TOKEN, null)
//    }
//
//    // Simpan user_id
//    fun saveUserId(userId: String) {
//        editor.putString(KEY_USER_ID, userId)
//        editor.apply()
//    }
//
//    // Ambil user_id
//    fun getUserId(): String? {
//        return sharedPreferences.getString(KEY_USER_ID, null)
//    }
//
//    // Hapus sesi saat logout
//    fun clearSession() {
//        editor.clear()
//        editor.apply()
//    }
//}