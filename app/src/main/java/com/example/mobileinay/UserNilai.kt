//package com.example.mobileinay
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class UserNilai(private val userList: ArrayList<SubNilai>) : RecyclerView.Adapter<UserNilai.UserViewHolder>() {
//
//    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        val namaMapel: TextView = itemView.findViewById(R.id.NamaMapel)
//        val nilaiMapel: TextView = itemView.findViewById(R.id.Nilai)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
//        val itemView =
//            LayoutInflater.from(parent.context).inflate(R.layout.card_sub_nilai, parent, false)
//        return UserViewHolder(itemView)
//    }
//
////    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
////        holder.namaMapel.text = userList[position].mapel
////        holder.nilaiMapel.text = userList[position].nilai
////    }
//
//    override fun getItemCount(): Int {
//        return userList.size
//    }
//
//
//}