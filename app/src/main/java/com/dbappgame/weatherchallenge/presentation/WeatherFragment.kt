package com.dbappgame.weatherchallenge.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dbappgame.weatherchallenge.databinding.FragmentWeatherBinding
import com.dbappgame.weatherchallenge.domain.model.Forecast
import com.dbappgame.weatherchallenge.utils.CITY_KEY
import com.dbappgame.weatherchallenge.utils.showView
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WeatherFragment: Fragment() {


    companion object {
        val TAG: String = WeatherFragment::class.java.simpleName
        fun newInstance() = WeatherFragment()
    }

    private val viewModel: WeatherViewModel by activityViewModels()
    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding
    private val weatherAdapter by lazy { WeatherAdapter(::onClickForecast) }
    private var callback: WeatherListeners? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeRecyclerview()
        collectForecast()
        val city =requireArguments().getString(CITY_KEY,"")
        viewModel.getForecast(city)


    }

    private fun initializeRecyclerview() {
        binding?.let {
            with(it.rvWeather){
                layoutManager = LinearLayoutManager(requireContext())
                adapter = weatherAdapter
            }
        }
    }

    private fun collectForecast(){
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.forecastState.collect{
                    binding?.lavClouds?.showView(it.isLoading)
                    it.forecastResponse?.let { forecastResponse ->
                        weatherAdapter.submitList(forecastResponse.list)
                    }
                    if (it.error.isNotEmpty())
                        Snackbar.make(requireView(),it.error, Snackbar.LENGTH_INDEFINITE).show()

                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as WeatherListeners
    }

    
    private fun onClickForecast(forecast: Forecast){
        viewModel.forecastSelected = forecast
        callback?.onClickItem()
    }

    interface WeatherListeners {
        fun onClickItem()
    }
}