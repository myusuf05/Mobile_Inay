package com.example.mobileinay.api.adapter
import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SessionManager(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences("user_session", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = prefs.edit()

    fun setToken(token:String?){
        prefs.edit().putString("ACCESS_TOKEN", token).apply()
        Log.d("SessionManager", "Token disimpan: $token")

    }
    fun getTokenAcces():String?{
        val token = prefs.getString("ACCESS_TOKEN", null)
        Log.d("SessionManager", "Token diambil: $token")
        return token
    }
    fun setkKelas(kelas:String){
        editor.putString("id_kelas", kelas)
        editor.commit()
    }

    fun getKelas():String?{
        return prefs.getString("id_kelas", "")
    }
    fun removeData(){
        prefs.edit().remove("ACCESS_TOKEN").apply()
        Log.d("SessionManager", "Token dihapus")

    }

}
