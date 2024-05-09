package com.example.busschedule.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.busschedule.BusScheduleApplication
import com.example.busschedule.data.BusSchedule
import com.example.busschedule.data.Dao
import kotlinx.coroutines.flow.Flow

// view model
class BusScheduleViewModel(private val busScheduleDao: Dao): ViewModel() {
    fun getFullSchedule(): Flow<List<BusSchedule>> = busScheduleDao.getAll()
    fun getScheduleFor(stopName: String): Flow<List<BusSchedule>> =
    busScheduleDao.getByStopName(stopName)

companion object {
val factory : ViewModelProvider.Factory = viewModelFactory {
initializer {
    val application = (this[APPLICATION_KEY] as BusScheduleApplication)
    BusScheduleViewModel(application.database.busScheduleDao())
            }
        }
    }
}
