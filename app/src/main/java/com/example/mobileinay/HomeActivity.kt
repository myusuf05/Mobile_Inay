package com.example.mobileinay

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.mobileinay.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.google.firebase.auth.FirebaseAuth


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        supportActionBar?.hide()

        binding.btnNv.setOnItemSelectedListener {
            when(it.itemId){
                R.id.btn_home -> replaceFragment(HomeFragment())
                R.id.btn_mapel -> replaceFragment(MapelFragment())
                R.id.btn_tagihan -> replaceFragment(TagihanFragment())
                R.id.btn_profile -> replaceFragment(ProfileFragment())

                else ->{

                }
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.Fragment_home,fragment)
        fragmentTransaction.commit()
    }
}