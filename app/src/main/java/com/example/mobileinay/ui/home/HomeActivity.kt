package com.example.mobileinay.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobileinay.HomeFragment
import com.example.mobileinay.MapelFragment
import com.example.mobileinay.ProfileFragment
import com.example.mobileinay.R
import com.example.mobileinay.TagihanFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNav = findViewById<BottomNavigationView>(R.id.btn_nv)

        replaceFragment(HomeFragment())
        supportActionBar?.hide()

//        load HomeFragment
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.Fragment_home, HomeFragment())
        }

        bottomNav.setOnItemSelectedListener {
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
        supportFragmentManager.beginTransaction()
            .replace(R.id.Fragment_home, fragment)
            .commit()
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.Fragment_home,fragment)
//        fragmentTransaction.commit()
    }
}