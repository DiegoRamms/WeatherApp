package com.dbappgame.weatherchallenge.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.dbappgame.weatherchallenge.R
import com.dbappgame.weatherchallenge.databinding.ActivityWeatherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherActivity : AppCompatActivity(), WeatherFragment.WeatherListeners {

    private lateinit var binding: ActivityWeatherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val weatherFragment = WeatherFragment.newInstance().apply { arguments = intent.extras }
        supportFragmentManager.commit {
            replace(
                R.id.content, weatherFragment ,WeatherFragment.TAG
            )
        }


    }

    override fun onClickItem() {
        supportFragmentManager.commit {
            replace(
                R.id.content, WeatherDetailFragment.newInstance(), WeatherDetailFragment.TAG
            )
            addToBackStack(WeatherDetailFragment.TAG)
        }
    }
}