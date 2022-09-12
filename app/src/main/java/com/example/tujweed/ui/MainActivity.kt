package com.example.tujweed.ui

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tujweed.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = this.findNavController(R.id.myNavHostFragment)
        val bottom = findViewById<BottomNavigationView>(R.id.bottomNavigationView2)
        bottom.background = null
        bottom.menu.getItem(2).isEnabled = false

        findViewById<BottomNavigationView>(R.id.bottomNavigationView2).setupWithNavController(navController)





    }
}