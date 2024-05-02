package com.challenge.postman.common.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.challenge.postman.tareas.data.entities.Tarea
import com.challenge.postman.tareas.data.TareaDao
import javax.inject.Singleton

@Singleton
@Database(entities = [Tarea::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
    abstract fun tareaDao(): TareaDao
}