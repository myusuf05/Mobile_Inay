package com.example.mobileinay.api.adapter
import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SessionManager(context: Context) {
    private val IS_Login = "is_login"
    private val prefs: SharedPreferences = context.getSharedPreferences("user_session", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = prefs.edit()



    fun setUserName(id_santri: String){
        editor.putString("id_santri", id_santri)
        editor.commit()
    }

    fun setToken(token:String?){
        prefs.edit().putString("ACCESS_TOKEN", token).apply()
        Log.d("SessionManager", "Token disimpan: $token")
//        editor.putString("token", token)
//        editor.commit()
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
    fun isLogin():Boolean{
        return  prefs.getBoolean(IS_Login, false)
    }
    fun getUserName():String?{
        return prefs.getString("Id_santri", "")
    }
    fun getKelas():String?{
        return prefs.getString("id_kelas", "")
    }
    fun getToken():String?{
        return prefs.getString("token", "")
    }
    fun removeData(){
        prefs.edit().remove("ACCESS_TOKEN").apply()
        Log.d("SessionManager", "Token dihapus")
//        editor.clear()
//        editor.commit()
    }


//    fun saveToken(token: String){
//        prefs.edit().putString("Acces_Token", token).apply()
//    }
//    fun getToken():String?{
//        return prefs.getString("Access_Token", null)
//    }
//    fun saveUserData(
//        id_santri: String,
//        nama: String,
//        idKelas: String
////        password:String
//    ){
//        prefs.edit().apply{
//            putString("Id_Santri", id_santri)
//            putString("Nama", nama)
//            putString("id Kelas", idKelas)
////            putString("Password", password)
//            apply()
//        }
//    }

//    fun getUserName(): String? {
//        return prefs.getString("Nama", null)
//    }
//
//    fun getuserClass(): String?{
//        return prefs.getString("Id_kelas", null)
//    }

}
