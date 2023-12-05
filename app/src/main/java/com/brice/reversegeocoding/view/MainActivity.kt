package com.brice.reversegeocoding.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brice.reversegeocoding.R
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private var param1: String? = null
    private lateinit var bottomNavigationView: NavigationBarView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bnv_id)
        setBottomMenu()
    }

    override fun onStart() {
        super.onStart()
        //Set up first fragment on load of app
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_id, ReverseFragment.newInstance())
            .commit()
    }

    //Manage Bottom menu
    private fun setBottomMenu() {
        bottomNavigationView.setOnItemSelectedListener() { item ->
            when (item.itemId) {
                R.id.item_1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fcv_id, ReverseFragment.newInstance())
                        .commit()
                    true
                }

                R.id.item_2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fcv_id, ForwardFragment.newInstance())
                        .commit()

                    true
                }

                else -> false
            }
        }
    }
}