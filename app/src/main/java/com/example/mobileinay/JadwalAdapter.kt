package com.example.mobileinay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JadwalAdapter(private val jadwalList:ArrayList<CardMapel>)
    :RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder>()
        {
    class  JadwalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val kegiatan : TextView = itemView.findViewById(R.id.JdlKegiatan)
        val kitab: TextView = itemView.findViewById(R.id.Kitab)
        val lokasi: TextView= itemView.findViewById(R.id.lokasi)
        val jam: TextView= itemView.findViewById(R.id.jam)
    }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JadwalViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_jad_nga_selasa, parent, false)
                return JadwalViewHolder(view)
            }
            override fun onBindViewHolder(holder: JadwalViewHolder, position: Int) {
                val mapel = jadwalList[position]
                holder.jam.text = mapel.jam
                holder.kegiatan.text = mapel.kegiatan
                holder.kitab.text = mapel.kitab
                holder.lokasi.text = mapel.lokasi

            }

            override fun getItemCount(): Int {
                return jadwalList.size
            }


        }