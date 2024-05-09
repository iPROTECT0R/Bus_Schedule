package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.ProgramDatabase

class BusScheduleApplication: Application() {
    val database: ProgramDatabase by lazy {
        ProgramDatabase.getDatabase(this) }
}
