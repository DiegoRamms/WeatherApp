package com.dbappgame.weatherchallenge.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dbappgame.weatherchallenge.data.repository.ForecastRepository
import com.dbappgame.weatherchallenge.domain.model.Forecast
import com.dbappgame.weatherchallenge.domain.model.ForecastResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: ForecastRepository) :
    ViewModel() {

    private val _forecastSate = MutableStateFlow(ForecastState())
    val forecastState get() = _forecastSate.asStateFlow()
    var forecastSelected: Forecast? = null


    fun getForecast(city: String){
        viewModelScope.launch( CoroutineExceptionHandler { _, _ ->
            _forecastSate.value = _forecastSate.updateAndGet { it.copy(isLoading = false, error = "Salir y elegir otra opción") }
        }) {
            _forecastSate.value = _forecastSate.updateAndGet {
                 it.copy(
                    isLoading = false,
                    forecastResponse = repository.getForecast(city)
                )
            }
        }
    }

}


data class ForecastState(val isLoading: Boolean = true, val forecastResponse: ForecastResponse? = null, val error: String = "")