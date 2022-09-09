package com.dbappgame.weatherchallenge.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import com.dbappgame.weatherchallenge.databinding.ActivityMainBinding
import com.dbappgame.weatherchallenge.utils.CITY_KEY

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Intent(applicationContext,WeatherActivity::class.java).apply {
                putExtras(
                    bundleOf(Pair(CITY_KEY,binding.edtCity.text.toString()))
                )
                startActivity(this)
            }
        }

    }
}