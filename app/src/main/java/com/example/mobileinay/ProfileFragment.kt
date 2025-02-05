package com.example.mobileinay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Logout Button
        val btnLogout = view.findViewById<Button>(R.id.btn_logOut)
        btnLogout.setOnClickListener {
            // Tambahkan logika logout API jika perlu
            requireActivity().finish()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        getProfile(view)
    }

//    private fun getProfile(view: View){
//
//        val call = ApiClient.profileSantriServices.getProfile()
//
//        call.enqueue(object : Callback<ProfileSantri>{
//            override fun onResponse(call: Call<ProfileSantri>, response: Response<ProfileSantri>) {
//                val data = response.body();
//                if (response.isSuccessful) {
//                        view.findViewById<TextView>(R.id.Tv_NameUser)?.text = data?.santri_nama
//                        view.findViewById<TextView>(R.id.Tv_kelas)?.text = data?.santri_kelas
//
//                } else {
//                    Log.e("ProfileFragment", "Response failed: ${response.errorBody()?.string()}")
//                }
//            }
//
//            override fun onFailure(call: Call<ProfileSantri>, t: Throwable) {
//                Log.e("ProfileFragment", "Error fetching user data", t)
//            }
//
//        })
//    }
}
