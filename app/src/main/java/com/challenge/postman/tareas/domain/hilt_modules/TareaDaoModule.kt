package com.challenge.postman.tareas.domain.hilt_modules

import com.challenge.postman.common.data.AppDatabase
import com.challenge.postman.tareas.data.TareaDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TareaDaoModule {
    @Provides
    @Singleton
    fun provideTareaDao(db: AppDatabase): TareaDao { return db.tareaDao() }
}