package com.dbappgame.weatherchallenge.di

import com.dbappgame.weatherchallenge.data.networkdatasource.ForecastNetworkDataSource
import com.dbappgame.weatherchallenge.data.networkdatasource.ForecastNetworkDataSourceImp
import com.dbappgame.weatherchallenge.data.repository.ForecastRepository
import com.dbappgame.weatherchallenge.data.repository.ForecastRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

   @Binds
   abstract fun provideForecastRepository(forecastRepository: ForecastRepositoryImp): ForecastRepository

   @Binds abstract fun provideForecastNetworkSource(forecastNetworkDataSourceImp: ForecastNetworkDataSourceImp): ForecastNetworkDataSource
}