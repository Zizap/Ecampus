package com.example.ecampus.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.ecampus.R
import com.example.ecampus.databinding.ActivityMainBinding
import com.example.ecampus.presentation.scheduleFragments.Institute


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setSupportActionBar(binding?.topAppBar)

        supportFragmentManager.beginTransaction().replace(R.id.contentFragment,Home()).commit()
        binding?.bottomMainMenu?.selectedItemId = R.id.bottomMenuHome

        binding?.bottomMainMenu?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottomMenuHome -> supportFragmentManager.beginTransaction().replace(R.id.contentFragment, Home()).commit()
                //R.id.bottomMenuAccount -> supportFragmentManager.beginTransaction().replace(R.id.contentFragment, Account()).commit()
                R.id.bottomMenuSchedule -> supportFragmentManager.beginTransaction().replace(R.id.contentFragment, Institute()).commit()


            }
            return@setOnItemSelectedListener true
        }

        setContentView(binding?.root)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val mainMenu = MainMenu()
                mainMenu.show(
                    supportFragmentManager,
                    "main_menu"
                )
            }
        }
        return true
    }





}

