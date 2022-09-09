package com.dbappgame.weatherchallenge.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.dbappgame.weatherchallenge.databinding.FragmentForecastDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherDetailFragment: Fragment() {

    companion object {
        val TAG: String = WeatherDetailFragment::class.java.simpleName
        fun newInstance() = WeatherDetailFragment()
    }

    private var _binding: FragmentForecastDetailBinding? = null
    private val binding get() = _binding
    private val viewModel by activityViewModels<WeatherViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForecastDetailBinding.inflate(layoutInflater,container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let {
            it.tvTemperature.text = viewModel.forecastSelected?.main?.temp.toString()
            it.tvWeather.text = viewModel.forecastSelected?.weather?.first()?.main ?: "No Info"
            it.tvFeelsTemperature.text = "Feels Like: ${viewModel.forecastSelected?.main?.feelsLike.toString()}"
            it.tvDescription.text = viewModel.forecastSelected?.weather?.first()?.description ?: "No description"
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}