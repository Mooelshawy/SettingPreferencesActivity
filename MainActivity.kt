package com.omran.settingpreferencesactivity.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.omran.settingpreferencesactivity.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //set for back button
        setupActionBarWithNavController(findNavController(R.id.fragment_main))

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}