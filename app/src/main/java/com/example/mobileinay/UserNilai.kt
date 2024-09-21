package com.example.mobileinay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class NilaiItem(
    val mapel: String = "",
    val nilai: Int = 0
)

class UserNilai(private val nilaiList: List<NilaiItem>) :
    RecyclerView.Adapter<UserNilai.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val namaMapel: TextView = itemView.findViewById(R.id.NamaMapel_tv)
        val nilaiMapel: TextView = itemView.findViewById(R.id.Nilai_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_sub_nilai, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val nilai = nilaiList[position]
        holder.namaMapel.text = nilai.mapel
        holder.nilaiMapel.text = nilai.nilai.toString()
    }

    override fun getItemCount(): Int {
        return nilaiList.size
    }
}