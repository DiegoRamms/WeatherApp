package com.dbappgame.weatherchallenge.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dbappgame.weatherchallenge.databinding.ItemWeatherBinding
import com.dbappgame.weatherchallenge.domain.model.Forecast

class WeatherAdapter(private val callback: ((Forecast) -> Unit)? = null) :
    ListAdapter<Forecast, WeatherAdapter.ViewHolder>(ForecastDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemWeatherBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)
    }

    inner class ViewHolder(private val binding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Forecast) {
            with(binding) {
                textView2.text = item.weather.first().main
                textView3.text = "Temp: ${item.main.temp}"
                root.setOnClickListener {
                    callback?.let { it(item) }
                }
            }


        }
    }
}


object ForecastDiffCallback : DiffUtil.ItemCallback<Forecast>() {
    override fun areItemsTheSame(oldItem: Forecast, newItem: Forecast): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Forecast, newItem: Forecast): Boolean {
        return oldItem == newItem
    }

}
