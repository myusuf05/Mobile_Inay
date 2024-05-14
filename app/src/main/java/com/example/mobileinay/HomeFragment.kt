package com.example.mobileinay

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
//        FirebaseAuth
        val Nameuser =  view?.findViewById<TextView>(R.id.NamaUser)

        val firebaseAuth = FirebaseAuth.getInstance()


        //find the ImageButton in the layout
        val imgNilai = view?.findViewById<ImageButton>(R.id.imgNilai)
        val imgNgaji = view?.findViewById<ImageButton>(R.id.imgJadwal_ngaji)
        val imgAman = view?.findViewById<ImageButton>(R.id.imgkeamanan)
        val imgLaporan = view?.findViewById<ImageButton>(R.id.imgraport)
        val imgBuku = view?.findViewById<ImageButton>(R.id.majmu)

//        Set Nama User
        val firebaseUser = firebaseAuth.currentUser
        Log.e("faqih", "${firebaseUser?.displayName}")
        if (firebaseUser!=null){

            Nameuser?.setText("${firebaseUser?.displayName}")
        }else{
//            this.activity?.finish()
        }

        // Set click listener on the ImageButton
        imgNilai?.setOnClickListener {
            val intent = Intent(activity, NilaiActivity::class.java)
            startActivity(intent)
        }
        imgNgaji?.setOnClickListener{

            val intent = Intent(activity, JadwalNgajiActivity::class.java)
            startActivity(intent)
        }
        imgAman?.setOnClickListener{
            val intent = Intent(activity, KeamananActivity::class.java)
            startActivity(intent)
        }
        imgLaporan?.setOnClickListener {
            val intent = Intent(activity, RaportActivity::class.java)
            startActivity(intent)
        }
        imgBuku?.setOnClickListener {
            val intent = Intent(activity, MajmuActivity::class.java)
            startActivity(intent)
        }
        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}