package com.example.mobileinay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JadwalAdapter
    (private var jadwalList: List<DataJadwal>)
    : RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder>()
{
    class JadwalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(jadwal: DataJadwal){
            itemView.findViewById<TextView>(R.id.JdlKegiatan).text = jadwal.kegiatan
            itemView.findViewById<TextView>(R.id.Kitab).text = jadwal.kitab
            itemView.findViewById<TextView>(R.id.jamMulai).text = jadwal.jamMulai
            itemView.findViewById<TextView>(R.id.jamSelesai).text = jadwal.jamSelesai
        }

//        val tvMulai: TextView = itemView.findViewById(R.id.jamMulai)
//        val tvSelesai: TextView = itemView.findViewById(R.id.jamSelesai)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): JadwalViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.activity_jad_nga_selasa,parent, false)
        return JadwalViewHolder(item)
    }

    override fun onBindViewHolder(holder: JadwalViewHolder, position: Int) {

        holder.bind(jadwalList[position])
    }

    override fun getItemCount(): Int = jadwalList.size

    fun updateData(newList: List<DataJadwal>) {
        jadwalList = newList
        notifyDataSetChanged()
    }

}
