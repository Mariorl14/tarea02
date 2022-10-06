package com.tarea02.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tarea02.model.Sede


@Database(entities = [Sede::class],version=1, exportSchema = false)
abstract class SedeDatabase : RoomDatabase() {
    abstract fun SedeDao() : SedeDao
    companion object {
        @Volatile
        private var INSTANCE: SedeDatabase? = null
        fun getDatabase(context: android.content.Context) : SedeDatabase {
            val temp = INSTANCE
            if (temp != null) {
                return temp
            }
            synchronized(this) {
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    SedeDatabase::class.java,
                    "sede_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}