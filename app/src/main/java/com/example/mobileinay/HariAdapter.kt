package com.example.mobileinay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HariAdapter(
    private val jadwalList: List<Jadwal>,
    private val onHariClick: (Jadwal) -> Unit
) : RecyclerView.Adapter<HariAdapter.HariViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HariViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_jad_nga_selasa, parent, false)
        return HariViewHolder(view)
    }

    override fun onBindViewHolder(holder: HariViewHolder, position: Int) {
        val jadwal = jadwalList[position]
        holder.bind(jadwal)
        holder.itemView.setOnClickListener { onHariClick(jadwal) }
    }

    override fun getItemCount(): Int = jadwalList.size

    class HariViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(jadwal: Jadwal) {
            itemView.findViewById<TextView>(R.id.tvSenin).text = jadwal.hari
        }
    }
}
