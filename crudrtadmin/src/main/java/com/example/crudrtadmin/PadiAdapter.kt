package com.example.crudrtadmin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PagiAdapter(private val pagiList: ArrayList<Pagi>)
    :RecyclerView.Adapter<PagiAdapter.PagiViewHolder>(){

    class PagiViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val kegiatan : TextView = itemView.findViewById(R.id.JdlKegiatan)
        val kitab : TextView = itemView.findViewById(R.id.Kitab)
        val lokasi : TextView = itemView.findViewById(R.id.lokasi)
        val jam : TextView = itemView.findViewById(R.id.jam)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day_item, parent, false)
        return  PagiViewHolder(view)
    }

    override fun onBindViewHolder(holder: PagiViewHolder, position: Int) {
        val cardjdl = pagiList[position]
        holder.kegiatan.text = cardjdl.kegiatan
        holder.kitab.text = cardjdl.kitab
        holder.lokasi.text = cardjdl.lokasi
        holder.jam.setText(cardjdl.jam)

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}