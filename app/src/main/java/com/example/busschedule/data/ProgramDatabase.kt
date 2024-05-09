package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(BusSchedule::class), version = 1)
abstract class ProgramDatabase: RoomDatabase() {
    abstract fun busScheduleDao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: ProgramDatabase? = null

        fun getDatabase(context: Context): ProgramDatabase {
        return INSTANCE ?: synchronized(this) {
            Room.databaseBuilder(
                context,
                ProgramDatabase::class.java,
                "app_database"
            )
                .createFromAsset("database/bus_schedule.db")
                .fallbackToDestructiveMigration()
                .build()
                .also {
                    INSTANCE = it
                    }
            }
        }
    }
}